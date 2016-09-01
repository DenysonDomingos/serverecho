/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mark
 */
public class Client {
    private String hostAddress;
    private Integer hostPort;
    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public Client(String hostAddress, Integer hostPort) {
        this.hostAddress = hostAddress;
        this.hostPort = hostPort;
    }
    
    public void execute() {
        try {
            this.socket = new Socket(this.hostAddress, this.hostPort);
            System.out.println("Conectado ao servidor: " + this.socket.getRemoteSocketAddress().toString());
            this.dataInputStream = new DataInputStream(System.in);
            this.dataOutputStream = new DataOutputStream(this.socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            String input = new String("");
            String apelido = new String("");
            System.out.println("Digite um apelido: ");
            apelido = scanner.nextLine();
            Boolean running = true;
            while(running) {
                input = scanner.nextLine();
                this.dataOutputStream.writeUTF(apelido + ": " + input);
                this.dataOutputStream.flush();
            }
            this.dataInputStream.close();
            this.dataOutputStream.close();
            this.socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getHostAddress() {
        return hostAddress;
    }

    public void setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
    }

    public Integer getHostPort() {
        return hostPort;
    }

    public void setHostPort(Integer hostPort) {
        this.hostPort = hostPort;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public DataInputStream getDataInputStream() {
        return dataInputStream;
    }

    public void setDataInputStream(DataInputStream dataInputStream) {
        this.dataInputStream = dataInputStream;
    }

    public DataOutputStream getDataOutputStream() {
        return dataOutputStream;
    }

    public void setDataOutputStream(DataOutputStream dataOutputStream) {
        this.dataOutputStream = dataOutputStream;
    }
}