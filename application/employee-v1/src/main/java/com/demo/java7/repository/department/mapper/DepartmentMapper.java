package com.demo.java7.repository.department.mapper;

import com.demo.java7.departments.dto.DepartmentDTO;
import java.util.StringTokenizer;

public class DepartmentMapper {

  public static DepartmentDTO stringToDepartment(String departmentToString){
    DepartmentDTO department = new DepartmentDTO();

    StringTokenizer token = new StringTokenizer(departmentToString,",");
    department.setCode(Integer.parseInt(token.nextToken()));
    department.setName(token.nextToken());
    department.setLocation(token.nextToken());
    return department;
  }
}
