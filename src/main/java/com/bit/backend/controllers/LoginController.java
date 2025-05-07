package com.bit.backend.controllers;

import com.bit.backend.dtos.LoginDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.impl.LoginServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class LoginController {

    private final LoginServiceI loginServiceI;

    public LoginController(LoginServiceI loginServiceI) {this.loginServiceI = loginServiceI;}

    @PostMapping("/Login")
    public ResponseEntity<LoginDto> addLogin(@RequestBody LoginDto loginDto) {

        try {
            LoginDto loginDtoResponse = loginServiceI.addLoginEntity(loginDto);
            return ResponseEntity.created(URI.create("/Login"+loginDtoResponse.getFirstName())).body(loginDtoResponse);
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
            LoginDto responseLoginDto = loginServiceI.updateLogin(id, loginDto);
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
