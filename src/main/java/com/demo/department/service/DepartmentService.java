package com.demo.department.service;

import com.demo.department.dto.DepartmentDTO;
import java.util.List;

public interface DepartmentService {

  List<DepartmentDTO> findAll();

  DepartmentDTO findByCode(int code);
}
