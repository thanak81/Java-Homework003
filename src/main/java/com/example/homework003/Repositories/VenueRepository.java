package com.example.homework003.Repositories;


import com.example.homework003.Entity.Model.Event;
import com.example.homework003.Entity.Model.Venue;
import com.example.homework003.Entity.Request.EventRequest;
import com.example.homework003.Entity.Request.VenueRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VenueRepository {

    @Select("SELECT * FROM venues ORDER BY venue_id LIMIT #{size} OFFSET (#{page}-1)")
    @Results({
            @Result(property = "venueId", column = "venue_id"),
    })
    List<Venue> getAllVenue (Integer page, Integer size);
    @Select("SELECT * FROM venues where venue_id = #{id}")
    @Results ({
            @Result(property = "venueId", column = "venue_id"),
    })
    Venue getVenueByID(Integer id);
    @Select("INSERT INTO venues (venuename,location) VALUES  (#{request.venuename},#{request.location}  )returning venue_id")
    Integer createVenue(@Param("request") VenueRequest venueRequest);
    @Select("UPDATE venues SET venuename= #{request.venuename} ,location = #{request.location}  WHERE venue_id= #{id}")
    @Result (property = "venueId", column = "venue_id")
    Venue  updateVenue (@Param("request") VenueRequest venueRequest, Integer id);

    @Select("DELETE  FROM venues WHERE venue_id=#{id}")
    @Result (property = "venueId", column = "venue_id")
    Venue  deleteVenue (Integer id);
}
