package com.example.homework003.Controller;

import com.example.homework003.Entity.Model.Event;
import com.example.homework003.Entity.Request.EventRequest;
import com.example.homework003.Entity.Response.ApiResponse;
import com.example.homework003.Exception.ModelException;
import com.example.homework003.Services.Service.EventService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/events/")
@AllArgsConstructor
public class EventController {
    private final EventService eventService;
    @GetMapping("/")
    public ResponseEntity<?> getAllEvent(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer size){
        ApiResponse<List<Event>> apiResponse;
        if(eventService.getAllEvent(page,size).isEmpty()){
            throw new ModelException("No Event Available");

        }else{
            apiResponse = ApiResponse.<List<Event>>builder()
                    .message("Event Lists Retrives")
                    .httpStatus(HttpStatus.FOUND)
                    .payload(eventService.getAllEvent(page, size))
                    .timestamp(new Date(System.currentTimeMillis()))
                    .build();
        }
        return ResponseEntity.ok(apiResponse);

    }

    @GetMapping("{id}")
    public ResponseEntity<?> getAttendeeByID(@PathVariable Integer id){
        ApiResponse<Event> apiResponse;
        if(eventService.getEventById(id) == null){
            throw new ModelException("ID NOT FOUND");
        }else{
            apiResponse = ApiResponse.<Event>builder()
                    .httpStatus(HttpStatus.FOUND)
                    .message("Event with ID "+eventService.getEventById(id).getEventId() + " is retrieve"  )
                    .payload(eventService.getEventById(id))
                    .timestamp(new Date(System.currentTimeMillis()))
                    .build();
        }
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/")
    public ResponseEntity<?> createEvent(@RequestBody EventRequest eventRequest) {
        ApiResponse<Event> apiResponse;
        if(eventRequest.getEventName().isBlank() || eventRequest.getEventDate().isBlank()){
            throw new ModelException("Name or Date must not be blank");
        }
        {
            eventService.createEvent(eventRequest);
            apiResponse = ApiResponse.<Event>builder()
                    .httpStatus(HttpStatus.FOUND)
                    .message("Event Created Successfully")
                    .payload((eventService.getEventById(eventService.createEvent(eventRequest))))
                    .timestamp(new Date(System.currentTimeMillis()))
                    .build();
        }
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateEvent(@RequestBody EventRequest eventRequest,@PathVariable Integer id){
        ApiResponse<Event> apiResponse ;
        if(eventService.getEventById(id) == null){
            throw new ModelException("ID NOT FOUND");
        }else {
            eventService.updateEvent(eventRequest,id);
            apiResponse = ApiResponse.<Event>builder()
                    .httpStatus(HttpStatus.OK)
                    .message("Event is updated successfully")
                    .payload(eventService.getEventById(id))
                    .timestamp(new Date(System.currentTimeMillis()))
                    .build();
        }
        return ResponseEntity.ok(apiResponse);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteEvent (@PathVariable Integer id){
        ApiResponse<Event> apiResponse;

        if(eventService.getEventById(id) == null) {
            throw new ModelException("ID NOT FOUND");
        }else{
            apiResponse = ApiResponse.<Event>builder()
                    .httpStatus(HttpStatus.OK)
                    .message("Event is successfully deleted")
                    .payload(eventService.getEventById(id))
                    .timestamp(new Date(System.currentTimeMillis()))
                    .build();
            eventService.deleteEvent(id);
        }
        return ResponseEntity.ok(apiResponse);
    }
}
