package com.demo.java7.business.employee.infrastructure.consume.employee.dao;

import com.demo.java7.business.employee.domain.model.EmployeeDto;
import com.demo.java7.business.commons.database.config.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Patrón de diseño: Data Access Object (DAO)
 * <p>
 * <br/>Clase DAO que permite interactuar directamente con la fuente de datos, haciendo uso de instrucciones nativas
 * SQL, NOSQL u otras tecnologías para acceder a la fuente de datos.<br/>
 */
public abstract class EmployeeDatabaseDAO {

  protected abstract String getQueryToGetLatestEmployees();
  private Connection connection = null;
  private PreparedStatement statement = null;
  private ResultSet result = null;

  public EmployeeDto findByCode(int employeeCode) {
    try {
      connection = DatabaseConnection.getConnection();
      connection.setAutoCommit(false);
      statement = connection.prepareStatement("SELECT code, name, contract_date, department_code FROM employees WHERE code = ? ");
      statement.setInt(1, employeeCode);
      result = statement.executeQuery();

      EmployeeDto employee = new EmployeeDto();
      if (result.next()) {
        employee.setCode(result.getInt("code"));
        employee.setName(result.getString("name"));
        employee.setContractDate(result.getDate("contract_date"));
        employee.setDepartmentCode(result.getInt("department_code"));
      }
      connection.commit();
      return employee;

    } catch (Exception exception) {
      rollback();
      throw new RuntimeException("error to find employees by department code: " + exception.getMessage());

    } finally {
      closeResources();
    }
  }

  public List<EmployeeDto> findLatestEmployees(int latest) {
    try {
      connection = DatabaseConnection.getConnection();
      statement = connection.prepareStatement(getQueryToGetLatestEmployees());
      statement.setInt(1, latest);
      result = statement.executeQuery();

      List<EmployeeDto> employeeList = new ArrayList<>();
      while (result.next()) {
        EmployeeDto employee = new EmployeeDto();
        employee.setCode(result.getInt("code"));
        employee.setName(result.getString("name"));
        employee.setContractDate(result.getDate("contract_date"));
        employee.setDepartmentCode(result.getInt("department_code"));

        employeeList.add(employee);
      }
      connection.commit();
      return employeeList;

    } catch (Exception exception) {
      rollback();
      throw new RuntimeException("error to find latest employees: " + exception.getMessage());

    } finally {
      closeResources();
    }
  }

  private void rollback() {
    try {
      if (connection != null) {
        connection.rollback();
      }
    } catch (Exception exception) {
      throw new RuntimeException("error to rollback: " + exception.getMessage());
    }
  }

  private void closeResources() {
    try {
      if (statement != null) {
        statement.close();
      }
      if (result != null) {
        result.close();
      }
    } catch (Exception exception) {
      throw new RuntimeException("error to close resources: " + exception.getMessage());
    }
  }

}
