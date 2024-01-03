package com.demo.java7.business.department.infrastructure.consume.repository;

import com.demo.java7.business.department.domain.model.DepartmentDto;
import java.util.List;

public interface DepartmentRepository {

  List<DepartmentDto> findAll();

  DepartmentDto findByCode(int code);
}
