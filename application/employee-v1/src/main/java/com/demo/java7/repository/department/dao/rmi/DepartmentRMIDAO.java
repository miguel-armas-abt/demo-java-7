package com.demo.java7.repository.department.dao.rmi;

import static com.demo.java7.properties.EmployeeProperties.getDepartmentServerIP;
import static com.demo.java7.properties.EmployeeProperties.getDepartmentServerRMIPort;

import com.demo.java7.repository.department.dao.DepartmentDAO;
import com.demo.java7.departments.dto.DepartmentDTO;
import com.demo.java7.departments.rmi.DepartmentRMIService;
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
      Registry registry = LocateRegistry.getRegistry(getDepartmentServerIP(), getDepartmentServerRMIPort());
      return registry.lookup(remoteObjectName);
    } catch (Exception exception) {
      throw new RuntimeException("Error to connect to RMI Server: " + exception.getMessage(), exception);
    }
  }

  @Override
  public List<DepartmentDTO> findAll() {
    try {
      return departmentRMIService.findAll();
    } catch (Exception exception) {
      throw new RuntimeException("Error getting the department list: " + exception.getMessage(), exception);
    }
  }

  @Override
  public DepartmentDTO findByCode(int code) {
    try {
      return departmentRMIService.findByCode(code);
    } catch (Exception exception) {
      throw new RuntimeException("Error getting the department by code: " + exception.getMessage(), exception);
    }
  }
}
