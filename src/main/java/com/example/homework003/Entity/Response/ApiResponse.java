package com.example.homework003.Entity.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse <t> {
    private String message;
    private HttpStatus httpStatus;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private t payload;
    private Date timestamp;
}
