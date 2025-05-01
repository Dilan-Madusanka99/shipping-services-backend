package com.bit.backend.services.impl;

import com.bit.backend.dtos.UserProfileDto;

import java.util.List;

public interface UserProfileServiceI {

    UserProfileDto addUserProfileEntity(UserProfileDto userProfileDto);
    List<UserProfileDto> getData();
    UserProfileDto updateUserProfile(long id, UserProfileDto userProfileDto);
    UserProfileDto deleteUserProfile(long id);
}
