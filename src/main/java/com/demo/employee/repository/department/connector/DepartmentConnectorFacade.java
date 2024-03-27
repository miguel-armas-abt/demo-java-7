package com.demo.employee.repository.department.connector;

import java.util.List;
import com.demo.department.dto.DepartmentDTO;

/**
 * Patrón de diseño: Facade
 * <p>
 * <br/> Clase fachada que proporciona una interfaz simple que oculte las complejidades internas de un conjunto de clases o servicios. <br/>
 */
public interface DepartmentConnectorFacade {

  List<DepartmentDTO> findAll();

  DepartmentDTO findByCode(int code);
}
