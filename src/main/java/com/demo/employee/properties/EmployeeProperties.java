package com.demo.employee.properties;

import com.demo.commons.util.PropertiesReader;

public class EmployeeProperties {

  private EmployeeProperties() {}

  private static final String EMPLOYEE_PROPERTIES_FILE = "employee.properties";

  public static String getEmployeeDAOClass() {
    return PropertiesReader.getProperty("employeeDatabaseDAOClass", EMPLOYEE_PROPERTIES_FILE);
  }

  public static String getDepartmentDAOClass() {
    return PropertiesReader.getProperty("departmentDAOClass", EMPLOYEE_PROPERTIES_FILE);
  }
}
