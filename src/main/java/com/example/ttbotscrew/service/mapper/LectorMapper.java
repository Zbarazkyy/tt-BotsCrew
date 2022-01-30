package com.example.ttbotscrew.service.mapper;

import com.example.ttbotscrew.dto.DepartmentResponseDto;
import com.example.ttbotscrew.dto.HeadDepartmentResponseDto;
import com.example.ttbotscrew.dto.LectorResponseDto;
import com.example.ttbotscrew.model.Lector;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class LectorMapper {
    public HeadDepartmentResponseDto fromModalToHeadDepartmentDto(Lector lector,
                                                                  String departmentName) {
        HeadDepartmentResponseDto responseDto = new HeadDepartmentResponseDto();
        responseDto.setName(lector.getName());
        responseDto.setSurname(lector.getSurname());
        responseDto.setDepartmentName(departmentName);
        return responseDto;
    }

    public LectorResponseDto fromModalToLectorDto(Lector lector) {
        LectorResponseDto responseDto = new LectorResponseDto();
        responseDto.setName(lector.getName());
        responseDto.setSurname(lector.getSurname());
        responseDto.setDegree(lector.getDegree());
        responseDto.setDepartments(lector.getDepartments()
                .stream()
                .map(l -> new DepartmentResponseDto(l.getDepartmentsName()))
                .collect(Collectors.toList()));
        responseDto.setSalary(lector.getSalary());
        return responseDto;
    }
}
