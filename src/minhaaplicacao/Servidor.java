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
public class Servidor {
    private String msg;

    public String getMsg() {
        return msg;
    }


    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public static String ConvertMsg(String msg){
        msg = msg.toUpperCase();
        return msg;
    }    
}
