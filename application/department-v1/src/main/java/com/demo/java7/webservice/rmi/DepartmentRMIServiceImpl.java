package com.demo.java7.webservice.rmi;

import com.demo.java7.departments.dto.DepartmentDTO;
import com.demo.java7.departments.rmi.DepartmentRMIService;
import com.demo.java7.service.DepartmentService;
import com.demo.java7.service.DepartmentServiceImpl;
import com.demo.java7.repository.DepartmentRepositoryImpl;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class DepartmentRMIServiceImpl extends UnicastRemoteObject implements DepartmentRMIService {

  private final DepartmentService departmentService;

  public DepartmentRMIServiceImpl() throws RemoteException {
    super();
    departmentService = new DepartmentServiceImpl(new DepartmentRepositoryImpl());
  }

  @Override
  public List<DepartmentDTO> findAll() throws RemoteException {
    printLogs();
    return departmentService.findAll();
  }

  @Override
  public DepartmentDTO findByCode(int code) throws RemoteException {
    printLogs();
    return departmentService.findByCode(code);
  }

  private void printLogs() {
    System.out.println("Received request from client...");
  }
}
