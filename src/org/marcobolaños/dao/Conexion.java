/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.marcobolaños.dao;
import java.sql.*;
/**
 *
 * @author MARCO
 */
// DA0
// JCDB (CONEXION)
public class Conexion {
  // 1er paso Singleton
    private Connection conexion;
    private static Conexion instancia;
    
    // 2do USO DE SINGLETON 
    private Conexion(){
        // MANEJO EXCEPCIONES
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection
                                ("jdbc:mysql://localhost:3306/dbexamenfinal?useSSL=false","root","marco1234");
        }catch(ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException error){
            System.out.println(error.getMessage());
        }
    }
    
    // 3er uso de Singleton
    public static synchronized Conexion getInstancia(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

}


