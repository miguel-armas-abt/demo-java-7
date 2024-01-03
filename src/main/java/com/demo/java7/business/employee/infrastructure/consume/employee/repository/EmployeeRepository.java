package com.demo.java7.business.employee.infrastructure.consume.employee.repository;

import java.util.List;
import com.demo.java7.business.employee.domain.model.EmployeeDto;

public interface EmployeeRepository {

  List<EmployeeDto> findLatestEmployees(int latest);

  EmployeeDto findByCode(int employeeCode);
}
