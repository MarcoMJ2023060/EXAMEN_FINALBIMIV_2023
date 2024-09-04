/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.marcobolaños.view;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.marcobolaños.utils.Lector;
/**
 *
 * @author MARCO
 */
// VIEWS PATRON MVC 
public class MenuGeneralExamenFinal {
    private final Scanner leer = Lector.getInstancia();
    private int op = 0;
    private LibroView lv = LibroView.getInstancia();
    private AutorView av = AutorView.getInstancia();
    
    
    public void inicio(){
        // Manejo de excepciones
        try{
            boolean flag = false;
            while(!flag){
                System.out.println("Ingresa al sistema de administración DBexamenfinal" + "\n" +
                        "Ingresa la número de la opción que deseas realizar" + "\n" +
                        "1. Administración de Libros" + "\n" + 
                        "2. Administracion de Autores" + "\n"+ 
                        "0. Terminar programa" + "\n" );
                op = leer.nextInt();
                switch(op){
                    case 1:
                        administradorLibros();
                        break;
                    case 2:
                        administradorAutores();
                    break;
                    case 0:
                        System.exit(0);
                        break;
                }
            }
        }catch(InputMismatchException e){
            System.out.println("Error: Ingresaste una caracter inválido, ingresa un número");
        }
    }
    
    private void administradorLibros(){
        try{
            boolean flag = false;
            while(!flag){
                System.out.println("Bienvenido al administrador de Libros" + "\n" +
                        "Ingresa el número de la opción que deseas realizar" + "\n" +
                        "1. Listar libro" + "\n" + 
                        "2. Buscar libro" + "\n" +
                        "3. Eliminar libro" + "\n" +
                        "4. Agregar libros" + "\n" + 
                        "5. Actualizar libro" + "\n" +
                        "0. Regresar al menú anterior");
                op = leer.nextInt();
                switch(op){
                    case 1:
                        lv.listarLibros();
                        break;
                    case 2:
                        lv.buscarLibro();
                        break;
                    case 3:
                        lv.eliminarLibros();
                        break;
                    case 4:
                        lv.agregarLibro();
                        break;
                    case 5:
                        lv.actualizarLibro();
                    case 0:
                        inicio();
                        break;
                }
            }
        }catch(InputMismatchException e){
            System.out.println("Error: Ingresaste una caracter inválido, ingresa un número");
        }        
                }        

    
    private void administradorAutores(){
        try{
            boolean flag = false;
            while(!flag){
                System.out.println("Bienvenido al administrador de Autores" + "\n" +
                        "Ingresa el número de la opción que deseas realizar" + "\n" +
                        "1. Listar Autores" + "\n" + 
                        "2. Buscar Autor" + "\n" +
                        "3. Eliminar Autor" + "\n" +
                        "4. Agregar Autor" + "\n" + 
                        "5. Actualizar Autor" + "\n" +
                        "0. Regresar al menú anterior");
                op = leer.nextInt();
                switch(op){
                    case 1:
                        av.listarAutores();
                        break;
                    case 2:
                        av.buscarAutor();
                        break;
                    case 3:
                        av.eliminarAutores();
                        break;
                    case 4:
                        av.agregarAutor();
                        break;
                    case 5:
                        av.actualizarAutor();
                    case 0:
                        inicio();
                        break;
                }
            }
        }catch(InputMismatchException e){
            System.out.println("Error: Ingresaste una caracter inválido, ingresa un número");
        }        
                }   
}
