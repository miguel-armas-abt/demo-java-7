package com.demo.java7;

import com.demo.java7.expose.rmi.RMIRemoteObjectType;
import com.demo.java7.departments.rmi.DepartmentRMIService;
import com.demo.java7.expose.rmi.DepartmentRMIServiceImpl;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Tecnología Java: Remote Method Invocation (RMI)
 * <p>
 * <br/> RMI está basado en objetos remotos, los cuales pueden ser invocados de manera remota como si hubieran sido
 * invocados localmente.<br/>
 */
public class DepartmentRMIApplication {

  private static final int DEPARTMENTS_RMI_SERVICE_PORT = 5001;

  public static void main(String[] args) throws RemoteException {

    DepartmentRMIService departmentRMIService = new DepartmentRMIServiceImpl();
    Registry registry = LocateRegistry.createRegistry(DEPARTMENTS_RMI_SERVICE_PORT);
    registry.rebind(RMIRemoteObjectType.DEPARTMENT.getRemoteObjectName(), departmentRMIService);
    System.out.println("You have connected to the department's RMI server.");
  }
}
