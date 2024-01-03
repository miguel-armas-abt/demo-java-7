package com.demo.java7.business.employee.infrastructure.consume.department.repository;

import com.demo.java7.business.department.domain.model.DepartmentDto;
import com.demo.java7.business.employee.infrastructure.consume.department.connector.DepartmentConnectorFacade;
import com.demo.java7.business.infrastructure.constant.FileConstant;
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

  private final DepartmentConnectorFacade departmentConnectorFacade = (DepartmentConnectorFacade) ObjectFactory.build(selectConnectorClass());

  @Override
  public List<DepartmentDto> findAll() {
    return departmentConnectorFacade.findAll();
  }

  @Override
  public DepartmentDto findByCode(int code) {
    return departmentConnectorFacade.findByCode(code);
  }

  private static String selectConnectorClass() {
    return PropertiesReader.getProperty("departmentConnectorClass", FileConstant.SELECTOR_CLASS_FILE);
  }
}
