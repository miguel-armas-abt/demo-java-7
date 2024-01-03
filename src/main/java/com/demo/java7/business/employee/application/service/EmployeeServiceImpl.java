package com.demo.java7.business.employee.application.service;

import com.demo.java7.business.department.domain.model.DepartmentDto;
import com.demo.java7.business.employee.domain.model.EmployeeDto;
import com.demo.java7.business.employee.domain.model.EmployeeLocationDto;
import com.demo.java7.business.employee.infrastructure.consume.department.repository.DepartmentRepository;
import com.demo.java7.business.employee.infrastructure.consume.employee.repository.EmployeeRepository;
import java.util.List;

/**
 * <br/>Clase SERVICE que IMPLEMENTA los métodos necesarios para tramitar la lógica de negocio en el contexto EMPLEADO.<br/>
 */
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository employeeRepository;
  private final DepartmentRepository departmentRepository;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
    this.employeeRepository = employeeRepository;
    this.departmentRepository = departmentRepository;
  }

  @Override
  public List<EmployeeDto> findLatestEmployees(int quantity) {
    return employeeRepository.findLatestEmployees(quantity);
  }

  @Override
  public EmployeeDto findByCode(int employeeCode) {
    return employeeRepository.findByCode(employeeCode);
  }

  @Override
  public EmployeeLocationDto findEmployeeLocation(int employeeCode) {
    EmployeeDto employee = this.findByCode(employeeCode);
    DepartmentDto department = departmentRepository.findByCode(employee.getDepartmentCode());

    EmployeeLocationDto employeeLocation = new EmployeeLocationDto();
    employeeLocation.setCode(employee.getCode());
    employeeLocation.setName(employee.getName());
    employeeLocation.setLocation(department.getLocation());

    return employeeLocation;
  }
}
