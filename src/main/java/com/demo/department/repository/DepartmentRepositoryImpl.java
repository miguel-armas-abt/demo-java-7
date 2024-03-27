package com.demo.department.repository;

import com.demo.commons.util.ObjectFactory;
import com.demo.department.constant.DepartmentConstant;
import com.demo.department.dto.DepartmentDTO;
import com.demo.department.repository.dao.DepartmentDatabaseDAO;
import com.demo.commons.util.PropertiesReader;
import java.util.List;

/**
 * Patrón de diseño: Repository
 * <p>
 * <br/> Clase Repository que proporciona una interfaz que define los métodos para acceder a los datos almacenados sin
 * exponer los detalles de almacenamiento (base de datos, caché, servicio web, etc.) <br/>
 */
public class DepartmentRepositoryImpl implements DepartmentRepository {
  private final DepartmentDatabaseDAO departmentDatabaseDAO = (DepartmentDatabaseDAO) ObjectFactory.build(selectDaoClass());

  @Override
  public List<DepartmentDTO> findAll() {
    return departmentDatabaseDAO.findAll();
  }

  @Override
  public DepartmentDTO findByCode(int code) {
    return departmentDatabaseDAO.findByCode(code);
  }

  private static String selectDaoClass() {
    return PropertiesReader.getProperty("departmentDatabaseDaoClass", DepartmentConstant.DEPARTMENT_PROPERTIES_FILE);
  }

}
