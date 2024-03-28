package com.demo.department.service;

import com.demo.department.repository.DepartmentRepository;
import com.demo.department.dto.DepartmentDTO;
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
  public List<DepartmentDTO> findAll() {
    return departmentRepository.findAll();
  }

  @Override
  public DepartmentDTO findByCode(int code) {
    return departmentRepository.findByCode(code);
  }
}
