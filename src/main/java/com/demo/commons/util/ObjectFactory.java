package com.demo.commons.util;

import java.util.Hashtable;

/**
 * Patrón de diseño: Factory
 * <p>
 * <br/> Clase Factory que permite fabricar un nuevo objeto, ocultando los detalles de instanciación.<br/>
 */
public class ObjectFactory {

  private static final Hashtable<String, Object> instancesHash = new Hashtable<>();

  public static Object build(String className) {
    try {
      Object object = instancesHash.get(className);
      if (object == null) {
        object = Class.forName(className).newInstance(); //creamos una nueva instancia del tipo de objeto seleccionado
        instancesHash.put(className, object);
      }
      return object;
    } catch (Exception ex) {
      throw new RuntimeException("error to factory the object: " + ex.getMessage());
    }
  }
}
