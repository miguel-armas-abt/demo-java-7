package com.demo.employee.repository.employee;

import java.util.List;
import com.demo.employee.dto.EmployeeDTO;

public interface EmployeeRepository {

  List<EmployeeDTO> findLatestEmployees(int latest);

  EmployeeDTO findByCode(int employeeCode);
}
