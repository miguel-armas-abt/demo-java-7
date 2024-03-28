package com.demo.commons.enums;

public enum RMIRemoteObjectType {

  DEPARTMENT("departments");

  private final String remoteObjectName;

  RMIRemoteObjectType(String remoteObjectName) {
    this.remoteObjectName = remoteObjectName;
  }

  public String getRemoteObjectName() {
    return this.remoteObjectName;
  }
}
