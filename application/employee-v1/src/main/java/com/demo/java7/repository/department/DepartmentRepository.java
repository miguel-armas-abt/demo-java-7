package com.demo.java7.repository.department;

import com.demo.java7.departments.dto.DepartmentDTO;
import java.util.List;

public interface DepartmentRepository {

  List<DepartmentDTO> findAll();

  DepartmentDTO findByCode(int code);
}
