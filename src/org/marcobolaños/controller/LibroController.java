/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.marcobolaños.controller;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.marcobolaños.model.Libro;
import org.marcobolaños.dao.Conexion;
import org.marcobolaños.dao.Conexion;
/**
 *
 * @author MARCO
 */
// CONTROLADOR PATRON MVC 
public class LibroController {
    
    private static LibroController instancia;
    private Libro li = new Libro();
    
    private LibroController(){
        
    }
    
    public static synchronized LibroController getinstancia(){
        if(instancia==null){
            instancia = new LibroController();
        }
        return instancia;
    }
    
    public ResultSet listarLibros(){
        ResultSet respuesta = null;
        try{
         PreparedStatement sp  = Conexion.getInstancia().getConexion().prepareCall("call sp_listarLibro();");  
            respuesta  = sp.executeQuery();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return respuesta;
    }
    
    public Libro buscarLibro(String ISBN){
        try{
            PreparedStatement sp = Conexion.getInstancia().getConexion().prepareCall("call sp_buscarLibro(?);");
            sp.setString(1, ISBN);
            ResultSet respuesta = sp.executeQuery();
            while(respuesta.next()){
                li.setISBN(respuesta.getNString(1));
                li.setTitulo(respuesta.getNString(2));
                li.setAñoPublicacion(3);
                li.setGenero(respuesta.getNString(4));        
            }
            respuesta.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return li;
    }
    
    public void eliminarLibros(String ISBN){
        try{
            PreparedStatement sp = Conexion.getInstancia().getConexion().prepareCall("call sp_borrarLibro(?);");
            sp.setString(1, ISBN);
            sp.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void agregarLibro(String ISBN, String titulo,int AñoPublicacion, String genero){
    try{
        PreparedStatement sp = Conexion.getInstancia().getConexion().prepareCall("call sp_agregarLibro(?, ?, ?, ?);");
        sp.setString(1, ISBN);
        sp.setString(2, titulo);
        sp.setString(3, genero);
        sp.setInt(4, AñoPublicacion);
        sp.execute();   
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
    }
    
    public void actualizarLibro(String ISBN, String titulo,int AñoPublicacion, String genero){
        try{
            PreparedStatement sp = Conexion.getInstancia().getConexion().prepareCall("call sp_actualizarLibros(?, ?, ?, ?);");
            sp.setString(1, ISBN);
            sp.setString(2, titulo);
            sp.setInt(3, AñoPublicacion);
            sp.setString(4, genero);
            sp.execute();               
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
