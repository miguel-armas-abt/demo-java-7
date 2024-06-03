package com.demo.java7.repository.employee;

import com.demo.java7.repository.employee.dao.EmployeeDAO;
import com.demo.java7.dto.EmployeeDTO;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

  private final EmployeeDAO employeeDao;

  public EmployeeRepositoryImpl() {
    employeeDao = new EmployeeDAO();
  }

  @Override
  public List<EmployeeDTO> findLatestEmployees(int quantity) {
    return employeeDao.findLatestEmployees(quantity);
  }

  @Override
  public EmployeeDTO findByCode(int employeeCode) {
    return employeeDao.findByCode(employeeCode);
  }
}
