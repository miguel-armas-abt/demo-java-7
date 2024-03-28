package com.demo.department.repository;

import com.demo.commons.util.ObjectFactory;
import com.demo.department.properties.DepartmentProperties;
import com.demo.department.dto.DepartmentDTO;
import com.demo.department.repository.dao.DepartmentDatabaseDAO;
import java.util.List;

/**
 * Patrón de diseño: Repository
 * <p>
 * <br/> Clase Repository que proporciona una interfaz que define los métodos para acceder a los datos almacenados sin
 * exponer los detalles de almacenamiento (base de datos, caché, servicio web, etc.) <br/>
 */
public class DepartmentRepositoryImpl implements DepartmentRepository {

  private final DepartmentDatabaseDAO departmentDatabaseDAO;

  public DepartmentRepositoryImpl() {
    departmentDatabaseDAO = (DepartmentDatabaseDAO) ObjectFactory.build(DepartmentProperties.getDepartmentDAOClass());
  }

  @Override
  public List<DepartmentDTO> findAll() {
    return departmentDatabaseDAO.findAll();
  }

  @Override
  public DepartmentDTO findByCode(int code) {
    return departmentDatabaseDAO.findByCode(code);
  }
}
