package com.demo.java7.business.department.application.service;

import com.demo.java7.business.department.domain.model.DepartmentDto;
import java.util.List;

public interface DepartmentService {

  List<DepartmentDto> findAll();

  DepartmentDto findByCode(int code);
}
