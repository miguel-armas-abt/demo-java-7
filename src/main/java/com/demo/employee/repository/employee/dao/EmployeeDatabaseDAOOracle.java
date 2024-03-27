package com.demo.employee.repository.employee.dao;

public class EmployeeDatabaseDAOOracle extends EmployeeDatabaseDAO {

  @Override
  public String getQueryToGetLatestEmployees(){
    String selectQuery = "";
    selectQuery += "SELECT number, name, contract_date, department_code ";
    selectQuery += "FROM employees ";
    selectQuery += "ORDER BY contract_date DESC ";
    selectQuery += "LIMIT ? ";
    return selectQuery;
  }

}
