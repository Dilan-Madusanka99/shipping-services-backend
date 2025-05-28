package com.bit.backend.controllers;

import com.bit.backend.dtos.LoginDto;
import com.bit.backend.dtos.SignUpDto;
import com.bit.backend.dtos.UserDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.UserServiceI;
import com.bit.backend.services.impl.LoginServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class LoginController {

    private final LoginServiceI loginServiceI;
    private final UserServiceI userServiceI;

    public LoginController(LoginServiceI loginServiceI, UserServiceI userServiceI) {this.loginServiceI = loginServiceI;
        this.userServiceI = userServiceI;}

    @PostMapping("/Login")
    public ResponseEntity<LoginDto> addLogin(@RequestBody LoginDto loginDto) {
        LoginDto updatedLoginDto = loginDto;
        try {
            SignUpDto signUpDto = new SignUpDto(loginDto.getFirstName(), loginDto.getLastName(), loginDto.getUserName(), loginDto.getPassword().toCharArray(), loginDto.getRole());
            loginDto.setPassword(null);
            LoginDto loginDtoResponse = loginServiceI.addLoginEntity(loginDto);
            UserDto user = userServiceI.register(signUpDto);

            if (user.getId() != null) {
                long loginId = loginDtoResponse.getId();
                long userId = user.getId();
                LoginDto newLoginDto = loginDtoResponse;
                newLoginDto.setUserId(userId);
                updatedLoginDto = loginServiceI.updateLogin(loginId, newLoginDto);
            }
            return ResponseEntity.created(URI.create("/Login"+updatedLoginDto.getFirstName())).body(updatedLoginDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/Login")
    public ResponseEntity<List<LoginDto>> getData() {

        try {
            List<LoginDto> loginDtoList = loginServiceI.getData();
            return ResponseEntity.ok(loginDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/Login/{id}")
    public ResponseEntity<LoginDto> updateLogin(@PathVariable Long id, @RequestBody LoginDto loginDto) {

        try {
            String password = loginDto.getPassword();
            loginDto.setPassword(null);
            LoginDto responseLoginDto = loginServiceI.updateLogin(id, loginDto);
            boolean value = userServiceI.updatePassword(responseLoginDto, password);
            return ResponseEntity.ok(responseLoginDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/Login/{id}")
    public ResponseEntity<LoginDto> deleteLogin(@PathVariable Long id) {

        try {
            LoginDto loginDto = loginServiceI.deleteLogin(id);
            return ResponseEntity.ok(loginDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
