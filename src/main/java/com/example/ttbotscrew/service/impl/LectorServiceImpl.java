package com.example.ttbotscrew.service.impl;

import com.example.ttbotscrew.dto.AverageSalaryResponseDto;
import com.example.ttbotscrew.dto.CountEmployeeResponseDto;
import com.example.ttbotscrew.model.Lector;
import com.example.ttbotscrew.repository.LectorRepository;
import com.example.ttbotscrew.service.LectorService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LectorServiceImpl implements LectorService {
    private LectorRepository lectorRepository;

    public LectorServiceImpl(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }

    @Override
    public Lector addLector(Lector lector) {
        return lectorRepository.save(lector);
    }

    @Override
    public List<Lector> getLectorByDepartment(String departmentName) {
        return lectorRepository.findLectorByDepartment(departmentName);
    }

    public List<String> getStatistics(String departmentName) {
        List<String> statistics = lectorRepository.getStatistics(departmentName);
        return statistics;
    }

    @Override
    public AverageSalaryResponseDto getAverageSalaryByDepartment(String departmentName) {
        Integer averageSalary = lectorRepository.getAverageSalaryByDepartment(departmentName)
                .orElse(0);
        return new AverageSalaryResponseDto(averageSalary, departmentName);
    }

    @Override
    public CountEmployeeResponseDto getCountEmployeeByDepartment(String departmentName) {
        return new CountEmployeeResponseDto(
                lectorRepository.getCountEmployeeByDepartment(departmentName), departmentName);
    }

    @Override
    public List<Lector> getLectorByTemplate(String template) {
        return lectorRepository.getLectorByTemplate(template);
    }
}
