/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhaaplicacao;

/**
 *
 * @author deny_domin
 */
public class Echo2 extends Thread{
    
    @Override
    public void run() {
        while (true) {
        System.out.println("2");
        }
    }
    
}
