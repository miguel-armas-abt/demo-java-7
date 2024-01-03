package com.demo.java7.business.employee.application.service;

import java.util.List;

import com.demo.java7.business.employee.domain.model.EmployeeDto;
import com.demo.java7.business.employee.domain.model.EmployeeLocationDto;

public interface EmployeeService {

  List<EmployeeDto> findLatestEmployees(int quantity);

  EmployeeDto findByCode(int employeeCode);

  EmployeeLocationDto findEmployeeLocation(int employeeCode);
}
