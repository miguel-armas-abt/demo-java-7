package com.demo.java7.business.infrastructure.properties;

import com.demo.java7.business.infrastructure.constant.FileConstant;
import com.demo.java7.business.infrastructure.util.PropertiesReader;

public class NetworkProperties {

  private NetworkProperties() {}

  public static int DEPARTMENTS_TCP_SERVICE_PORT = Integer.parseInt(PropertiesReader.getProperty("department-tcp-port", FileConstant.NETWORK_FILE));
  public static int DEPARTMENTS_RMI_SERVICE_PORT = Integer.parseInt(PropertiesReader.getProperty("department-rmi-port", FileConstant.NETWORK_FILE));
  public static String SERVER_IP = PropertiesReader.getProperty("server-ip", FileConstant.NETWORK_FILE);
}
