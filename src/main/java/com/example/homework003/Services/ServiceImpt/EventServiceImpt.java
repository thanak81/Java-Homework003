package com.example.homework003.Services.ServiceImpt;

import com.example.homework003.Entity.Model.Attendee;
import com.example.homework003.Entity.Model.Event;
import com.example.homework003.Entity.Request.AttendeeRequest;
import com.example.homework003.Entity.Request.EventRequest;
import com.example.homework003.Repositories.EventRepository;
import com.example.homework003.Services.Service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class EventServiceImpt implements EventService {
    private final EventRepository eventRepository;

    @Override
    public List<Event> getAllEvent(Integer page, Integer size) {
        return eventRepository.getAllEvent(page,size);
    }

    @Override
    public Event getEventById(Integer id) {
        return eventRepository.getEventByID(id);
    }

    @Override
    public Integer createEvent(EventRequest eventRequest) {
        return eventRepository.createEvent(eventRequest);
    }


    @Override
    public Event updateEvent(EventRequest eventRequest, Integer id) {
        return eventRepository.updateEvent(eventRequest,id);
    }

    @Override
    public Event deleteEvent(Integer id) {
        return eventRepository.deleteEvent(id);
    }
}
