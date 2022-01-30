package com.example.ttbotscrew.controller;

import com.example.ttbotscrew.dto.AverageSalaryResponseDto;
import com.example.ttbotscrew.dto.CountEmployeeResponseDto;
import com.example.ttbotscrew.dto.HeadDepartmentResponseDto;
import com.example.ttbotscrew.dto.LectorResponseDto;
import com.example.ttbotscrew.service.LectorService;
import com.example.ttbotscrew.service.mapper.LectorMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/university")
public class UniversityController {
    private LectorService lectorService;
    private LectorMapper lectorMapper;

    public UniversityController(LectorService lectorService, LectorMapper lectorMapper) {
        this.lectorService = lectorService;
        this.lectorMapper = lectorMapper;
    }

    @GetMapping("/head/{departmentName}")
    public ResponseEntity<List<HeadDepartmentResponseDto>> getHeadDepartment(
            @PathVariable String departmentName) {
        List<HeadDepartmentResponseDto> lectorsByDepartment =
                lectorService.getLectorByDepartment(departmentName).stream()
                .map(l -> lectorMapper.fromModalToHeadDepartmentDto(l, departmentName))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lectorsByDepartment);
    }

    @GetMapping("/statistics/{departmentName}")
    public ResponseEntity<List<String>> getStatistics(@PathVariable String departmentName) {
        return ResponseEntity.ok(lectorService.getStatistics(departmentName));
    }

    @GetMapping("/salary/average/{departmentName}")
    public ResponseEntity<AverageSalaryResponseDto> getAverageSalaryByDepartment(
            @PathVariable String departmentName) {
        AverageSalaryResponseDto responseAverageSalary = lectorService
                .getAverageSalaryByDepartment(departmentName);
        return ResponseEntity.ok(responseAverageSalary);
    }

    @GetMapping("/employee/count/{departmentName}")
    public ResponseEntity<CountEmployeeResponseDto> getCountEmployeeByDepartment(
            @PathVariable String departmentName) {
        CountEmployeeResponseDto responseCountEmployee = lectorService
                .getCountEmployeeByDepartment(departmentName);
        return ResponseEntity.ok(responseCountEmployee);
    }

    @GetMapping("/lector/{template}")
    public ResponseEntity<List<LectorResponseDto>> getLectorByTemplate(
            @PathVariable String template) {
        List<LectorResponseDto> lectorByTemplate = lectorService
                .getLectorByTemplate(template).stream()
                .map(l -> lectorMapper.fromModalToLectorDto(l))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lectorByTemplate);
    }
}
