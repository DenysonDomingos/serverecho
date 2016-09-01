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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mark
 */
public class Clients implements Runnable {
    private Socket socket;
    private Server server;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    
    public Clients(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            this.dataInputStream = new DataInputStream(this.socket.getInputStream());
            this.dataOutputStream = new DataOutputStream(this.socket.getOutputStream());
            Boolean running = true;
            String str;
            while (running) {
                str = this.dataInputStream.readUTF();
                System.out.println("[" + this.socket.getInetAddress().getHostAddress() +"]: " + str);
            }
            this.dataInputStream.close();
            this.dataOutputStream.close();
            this.socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
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