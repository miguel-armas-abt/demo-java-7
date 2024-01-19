package com.demo.java7.business.employee.infrastructure.consume.employee.repository;

import com.demo.java7.business.employee.infrastructure.constant.EmployeeConstant;
import com.demo.java7.business.employee.infrastructure.consume.employee.dao.EmployeeDatabaseDAO;
import com.demo.java7.business.employee.domain.model.EmployeeDto;
import com.demo.java7.business.commons.util.ObjectFactory;
import com.demo.java7.business.commons.util.PropertiesReader;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

  private final EmployeeDatabaseDAO employeeDao = (EmployeeDatabaseDAO) ObjectFactory.build(selectDaoClass());

  @Override
  public List<EmployeeDto> findLatestEmployees(int quantity) {
    return employeeDao.findLatestEmployees(quantity);
  }

  @Override
  public EmployeeDto findByCode(int employeeCode) {
    return employeeDao.findByCode(employeeCode);
  }

  private static String selectDaoClass() {
    return PropertiesReader.getProperty("employeeDatabaseDaoClass", EmployeeConstant.EMPLOYEE_PROPERTIES_FILE);
  }
}
