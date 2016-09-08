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
               EchoControlServer echoserver = new EchoControlServer(soc);
               echoserver.start();
               
//               Echo12 e1 = new Echo12();
//               Echo2 e2 = new Echo2();
//               
//               e1.start();
//               e2.start();
            }
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
    }
    
}
