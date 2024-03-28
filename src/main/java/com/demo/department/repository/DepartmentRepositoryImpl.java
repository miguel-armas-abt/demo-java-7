package com.demo.department.repository;

import com.demo.department.dto.DepartmentDTO;
import com.demo.department.repository.dao.DepartmentDAO;
import java.util.List;

/**
 * Patrón de diseño: Repository
 * <p>
 * <br/> Clase Repository que proporciona una interfaz que define los métodos para acceder a los datos almacenados sin
 * exponer los detalles de almacenamiento (base de datos, caché, servicio web, etc.) <br/>
 */
public class DepartmentRepositoryImpl implements DepartmentRepository {

  private final DepartmentDAO departmentDAO;

  public DepartmentRepositoryImpl() {
    departmentDAO = new DepartmentDAO();
  }

  @Override
  public List<DepartmentDTO> findAll() {
    return departmentDAO.findAll();
  }

  @Override
  public DepartmentDTO findByCode(int code) {
    return departmentDAO.findByCode(code);
  }
}
