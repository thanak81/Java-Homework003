package com.example.homework003.Services.Service;

import com.example.homework003.Entity.Model.Event;
import com.example.homework003.Entity.Model.Venue;
import com.example.homework003.Entity.Request.EventRequest;
import com.example.homework003.Entity.Request.VenueRequest;

import java.util.List;

public interface VenueService {
    List<Venue> getAllVenue(Integer page, Integer size);
    Venue getVenueById(Integer id);
    Integer createVenue( VenueRequest venueRequest);
    Venue updateVenue(VenueRequest venueRequest, Integer id);
    Venue deleteVenue(Integer id);
}
