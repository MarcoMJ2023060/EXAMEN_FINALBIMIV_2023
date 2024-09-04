/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.marcobolaños.controller;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.marcobolaños.model.Autor;
import org.marcobolaños.model.Libro;
import org.marcobolaños.dao.Conexion;
import org.marcobolaños.dao.Conexion;
/**
 *
 * @author MARCO
 */
public class AutorController {
    private static AutorController instancia;
    private Autor au = new Autor();
    
    private AutorController(){
        
    }
    
    public static synchronized AutorController getinstancia(){
        if(instancia==null){
            instancia = new AutorController();
        }
        return instancia;
    }
    
    public ResultSet listarAutores(){
        ResultSet respuesta = null;
        try{
         PreparedStatement sp  = Conexion.getInstancia().getConexion().prepareCall("call sp_listarAutor();");  
            respuesta  = sp.executeQuery();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return respuesta;
    }
    
    public Autor buscarAutor(String idAutor){
        try{
            PreparedStatement sp = Conexion.getInstancia().getConexion().prepareCall("call sp_buscarAutor(?);");
            sp.setString(1, idAutor);
            ResultSet respuesta = sp.executeQuery();
            while(respuesta.next()){
                au.setIdAutor(respuesta.getNString(1));
                au.setNombres(respuesta.getNString(2));
                au.setNacionalidad(respuesta.getNString(3));  
            }
            respuesta.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return au;
    }
    
    public void eliminarAutor(String idAutor){
        try{
            PreparedStatement sp = Conexion.getInstancia().getConexion().prepareCall("call sp_borrarAutor(?);");
            sp.setString(1, idAutor);
            sp.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void agregarAutor(String idAutor, String nombres,String nacionalidad){
    try{
        PreparedStatement sp = Conexion.getInstancia().getConexion().prepareCall("call sp_agregaraUTOR(?, ?, ?);");
        sp.setString(1, idAutor);
        sp.setString(2, nombres);
        sp.setString(3, nacionalidad);
        sp.execute();   
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
    }

    
    public void actualizarAutor(String idAutor, String nombres, String nacionalidad){
        try{
            PreparedStatement sp = Conexion.getInstancia().getConexion().prepareCall("call sp_actualizarAutor(?, ?, ?);");
            sp.setString(1, idAutor);
            sp.setString(2, nombres);
            sp.setString(3, nacionalidad);
            sp.execute();               
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

