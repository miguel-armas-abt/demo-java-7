package com.demo.java7.service;

import com.demo.java7.departments.dto.DepartmentDTO;
import com.demo.java7.dto.EmployeeDTO;
import com.demo.java7.dto.EmployeeLocationDTO;
import com.demo.java7.repository.department.DepartmentRepository;
import com.demo.java7.repository.employee.EmployeeRepository;
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
  public List<EmployeeDTO> findLatestEmployees(int quantity) {
    return employeeRepository.findLatestEmployees(quantity);
  }

  @Override
  public EmployeeDTO findByCode(int employeeCode) {
    return employeeRepository.findByCode(employeeCode);
  }

  @Override
  public EmployeeLocationDTO findEmployeeLocation(int employeeCode) {
    EmployeeDTO employee = this.findByCode(employeeCode);
    DepartmentDTO department = departmentRepository.findByCode(employee.getDepartmentCode());

    EmployeeLocationDTO employeeLocation = new EmployeeLocationDTO();
    employeeLocation.setCode(employee.getCode());
    employeeLocation.setName(employee.getName());
    employeeLocation.setLocation(department.getLocation());

    return employeeLocation;
  }
}
