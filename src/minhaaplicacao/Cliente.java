/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhaaplicacao;


public class Cliente {
    
    private String msg;


    public String getMsg() {
        return msg;
    }


    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public void exibir(){
    System.out.println("Cli I: " + getMsg());
    }
}
