package com.demo.java7.business.employee.domain.model;

import java.io.Serializable;

/**
 * Patrón de diseño: Data Transfer Object (DTO)
 * <p>
 * <br/> Clase DTO que contiene datos en un modelo simple, sin lógica de negocio ni tecnologías de infraestructura.
 * Este modelo permite transferir sus datos entre diferentes componentes del sistema.<br/>
 */
public class EmployeeLocationDto implements Serializable {

  private int code;

  private String name;

  private String location;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  @Override
  public String toString() {
    return "El colaborador " + this.name + " con código " + this.code + " está ubicado en la sede " + this.location;
  }
}
