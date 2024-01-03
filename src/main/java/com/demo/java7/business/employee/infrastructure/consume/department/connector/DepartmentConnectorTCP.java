package com.demo.java7.business.employee.infrastructure.consume.department.connector;

import com.demo.java7.business.department.domain.model.DepartmentDto;
import com.demo.java7.business.employee.infrastructure.consume.department.dao.DepartmentTCPDAO;
import java.util.List;

public class DepartmentConnectorTCP implements DepartmentConnectorFacade {

  @Override
  public List<DepartmentDto> findAll() {
    return (List<DepartmentDto>) DepartmentTCPDAO.findAll();
  }

  @Override
  public DepartmentDto findByCode(int code) {
    return DepartmentTCPDAO.findByCode(code);
  }
}
