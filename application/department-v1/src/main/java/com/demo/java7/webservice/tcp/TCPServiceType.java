package com.demo.java7.webservice.tcp;

public enum TCPServiceType {

  DEPARTMENTS_FIND_ALL(1),
  DEPARTMENTS_FIND_BY_CODE(2);

  private final int serviceCode;

  TCPServiceType(int serviceCode) {
    this.serviceCode = serviceCode;
  }

  public int getServiceCode() {
    return this.serviceCode;
  }

}
