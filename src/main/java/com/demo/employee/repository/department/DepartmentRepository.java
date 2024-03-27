package com.demo.employee.repository.department;

import java.util.List;
import com.demo.department.dto.DepartmentDTO;

public interface DepartmentRepository {

  List<DepartmentDTO> findAll();

  DepartmentDTO findByCode(int code);
}
