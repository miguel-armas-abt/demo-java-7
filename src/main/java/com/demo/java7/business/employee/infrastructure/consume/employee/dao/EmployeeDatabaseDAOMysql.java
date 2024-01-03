package com.demo.java7.business.employee.infrastructure.consume.employee.dao;

public class EmployeeDatabaseDAOMysql extends EmployeeDatabaseDAO {

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
