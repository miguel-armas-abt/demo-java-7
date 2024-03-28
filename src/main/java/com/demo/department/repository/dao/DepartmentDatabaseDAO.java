package com.demo.department.repository.dao;

import com.demo.commons.database.config.DatabaseConnection;
import com.demo.department.dto.DepartmentDTO;
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

  public List<DepartmentDTO> findAll() {
    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement("SELECT code, name, location FROM departments");
         ResultSet result = statement.executeQuery()) {

      List<DepartmentDTO> departmentList = new ArrayList<>();
      while (result.next()) {
        DepartmentDTO department = new DepartmentDTO();
        department.setCode(result.getInt("code"));
        department.setName(result.getString("name"));
        department.setLocation(result.getString("location"));
        departmentList.add(department);
      }
      return departmentList;

    } catch (Exception ex) {
      throw new RuntimeException("Error to find all departments: " + ex.getMessage(), ex);
    }
  }

  public DepartmentDTO findByCode(int code) {
    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement("SELECT code, name, location FROM departments WHERE code = ?")) {

      statement.setInt(1, code);
      try (ResultSet result = statement.executeQuery()) {
        DepartmentDTO department = new DepartmentDTO();
        if (result.next()) {
          department.setCode(result.getInt("code"));
          department.setLocation(result.getString("location"));
          department.setName(result.getString("name"));
        }
        return department;
      }

    } catch (Exception exception) {
      throw new RuntimeException("Error to find department by code: " + exception.getMessage(), exception);
    }
  }
}

