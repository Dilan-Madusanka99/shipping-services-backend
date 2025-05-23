package com.bit.backend.services.impl;

import com.bit.backend.dtos.LoginDto;
import com.bit.backend.entities.LoginEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.LoginMapper;
import com.bit.backend.repositories.LoginRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService implements LoginServiceI {

    private final LoginRepository loginRepository;
    private final LoginMapper loginMapper;

    public LoginService(LoginRepository loginRepository, LoginMapper loginMapper) {
        this.loginRepository = loginRepository;
        this.loginMapper = loginMapper;
    }

    @Override
    public LoginDto addLoginEntity(LoginDto loginDto) {
        try {
            System.out.println("***In Backend***");
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
