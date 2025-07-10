package com.bit.backend.services.impl;

import com.bit.backend.dtos.PaymentsDto;
import com.bit.backend.entities.PaymentsEntity;
import com.bit.backend.entities.SeafarersEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.PaymentsMapper;
import com.bit.backend.repositories.PaymentsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentsService implements PaymentsServiceI{

    private final PaymentsRepository paymentsRepository;
    private final PaymentsMapper paymentsMapper;

    public PaymentsService(PaymentsRepository paymentsRepository, PaymentsMapper paymentsMapper) {
        this.paymentsRepository = paymentsRepository;
        this.paymentsMapper = paymentsMapper;
    }

    @Override
    public PaymentsDto addPaymentsEntity(PaymentsDto paymentsDto) {
        try {
            System.out.println("***In Backend***");

            Optional<PaymentsEntity> optionalPaymentsEntity = paymentsRepository.findByPaymentNo(paymentsDto.getPaymentNo());

            if (optionalPaymentsEntity.isPresent()) {
                throw new AppException("Seafarer Already Exists", HttpStatus.BAD_REQUEST);
            }

            PaymentsEntity paymentsEntity = paymentsMapper.toPaymentsEntity(paymentsDto);
            PaymentsEntity savedItem =  paymentsRepository.save(paymentsEntity);
            PaymentsDto savedDto = paymentsMapper.toPaymentsDto(savedItem);
            return savedDto;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<PaymentsDto> getData() {

        try {
            List<PaymentsEntity>  paymentsEntityList = paymentsRepository.findAll();
            List<PaymentsDto> paymentsDtoList = paymentsMapper.toPaymentsDtoList(paymentsEntityList);
            return paymentsDtoList;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public PaymentsDto updatePayments(long id, PaymentsDto paymentsDto) {

        try {
            Optional<PaymentsEntity> optionalPaymentsEntity = paymentsRepository.findById(id);

            if (!optionalPaymentsEntity.isPresent()) {
                throw new AppException("Payments Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            PaymentsEntity newPaymentsEntity = paymentsMapper.toPaymentsEntity(paymentsDto);

            newPaymentsEntity.setId(id);
            PaymentsEntity savedPaymentsEntity = paymentsRepository.save(newPaymentsEntity);

            PaymentsDto responsePaymentsDto = paymentsMapper.toPaymentsDto(savedPaymentsEntity);
            return responsePaymentsDto;

        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public PaymentsDto deletePayments(long id) {

        try {
            Optional<PaymentsEntity> optionalPaymentsEntity = paymentsRepository.findById(id);

            if (!optionalPaymentsEntity.isPresent()) {
                throw new AppException("Payments Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            paymentsRepository.deleteById(id);
            return paymentsMapper.toPaymentsDto(optionalPaymentsEntity.get());
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
