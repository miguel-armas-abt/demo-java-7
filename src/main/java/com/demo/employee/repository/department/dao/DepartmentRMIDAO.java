package com.demo.employee.repository.department.dao;

import com.demo.commons.constant.NetworkConstant;
import com.demo.commons.enums.RMIRemoteObjectType;
import com.demo.department.dto.DepartmentDTO;
import com.demo.department.webservice.rmi.DepartmentRMIService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class DepartmentRMIDAO implements DepartmentDAO {

  public DepartmentRMIService departmentRMIService;

  public DepartmentRMIDAO() {
    departmentRMIService = (DepartmentRMIService) DepartmentRMIDAO.getRemoteObject(RMIRemoteObjectType.DEPARTMENT.getRemoteObjectName());
  }

  public static Object getRemoteObject(String remoteObjectName){
    try{
      Registry registry = LocateRegistry.getRegistry(NetworkConstant.SERVER_IP, NetworkConstant.DEPARTMENTS_RMI_SERVICE_PORT);
      return registry.lookup(remoteObjectName);
    } catch (Exception exception) {
      throw new RuntimeException("error to connect to RMI Server: " + exception.getMessage());
    }
  }

  @Override
  public List<DepartmentDTO> findAll() {
    try {
      return departmentRMIService.findAll();
    } catch (Exception exception) {
      throw new RuntimeException("error getting the department list: " + exception.getMessage());
    }
  }

  @Override
  public DepartmentDTO findByCode(int code) {
    try {
      return departmentRMIService.findByCode(code);
    } catch (Exception exception) {
      throw new RuntimeException("error getting the department by code: " + exception.getMessage());
    }
  }
}
