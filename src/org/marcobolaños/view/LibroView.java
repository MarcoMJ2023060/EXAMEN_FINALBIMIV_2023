/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.marcobolaños.view;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.marcobolaños.controller.LibroController;
import org.marcobolaños.model.Libro;
import org.marcobolaños.utils.Lector;
/**
 *
 * @author MARCO
 */
public class LibroView {
    private static LibroView instancia;
        private LibroController lc = LibroController.getinstancia();
        private Scanner leer = Lector.getInstancia();
        private Libro li = new Libro();
    
    LibroView(){
    
    }
    public static synchronized LibroView getInstancia(){
        if(instancia==null){
            instancia = new LibroView();
        }
        return instancia;
    }
    
    public void listarLibros(){
        ResultSet respuesta = lc.listarLibros();
        try{
            while(respuesta.next()){    
                li.setISBN(respuesta.getNString(1));
                li.setTitulo(respuesta.getNString(2));
                li.setAñoPublicacion(respuesta.getInt(3));
                li.setGenero(respuesta.getNString(4));
                System.out.println(li);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }    
    
    public void buscarLibro(){
        System.out.println("Ingresa el ISBN del cliente a buscar");
         leer.nextLine();
        String ISBN = leer.nextLine();
        li = lc.buscarLibro(ISBN);
        if(li.getISBN()!= null){
            System.out.println(li);
        }else{
            System.out.println("No se encontró el cliente con el ISBN: " + ISBN);
        }
    }
    
    
    public void eliminarLibros(){
        System.out.println("Ingrese el ISBN del cliente a eliminar");
        leer.nextLine();
        String ISBN = leer.nextLine();
        lc.eliminarLibros(ISBN);
        System.out.println("Libro eliminado exitosamente");
    }
    
    public void agregarLibro(){
        System.out.println("Ingresa el ISBN");
        leer.nextLine();
        String ISBN = leer.nextLine();
        System.out.println("Ingresa el titulo");
        String titulo = leer.nextLine();
        System.out.println("Ingresa el genero");
        String genero = leer.nextLine();
        int AñoPublicacion = 0;        
        try{
            boolean validInput = false;
            while(!validInput){
                System.out.println("Ingresa el año publicacion");
                AñoPublicacion = leer.nextInt();
                validInput = true;
        }
        }catch(InputMismatchException e){
            System.out.println("Ingresa un número, no una letra");
        }           
        lc.agregarLibro(ISBN, titulo, AñoPublicacion, genero);
        li = lc.buscarLibro(ISBN);
        if(li.getISBN().equals(ISBN)){
            System.out.println("Cliente Guardado");
        }else{
            System.out.println("No se pudo registrar el cliente");
        }
    }
    
    public void actualizarLibro(){
        System.out.println("ingresa el ISBN del cliente a actualizar");
        leer.nextLine();
        String ISBN = leer.nextLine();
        li = lc.buscarLibro(ISBN);
        if(li.getISBN().equals(ISBN))
        System.out.println("ingresa el titulo");
        String titulo = leer.nextLine();
        System.out.println("ingresa el genero");
        String genero = leer.nextLine();
         System.out.println("ingresa el año de publicacion");
         int AñoPublicacion = leer.nextInt();
         lc.actualizarLibro(ISBN, titulo, AñoPublicacion, genero);
         System.out.println("Libro actualizado exitosamente");
          }{
           
        System.out.println("No se encontro el libro con el ISBN " + "ISBN");
    }
}

