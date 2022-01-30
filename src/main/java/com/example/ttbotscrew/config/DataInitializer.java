package com.example.ttbotscrew.config;

import com.example.ttbotscrew.model.Degree;
import com.example.ttbotscrew.model.Department;
import com.example.ttbotscrew.model.Lector;
import com.example.ttbotscrew.service.DepartmentService;
import com.example.ttbotscrew.service.LectorService;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private DepartmentService departmentService;
    private LectorService lectorService;

    public DataInitializer(DepartmentService departmentService, LectorService lectorService) {
        this.departmentService = departmentService;
        this.lectorService = lectorService;
    }

    @PostConstruct
    public void inject() {
        Department firstDeprecated = new Department();
        firstDeprecated.setDepartmentsName("financial");
        Department secondDeprecated = new Department();
        secondDeprecated.setDepartmentsName("legal");
        Department thirdDeprecated = new Department();
        thirdDeprecated.setDepartmentsName("mathematical");
        Department fourthDeprecated = new Department();
        fourthDeprecated.setDepartmentsName("literary");
        departmentService.addDepartment(firstDeprecated);
        departmentService.addDepartment(secondDeprecated);
        departmentService.addDepartment(thirdDeprecated);
        departmentService.addDepartment(fourthDeprecated);
        Lector secondLector = new Lector();
        secondLector.setName("Petro");
        secondLector.setSurname("Ivanov");
        secondLector.setDegree(Degree.ASSOCIATE_PROFESSOR);
        secondLector.setDepartments(Arrays.asList(thirdDeprecated));
        secondLector.setSalary(1200);
        lectorService.addLector(secondLector);
        Lector firstLector = new Lector();
        firstLector.setName("Ivan");
        firstLector.setSurname("Petrenk");
        firstLector.setDegree(Degree.ASSISTANT);
        firstLector.setDepartments(Arrays.asList(firstDeprecated, secondDeprecated));
        firstLector.setSalary(2300);
        lectorService.addLector(firstLector);
        Lector fourthLector = new Lector();
        fourthLector.setName("Alisa");
        fourthLector.setSurname("Alisovscaya");
        fourthLector.setDegree(Degree.PROFESSOR);
        fourthLector.setDepartments(Arrays.asList(fourthDeprecated));
        fourthLector.setSalary(3500);
        lectorService.addLector(fourthLector);
        Lector thirdLector = new Lector();
        thirdLector.setName("Third");
        thirdLector.setSurname("Thied");
        thirdLector.setDegree(Degree.PROFESSOR);
        thirdLector.setDepartments(Arrays.asList(firstDeprecated, fourthDeprecated));
        thirdLector.setSalary(1000);
        lectorService.addLector(thirdLector);
    }
}
