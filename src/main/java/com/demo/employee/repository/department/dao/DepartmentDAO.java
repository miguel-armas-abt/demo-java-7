package com.demo.employee.repository.department.dao;

import com.demo.department.dto.DepartmentDTO;
import java.util.List;

public interface DepartmentDAO {

  List<DepartmentDTO> findAll();

  DepartmentDTO findByCode(int code);
}
