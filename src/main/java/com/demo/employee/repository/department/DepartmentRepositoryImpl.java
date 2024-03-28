package com.demo.employee.repository.department;

import com.demo.commons.util.ObjectFactory;
import com.demo.department.dto.DepartmentDTO;
import com.demo.employee.properties.EmployeeProperties;
import com.demo.employee.repository.department.dao.DepartmentDAO;
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
    departmentDAO = (DepartmentDAO) ObjectFactory.build(EmployeeProperties.getDepartmentConnectorDAOClass());
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
