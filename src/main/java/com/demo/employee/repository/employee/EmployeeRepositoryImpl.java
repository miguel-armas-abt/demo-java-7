package com.demo.employee.repository.employee;

import com.demo.commons.util.ObjectFactory;
import com.demo.employee.constant.EmployeeConstant;
import com.demo.employee.repository.employee.dao.EmployeeDatabaseDAO;
import com.demo.employee.dto.EmployeeDTO;
import com.demo.commons.util.PropertiesReader;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

  private final EmployeeDatabaseDAO employeeDao = (EmployeeDatabaseDAO) ObjectFactory.build(selectDaoClass());

  @Override
  public List<EmployeeDTO> findLatestEmployees(int quantity) {
    return employeeDao.findLatestEmployees(quantity);
  }

  @Override
  public EmployeeDTO findByCode(int employeeCode) {
    return employeeDao.findByCode(employeeCode);
  }

  private static String selectDaoClass() {
    return PropertiesReader.getProperty("employeeDatabaseDaoClass", EmployeeConstant.EMPLOYEE_PROPERTIES_FILE);
  }
}
