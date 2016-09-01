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
public class EchoCliente {
    
    public static void main(String[] args) {
        
        Socket soc = null;
        BufferedReader bin = null;
        BufferedReader cin = null;
        PrintWriter out = null;
        String str;
        
        try
        {
            soc = new Socket("127.0.0.1",44406);
            bin = new BufferedReader (new InputStreamReader(System.in));
            cin = new BufferedReader (new InputStreamReader(soc.getInputStream()));
            out = new PrintWriter (new OutputStreamWriter(soc.getOutputStream()));
            
            do
            {
                System.out.println("Enter message: ");
                str = bin.readLine();
                out.println(str);
                out.flush();
                str = cin.readLine();
                System.out.println("Message Server Received = "+str);
            }
            while (!(str.equalsIgnoreCase("bye")));
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
    }
    
}
