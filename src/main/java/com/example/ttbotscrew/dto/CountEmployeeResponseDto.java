package com.example.ttbotscrew.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountEmployeeResponseDto {
    private int countEmployee;
    private String departmentName;
}
