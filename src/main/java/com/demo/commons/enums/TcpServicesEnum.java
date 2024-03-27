package com.demo.commons.enums;

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
