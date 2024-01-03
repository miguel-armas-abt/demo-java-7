package com.demo.java7.business.infrastructure.properties;

import com.demo.java7.business.infrastructure.constant.FileConstant;
import com.demo.java7.business.infrastructure.util.PropertiesReader;

public class TcpServiceNameProperties {

  private TcpServiceNameProperties() {}

  public static final int DEPARTMENTS_FIND_ALL = Integer.parseInt(PropertiesReader.getProperty("departments-find-all", FileConstant.TCP_SERVICES_FILE));
  public static final int DEPARTMENTS_FIND_BY_CODE = Integer.parseInt(PropertiesReader.getProperty("departments-find-by-code", FileConstant.TCP_SERVICES_FILE));

}
