package com.demo.employee.repository.department.connector;

import com.demo.employee.repository.department.dao.DepartmentRMIDAO;
import com.demo.employee.repository.department.mapper.DepartmentMapper;
import com.demo.department.dto.DepartmentDTO;
import com.demo.department.webservice.rmi.DepartmentRMIService;
import com.demo.commons.enums.RMIRemoteObjectEnum;
import java.util.ArrayList;
import java.util.List;

public class DepartmentConnectorRMI implements DepartmentConnectorFacade {

  public DepartmentRMIService departmentRMIService;

  public DepartmentConnectorRMI() {
    departmentRMIService = (DepartmentRMIService) DepartmentRMIDAO.getRemoteObject(RMIRemoteObjectEnum.DEPARTMENT.getRemoteObjectName());
  }

  @Override
  public List<DepartmentDTO> findAll() {
    try {
      List<String> departmentListToString = departmentRMIService.findAll();
      List<DepartmentDTO> departmentList = new ArrayList<>();

      for (String actualDepartment : departmentListToString) {
        departmentList.add(DepartmentMapper.stringToDepartment(actualDepartment));
      }
      return departmentList;
    } catch (Exception exception) {
      throw new RuntimeException("error mapping the department list: " + exception.getMessage());
    }
  }

  @Override
  public DepartmentDTO findByCode(int code) {
    try {
      return DepartmentMapper.stringToDepartment(departmentRMIService.findByCode(code));
    } catch (Exception exception) {
      throw new RuntimeException("error mapping the department by code: " + exception.getMessage());
    }
  }
}
