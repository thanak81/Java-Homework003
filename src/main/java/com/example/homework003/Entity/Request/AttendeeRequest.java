package com.example.homework003.Entity.Request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendeeRequest {
    private String attendeeName;
    private String email;
}
