package com.demo.java7.business;

import com.demo.java7.business.employee.infrastructure.consume.department.repository.DepartmentRepositoryImpl;
import com.demo.java7.business.employee.infrastructure.consume.employee.repository.EmployeeRepositoryImpl;
import com.demo.java7.business.employee.application.service.EmployeeService;
import com.demo.java7.business.employee.application.service.EmployeeServiceImpl;

public class Application {

  public static void main(String[] args) {
    EmployeeService employeeService = new EmployeeServiceImpl(new EmployeeRepositoryImpl(), new DepartmentRepositoryImpl());
    System.out.println(employeeService.findEmployeeLocation(2));
  }
}
