package com.demo.department;

import com.demo.commons.constant.NetworkConstant;
import com.demo.commons.enums.RMIRemoteObjectType;
import com.demo.department.webservice.rmi.DepartmentRMIService;
import com.demo.department.webservice.rmi.DepartmentRMIServiceImpl;
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

  public static void main(String[] args) throws RemoteException {

    DepartmentRMIService departmentRMIService = new DepartmentRMIServiceImpl();
    Registry registry = LocateRegistry.createRegistry(NetworkConstant.DEPARTMENTS_RMI_SERVICE_PORT);
    registry.rebind(RMIRemoteObjectType.DEPARTMENT.getRemoteObjectName(), departmentRMIService);
    System.out.println("You have connected to the department's RMI server.");
  }
}
