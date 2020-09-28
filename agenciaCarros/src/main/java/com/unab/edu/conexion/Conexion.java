/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Mauricio
 */
public class Conexion {
    private Connection conexion;
    public Conexion(){
        try {
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/agenciac","root","root");
            System.out.println("Conexion Existosa!");
        } catch (Exception e) {
            System.out.println("No se pudo realizar la Conexion "+e);
        }
    }
    public Connection retornarConexion(){
        return conexion;
    }
}
