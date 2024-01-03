package com.demo.java7.business.employee.infrastructure.consume.department.mapper;

import java.util.StringTokenizer;
import com.demo.java7.business.department.domain.model.DepartmentDto;

public class DepartmentMapper {

  public static DepartmentDto stringToDepartment(String departmentToString){
    DepartmentDto department = new DepartmentDto();

    StringTokenizer token = new StringTokenizer(departmentToString,",");
    department.setCode(Integer.parseInt(token.nextToken()));
    department.setName(token.nextToken());
    department.setLocation(token.nextToken());
    return department;
  }
}
