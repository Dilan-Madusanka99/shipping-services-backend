package com.bit.backend.mappers;

import com.bit.backend.dtos.EmployeeAttendenceDto;
import com.bit.backend.entities.EmployeeAttendenceEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface EmployeeAttendenceMapper {

    EmployeeAttendenceDto toEmployeeAttendenceDto (EmployeeAttendenceEntity employeeAttendenceEntity);
    EmployeeAttendenceEntity toEmployeeAttendenceEntity (EmployeeAttendenceDto employeeAttendenceDto);
    List<EmployeeAttendenceDto> toEmployeeAttendenceDtoList(List<EmployeeAttendenceEntity> employeeAttendenceEntityList);

}
