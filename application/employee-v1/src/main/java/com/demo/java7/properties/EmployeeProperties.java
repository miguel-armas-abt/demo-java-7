package com.demo.java7.properties;

import com.demo.java7.commons.util.PropertiesReader;

public class EmployeeProperties {

  private EmployeeProperties() {}

  public static String getDepartmentConnectorDAOClass() {
    return PropertiesReader.getProperty("web-client.department.dao-selector-class");
  }

  public static String getDepartmentServerIP() {
    return PropertiesReader.getProperty("web-client.department.ip");
  }

  public static int getDepartmentServerTCPPort() {
    return Integer.parseInt(PropertiesReader.getProperty("web-client.department.tcp-port"));
  }

  public static int getDepartmentServerRMIPort() {
    return Integer.parseInt(PropertiesReader.getProperty("web-client.department.rmi-port"));
  }
}
