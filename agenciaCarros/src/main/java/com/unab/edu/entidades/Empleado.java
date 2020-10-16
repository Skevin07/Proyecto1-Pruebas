/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.entidades;

import lombok.Data;

/**
 *
 * @author Mauricio
 */
@Data
public class Empleado {
    private int Id;
    private String Nombre;
    private String Apellido;
    private String Sexo;
    private String Direccion;
    private String Telefono;
    private String Dui;
    private String Nit;
    private String Cargo;
    private String Departamento;
    
}
