package com.demo.java7.business.infrastructure.enums;

public enum RMIRemoteObjectEnum {

  DEPARTMENT("rmiDepartmentRemote");

  private final String remoteObjectName;

  RMIRemoteObjectEnum(String remoteObjectName) {
    this.remoteObjectName = remoteObjectName;
  }

  public String getRemoteObjectName() {
    return this.remoteObjectName;
  }
}
