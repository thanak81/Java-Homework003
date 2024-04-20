package com.example.homework003.Exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse{
    private String type;
    private HttpStatus title;
    private String instance;
    private Integer statusCode;
    private String message;
    private Date timestamp;
    private List<String> errors;
}
