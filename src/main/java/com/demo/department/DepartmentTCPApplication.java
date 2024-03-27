package com.demo.department;

import com.demo.commons.constant.NetworkConstant;
import com.demo.department.webservice.tcp.DepartmentTCPService;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Protocolo de comunicación: Transfer Control Protocol (TCP)
 * <p>
 * <br/> La comunicación TCP está basada en sockets. Un socket está definido por una dirección IP y un número de puerto.
 * Durante la comunicación TCP, un socket de un dispositivo (cliente) se conecta al socket de otro (server), creando un
 * canal de comunicación.
 */
public class DepartmentTCPApplication extends Thread {

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(NetworkConstant.DEPARTMENTS_TCP_SERVICE_PORT);
    Socket actualSocket;
    while (true) {
      actualSocket = serverSocket.accept();
      new DepartmentTCPService(actualSocket).start(); //por cada conexión con el socket se instancia un nuevo TcpServer
      System.out.println("You have connected to the department's TCP server.");
    }
  }

}
