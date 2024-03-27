package com.demo.employee.repository.department.connector;

import com.demo.department.dto.DepartmentDTO;
import com.demo.employee.repository.department.dao.DepartmentTCPDAO;
import java.util.List;

public class DepartmentConnectorTCP implements DepartmentConnectorFacade {

  @Override
  public List<DepartmentDTO> findAll() {
    return (List<DepartmentDTO>) DepartmentTCPDAO.findAll();
  }

  @Override
  public DepartmentDTO findByCode(int code) {
    return DepartmentTCPDAO.findByCode(code);
  }
}
