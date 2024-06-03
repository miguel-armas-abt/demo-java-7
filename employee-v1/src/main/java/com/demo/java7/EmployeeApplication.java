package com.demo.java7;

import com.demo.java7.service.EmployeeService;
import com.demo.java7.service.EmployeeServiceImpl;
import com.demo.java7.repository.department.DepartmentRepositoryImpl;
import com.demo.java7.repository.employee.EmployeeRepositoryImpl;

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
