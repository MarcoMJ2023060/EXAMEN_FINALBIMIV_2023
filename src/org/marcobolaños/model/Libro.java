/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.marcobolaños.model;

/**
 *
 * @author MARCO
 */
// MODELO LIBRO PATRON MVC
public class Libro {
    private String ISBN;
    private String titulo;
    private int AñoPublicacion;
    private String genero;

    public Libro() {
    }

    public Libro(String ISBN, String titulo, int AñoPublicacion, String genero) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.AñoPublicacion = AñoPublicacion;
        this.genero = genero;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAñoPublicacion() {
        return AñoPublicacion;
    }

    public void setAñoPublicacion(int AñoPublicacion) {
        this.AñoPublicacion = AñoPublicacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Libro{" + "ISBN=" + ISBN + ", titulo=" + titulo + ", A\u00f1oPublicacion=" + AñoPublicacion + ", genero=" + genero + '}';
    }

    
    
    
}
