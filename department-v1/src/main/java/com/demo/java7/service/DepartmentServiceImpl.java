package com.demo.java7.service;

import com.demo.java7.departments.dto.DepartmentDTO;
import com.demo.java7.repository.DepartmentRepository;
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
