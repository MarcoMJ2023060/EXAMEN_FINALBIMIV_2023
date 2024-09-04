/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.marcobolaños.utils;
import java.util.Scanner;

/**
 *
 * @author MARCO
 */
// SCANNER SINGLETON 
public class Lector {
    private static Scanner instancia;
    
    private Lector(){}
    
    public static synchronized Scanner getInstancia(){
        if(instancia == null){
            instancia = new Scanner(System.in);
        }
        return instancia;
    }
}

