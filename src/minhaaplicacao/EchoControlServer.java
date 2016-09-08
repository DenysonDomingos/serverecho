/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhaaplicacao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author deny_domin
 */
public class EchoControlServer extends Thread{

    Socket soc = null;
    BufferedReader bin = null;
    BufferedReader cin = null;
    PrintWriter out = null;
    String str;
    
    public EchoControlServer (Socket soc){
        this.soc = soc;
    }
    
    @Override
    public void run() {
        try {
            System.out.println("Client called" + soc);
               bin = new BufferedReader(new InputStreamReader(System.in));
               cin = new BufferedReader(new InputStreamReader(soc.getInputStream()));
               out = new PrintWriter(new OutputStreamWriter(soc.getOutputStream()));
               do
               {
                   str = cin.readLine();
                   System.out.println("Received Client: " + str);
                   out.println(str.toUpperCase());
                   out.flush();
               }
               while ( !(str.equalsIgnoreCase("bye")));
            } 
        catch (IOException ex) {
            Logger.getLogger(EchoControlServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
