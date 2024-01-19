package com.demo.java7.business.commons.database.config;

import com.demo.java7.business.commons.util.PropertiesReader;
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
    try {
      if (instance == null) {
        Runtime.getRuntime().addShutdownHook(new ShutdownHook());

        String driver = PropertiesReader.getProperty("driver", DB_CONNECTION_FILE);
        String url = PropertiesReader.getProperty("url", DB_CONNECTION_FILE);
        String password = PropertiesReader.getProperty("password", DB_CONNECTION_FILE);
        String user = PropertiesReader.getProperty("user", DB_CONNECTION_FILE);

        Class.forName(driver);
        instance = DriverManager.getConnection(url, user, password);
      }
      return instance;
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException();
    }
  }

  /**
   * En caso de alguna interrupción el método run() se ejecutará de todos modos.
   */
  static class ShutdownHook extends Thread {
    public void run() {
      try {
        Connection connection = DatabaseConnection.getConnection();
        connection.close();
      } catch (Exception exception) {
        exception.printStackTrace();
        throw new RuntimeException();
      }
    }
  }

}
