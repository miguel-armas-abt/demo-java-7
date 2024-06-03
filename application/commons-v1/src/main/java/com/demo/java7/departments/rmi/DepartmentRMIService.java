package com.demo.java7.departments.rmi;

import com.demo.java7.departments.dto.DepartmentDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface DepartmentRMIService extends Remote {

  List<DepartmentDTO> findAll() throws RemoteException;
  DepartmentDTO findByCode(int code) throws RemoteException;
}
