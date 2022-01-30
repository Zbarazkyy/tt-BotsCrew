package com.example.ttbotscrew.dto;

import com.example.ttbotscrew.model.Degree;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LectorResponseDto {
    private String name;
    private String surname;
    private Degree degree;
    private List<DepartmentResponseDto> departments;
    private int salary;
}
