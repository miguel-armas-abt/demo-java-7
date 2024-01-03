package com.demo.java7.business.employee.infrastructure.consume.department.repository;

import java.util.List;
import com.demo.java7.business.department.domain.model.DepartmentDto;

public interface DepartmentRepository {

  List<DepartmentDto> findAll();

  DepartmentDto findByCode(int code);
}
