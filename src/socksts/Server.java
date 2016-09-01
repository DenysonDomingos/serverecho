/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mark
 */
public class Server {
    private ServerSocket serverSocket;
    private ArrayList<Clients> clients;
    private Integer port;

    public Server(Integer port) {
        this.port = port;
        this.clients = new ArrayList<>();
    }
    
    public void execute() {
        try {
            this.serverSocket = new ServerSocket(this.port);
            System.out.println("Servidor ligado na porta " + this.port);
            Socket socket;
            Boolean running = true;
            Clients clients;
            Thread thread;
            while(running) {
                socket = this.serverSocket.accept();
                clients = new Clients(socket, this);
                thread = new Thread(clients);
                this.clients.add(clients);
                thread.start();
            }
            this.serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public ArrayList<Clients> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Clients> clients) {
        this.clients = clients;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}