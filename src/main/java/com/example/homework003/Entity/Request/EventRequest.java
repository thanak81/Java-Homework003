package com.example.homework003.Entity.Request;

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
public class EventRequest {
    private String eventName;
    private String eventDate;
    private Integer venueId;
    private List<Integer> attendeeId;
}
