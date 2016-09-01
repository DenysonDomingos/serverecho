/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhaaplicacao;

import javax.swing.JOptionPane;

/**
 *
 * @author deny_domin
 */
public class InputText {
    public static void main(String[] args) {
        String nome = null;
        nome = JOptionPane.showInputDialog("Qual o seu nome?");
        JOptionPane.showMessageDialog(null, "Seu nome é " + nome);
    }
}
