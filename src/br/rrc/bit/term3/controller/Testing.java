/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rrc.bit.term3.controller;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Pedro Henrique
 */
public class Testing implements Runnable {
    
    private JFrame jMainFrame;
    public  Testing(int componentNumber,JFrame mainFrame){
        jMainFrame = mainFrame;
    }
    @Override
    public void run() {
        
    }
    
}
