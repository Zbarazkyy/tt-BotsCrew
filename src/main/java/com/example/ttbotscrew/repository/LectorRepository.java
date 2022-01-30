package com.example.ttbotscrew.repository;

import com.example.ttbotscrew.model.Lector;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LectorRepository extends JpaRepository<Lector, Long> {
    @Query("SELECT l FROM Lector l  join fetch l.departments ld WHERE ld.departmentsName = ?1")
    List<Lector> findLectorByDepartment(String departmentName);

    @Query(value = "SELECT l.degree, COUNT(*) "
            + "FROM departments AS d "
            + "JOIN lectors_departments AS ld "
            + "ON d.id = ld.departments_id "
            + "JOIN lectors AS l "
            + "ON l.id = ld.lector_id "
            + "WHERE d.departments_name = ?1 "
            + "GROUP BY l.degree",
            nativeQuery = true)
    List<String> getStatistics(String departmentName);

    @Query(value = "SELECT AVG(l.salary) "
            + "FROM departments AS d "
            + "JOIN lectors_departments AS ld "
            + "ON d.id = ld.departments_id "
            + "JOIN lectors AS l "
            + "ON l.id = ld.lector_id "
            + "WHERE d.departments_name = ?1 "
            + "GROUP BY d.departments_name",
            nativeQuery = true)
    Optional<Integer> getAverageSalaryByDepartment(String departmentName);

    @Query(value = "SELECT COUNT(l.id) "
            + "FROM departments AS d "
            + "JOIN lectors_departments AS ld "
            + "ON d.id = ld.departments_id "
            + "JOIN lectors as l "
            + "ON l.id = ld.lector_id "
            + "WHERE d.departments_name = ?1 "
            + "GROUP BY d.departments_name",
            nativeQuery = true)
    int getCountEmployeeByDepartment(String departmentName);

    @Query("SELECT DISTINCT l FROM Lector l WHERE l.name LIKE %?1% OR l.surname LIKE %?1%")
    List<Lector> getLectorByTemplate(String template);
}
