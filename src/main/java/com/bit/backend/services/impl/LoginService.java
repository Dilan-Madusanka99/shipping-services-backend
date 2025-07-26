package com.bit.backend.services.impl;

import com.bit.backend.dtos.LoginDto;
import com.bit.backend.entities.LoginEntity;
import com.bit.backend.entities.SeafarersEntity;
import com.bit.backend.entities.User;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.LoginMapper;
import com.bit.backend.repositories.LoginRepository;
import com.bit.backend.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService implements LoginServiceI {

    private final LoginRepository loginRepository;
    private final LoginMapper loginMapper;
    private final UserRepository userRepository;

    public LoginService(LoginRepository loginRepository, LoginMapper loginMapper, UserRepository userRepository) {
        this.loginRepository = loginRepository;
        this.loginMapper = loginMapper;
        this.userRepository = userRepository;
    }

    @Override
    public LoginDto addLoginEntity(LoginDto loginDto) {
        try {
            System.out.println("***In Backend***");

//            Optional<LoginEntity> newLoginEntity = loginRepository.findByUserId(loginDto.getUserId());
//
//            if (newLoginEntity.isPresent()) {
//                throw new AppException("Login already exist for the employee", HttpStatus.BAD_REQUEST);
//            }

            Optional<User> oUser = userRepository.findByLogin(loginDto.getUserName());

            if (oUser.isPresent()) {
                throw new AppException("User Already Exists", HttpStatus.BAD_REQUEST);
            }

            Optional<LoginEntity> optionalLoginEntity = loginRepository.findByUserName(loginDto.getUserName());

            if (optionalLoginEntity.isPresent()) {
                throw new AppException("User Name Already Exists", HttpStatus.BAD_REQUEST);
            }

            // not null
//            if (loginDto.getUsers() == null || loginDto.getUsers().isEmpty()) {
//                throw new AppException("User Is Empty", HttpStatus.BAD_REQUEST);
//            }
//            if (loginDto.getUserName() == null || loginDto.getUserName().isEmpty()) {
//                throw new AppException("User Name Is Empty", HttpStatus.BAD_REQUEST);
//            }

            LoginEntity loginEntity = loginMapper.toLoginEntity(loginDto);
            LoginEntity savedItem =  loginRepository.save(loginEntity);
            LoginDto savedDto = loginMapper.toLoginDto(savedItem);
            return savedDto;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<LoginDto> getData() {

        try {
            List<LoginEntity>  loginEntityList = loginRepository.findAll();
            List<LoginDto> loginDtoList = loginMapper.toLoginDtoList(loginEntityList);
            return loginDtoList;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public LoginDto updateLogin(long id, LoginDto loginDto) {

        try {
            Optional<LoginEntity> optionalLoginEntity = loginRepository.findById(id);

            if (!optionalLoginEntity.isPresent()) {
                throw new AppException("Login Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            LoginEntity newLoginEntity = loginMapper.toLoginEntity(loginDto);

            newLoginEntity.setId(id);
            newLoginEntity.setUserId(optionalLoginEntity.get().getUserId());
            LoginEntity savedLoginEntity = loginRepository.save(newLoginEntity);

            LoginDto responseLoginDto = loginMapper.toLoginDto(savedLoginEntity);
            return responseLoginDto;

        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public LoginDto deleteLogin(long id) {

        try {
            Optional<LoginEntity> optionalLoginEntity = loginRepository.findById(id);

            if (!optionalLoginEntity.isPresent()) {
                throw new AppException("Login Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            loginRepository.deleteById(id);
            return loginMapper.toLoginDto(optionalLoginEntity.get());
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
