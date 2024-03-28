package com.demo.employee.repository.employee.dao;

public class EmployeeMysqlDAO extends EmployeeDAO {

  @Override
  public String getQueryToGetLatestEmployees() {
    String selectQuery = "";
    selectQuery += "SELECT code, name, contract_date, department_code ";
    selectQuery += "FROM employees ";
    selectQuery += "ORDER BY contract_date DESC ";
    selectQuery += "LIMIT ? ";
    return selectQuery;
  }

}
