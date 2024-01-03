package com.demo.java7.business.department.infrastructure.expose.webservice.rmi;

import com.demo.java7.business.infrastructure.constant.RMIRemoteObjectConstant;
import com.demo.java7.business.infrastructure.properties.NetworkProperties;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Tecnología Java: Remote Method Invocation (RMI)
 * <p>
 * <br/> RMI está basado en objetos remotos, los cuales pueden ser invocados de manera remota como si hubieran sido
 * invocados localmente.<br/>
 */
public class DepartmentRMIServer {

  public static void main(String[] args) throws RemoteException {

    DepartmentRemoteObject departmentRemoteObject = new DepartmentRemoteObjectImpl();
    Registry registry = LocateRegistry.createRegistry(NetworkProperties.DEPARTMENTS_RMI_SERVICE_PORT);
    registry.rebind(RMIRemoteObjectConstant.DEPARTMENT, departmentRemoteObject);
    System.out.println("You have connected to the department's RMI server.");
  }
}
