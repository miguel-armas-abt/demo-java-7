package com.demo.department.repository;

import com.demo.department.dto.DepartmentDTO;
import java.util.List;

public interface DepartmentRepository {

  List<DepartmentDTO> findAll();

  DepartmentDTO findByCode(int code);
}
