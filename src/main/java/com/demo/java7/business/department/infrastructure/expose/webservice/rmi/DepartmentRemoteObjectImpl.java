package com.demo.java7.business.department.infrastructure.expose.webservice.rmi;

import com.demo.java7.business.department.application.service.DepartmentService;
import com.demo.java7.business.department.application.service.DepartmentServiceImpl;
import com.demo.java7.business.department.domain.model.DepartmentDto;
import com.demo.java7.business.department.infrastructure.consume.repository.DepartmentRepositoryImpl;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRemoteObjectImpl extends UnicastRemoteObject implements DepartmentRemoteObject {

  public DepartmentRemoteObjectImpl() throws RemoteException {
    super();
  }

  @Override
  public List<String> findAll() throws RemoteException {
    DepartmentService departmentService = new DepartmentServiceImpl(new DepartmentRepositoryImpl());
    List<DepartmentDto> departmentList = departmentService.findAll();

    List<String> departmentListToString = new ArrayList<>();
    for(DepartmentDto department: departmentList)
      departmentListToString.add(department.toString());

    return departmentListToString;
  }

  @Override
  public String findByCode(int code) throws RemoteException {
    DepartmentService departmentService = new DepartmentServiceImpl(new DepartmentRepositoryImpl());
    DepartmentDto department = departmentService.findByCode(code);
    return department.toString();
  }
}
