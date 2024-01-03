package com.demo.java7.business.employee.infrastructure.consume.department.connector;

import java.util.List;
import com.demo.java7.business.department.domain.model.DepartmentDto;

/**
 * Patrón de diseño: Facade
 * <p>
 * <br/> Clase fachada que proporciona una interfaz simple que oculte las complejidades internas de un conjunto de clases o servicios. <br/>
 */
public interface DepartmentConnectorFacade {

  List<DepartmentDto> findAll();

  DepartmentDto findByCode(int code);
}
