package com.bit.backend.mappers;

import com.bit.backend.dtos.JobPostingDto;
import com.bit.backend.entities.JobPostingEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper( componentModel = "spring" , builder = @Builder(disableBuilder = true))
public interface JobPostingMapper {

    JobPostingDto toJobPostingDto (JobPostingEntity jobPostingEntity);
    JobPostingEntity toJobPostingEntity (JobPostingDto jobPostingDto);
    List<JobPostingDto> toJobPostingDtoList(List<JobPostingEntity> jobPostingEntityList);
}
