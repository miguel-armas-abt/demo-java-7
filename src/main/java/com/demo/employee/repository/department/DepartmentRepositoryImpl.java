package com.demo.employee.repository.department;

import com.demo.commons.util.ObjectFactory;
import com.demo.department.constant.DepartmentConstant;
import com.demo.department.dto.DepartmentDTO;
import com.demo.employee.repository.department.connector.DepartmentConnectorFacade;
import com.demo.commons.util.PropertiesReader;
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
  public List<DepartmentDTO> findAll() {
    return departmentConnectorFacade.findAll();
  }

  @Override
  public DepartmentDTO findByCode(int code) {
    return departmentConnectorFacade.findByCode(code);
  }

  private static String selectConnectorClass() {
    return PropertiesReader.getProperty("departmentConnectorClass", DepartmentConstant.DEPARTMENT_PROPERTIES_FILE);
  }
}
