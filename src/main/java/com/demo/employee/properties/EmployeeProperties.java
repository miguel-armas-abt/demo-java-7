package com.demo.employee.properties;

import com.demo.commons.util.PropertiesReader;

public class EmployeeProperties {

  private EmployeeProperties() {}

  private static final String EMPLOYEE_PROPERTIES_FILE = "employee.properties";

  public static String getDepartmentConnectorDAOClass() {
    return PropertiesReader.getProperty("departmentConnectorDAOClass", EMPLOYEE_PROPERTIES_FILE);
  }
}
