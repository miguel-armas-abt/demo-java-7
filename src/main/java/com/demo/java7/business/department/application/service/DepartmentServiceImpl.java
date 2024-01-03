package com.demo.java7.business.department.application.service;

import com.demo.java7.business.department.domain.model.DepartmentDto;
import com.demo.java7.business.department.infrastructure.consume.repository.DepartmentRepository;
import java.util.List;

/**
 * <br/>Clase SERVICE que IMPLEMENTA los métodos necesarios para tramitar la lógica de negocio en el contexto DEPARTAMENTO.<br/>
 */
public class DepartmentServiceImpl implements DepartmentService {

  private final DepartmentRepository departmentRepository;

  public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
    this.departmentRepository = departmentRepository;
  }

  @Override
  public List<DepartmentDto> findAll() {
    return departmentRepository.findAll();
  }

  @Override
  public DepartmentDto findByCode(int code) {
    return departmentRepository.findByCode(code);
  }
}
