package com.demo.department.webservice.tcp;

import com.demo.department.service.DepartmentService;
import com.demo.department.service.DepartmentServiceImpl;
import com.demo.department.dto.DepartmentDTO;
import com.demo.department.repository.DepartmentRepositoryImpl;
import com.demo.commons.enums.TCPServiceType;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Collection;

/**
 * Protocolo de comunicación: Transfer Control Protocol (TCP)
 * <p>
 * <br/> La comunicación TCP está basada en sockets. Un socket está definido por una dirección IP y un número de puerto.
 * Durante la comunicación TCP, un socket de un dispositivo (cliente) se conecta al socket de otro (server), creando un
 * canal de comunicación.
 */
public class DepartmentTCPService extends Thread {

  private final Socket socket;
  private DataInputStream inputStream = null;
  private DataOutputStream outputStream = null;

  public DepartmentTCPService(Socket socket) {
    this.socket = socket;
  }

  public void run() {
    try {
      inputStream = new DataInputStream(socket.getInputStream());
      outputStream = new DataOutputStream(socket.getOutputStream());

      int clientRequest = inputStream.readInt();

      if(clientRequest == TCPServiceType.DEPARTMENTS_FIND_ALL.getServiceCode()) {
        findAll(outputStream);
      }

      if(clientRequest == TCPServiceType.DEPARTMENTS_FIND_BY_CODE.getServiceCode()) {
        findByCode(inputStream, outputStream);
      }

    } catch (Exception exception) {
      throw new RuntimeException("error to select TCP department service: " + exception.getMessage());

    } finally {
      try {
        if (outputStream != null) outputStream.close();
        if (inputStream != null) inputStream.close();
        if (socket != null) socket.close();
      } catch (Exception exception) {
        throw new RuntimeException("error to close TCP connection: " + exception.getMessage());
      }
    }
  }

  private void findAll(DataOutputStream output) {
    try {
      DepartmentService departmentService = new DepartmentServiceImpl(new DepartmentRepositoryImpl());
      Collection<DepartmentDTO> departmentList = departmentService.findAll();

      int size = departmentList.size(); //envío el tamaño de la colección al cliente
      output.writeInt(size);

      for (DepartmentDTO department : departmentList) {
        output.writeUTF(department.toString()); //envío el toString de cada objeto
      }

    } catch (Exception exception) {
      throw new RuntimeException("error to send department list: " + exception.getMessage());
    }
  }

  private void findByCode(DataInputStream input, DataOutputStream output) {
    try {
      DepartmentService departmentService = new DepartmentServiceImpl(new DepartmentRepositoryImpl());
      DepartmentDTO department = departmentService.findByCode(Integer.parseInt(input.readUTF())); //lee el department code
      output.writeUTF(department.toString());
    } catch (Exception exception) {
      throw new RuntimeException("error to send department by code: " + exception.getMessage());
    }
  }

}
