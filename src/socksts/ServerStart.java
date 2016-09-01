/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

/**
 *
 * @author mark
 */
public class ServerStart {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Server server = new Server(44405);
        server.execute();
    }
    
}
