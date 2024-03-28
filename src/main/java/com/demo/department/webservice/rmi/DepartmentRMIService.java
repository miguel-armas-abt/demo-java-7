package com.demo.department.webservice.rmi;

import com.demo.department.dto.DepartmentDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface DepartmentRMIService extends Remote {

  List<DepartmentDTO> findAll() throws RemoteException;
  DepartmentDTO findByCode(int code) throws RemoteException;
}
