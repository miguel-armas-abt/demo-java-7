package com.demo.employee.service;

import java.util.List;

import com.demo.employee.dto.EmployeeDTO;
import com.demo.employee.dto.EmployeeLocationDTO;

public interface EmployeeService {

  List<EmployeeDTO> findLatestEmployees(int quantity);

  EmployeeDTO findByCode(int employeeCode);

  EmployeeLocationDTO findEmployeeLocation(int employeeCode);
}
