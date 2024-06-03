package com.demo.java7.repository.employee;

import java.util.List;
import com.demo.java7.dto.EmployeeDTO;

public interface EmployeeRepository {

  List<EmployeeDTO> findLatestEmployees(int latest);

  EmployeeDTO findByCode(int employeeCode);
}
