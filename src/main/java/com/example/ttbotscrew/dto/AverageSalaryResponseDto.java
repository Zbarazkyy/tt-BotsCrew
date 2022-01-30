package com.example.ttbotscrew.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AverageSalaryResponseDto {
    private int averageSalary;
    private String departmentName;
}
