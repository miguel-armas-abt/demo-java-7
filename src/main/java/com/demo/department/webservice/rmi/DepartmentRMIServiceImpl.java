package com.demo.department.webservice.rmi;

import com.demo.department.service.DepartmentService;
import com.demo.department.service.DepartmentServiceImpl;
import com.demo.department.dto.DepartmentDTO;
import com.demo.department.repository.DepartmentRepositoryImpl;
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
    return departmentService.findAll();
  }

  @Override
  public DepartmentDTO findByCode(int code) throws RemoteException {
    return departmentService.findByCode(code);
  }
}
