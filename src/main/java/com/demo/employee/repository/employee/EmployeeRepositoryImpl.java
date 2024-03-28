package com.demo.employee.repository.employee;

import com.demo.commons.util.ObjectFactory;
import com.demo.employee.properties.EmployeeProperties;
import com.demo.employee.repository.employee.dao.EmployeeDatabaseDAO;
import com.demo.employee.dto.EmployeeDTO;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

  private final EmployeeDatabaseDAO employeeDao = (EmployeeDatabaseDAO) ObjectFactory.build(EmployeeProperties.getEmployeeDAOClass());

  @Override
  public List<EmployeeDTO> findLatestEmployees(int quantity) {
    return employeeDao.findLatestEmployees(quantity);
  }

  @Override
  public EmployeeDTO findByCode(int employeeCode) {
    return employeeDao.findByCode(employeeCode);
  }
}
