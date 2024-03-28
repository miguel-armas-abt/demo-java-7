package com.demo.commons.database.config;

import com.demo.commons.util.PropertiesReader;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Patrón de diseño: Singleton
 * <p>
 * <br/>Permite instanciar una única conexión a base de datos.<br/>
 */
public class DatabaseConnection {

  private static final String DB_CONNECTION_FILE = "mysql-jdbc.properties";
  private static Connection instance = null;

  public static Connection getConnection() {

      if (instance == null) {
        try {
          String driver = PropertiesReader.getProperty("driver", DB_CONNECTION_FILE);
          String url = PropertiesReader.getProperty("url", DB_CONNECTION_FILE);
          String password = PropertiesReader.getProperty("password", DB_CONNECTION_FILE);
          String user = PropertiesReader.getProperty("user", DB_CONNECTION_FILE);

          Class.forName(driver);
          instance = DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {
          throw new RuntimeException("Error connecting with database", ex);
        }
      }
      return instance;
  }
}