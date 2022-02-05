package com.sombreurs.demo2.repo;

import com.sombreurs.demo2.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {



}
