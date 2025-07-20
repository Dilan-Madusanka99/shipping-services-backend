package com.bit.backend.services.impl;

import com.bit.backend.dtos.JobPostingDto;
import com.bit.backend.entities.JobPostingEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.JobPostingMapper;
import com.bit.backend.repositories.JobPostingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobPostingService implements JobPostingServiceI {

    private final JobPostingRepository jobPostingRepository;
    private final JobPostingMapper jobPostingMapper;

    public JobPostingService(JobPostingRepository jobPostingRepository, JobPostingMapper jobPostingMapper) {
        this.jobPostingRepository = jobPostingRepository;
        this.jobPostingMapper = jobPostingMapper;
    }

    @Override
    public JobPostingDto addJobPostingEntity(JobPostingDto jobPostingDto) {
        try {
            if (jobPostingDto.getVesselName() == null || jobPostingDto.getVesselName().isEmpty()) {
                throw new AppException("Vessel Name Is Empty", HttpStatus.BAD_REQUEST);
            }

             System.out.println("***In Backend***");
            JobPostingEntity jobPostingEntity = jobPostingMapper.toJobPostingEntity(jobPostingDto);
            JobPostingEntity savedItem =  jobPostingRepository.save(jobPostingEntity);
            JobPostingDto savedDto = jobPostingMapper.toJobPostingDto(savedItem);
            return savedDto;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<JobPostingDto> getData() {

        try {
            List<JobPostingEntity>  jobPostingEntityList = jobPostingRepository.findAll();
            List<JobPostingDto> jobPostingDtoList = jobPostingMapper.toJobPostingDtoList(jobPostingEntityList);
            return jobPostingDtoList;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public JobPostingDto updateJobPosting(long id, JobPostingDto jobPostingDto) {

        try {
            Optional<JobPostingEntity> optionalJobPostingEntity = jobPostingRepository.findById(id);

            if (!optionalJobPostingEntity.isPresent()) {
                throw new AppException("Seafarers JobPosting Registration Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            JobPostingEntity newJobPostingEntity = jobPostingMapper.toJobPostingEntity(jobPostingDto);

            newJobPostingEntity.setId(id);
            JobPostingEntity savedJobPostingEntity = jobPostingRepository.save(newJobPostingEntity);

            JobPostingDto responseJobPostingDto = jobPostingMapper.toJobPostingDto(savedJobPostingEntity);
            return responseJobPostingDto;

        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public JobPostingDto deleteJobPosting(long id) {

        try {
            Optional<JobPostingEntity> optionalJobPostingEntity = jobPostingRepository.findById(id);

            if (!optionalJobPostingEntity.isPresent()) {
                throw new AppException("Seafarers Other Details Registration Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            jobPostingRepository.deleteById(id);
            return jobPostingMapper.toJobPostingDto(optionalJobPostingEntity.get());
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
