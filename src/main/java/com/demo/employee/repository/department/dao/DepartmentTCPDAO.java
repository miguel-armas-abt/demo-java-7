package com.demo.employee.repository.department.dao;

import com.demo.commons.constant.NetworkConstant;
import com.demo.commons.enums.TCPServiceType;
import com.demo.department.dto.DepartmentDTO;
import com.demo.employee.repository.department.mapper.DepartmentMapper;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class DepartmentTCPDAO implements DepartmentDAO {

  public List<DepartmentDTO> findAll() {
    List<DepartmentDTO> departmentList = new ArrayList<>();

    try (Socket socket = new Socket(NetworkConstant.SERVER_IP, NetworkConstant.DEPARTMENTS_TCP_SERVICE_PORT);
         DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
         DataInputStream inputStream = new DataInputStream(socket.getInputStream())) {

      outputStream.writeInt(TCPServiceType.DEPARTMENTS_FIND_ALL.getServiceCode());
      int departmentsNumber = inputStream.readInt();

      for (int i = 0; i < departmentsNumber; i++) {
        String serverResponse = inputStream.readUTF();
        departmentList.add(DepartmentMapper.stringToDepartment(serverResponse));
      }

    } catch (Exception exception) {
      throw new RuntimeException("Error while receiving department list: " + exception.getMessage(), exception);
    }

    return departmentList;
  }

  public DepartmentDTO findByCode(int departmentCode) {
    try (Socket socket = new Socket(NetworkConstant.SERVER_IP, NetworkConstant.DEPARTMENTS_TCP_SERVICE_PORT);
         DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
         DataInputStream inputStream = new DataInputStream(socket.getInputStream())) {

      outputStream.writeInt(TCPServiceType.DEPARTMENTS_FIND_BY_CODE.getServiceCode());
      outputStream.writeUTF(Integer.toString(departmentCode));

      String serverResponse = inputStream.readUTF();
      return DepartmentMapper.stringToDepartment(serverResponse);

    } catch (Exception exception) {
      throw new RuntimeException("Error while receiving department by code: " + exception.getMessage(), exception);
    }
  }

}