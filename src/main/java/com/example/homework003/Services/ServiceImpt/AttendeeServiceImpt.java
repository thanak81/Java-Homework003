package com.example.homework003.Services.ServiceImpt;

import com.example.homework003.Entity.Model.Attendee;
import com.example.homework003.Entity.Request.AttendeeRequest;
import com.example.homework003.Repositories.AttendeeRepository;
import com.example.homework003.Services.Service.AttendeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AttendeeServiceImpt implements AttendeeService {
    private final AttendeeRepository attendeeRepository;

    @Override
    public List<Attendee> getAllAttendee(Integer page, Integer size) {
        return attendeeRepository.getAllAttendee(page,size);
    }

    @Override
    public Attendee getAttendeeById(Integer id) {
        return attendeeRepository.getAttendeeByID(id);
    }

    @Override
    public Integer createAttendee(AttendeeRequest attendeeRequest) {
        return attendeeRepository.createAttendee(attendeeRequest);
    }

    @Override
    public Attendee updateAttendee(AttendeeRequest attendeeRequest, Integer id) {
        return attendeeRepository.updateAttendee(attendeeRequest,id);
    }

    @Override
    public Attendee deleteAttendee(Integer id) {
        return attendeeRepository.deleteAttendee(id);
    }
}
