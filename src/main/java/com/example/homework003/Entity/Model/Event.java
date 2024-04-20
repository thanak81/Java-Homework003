package com.example.homework003.Entity.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    private Integer eventId;
    private String eventName;
    private Integer venueId;
    private String eventDate;
    private Venue venueList;
    private List<EventAttendee> attendeeList;

}
