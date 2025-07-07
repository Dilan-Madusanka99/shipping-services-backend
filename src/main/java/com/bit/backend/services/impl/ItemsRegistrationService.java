package com.bit.backend.services.impl;

import com.bit.backend.dtos.ItemsRegistrationDto;
import com.bit.backend.entities.ItemsRegistrationEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.ItemsRegistrationMapper;
import com.bit.backend.repositories.ItemsRegistrationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemsRegistrationService implements ItemsRegistrationServiceI{

    private final ItemsRegistrationRepository itemsRegistrationRepository;
    private final ItemsRegistrationMapper itemsRegistrationMapper;

    public ItemsRegistrationService(ItemsRegistrationRepository itemsRegistrationRepository, ItemsRegistrationMapper itemsRegistrationMapper) {
        this.itemsRegistrationRepository = itemsRegistrationRepository;
        this.itemsRegistrationMapper = itemsRegistrationMapper;
    }

    @Override
    public ItemsRegistrationDto addItemsRegistrationEntity(ItemsRegistrationDto itemsRegistrationDto) {
        try {
            System.out.println("***In Backend***");
            ItemsRegistrationEntity itemsRegistrationEntity = itemsRegistrationMapper.toItemsRegistrationEntity(itemsRegistrationDto);
            ItemsRegistrationEntity savedItem =  itemsRegistrationRepository.save(itemsRegistrationEntity);
            ItemsRegistrationDto savedDto = itemsRegistrationMapper.toItemsRegistrationDto(savedItem);
            return savedDto;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<ItemsRegistrationDto> getData() {

        try {
            List<ItemsRegistrationEntity>  itemsRegistrationEntityList = itemsRegistrationRepository.findAll();
            List<ItemsRegistrationDto> itemsRegistrationDtoList = itemsRegistrationMapper.toItemsRegistrationDtoList(itemsRegistrationEntityList);
            return itemsRegistrationDtoList;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ItemsRegistrationDto updateItemsRegistration(long id, ItemsRegistrationDto itemsRegistrationDto) {

        try {
            Optional<ItemsRegistrationEntity> optionalItemsRegistrationEntity = itemsRegistrationRepository.findById(id);

            if (!optionalItemsRegistrationEntity.isPresent()) {
                throw new AppException("Items Registration Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            ItemsRegistrationEntity newItemsRegistrationEntity = itemsRegistrationMapper.toItemsRegistrationEntity(itemsRegistrationDto);

            newItemsRegistrationEntity.setId(id);
            ItemsRegistrationEntity savedItemsRegistrationEntity = itemsRegistrationRepository.save(newItemsRegistrationEntity);

            ItemsRegistrationDto responseItemsRegistrationDto = itemsRegistrationMapper.toItemsRegistrationDto(savedItemsRegistrationEntity);
            return responseItemsRegistrationDto;

        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ItemsRegistrationDto deleteItemsRegistration(long id) {

        try {
            Optional<ItemsRegistrationEntity> optionalItemsRegistrationEntity = itemsRegistrationRepository.findById(id);

            if (!optionalItemsRegistrationEntity.isPresent()) {
                throw new AppException("Items Registration Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            itemsRegistrationRepository.deleteById(id);
            return itemsRegistrationMapper.toItemsRegistrationDto(optionalItemsRegistrationEntity.get());
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
