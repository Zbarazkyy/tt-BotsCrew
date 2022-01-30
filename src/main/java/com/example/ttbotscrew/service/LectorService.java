package com.example.ttbotscrew.service;

import com.example.ttbotscrew.dto.AverageSalaryResponseDto;
import com.example.ttbotscrew.dto.CountEmployeeResponseDto;
import com.example.ttbotscrew.model.Lector;
import java.util.List;

public interface LectorService {
    Lector addLector(Lector lector);

    List<Lector> getLectorByDepartment(String departmentName);

    List<String> getStatistics(String departmentName);

    AverageSalaryResponseDto getAverageSalaryByDepartment(String departmentName);

    CountEmployeeResponseDto getCountEmployeeByDepartment(String departmentName);

    List<Lector> getLectorByTemplate(String template);
}
