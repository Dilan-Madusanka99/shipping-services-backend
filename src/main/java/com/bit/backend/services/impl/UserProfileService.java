package com.bit.backend.services.impl;

import com.bit.backend.dtos.UserProfileDto;
import com.bit.backend.entities.UserProfileEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.UserProfileMapper;
import com.bit.backend.repositories.UserProfileRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService implements UserProfileServiceI{
    
    private final UserProfileRepository userProfileRepository;
    private final UserProfileMapper userProfileMapper;

    public UserProfileService(UserProfileRepository userProfileRepository, UserProfileMapper userProfileMapper) {
        this.userProfileRepository = userProfileRepository;
        this.userProfileMapper = userProfileMapper;
    }
    
    @Override
    public UserProfileDto addUserProfileEntity(UserProfileDto userProfileDto){
        try{
            System.out.println("***In Backend***");
            UserProfileEntity userProfileEntity = userProfileMapper.toUserProfileEntity(userProfileDto);
            UserProfileEntity savedItem = userProfileRepository.save(userProfileEntity);
            UserProfileDto savedDto = userProfileMapper.toUserProfileDto(savedItem);
            return savedDto;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<UserProfileDto> getData() {

        try {
            List<UserProfileEntity> userProfileEntityList = userProfileRepository.findAll();
            List<UserProfileDto> userProfileDtoList = userProfileMapper.toUserProfileDtoList(userProfileEntityList);
            return userProfileDtoList;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public UserProfileDto updateUserProfile(long id, UserProfileDto userProfileDto) {

        try {
            Optional<UserProfileEntity> optionalUserProfileEntity = userProfileRepository.findById(id);

            if (!optionalUserProfileEntity.isPresent()) {
                throw new AppException("UserProfile Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            UserProfileEntity newUserProfileEntity = userProfileMapper.toUserProfileEntity(userProfileDto);

            newUserProfileEntity.setId(id);
            UserProfileEntity savedUserProfileEntity = userProfileRepository.save(newUserProfileEntity);

            UserProfileDto responseUserProfileDto = userProfileMapper.toUserProfileDto(savedUserProfileEntity);
            return responseUserProfileDto;

        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public UserProfileDto deleteUserProfile(long id) {

        try {
            Optional<UserProfileEntity> optionalUserProfileEntity = userProfileRepository.findById(id);

            if (!optionalUserProfileEntity.isPresent()) {
                throw new AppException("UserProfile Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            userProfileRepository.deleteById(id);
            return userProfileMapper.toUserProfileDto(optionalUserProfileEntity.get());
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
