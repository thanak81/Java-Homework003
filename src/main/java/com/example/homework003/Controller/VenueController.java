package com.example.homework003.Controller;

import com.example.homework003.Entity.Model.Event;
import com.example.homework003.Entity.Model.Venue;
import com.example.homework003.Entity.Request.EventRequest;
import com.example.homework003.Entity.Request.VenueRequest;
import com.example.homework003.Entity.Response.ApiResponse;
import com.example.homework003.Exception.ModelException;
import com.example.homework003.Services.Service.EventService;
import com.example.homework003.Services.Service.VenueService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/venues/")
@AllArgsConstructor
public class VenueController {
    private final VenueService venueService;
    @GetMapping("/")
    public ResponseEntity<?> getAllVenue(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer size){
        ApiResponse<List<Venue>> apiResponse;
        if(venueService.getAllVenue(page,size).isEmpty()){
            throw new ModelException("No Venue Available");

        }else{
            apiResponse = ApiResponse.<List<Venue>>builder()
                    .message("Venue Lists Retrives")
                    .httpStatus(HttpStatus.FOUND)
                    .payload(venueService.getAllVenue(page, size))
                    .timestamp(new Date(System.currentTimeMillis()))
                    .build();
        }
        return ResponseEntity.ok(apiResponse);

    }

    @GetMapping("{id}")
    public ResponseEntity<?> getAttendeeByID(@PathVariable Integer id){
        ApiResponse<Venue> apiResponse;
        if(venueService.getVenueById(id) == null){
            throw new ModelException("ID NOT FOUND");
        }else{
            apiResponse = ApiResponse.<Venue>builder()
                    .httpStatus(HttpStatus.FOUND)
                    .message("Venue with ID "+venueService.getVenueById(id).getVenueId() + " is retrieve"  )
                    .payload(venueService.getVenueById(id))
                    .timestamp(new Date(System.currentTimeMillis()))
                    .build();
        }
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/")
    public ResponseEntity<?> createVenue(@RequestBody @Valid VenueRequest venueRequest) {
        ApiResponse<Venue> apiResponse;
        if(venueRequest.getLocation().isBlank()){
            throw new ModelException("Location must not be blank");
        }
        if(venueRequest.getVenuename().isBlank()){
            throw new ModelException("Venue Name must not be blank");
        }
        {
            venueService.createVenue(venueRequest);
            apiResponse = ApiResponse.<Venue>builder()
                    .httpStatus(HttpStatus.FOUND)
                    .message("Venue Created Successfully")
                    .payload((venueService.getVenueById(venueService.createVenue(venueRequest))))
                    .timestamp(new Date(System.currentTimeMillis()))
                    .build();
        }
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateVenue(@RequestBody VenueRequest venueRequest, @PathVariable Integer id){
        ApiResponse<Venue> apiResponse ;
        if(venueService.getVenueById(id) == null){
            throw new ModelException("ID NOT FOUND");
        }else {
            venueService.updateVenue(venueRequest,id);
            apiResponse = ApiResponse.<Venue>builder()
                    .httpStatus(HttpStatus.OK)
                    .message("Venue is updated successfully")
                    .payload(venueService.getVenueById(id))
                    .timestamp(new Date(System.currentTimeMillis()))
                    .build();
        }
        return ResponseEntity.ok(apiResponse);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteVenue (@PathVariable Integer id){
        ApiResponse<Venue> apiResponse;

        if(venueService.getVenueById(id) == null) {
            throw new ModelException("ID NOT FOUND");
        }else{
            apiResponse = ApiResponse.<Venue>builder()
                    .httpStatus(HttpStatus.OK)
                    .message("Venue is successfully deleted")
                    .payload(venueService.getVenueById(id))
                    .timestamp(new Date(System.currentTimeMillis()))
                    .build();
            venueService.deleteVenue(id);
        }
        return ResponseEntity.ok(apiResponse);
    }
}
