package com.bit.backend.controllers;

import com.bit.backend.dtos.FormDemoDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.FormDemoServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class FormDemoController {

    private final FormDemoServiceI formDemoServiceI;

    public FormDemoController(FormDemoServiceI formDemoServiceI) {
        this.formDemoServiceI = formDemoServiceI;
    }

    @PostMapping("/form-demo")
    public ResponseEntity<FormDemoDto> addForm(@RequestBody FormDemoDto formDemoDto) {

        try {
            FormDemoDto formDemoDtoResponse = formDemoServiceI.addFormDemoEntity(formDemoDto);
            return ResponseEntity.created(URI.create("/form-demo"+formDemoDtoResponse.getFirstName())).body(formDemoDtoResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/form-demo")
    public ResponseEntity<List<FormDemoDto>> getData() {

        try {
            List <FormDemoDto> formDemoDtoList = formDemoServiceI.getData();
            return ResponseEntity.ok(formDemoDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/form-demo/{id}")
    public ResponseEntity<FormDemoDto> updateFormDemo(@PathVariable long id, @RequestBody FormDemoDto formDemoDto) {

        try {
            FormDemoDto responseFormDemoDto = formDemoServiceI.updateFormDemo(id,formDemoDto);
            return ResponseEntity.ok(responseFormDemoDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/form-demo/{id}")
    public ResponseEntity<FormDemoDto> deleteFormDemo(@PathVariable long id) {

        try {
            FormDemoDto formDemoDto = formDemoServiceI.deleteFormDemo(id);
            return ResponseEntity.ok(formDemoDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
