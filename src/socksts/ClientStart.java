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
public class ClientStart {
    public static void main(String[] args) {
        Client client = new Client("10.42.0.1", 44405);
        client.execute();
    }
}
