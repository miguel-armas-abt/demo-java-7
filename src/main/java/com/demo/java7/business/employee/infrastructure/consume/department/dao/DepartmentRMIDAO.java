package com.demo.java7.business.employee.infrastructure.consume.department.dao;

import com.demo.java7.business.commons.constant.NetworkConstant;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DepartmentRMIDAO {

  public static Object getRemoteObject(String remoteObjectName){
    try{
      Registry registry = LocateRegistry.getRegistry(NetworkConstant.SERVER_IP, NetworkConstant.DEPARTMENTS_RMI_SERVICE_PORT);
      return registry.lookup(remoteObjectName);
    } catch (Exception exception) {
      throw new RuntimeException("error to connect to RMI Server: " + exception.getMessage());
    }
  }
}
