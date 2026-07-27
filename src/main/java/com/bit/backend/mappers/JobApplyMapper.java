package com.bit.backend.mappers;

import com.bit.backend.dtos.JobApplyDto;
import com.bit.backend.dtos.JobPostingDto;
import com.bit.backend.entities.JobApplyEntity;
import com.bit.backend.entities.JobPostingEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper( componentModel = "spring" , builder = @Builder(disableBuilder = true))
public interface JobApplyMapper {

    JobApplyDto toJobApplyDto (JobApplyEntity jobApplyEntity);
    JobApplyEntity toJobApplyEntity (JobApplyDto jobApplyDto);
    List<JobApplyDto> toJobApplyDtoList(List<JobApplyEntity> jobApplyEntityList);
}
