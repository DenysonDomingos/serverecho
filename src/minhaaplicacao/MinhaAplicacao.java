/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhaaplicacao;

public class MinhaAplicacao {
    
    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        Cliente cliente = new Cliente();
        ClienteII clienteii = new ClienteII();
        
        cliente.setMsg("ola");
        clienteii.setMsg("test");
        cliente.setMsg(Servidor.ConvertMsg(cliente.getMsg()));
        clienteii.setMsg(Servidor.ConvertMsg(clienteii.getMsg()));
        
        cliente.exibir();
        clienteii.exibir();
        
    }
    
}
