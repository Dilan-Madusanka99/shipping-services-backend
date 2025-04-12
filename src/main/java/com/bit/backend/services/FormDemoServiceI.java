package com.bit.backend.services;

import com.bit.backend.dtos.FormDemoDto;

import java.util.List;

public interface FormDemoServiceI {
    FormDemoDto addFormDemoEntity (FormDemoDto formDemoDto);
    List<FormDemoDto> getData();

    FormDemoDto updateFormDemo(long id, FormDemoDto formDemoDto);
    FormDemoDto deleteFormDemo(long id);
}
