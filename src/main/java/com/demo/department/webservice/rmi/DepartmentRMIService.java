package com.demo.department.webservice.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface DepartmentRMIService extends Remote {

  List<String> findAll() throws RemoteException;
  String findByCode(int code) throws RemoteException;
}
