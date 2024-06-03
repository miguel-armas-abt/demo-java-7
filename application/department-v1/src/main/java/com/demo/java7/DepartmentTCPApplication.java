package com.demo.java7;

import com.demo.java7.webservice.tcp.DepartmentTCPService;
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

  private static final int DEPARTMENTS_TCP_SERVICE_PORT = 5000;

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(DEPARTMENTS_TCP_SERVICE_PORT);
    System.out.println("You have connected to the department's TCP server.");
    while (true) {
      Socket actualSocket = serverSocket.accept();
      new DepartmentTCPService(actualSocket).start(); //por cada conexión con el socket se instancia un nuevo TcpServer
      System.out.println("Received request from client...");
    }
  }

}
