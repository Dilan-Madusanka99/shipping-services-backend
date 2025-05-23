package com.bit.backend.services.impl;

import com.bit.backend.dtos.LoginDto;

import java.util.List;

public interface LoginServiceI {

    LoginDto addLoginEntity(LoginDto loginDto);
    List<LoginDto> getData();
    LoginDto updateLogin(long id, LoginDto loginDto);
    LoginDto deleteLogin(long id);
}
