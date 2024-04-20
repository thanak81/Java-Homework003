package com.example.homework003.Services.Service;

import com.example.homework003.Entity.Model.Attendee;
import com.example.homework003.Entity.Request.AttendeeRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface AttendeeService {
     List<Attendee> getAllAttendee(Integer page,Integer size);
    Attendee getAttendeeById(Integer id);
     Integer createAttendee( AttendeeRequest attendeeRequest);
     Attendee updateAttendee(AttendeeRequest attendeeRequest, Integer id);
     Attendee deleteAttendee(Integer id);

}
