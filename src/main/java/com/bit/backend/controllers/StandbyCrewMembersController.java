package com.bit.backend.controllers;

import com.bit.backend.dtos.StandbyCrewMembersDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.impl.StandbyCrewMembersServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class StandbyCrewMembersController {

    private final StandbyCrewMembersServiceI standbyCrewMembersServiceI;

    public StandbyCrewMembersController(StandbyCrewMembersServiceI standbyCrewMembersServiceI) {
        this.standbyCrewMembersServiceI = standbyCrewMembersServiceI;
    }

    @PostMapping("/standbyCrewMembers")
    public ResponseEntity<StandbyCrewMembersDto> addStandbyCrewMembers(@RequestBody StandbyCrewMembersDto standbyCrewMembersDto) {

        try {
            StandbyCrewMembersDto standbyCrewMembersDtoResponse = standbyCrewMembersServiceI.addStandbyCrewMembersEntity(standbyCrewMembersDto);
            return ResponseEntity.created(URI.create("/standbyCrewMembers"+standbyCrewMembersDtoResponse.getSidNo())).body(standbyCrewMembersDtoResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/standbyCrewMembers")
    public ResponseEntity<List<StandbyCrewMembersDto>> getData() {

        try {
            List<StandbyCrewMembersDto> standbyCrewMembersDtoList = standbyCrewMembersServiceI.getData();
            return ResponseEntity.ok(standbyCrewMembersDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /* Get seafarer details related to SID */
    @GetMapping("/standbyCrewMembers/{sid}")
    public ResponseEntity<List<StandbyCrewMembersDto>> getSeafarerData(@PathVariable String sid) {
        try {
            List<StandbyCrewMembersDto> standbyCrewMembersDtoList = standbyCrewMembersServiceI.getSeafarerData(sid);
            return ResponseEntity.ok(standbyCrewMembersDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/standbyCrewMembers/{id}")
    public ResponseEntity<StandbyCrewMembersDto> updateStandbyCrewMembers(@PathVariable Long id, @RequestBody StandbyCrewMembersDto standbyCrewMembersDto) {

        try {
            StandbyCrewMembersDto responseStandbyCrewMembersDto = standbyCrewMembersServiceI.updateStandbyCrewMembers(id, standbyCrewMembersDto);
            return ResponseEntity.ok(responseStandbyCrewMembersDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/standbyCrewMembers/{id}")
    public ResponseEntity<StandbyCrewMembersDto> deleteStandbyCrewMembers(@PathVariable Long id) {

        try {
            StandbyCrewMembersDto standbyCrewMembersDto = standbyCrewMembersServiceI.deleteStandbyCrewMembers(id);
            return ResponseEntity.ok(standbyCrewMembersDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
