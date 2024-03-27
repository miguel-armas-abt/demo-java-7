package com.demo.employee.repository.department.mapper;

import java.util.StringTokenizer;
import com.demo.department.dto.DepartmentDTO;

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
