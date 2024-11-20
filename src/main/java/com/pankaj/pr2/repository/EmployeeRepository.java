package com.pankaj.pr2.repository;

import com.pankaj.pr2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}