package com.demo.employee;

import com.demo.employee.service.EmployeeService;
import com.demo.employee.service.EmployeeServiceImpl;
import com.demo.employee.repository.department.DepartmentRepositoryImpl;
import com.demo.employee.repository.employee.EmployeeRepositoryImpl;

public class EmployeeApplication {

  public static void main(String[] args) {
    EmployeeService employeeService = new EmployeeServiceImpl(new EmployeeRepositoryImpl(), new DepartmentRepositoryImpl());

    //operaciones que se conectan con el servicio web de departamentos
    System.out.println(employeeService.findEmployeeLocation(2));

    //operaciones que solo se conectan a base de datos
    System.out.println(employeeService.findByCode(2));
    System.out.println(employeeService.findLatestEmployees(2));
  }
}
