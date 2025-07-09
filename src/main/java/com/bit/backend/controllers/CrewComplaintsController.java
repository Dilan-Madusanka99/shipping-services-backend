package com.bit.backend.controllers;

import com.bit.backend.dtos.CrewComplaintsDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.impl.CrewComplaintsServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class CrewComplaintsController {

    private final CrewComplaintsServiceI crewComplaintsServiceI;

    public CrewComplaintsController(CrewComplaintsServiceI crewComplaintsServiceI) {
        this.crewComplaintsServiceI = crewComplaintsServiceI;
    }

    @PostMapping("/crewComplaints")
    public ResponseEntity<CrewComplaintsDto> addCrewComplaints(@RequestBody CrewComplaintsDto crewComplaintsDto) {

        try {
            CrewComplaintsDto crewComplaintsDtoResponse = crewComplaintsServiceI.addCrewComplaintsEntity(crewComplaintsDto);
            return ResponseEntity.created(URI.create("/crewComplaints"+crewComplaintsDtoResponse.getSidNo())).body(crewComplaintsDtoResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/crewComplaints")
    public ResponseEntity<List<CrewComplaintsDto>> getData() {

        try {
            List<CrewComplaintsDto> crewComplaintsDtoList = crewComplaintsServiceI.getData();
            return ResponseEntity.ok(crewComplaintsDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/crewComplaints/{id}")
    public ResponseEntity<CrewComplaintsDto> updateCrewComplaints(@PathVariable Long id, @RequestBody CrewComplaintsDto crewComplaintsDto) {

        try {
            CrewComplaintsDto responseCrewComplaintsDto = crewComplaintsServiceI.updateCrewComplaints(id, crewComplaintsDto);
            return ResponseEntity.ok(responseCrewComplaintsDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/crewComplaints/{id}")
    public ResponseEntity<CrewComplaintsDto> deleteCrewComplaints(@PathVariable Long id) {

        try {
            CrewComplaintsDto crewComplaintsDto = crewComplaintsServiceI.deleteCrewComplaints(id);
            return ResponseEntity.ok(crewComplaintsDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
