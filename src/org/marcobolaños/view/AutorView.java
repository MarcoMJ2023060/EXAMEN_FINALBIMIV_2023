/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.marcobolaños.view;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.marcobolaños.controller.AutorController;
import org.marcobolaños.model.Libro;
import org.marcobolaños.model.Autor;
import org.marcobolaños.utils.Lector;
/**
 *
 * @author MARCO
 */
public class AutorView {
    private static AutorView instancia;
        private AutorController ac = AutorController.getinstancia();
        private Scanner leer = Lector.getInstancia();
        private Autor au = new Autor();
    
    AutorView(){
    
    }
    public static synchronized AutorView getInstancia(){
        if(instancia==null){
            instancia = new AutorView();
        }
        return instancia;
    }
    
    public void listarAutores(){
        ResultSet respuesta = ac.listarAutores();
        try{
            while(respuesta.next()){    
                au.setIdAutor(respuesta.getNString(1));
                au.setNombres(respuesta.getNString(2));
                au.setNacionalidad(respuesta.getNString(3));
                System.out.println(au);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }    
    
    public void buscarAutor(){
        System.out.println("Ingresa el id del autor del autor a buscar");
         leer.nextLine();
        String idAutor = leer.nextLine();
        au = ac.buscarAutor(idAutor);
        if(au.getIdAutor()!= null){
            System.out.println(au);
        }else{
            System.out.println("No se encontró el autor con el id del autor: " + idAutor);
        }
    }
    
    public void eliminarAutores(){
        System.out.println("Ingrese el id del autor del autor a eliminar");
        leer.nextLine();
        String idAutor = leer.nextLine();
        ac.eliminarAutor(idAutor);
        System.out.println("Autor eliminado exitosamente");
    }
    
    public void agregarAutor(){
        System.out.println("Ingresa el id del autor");
        String idAutor = leer.nextLine();
        String ISBN = leer.nextLine();
        System.out.println("Ingresa los nombres");
        String nombres = leer.nextLine();
        System.out.println("Ingresa la nacionalidad");
        String nacionalidad = leer.nextLine();          
        ac.agregarAutor(idAutor, nombres, nacionalidad);
        au = ac.buscarAutor(idAutor);
        if(au.getIdAutor().equals(idAutor)){
            System.out.println("Autor Guardado");
        }else{
            System.out.println("No se pudo registrar el Autor");
        }
    }

    public void actualizarAutor(){
        System.out.println("ingresa el id del autor del autor a actualizar");
        String idAutor = leer.nextLine();
        String ISBN = leer.nextLine();
        au = ac.buscarAutor(idAutor);
        if(au.getIdAutor().equals(idAutor))
        System.out.println("ingresa los nombres");
        String nombres = leer.nextLine();
        System.out.println("ingresa la nacionalidad");
        String nacionalidad = leer.nextLine();
        ac.actualizarAutor(idAutor, nombres, nacionalidad);
         System.out.println("Autor-es actualizado-s exitosamente");
          }{
           
        System.out.println("No se encontro el Autor con el id " + "idAutor");
    }
}

