package com.demo.java7.business.infrastructure.enums;

public enum TcpServicesEnum {

  DEPARTMENTS_FIND_ALL(1),
  DEPARTMENTS_FIND_BY_CODE(2);

  private final int serviceCode;

  TcpServicesEnum(int serviceCode) {
    this.serviceCode = serviceCode;
  }

  public int getServiceCode() {
    return this.serviceCode;
  }

}
