package com.bit.backend.services.impl;

import com.bit.backend.dtos.SeafarersDto;
import com.bit.backend.entities.SeafarersEntity;
import com.bit.backend.entities.User;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.SeafarersMapper;;
import com.bit.backend.repositories.SeafarersRepository;
import com.bit.backend.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeafarersService implements SeafarersServiceI {

    private final SeafarersRepository seafarersRepository;
    private final SeafarersMapper seafarersMapper;
    private final UserRepository userRepository;

    public SeafarersService(SeafarersRepository seafarersRepository, SeafarersMapper seafarersMapper, UserRepository userRepository) {
        this.seafarersRepository = seafarersRepository;
        this.seafarersMapper = seafarersMapper;
        this.userRepository = userRepository;
    }

    @Override
    public SeafarersDto addSeafarersEntity(SeafarersDto seafarersDto) {
        try {
            System.out.println("***In Backend***");

            Optional<SeafarersEntity> oSeafarersEntity = seafarersRepository.findBySidNo(seafarersDto.getSidNo());

            if (oSeafarersEntity.isPresent()) {
                throw new AppException("Seafarer Already Exists", HttpStatus.BAD_REQUEST);
            }

//            if (seafarersDto.getSidNo() == null || seafarersDto.getSidNo().isEmpty()) {
//                throw new AppException("Seafarer ID No is Empty", HttpStatus.BAD_REQUEST);
//            }

            SeafarersEntity seafarersEntity = seafarersMapper.toSeafarersEntity(seafarersDto);
            SeafarersEntity savedItem =  seafarersRepository.save(seafarersEntity);
            SeafarersDto savedDto = seafarersMapper.toSeafarersDto(savedItem);
            return savedDto;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<SeafarersDto> getData() {

        try {
            List<SeafarersEntity>  seafarersEntityList = seafarersRepository.findAll();
            List<SeafarersDto> seafarersDtoList = seafarersMapper.toSeafarersDtoList(seafarersEntityList);
            return seafarersDtoList;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<SeafarersDto> getseafarersRegisteredByMonth() {

        try {
            List<SeafarersEntity>  seafarersEntityList = seafarersRepository.findAll();
            List<SeafarersDto> seafarersDtoList = seafarersMapper.toSeafarersDtoList(seafarersEntityList);
            return seafarersDtoList;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public SeafarersDto updateSeafarers(long id, SeafarersDto seafarersDto) {

        try {
            Optional<SeafarersEntity> optionalSeafarersEntity = seafarersRepository.findById(id);

            if (!optionalSeafarersEntity.isPresent()) {
                throw new AppException("Seafarers Registration Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            SeafarersEntity newSeafarersEntity = seafarersMapper.toSeafarersEntity(seafarersDto);

            newSeafarersEntity.setId(id);
            SeafarersEntity savedSeafarersEntity = seafarersRepository.save(newSeafarersEntity);

            SeafarersDto responseSeafarersDto = seafarersMapper.toSeafarersDto(savedSeafarersEntity);
            return responseSeafarersDto;

        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public SeafarersDto deleteSeafarers(long id) {

        try {
            Optional<SeafarersEntity> optionalSeafarersEntity = seafarersRepository.findById(id);

            if (!optionalSeafarersEntity.isPresent()) {
                throw new AppException("Seafarers  Registration Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            seafarersRepository.deleteById(id);
            return seafarersMapper.toSeafarersDto(optionalSeafarersEntity.get());
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public SeafarersDto getSeafarerData(String sid) {
        try {
            Optional<SeafarersEntity> optionalSeafarersEntity = seafarersRepository.findBySidNo(sid);

            if (!optionalSeafarersEntity.isPresent()) {
                throw new AppException("Seafarers  Registration Does Not Exists", HttpStatus.BAD_REQUEST);
            }
            return seafarersMapper.toSeafarersDto(optionalSeafarersEntity.get());
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public SeafarersDto getSeafarerDataById(long id) {
        try {
            Optional<SeafarersEntity> optionalSeafarersEntity = seafarersRepository.findById(id);

            if (!optionalSeafarersEntity.isPresent()) {
                throw new AppException("Seafarers  Registration Does Not Exists", HttpStatus.BAD_REQUEST);
            }
            return seafarersMapper.toSeafarersDto(optionalSeafarersEntity.get());
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public SeafarersDto getSeafarerDataByUserId(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (!optionalUser.isPresent()) {
            throw new AppException("Seafarer related User not found", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        User user = optionalUser.get();
        String seafarerId = user.getSid();

        Optional<SeafarersEntity> optionalSeafarersEntity = seafarersRepository.findBySidNo(seafarerId);

        if (!optionalSeafarersEntity.isPresent()) {
            throw new AppException("Seafarers  Registration Does Not Exists", HttpStatus.BAD_REQUEST);
        }
        return seafarersMapper.toSeafarersDto(optionalSeafarersEntity.get());
    }

    @Override
    public Boolean checkSeafarerIdUniqueness(String sid) {
        Optional<User> optionalUser = userRepository.findBySid(sid);

        if (optionalUser.isPresent()) {
            return true;
        }
//        User must be register even if there are data in seafarer registratin entity
//        Optional<SeafarersEntity> optionalSeafarersEntity = seafarersRepository.findBySidNo(sid);
//
//        if (optionalSeafarersEntity.isPresent()) {
//            return true;
//        }

        return false;
    }

    @Override
    public Boolean checkLoginNameUniqueness(String login) {
        Optional<User> optionalUser = userRepository.findByLogin(login);
        return optionalUser.isPresent();
    }
}
