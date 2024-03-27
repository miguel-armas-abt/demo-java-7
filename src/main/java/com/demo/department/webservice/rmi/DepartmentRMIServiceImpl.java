package com.demo.department.webservice.rmi;

import com.demo.department.service.DepartmentService;
import com.demo.department.service.DepartmentServiceImpl;
import com.demo.department.dto.DepartmentDTO;
import com.demo.department.repository.DepartmentRepositoryImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRMIServiceImpl extends UnicastRemoteObject implements DepartmentRMIService {

  public DepartmentRMIServiceImpl() throws RemoteException {
    super();
  }

  @Override
  public List<String> findAll() throws RemoteException {
    DepartmentService departmentService = new DepartmentServiceImpl(new DepartmentRepositoryImpl());
    List<DepartmentDTO> departmentList = departmentService.findAll();

    List<String> departmentListToString = new ArrayList<>();
    for(DepartmentDTO department: departmentList)
      departmentListToString.add(department.toString());

    return departmentListToString;
  }

  @Override
  public String findByCode(int code) throws RemoteException {
    DepartmentService departmentService = new DepartmentServiceImpl(new DepartmentRepositoryImpl());
    DepartmentDTO department = departmentService.findByCode(code);
    return department.toString();
  }
}
