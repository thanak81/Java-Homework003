package com.example.homework003.Repositories;


import com.example.homework003.Entity.Model.Event;
import com.example.homework003.Entity.Request.EventRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
publics interface EventRepository {
    @Select("SELECT * FROM events ORDER BY event_id LIMIT #{size} OFFSET (#{page}-1)")
    @Results(id = "eventResultMap", value = {
            @Result(property = "eventId", column = "event_id"),
            @Result(property = "eventName", column = "event_name"),
            @Result(property = "eventDate" , column = "event_date"),
            @Result(property = "venueId" , column = "venue_id"),
            @Result(property = "venueList" , column = "venue_id", one = @One(select = "com.example.homework003.Repositories.VenueRepository.getVenueByID")),
            @Result(property = "attendeeList", column = "event_id", many = @Many(select = "com.example.homework003.Repositories.AttendeeRepository.getAllAttendee"))
    })
    List<Event> getAllEvent (Integer page, Integer size);
    @Select("SELECT * FROM events where event_id = #{id}")
    @ResultMap("eventResultMap")
    Event getEventByID(Integer id);
    @Select("INSERT INTO events (event_name,event_date,venue_id) VALUES  (#{request.eventName} , #{request.eventDate} , #{request.venueId} )returning event_id")
    Integer createEvent(@Param("request")EventRequest eventRequest);
    @Select("UPDATE events SET event_name = #{request.eventName}, event_date=  #{request.date} , venue_id= #{venue_id} WHERE event_id= #{id}")
    @Result (property = "eventId", column = "event_id")
    Event  updateEvent (@Param("request") EventRequest eventRequest, Integer id);

    @Select("DELETE  FROM events WHERE event_id=#{id}")
    @Result (property = "eventId", column = "event_id")
    Event  deleteEvent (Integer id);
}
