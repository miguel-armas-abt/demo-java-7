package com.demo.java7.business.employee.infrastructure.consume.department.connector;

import com.demo.java7.business.employee.infrastructure.consume.department.dao.DepartmentRMIDAO;
import com.demo.java7.business.employee.infrastructure.consume.department.mapper.DepartmentMapper;
import com.demo.java7.business.department.domain.model.DepartmentDto;
import com.demo.java7.business.department.infrastructure.expose.webservice.rmi.DepartmentRemoteObject;
import com.demo.java7.business.infrastructure.enums.RMIRemoteObjectEnum;
import java.util.ArrayList;
import java.util.List;

public class DepartmentConnectorRMI implements DepartmentConnectorFacade {

  public DepartmentRemoteObject departmentRemoteObject;

  public DepartmentConnectorRMI() {
    departmentRemoteObject = (DepartmentRemoteObject) DepartmentRMIDAO.getRemoteObject(RMIRemoteObjectEnum.DEPARTMENT.getRemoteObjectName());
  }

  @Override
  public List<DepartmentDto> findAll() {
    try {
      List<String> departmentListToString = departmentRemoteObject.findAll();
      List<DepartmentDto> departmentList = new ArrayList<>();

      for (String actualDepartment : departmentListToString) {
        departmentList.add(DepartmentMapper.stringToDepartment(actualDepartment));
      }
      return departmentList;
    } catch (Exception exception) {
      throw new RuntimeException("error mapping the department list: " + exception.getMessage());
    }
  }

  @Override
  public DepartmentDto findByCode(int code) {
    try {
      return DepartmentMapper.stringToDepartment(departmentRemoteObject.findByCode(code));
    } catch (Exception exception) {
      throw new RuntimeException("error mapping the department by code: " + exception.getMessage());
    }
  }
}
