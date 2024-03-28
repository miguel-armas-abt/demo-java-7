package com.demo.department.properties;

import com.demo.commons.util.PropertiesReader;

public class DepartmentProperties {

  private DepartmentProperties() {}

  private static final String DEPARTMENT_PROPERTIES_FILE = "department.properties";

  public static String getDepartmentDAOClass() {
    return PropertiesReader.getProperty("departmentDAOClass", DEPARTMENT_PROPERTIES_FILE);
  }

}
