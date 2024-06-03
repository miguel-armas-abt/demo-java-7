package com.demo.java7.commons.database.config;

import com.demo.java7.commons.util.PropertiesReader;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Patrón de diseño: Singleton
 * <p>
 * <br/>Permite instanciar una única conexión a base de datos.<br/>
 */
public class MySQLConnection {

  private static Connection instance = null;

  public static Connection getConnection() {

      if (instance == null) {
        try {
          String driver = PropertiesReader.getProperty("database.driver");
          String url = PropertiesReader.getProperty("database.url");
          String password = PropertiesReader.getProperty("database.password");
          String user = PropertiesReader.getProperty("database.user");

          Class.forName(driver);
          instance = DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {
          throw new RuntimeException("Error connecting with database", ex);
        }
      }
      return instance;
  }
}