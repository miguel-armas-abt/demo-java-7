package com.demo.java7.business.department.infrastructure.consume.dao;

import com.demo.java7.business.department.domain.model.DepartmentDto;
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
public class DepartmentDatabaseDAO {

  private Connection connection = null;
  private PreparedStatement statement = null;
  private ResultSet result = null;

  public List<DepartmentDto> findAll() {
    try {
      connection = DatabaseConnection.getConnection();
      connection.setAutoCommit(false); //Las transacciones en BD no se confirmarán automáticamente. A continuación, debes confirmar (commit) o deshacer (rollback) explícitamente
      statement = connection.prepareStatement("SELECT code, name, location FROM departments ");
      result = statement.executeQuery();

      List<DepartmentDto> departmentList = new ArrayList<>();
      while (result.next()) {
        DepartmentDto department = new DepartmentDto();
        department.setCode(result.getInt("code"));
        department.setName(result.getString("name"));
        department.setLocation(result.getString("location"));
        departmentList.add(department);
      }
      connection.commit(); //Confirmamos la transacción al finalizar una operación exitosa
      return departmentList;

    } catch (Exception ex) {
      rollback(); //Deshacemos la transacción tras una operación errónea
      throw new RuntimeException("error to find all departments: " + ex.getMessage());
    } finally {
      closeResources();
    }
  }

  public DepartmentDto findByCode(int code) {
    try {
      connection = DatabaseConnection.getConnection();
      connection.setAutoCommit(false);
      statement = connection.prepareStatement("SELECT code, name, location FROM departments WHERE code = ?");
      statement.setInt(1, code);
      result = statement.executeQuery();

      DepartmentDto department = new DepartmentDto();
      if (result.next()) {
        department.setCode(result.getInt("code"));
        department.setLocation(result.getString("location"));
        department.setName(result.getString("name"));
      }
      connection.commit();
      return department;

    } catch (Exception exception) {
      rollback();
      throw new RuntimeException("error to find department by code: " + exception.getMessage());
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

