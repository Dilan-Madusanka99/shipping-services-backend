package com.bit.backend.controllers;

import com.bit.backend.dtos.UserProfileDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.impl.UserProfileServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@RestController
public class UserProfileController {

    private final UserProfileServiceI userProfileServiceI;

    public UserProfileController(UserProfileServiceI userProfileServiceI) {
        this.userProfileServiceI = userProfileServiceI;
    }

    @PostMapping(value = {"/userProfile"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<UserProfileDto> addUserProfile(@RequestPart("userProfileForm") UserProfileDto userProfileDto,
                                                         @RequestPart("userProfileImage") MultipartFile file) {

        try {
            userProfileDto.setUserProfileImage(file.getBytes());
            userProfileDto.setUserProfileImageName(file.getOriginalFilename());
            userProfileDto.setUserProfileImageType(file.getContentType());
            UserProfileDto userProfileDtoResponse = userProfileServiceI.addUserProfileEntity(userProfileDto);
            return ResponseEntity.created(URI.create("/userProfile"+userProfileDtoResponse.getFirstName())).body(userProfileDtoResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/userProfile")
    public ResponseEntity<List<UserProfileDto>> getData() {

        try {
            List<UserProfileDto> userProfileDtoList = userProfileServiceI.getData();
            return ResponseEntity.ok(userProfileDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/userProfile/{id}")
    public ResponseEntity<UserProfileDto> updateUserProfile(@PathVariable Long id,
                                                      @RequestPart ("userProfileForm") UserProfileDto userProfileDto,
                                                      @RequestPart(value = "userProfileImage", required = false) MultipartFile file) {

        try {
            if (file != null && !file.isEmpty()) {
                userProfileDto.setUserProfileImage(file.getBytes());
                userProfileDto.setUserProfileImageName(file.getOriginalFilename());
                userProfileDto.setUserProfileImageType(file.getContentType());
            }
            UserProfileDto responseUserProfileDto = userProfileServiceI.updateUserProfile(id, userProfileDto);
            return ResponseEntity.ok(responseUserProfileDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/userProfile/{id}")
    public ResponseEntity<UserProfileDto> deleteUserProfile(@PathVariable Long id) {

        try {
            UserProfileDto userProfileDto = userProfileServiceI.deleteUserProfile(id);
            return ResponseEntity.ok(userProfileDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
