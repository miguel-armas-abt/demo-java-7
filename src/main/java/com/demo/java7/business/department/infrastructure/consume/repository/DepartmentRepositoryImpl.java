package com.demo.java7.business.department.infrastructure.consume.repository;

import com.demo.java7.business.department.domain.model.DepartmentDto;
import com.demo.java7.business.department.infrastructure.constant.DepartmentConstant;
import com.demo.java7.business.department.infrastructure.consume.dao.DepartmentDatabaseDAO;
import com.demo.java7.business.infrastructure.util.ObjectFactory;
import com.demo.java7.business.infrastructure.util.PropertiesReader;
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
  public List<DepartmentDto> findAll() {
    return departmentDatabaseDAO.findAll();
  }

  @Override
  public DepartmentDto findByCode(int code) {
    return departmentDatabaseDAO.findByCode(code);
  }

  private static String selectDaoClass() {
    return PropertiesReader.getProperty("departmentDatabaseDaoClass", DepartmentConstant.DEPARTMENT_PROPERTIES_FILE);
  }

}
