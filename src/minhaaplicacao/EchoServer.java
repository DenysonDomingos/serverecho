/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhaaplicacao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author deny_domin
 */
public class EchoServer {
    
    public static void main(String[] args) {
        
        ServerSocket ssoc = null;
        Socket soc = null;
        BufferedReader bin = null;
        BufferedReader cin = null;
        PrintWriter out = null;
        String str;
        
        try
        {
            ssoc = new ServerSocket(44406);
            System.out.println("Server is started");
            while (true)
            {
               soc = ssoc.accept();
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
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
    }
    
}
