package com.example.homework003.Entity.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venue {
    private Integer venueId;
    private String venuename;
    private String location;
}
