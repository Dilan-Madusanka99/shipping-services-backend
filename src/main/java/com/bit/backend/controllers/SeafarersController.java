package com.bit.backend.controllers;

import com.bit.backend.dtos.SeafarersDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.impl.SeafarersServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@RestController
public class SeafarersController {

    private final SeafarersServiceI seafarersServiceI;

    public SeafarersController(SeafarersServiceI seafarersServiceI) {
        this.seafarersServiceI = seafarersServiceI;
    }

    //   // Photo upload [start]
    @PostMapping(value = {"/seafarers_registration"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<SeafarersDto> addSeafarers(@RequestPart("seafarersForm") SeafarersDto seafarersDto,
                                                     @RequestPart("profileImage") MultipartFile file) {

        try {
            seafarersDto.setProfileImage(file.getBytes());
            seafarersDto.setProfileImageName(file.getOriginalFilename());
            seafarersDto.setProfileImageType(file.getContentType());
            SeafarersDto seafarersDtoResponse = seafarersServiceI.addSeafarersEntity(seafarersDto);
            return ResponseEntity.created(URI.create("/seafarers_registration"+seafarersDtoResponse.getSurname())).body(seafarersDtoResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/seafarers_registration")
    public ResponseEntity<List<SeafarersDto>> getData() {

        try {
            List<SeafarersDto> seafarersDtoList = seafarersServiceI.getData();
            return ResponseEntity.ok(seafarersDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<SeafarersDto>> seafarersRegisteredByMonth() {

        try {
            List<SeafarersDto> seafarersRegisteredByMonthList = seafarersServiceI.seafarersRegisteredByMonth();
            return ResponseEntity.ok(seafarersRegisteredByMonthList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/seafarers_registration/{id}")
    public ResponseEntity<SeafarersDto> updateSeafarers(@PathVariable Long id,
                                                      @RequestPart ("seafarersForm") SeafarersDto seafarersDto,
                                                      @RequestPart(value = "profileImage", required = false) MultipartFile file) {

        try {
            if (file != null && !file.isEmpty()) {
                seafarersDto.setProfileImage(file.getBytes());
                seafarersDto.setProfileImageName(file.getOriginalFilename());
                seafarersDto.setProfileImageType(file.getContentType());
            }
            SeafarersDto responseSeafarersDto = seafarersServiceI.updateSeafarers(id, seafarersDto);
            return ResponseEntity.ok(responseSeafarersDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/seafarers_registration/{id}")
    public ResponseEntity<SeafarersDto> deleteSeafarers(@PathVariable Long id) {

        try {
            SeafarersDto seafarersDto = seafarersServiceI.deleteSeafarers(id);
            return ResponseEntity.ok(seafarersDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
