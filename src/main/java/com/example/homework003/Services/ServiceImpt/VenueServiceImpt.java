package com.example.homework003.Services.ServiceImpt;

import com.example.homework003.Entity.Model.Event;
import com.example.homework003.Entity.Model.Venue;
import com.example.homework003.Entity.Request.EventRequest;
import com.example.homework003.Entity.Request.VenueRequest;
import com.example.homework003.Repositories.VenueRepository;
import com.example.homework003.Services.Service.VenueService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class VenueServiceImpt implements VenueService {
    private final VenueRepository venueRepository;

    @Override
    public List<Venue> getAllVenue(Integer page, Integer size) {
        return venueRepository.getAllVenue(page,size);
    }

    @Override
    public Venue getVenueById(Integer id) {
        return venueRepository.getVenueByID(id);
    }

    @Override
    public Integer createVenue(VenueRequest venueRequest) {
        return venueRepository.createVenue(venueRequest);
    }


    @Override
    public Venue updateVenue(VenueRequest venueRequest, Integer id) {
        return venueRepository.updateVenue(venueRequest,id);
    }

    @Override
    public Venue deleteVenue(Integer id) {
        return venueRepository.deleteVenue(id);
    }
}
