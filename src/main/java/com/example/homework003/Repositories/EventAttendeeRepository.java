package com.example.homework003.Repositories;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EventAttendeeRepository {


    @Select("SELECT * FROM event_attendee")
    @Results({
            @Result(property = "eventList", column = "event_id"),
            @Result(property = "attendeeList" , column = "attendee_id")
    })
    List<?> getAllEventAttendee();

}
