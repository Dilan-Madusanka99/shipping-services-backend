package com.bit.backend.controllers;

import com.bit.backend.dtos.ItemsRegistrationDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.impl.ItemsRegistrationServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@RestController
public class ItemsRegistrationController {

    private final ItemsRegistrationServiceI itemsRegistrationServiceI;

    public ItemsRegistrationController(ItemsRegistrationServiceI itemsRegistrationServiceI) {
        this.itemsRegistrationServiceI = itemsRegistrationServiceI;
    }

    @PostMapping(value = {"/items_Registration"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<ItemsRegistrationDto> addItemsRegistration(@RequestPart("itemsRegistrationForm") ItemsRegistrationDto itemsRegistrationDto,
                                                                     @RequestPart("profileImage") MultipartFile file) {

        try {
            itemsRegistrationDto.setProfileImage(file.getBytes());
            itemsRegistrationDto.setProfileImageName(file.getOriginalFilename());
            itemsRegistrationDto.setProfileImageType(file.getContentType());
            ItemsRegistrationDto itemsRegistrationDtoResponse = itemsRegistrationServiceI.addItemsRegistrationEntity(itemsRegistrationDto);
            return ResponseEntity.created(URI.create("/items_Registration"+itemsRegistrationDtoResponse.getItemNo())).body(itemsRegistrationDtoResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/items_Registration")
    public ResponseEntity<List<ItemsRegistrationDto>> getData() {

        try {
            List<ItemsRegistrationDto> itemsRegistrationDtoList = itemsRegistrationServiceI.getData();
            return ResponseEntity.ok(itemsRegistrationDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/items_Registration/{id}")
    public ResponseEntity<ItemsRegistrationDto> updateItemsRegistration(@PathVariable Long id,
                                                      @RequestPart ("itemsRegistrationForm") ItemsRegistrationDto itemsRegistrationDto,
                                                      @RequestPart(value = "profileImage", required = false) MultipartFile file) {

        try {
            if (file != null && !file.isEmpty()) {
                itemsRegistrationDto.setProfileImage(file.getBytes());
                itemsRegistrationDto.setProfileImageName(file.getOriginalFilename());
                itemsRegistrationDto.setProfileImageType(file.getContentType());
            }
            ItemsRegistrationDto responseItemsRegistrationDto = itemsRegistrationServiceI.updateItemsRegistration(id, itemsRegistrationDto);
            return ResponseEntity.ok(responseItemsRegistrationDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/items_Registration/{id}")
    public ResponseEntity<ItemsRegistrationDto> deleteItemsRegistration(@PathVariable Long id) {

        try {
            ItemsRegistrationDto itemsRegistrationDto = itemsRegistrationServiceI.deleteItemsRegistration(id);
            return ResponseEntity.ok(itemsRegistrationDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
