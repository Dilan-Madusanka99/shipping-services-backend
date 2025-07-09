package com.bit.backend.controllers;

import com.bit.backend.dtos.PaymentsDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.impl.PaymentsServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@RestController
public class PaymentsController {

    private final PaymentsServiceI paymentsServiceI;

    public PaymentsController(PaymentsServiceI paymentsServiceI) {
        this.paymentsServiceI = paymentsServiceI;
    }

    @PostMapping(value = {"/payments"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<PaymentsDto> addPayments(@RequestPart ("paymentsForm") PaymentsDto paymentsDto,
                                                   @RequestPart("paymentImage") MultipartFile file) {

        try {
            paymentsDto.setPaymentImage(file.getBytes());
            paymentsDto.setPaymentImageName(file.getOriginalFilename());
            paymentsDto.setPaymentImageType(file.getContentType());
            PaymentsDto paymentsDtoResponse = paymentsServiceI.addPaymentsEntity(paymentsDto);
            return ResponseEntity.created(URI.create("/payments"+paymentsDtoResponse.getPaymentNo())).body(paymentsDtoResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/payments")
    public ResponseEntity<List<PaymentsDto>> getData() {

        try {
            List<PaymentsDto> paymentsDtoList = paymentsServiceI.getData();
            return ResponseEntity.ok(paymentsDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/payments/{id}")
    public ResponseEntity<PaymentsDto> updatePayments(@PathVariable Long id,
                                                      @RequestPart ("paymentsForm") PaymentsDto paymentsDto,
                                                      @RequestPart(value = "paymentImage", required = false) MultipartFile file) {

        try {
            if (file != null && !file.isEmpty()) {
                paymentsDto.setPaymentImage(file.getBytes());
                paymentsDto.setPaymentImageName(file.getOriginalFilename());
                paymentsDto.setPaymentImageType(file.getContentType());
            }
            PaymentsDto responsePaymentsDto = paymentsServiceI.updatePayments(id, paymentsDto);
            return ResponseEntity.ok(responsePaymentsDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/payments/{id}")
    public ResponseEntity<PaymentsDto> deletePayments(@PathVariable Long id) {

        try {
            PaymentsDto paymentsDto = paymentsServiceI.deletePayments(id);
            return ResponseEntity.ok(paymentsDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
