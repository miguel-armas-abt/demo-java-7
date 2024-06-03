package com.demo.java7.repository.department.dao;

import com.demo.java7.departments.dto.DepartmentDTO;
import java.util.List;

public interface DepartmentDAO {

  List<DepartmentDTO> findAll();

  DepartmentDTO findByCode(int code);
}
