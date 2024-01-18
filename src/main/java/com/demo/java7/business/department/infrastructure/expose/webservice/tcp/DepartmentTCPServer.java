package com.demo.java7.business.department.infrastructure.expose.webservice.tcp;

import com.demo.java7.business.department.application.service.DepartmentService;
import com.demo.java7.business.department.application.service.DepartmentServiceImpl;
import com.demo.java7.business.department.domain.model.DepartmentDto;
import com.demo.java7.business.department.infrastructure.consume.repository.DepartmentRepositoryImpl;
import com.demo.java7.business.infrastructure.constant.NetworkConstant;
import com.demo.java7.business.infrastructure.enums.TcpServicesEnum;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;

/**
 * Protocolo de comunicación: Transfer Control Protocol (TCP)
 * <p>
 * <br/> La comunicación TCP está basada en sockets. Un socket está definido por una dirección IP y un número de puerto.
 * Durante la comunicación TCP, un socket de un dispositivo (cliente) se conecta al socket de otro (server), creando un
 * canal de comunicación.
 */
public class DepartmentTCPServer extends Thread {

  private final Socket socket;
  private DataInputStream inputStream = null;
  private DataOutputStream outputStream = null;

  public DepartmentTCPServer(Socket socket) {
    this.socket = socket;
  }

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(NetworkConstant.DEPARTMENTS_TCP_SERVICE_PORT);
    Socket actualSocket;
    while (true) {
      actualSocket = serverSocket.accept();
      new DepartmentTCPServer(actualSocket).start(); //por cada conexión con el socket se instancia un nuevo TcpServer
      System.out.println("You have connected to the department's TCP server.");
    }
  }

  public void run() {
    try {
      inputStream = new DataInputStream(socket.getInputStream());
      outputStream = new DataOutputStream(socket.getOutputStream());

      int clientRequest = inputStream.readInt();

      if(clientRequest == TcpServicesEnum.DEPARTMENTS_FIND_ALL.getServiceCode()) {
        findAll(outputStream);
      }

      if(clientRequest == TcpServicesEnum.DEPARTMENTS_FIND_BY_CODE.getServiceCode()) {
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
      Collection<DepartmentDto> departmentList = departmentService.findAll();

      int size = departmentList.size(); //envío el tamaño de la colección al cliente
      output.writeInt(size);

      for (DepartmentDto department : departmentList) {
        output.writeUTF(department.toString()); //envío el toString de cada objeto
      }

    } catch (Exception exception) {
      throw new RuntimeException("error to send department list: " + exception.getMessage());
    }
  }

  private void findByCode(DataInputStream input, DataOutputStream output) {
    try {
      DepartmentService departmentService = new DepartmentServiceImpl(new DepartmentRepositoryImpl());
      DepartmentDto department = departmentService.findByCode(Integer.parseInt(input.readUTF())); //lee el department code
      output.writeUTF(department.toString());
    } catch (Exception exception) {
      throw new RuntimeException("error to send department by code: " + exception.getMessage());
    }
  }

}
