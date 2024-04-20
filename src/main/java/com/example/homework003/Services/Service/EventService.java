package com.example.homework003.Services.Service;

import com.example.homework003.Entity.Model.Attendee;
import com.example.homework003.Entity.Model.Event;
import com.example.homework003.Entity.Request.AttendeeRequest;
import com.example.homework003.Entity.Request.EventRequest;

import java.util.List;

public interface EventService {
    List<Event> getAllEvent(Integer page, Integer size);
    Event getEventById(Integer id);
    Integer createEvent( EventRequest eventRequest);
    Event updateEvent(EventRequest eventRequest, Integer id);
    Event deleteEvent(Integer id);
}
