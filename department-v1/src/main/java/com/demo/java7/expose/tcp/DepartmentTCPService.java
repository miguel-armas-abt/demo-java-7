package com.demo.java7.expose.tcp;

import com.demo.java7.departments.dto.DepartmentDTO;
import com.demo.java7.service.DepartmentService;
import com.demo.java7.service.DepartmentServiceImpl;
import com.demo.java7.repository.DepartmentRepositoryImpl;
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
  private final DepartmentService departmentService;

  public DepartmentTCPService(Socket socket) {
    this.socket = socket;
    departmentService = new DepartmentServiceImpl(new DepartmentRepositoryImpl());
  }

  public void run() {
    try (DataInputStream inputStream = new DataInputStream(socket.getInputStream());
         DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream())) {

      int clientRequest = inputStream.readInt();

      if(clientRequest == TCPServiceType.DEPARTMENTS_FIND_ALL.getServiceCode()) {
        findAll(outputStream);
      }

      if(clientRequest == TCPServiceType.DEPARTMENTS_FIND_BY_CODE.getServiceCode()) {
        findByCode(inputStream, outputStream);
      }

    } catch (Exception exception) {
      throw new RuntimeException("Error to select TCP department service: " + exception.getMessage(), exception);
    } finally {
      try {
        if (socket != null) socket.close();
      } catch (Exception exception) {
        throw new RuntimeException("Error to close TCP connection:: " + exception.getMessage(), exception);
      }
    }
  }

  private void findAll(DataOutputStream output) {
    try {
      Collection<DepartmentDTO> departmentList = departmentService.findAll();

      output.writeInt(departmentList.size()); //envío el tamaño de la colección al cliente

      for (DepartmentDTO department : departmentList) {
        output.writeUTF(department.toString()); //envío el toString de cada objeto
      }

    } catch (Exception exception) {
      throw new RuntimeException("Error to send department list: " + exception.getMessage(), exception);
    }
  }

  private void findByCode(DataInputStream input, DataOutputStream output) {
    try {
      DepartmentDTO department = departmentService.findByCode(Integer.parseInt(input.readUTF())); //lee el department code
      output.writeUTF(department.toString());
    } catch (Exception exception) {
      throw new RuntimeException("Error to send department by code: " + exception.getMessage(), exception);
    }
  }

}
