package com.example.homework003.Controller;


import com.example.homework003.Entity.Model.Attendee;
import com.example.homework003.Entity.Request.AttendeeRequest;
import com.example.homework003.Entity.Response.ApiResponse;
import com.example.homework003.Exception.ModelException;
import com.example.homework003.Services.Service.AttendeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/attendees/")
@AllArgsConstructor
public class AttendeeController {
    private final AttendeeService attendeeService;
    @GetMapping("/")
    public ResponseEntity<?> getAllAttendee(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer size){
        System.out.println(attendeeService.getAllAttendee(page,size));
        ApiResponse<List<Attendee>> apiResponse;
        if(attendeeService.getAllAttendee(page,size).isEmpty()){
            throw  new ModelException("No Attendee Available");
        }else{
             apiResponse = ApiResponse.<List<Attendee>>builder()
                .message("Attendees Lists Retrives")
                .httpStatus(HttpStatus.FOUND)
                .payload(attendeeService.getAllAttendee(page, size))
                .timestamp(new Date(System.currentTimeMillis()))
                .build();
        }
        return ResponseEntity.ok(apiResponse);

    }

    @GetMapping("{id}")
    public ResponseEntity<?> getAttendeeByID(@PathVariable Integer id){
        ApiResponse<Attendee> apiResponse;
        if(attendeeService.getAttendeeById(id) == null){
            throw new ModelException("ID NOT FOUND");
        }else{
            apiResponse = ApiResponse.<Attendee>builder()
                    .httpStatus(HttpStatus.FOUND)
                    .message("Attendee with ID "+attendeeService.getAttendeeById(id).getAttendeeId() + " is retrieve"  )
                    .payload(attendeeService.getAttendeeById(id))
                    .timestamp(new Date(System.currentTimeMillis()))
                    .build();
        }
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/")
    public ResponseEntity<?> createAttendee(@RequestBody AttendeeRequest attendeeRequest) {
        ApiResponse<Attendee> apiResponse;
        if(attendeeRequest.getAttendeeName().isBlank() ){
            throw new ModelException("Name must not be blank");
        }
        if(attendeeRequest.getEmail().isBlank()){
            throw new ModelException("Email must not be blank");
        }
        {
            attendeeService.createAttendee(attendeeRequest);
            apiResponse = ApiResponse.<Attendee>builder()
                    .httpStatus(HttpStatus.FOUND)
                    .message("Attendee Created Successfully")
                    .payload((attendeeService.getAttendeeById(attendeeService.createAttendee(attendeeRequest))))
                    .timestamp(new Date(System.currentTimeMillis()))
                    .build();
        }
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateAttendee(@RequestBody AttendeeRequest attendeeRequest,@PathVariable Integer id){
        ApiResponse<Attendee> apiResponse ;
        if(attendeeService.getAttendeeById(id) == null){
            throw new ModelException("ID NOT FOUND");
//            apiResponse= ApiResponse.<Attendee>builder()
//                    .httpStatus(HttpStatus.NOT_FOUND)
//                    .message("ID NOT FOUND")
//                    .timestamp(new Date(System.currentTimeMillis()))
//                    .build();
//            return ResponseEntity.ok(apiResponse);
        }else {
            attendeeService.updateAttendee(attendeeRequest,id);
            apiResponse = ApiResponse.<Attendee>builder()
                    .httpStatus(HttpStatus.OK)
                    .message("Attendee is updated successfully")
                    .payload(attendeeService.getAttendeeById(id))
                    .timestamp(new Date(System.currentTimeMillis()))
                    .build();
        }
        return ResponseEntity.ok(apiResponse);
}
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteAttendee (@PathVariable Integer id){
        ApiResponse<Attendee> apiResponse;

        if(attendeeService.getAttendeeById(id) == null) {
            throw new ModelException("ID NOT FOUND");
        }else{
            apiResponse = ApiResponse.<Attendee>builder()
                    .httpStatus(HttpStatus.OK)
                    .message("Attendee is successfully deleted")
                    .payload(attendeeService.getAttendeeById(id))
                    .timestamp(new Date(System.currentTimeMillis()))
                    .build();
            attendeeService.deleteAttendee(id);
        }
        return ResponseEntity.ok(apiResponse);
    }
}
