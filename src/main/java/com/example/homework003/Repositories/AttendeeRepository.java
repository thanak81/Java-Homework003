package com.example.homework003.Repositories;


import com.example.homework003.Entity.Model.Attendee;
import com.example.homework003.Entity.Request.AttendeeRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AttendeeRepository {

    @Select("SELECT * FROM attendees ORDER BY attendee_id LIMIT #{size} OFFSET (#{page}-1)")
    @Results ({
            @Result(property = "attendeeId", column = "attendee_id"),
            @Result(property = "attendeeName", column = "attendee_name")
    })
    List<Attendee> getAllAttendee (Integer page, Integer size);
    @Select("SELECT * FROM attendees where attendee_id = #{id}")
    @Results ({
            @Result(property = "attendeeId", column = "attendee_id"),
            @Result(property = "attendeeName", column = "attendee_name")
    })
    Attendee getAttendeeByID(Integer id);

    @Select("INSERT INTO attendees (attendee_name, email) VALUES  (#{request.attendeeName} , #{request.email} )returning attendee_id")
    Integer createAttendee(@Param("request") AttendeeRequest attendeeRequest);
    @Select("UPDATE attendees SET attendee_name = #{request.attendeeName}, email=  #{request.email} WHERE attendee_id= #{id}")
    @Result (property = "attendeeId", column = "attendee_id")
    Attendee updateAttendee(@Param("request") AttendeeRequest attendeeRequest,Integer id);

    @Select("DELETE  FROM attendees WHERE attendee_id=#{id}")
    @Result (property = "attendeeId", column = "attendee_id")
    Attendee deleteAttendee(Integer id);
}
