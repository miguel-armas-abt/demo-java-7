package com.demo.java7.service;

import java.util.List;

import com.demo.java7.dto.EmployeeDTO;
import com.demo.java7.dto.EmployeeLocationDTO;

public interface EmployeeService {

  List<EmployeeDTO> findLatestEmployees(int quantity);

  EmployeeDTO findByCode(int employeeCode);

  EmployeeLocationDTO findEmployeeLocation(int employeeCode);
}
