package com.bit.backend.services.impl;

import com.bit.backend.dtos.*;
import com.bit.backend.entities.JobPostingEntity;
import com.bit.backend.entities.JobSuggestionsEntity;
import com.bit.backend.entities.VesselRegistrationEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.JobPostingMapper;
import com.bit.backend.repositories.JobPostingRepository;
import com.bit.backend.repositories.JobSuggestionsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class JobPostingService implements JobPostingServiceI {

    private final JobPostingRepository jobPostingRepository;
    private final JobPostingMapper jobPostingMapper;
    private final OnboardCrewRegistrationServiceI onboardCrewRegistrationServiceI;
    CertificatesRegistrationServiceI certificatesRegistrationServiceI;
    private final SeaServicesServiceI seaServicesServiceI;
    private final SeafarersServiceI seafarersServiceI;
    private final JobSuggestionsRepository jobSuggestionsRepository;
    private final VesselRegistrationServiceI vesselRegistrationServiceI;

    public JobPostingService(JobPostingRepository jobPostingRepository, JobPostingMapper jobPostingMapper,
                             OnboardCrewRegistrationServiceI onboardCrewRegistrationServiceI,
                             CertificatesRegistrationServiceI certificatesRegistrationServiceI,
                             SeaServicesServiceI seaServicesServiceI,
                             SeafarersServiceI seafarersServiceI,
                             JobSuggestionsRepository jobSuggestionsRepository,
                             VesselRegistrationServiceI vesselRegistrationServiceI) {
        this.jobPostingRepository = jobPostingRepository;
        this.jobPostingMapper = jobPostingMapper;
        this.onboardCrewRegistrationServiceI = onboardCrewRegistrationServiceI;
        this.certificatesRegistrationServiceI = certificatesRegistrationServiceI;
        this.seaServicesServiceI = seaServicesServiceI;
        this.seafarersServiceI = seafarersServiceI;
        this.jobSuggestionsRepository = jobSuggestionsRepository;
        this.vesselRegistrationServiceI = vesselRegistrationServiceI;
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

            // run job matching engine
            this.getSuggestionsForJob(savedDto);

            return savedDto;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void getSuggestionsForJob(JobPostingDto jobPostingDto) {
        List<OnboardCrewRegistrationDto> inactiveCrewData = onboardCrewRegistrationServiceI.getInactiveData();

        for (OnboardCrewRegistrationDto onboardCrewRegistrationDto : inactiveCrewData) {
            float score = 0;
            String sidNo = onboardCrewRegistrationDto.getSidNo();
            SeafarersDto seafarersDto = seafarersServiceI.getSeafarerDataById(Long.parseLong(sidNo));
            String position = onboardCrewRegistrationDto.getPosition();
            List<CertificatesRegistrationDto> certificatesRegistrationDtoList = certificatesRegistrationServiceI.getSeafarerData(seafarersDto.getSidNo());
            Integer experience = seaServicesServiceI.getSearServiceExperience(sidNo);
            VesselRegistrationDto vesselRegistrationDto = vesselRegistrationServiceI.getVessleById(Long.parseLong(jobPostingDto.getVesselName()));

            if (jobPostingDto.getPosition().equals(position)) {
                score = score + 40; /* 40 for position match */
            }

            if (Integer.parseInt(jobPostingDto.getMinimumExp()) <= experience) {
                score = score + 30;
            }

            /* cName comma seperated string*/
            List<String> certList = Arrays.asList(jobPostingDto.getcName().split(","));
            int noOfCertificatesRequired = certList.size();
            float scorePerCertificate = noOfCertificatesRequired > 0 ? (float) 30 / noOfCertificatesRequired : 0;

            if (scorePerCertificate > 0) {
                for (CertificatesRegistrationDto certificatesRegistrationDto : certificatesRegistrationDtoList) {
                    String certName = certificatesRegistrationDto.getcName();

                    if (certList.contains(certName)) {
                        score = score + scorePerCertificate;
                    }
                }
            }

            JobSuggestionsEntity jobSuggestionsEntity = jobSuggestionsRepository.findByJobIdAndSeafarerId(jobPostingDto.getId(), sidNo)
                    .orElse(new JobSuggestionsEntity()); // insert if not found, update if found

            jobSuggestionsEntity.setJobId(jobPostingDto.getId());
            jobSuggestionsEntity.setSeafarerId(sidNo);
            jobSuggestionsEntity.setSeafarerNo(seafarersDto.getSidNo());
            jobSuggestionsEntity.setPosition(position);
            jobSuggestionsEntity.setMatchScore(score);
            jobSuggestionsEntity.setVessleName(jobPostingDto.getVesselName());
            jobSuggestionsEntity.setJobName(vesselRegistrationDto.getVesselName() + "~" + jobPostingDto.getPosition());
            jobSuggestionsEntity.setStatus("PENDING");

            jobSuggestionsRepository.save(jobSuggestionsEntity);
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
    public List<Integer> getAuthIds(long jobId) {
        Optional<List<Integer>> optionalAuthIdLists = JobSuggestionsRepository.findByJobIdAndSeafarerId(jobId);
        List<Integer> authIdLists = optionalAuthIdLists.get();

        return authIdLists;
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

            this.getSuggestionsForJob(responseJobPostingDto);

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

    @Override
    public List<JobPostingDto> getOpenJobs() {
        try {
            List<JobPostingEntity>  jobPostingEntityList = jobPostingRepository.findByJobStatus("Open");
            List<JobPostingDto> jobPostingDtoList = jobPostingMapper.toJobPostingDtoList(jobPostingEntityList);
            return jobPostingDtoList;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
