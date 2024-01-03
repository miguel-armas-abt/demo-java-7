package com.demo.java7.business.infrastructure.database.config;

import com.demo.java7.business.infrastructure.constant.FileConstant;
import com.demo.java7.business.infrastructure.util.PropertiesReader;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Patrón de diseño: Singleton
 * <p>
 * <br/>Permite instanciar una única conexión a base de datos.<br/>
 */
public class DatabaseConnection {

  private static Connection instance = null;

  public static Connection getConnection() {
    try {
      if (instance == null) {
        Runtime.getRuntime().addShutdownHook(new ShutdownHook());

        String driver = PropertiesReader.getProperty("driver", FileConstant.DB_CONNECTION_FILE);
        String url = PropertiesReader.getProperty("url", FileConstant.DB_CONNECTION_FILE);
        String password = PropertiesReader.getProperty("password", FileConstant.DB_CONNECTION_FILE);
        String user = PropertiesReader.getProperty("user", FileConstant.DB_CONNECTION_FILE);

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
