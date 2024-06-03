package com.demo.java7.service;

import com.demo.java7.departments.dto.DepartmentDTO;
import java.util.List;

public interface DepartmentService {

  List<DepartmentDTO> findAll();

  DepartmentDTO findByCode(int code);
}
