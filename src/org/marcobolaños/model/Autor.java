/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.marcobolaños.model;

/**
 *
 * @author MARCO
 */
public class Autor {
    private String idAutor;
    private String nombres;
    private String nacionalidad;

    public Autor() {
    }

    public Autor(String idAutor, String nombres, String nacionalidad) {
        this.idAutor = idAutor;
        this.nombres = nombres;
        this.nacionalidad = nacionalidad;
    }

    public String getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(String idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "Autor{" + "idAutor=" + idAutor + ", nombres=" + nombres + ", nacionalidad=" + nacionalidad + '}';
    }
    
    
}
