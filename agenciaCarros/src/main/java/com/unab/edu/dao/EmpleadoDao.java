/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.dao;

import com.unab.edu.conexion.Conexion;
import com.unab.edu.entidades.Empleado;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio
 */
public class EmpleadoDao {

    Conexion cn = new Conexion();
    Connection con = cn.retornarConexion();

    //METODOS DE ACCESO A LA BASE DE DATOS
    public void agregarEmpleado(Empleado empleado) {
        try {
            CallableStatement statement = con.prepareCall("call sp_i_Empleado(?,?,?,?,?,?,?,?,?)");
            statement.setString("pNombre", empleado.getNombre());
            statement.setString("pApellido", empleado.getApellido());
            statement.setString("pSexo", empleado.getSexo());
            statement.setString("pDireccion", empleado.getDireccion());
            statement.setString("pTelefono", empleado.getTelefono());
            statement.setString("pDui", empleado.getDui());
            statement.setString("pNit", empleado.getNit());
            statement.setString("pCargo", empleado.getCargo());
            statement.setString("pDepartamento", empleado.getDepartamento());
            //ejecutamos la consulta
            statement.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "Empleado almacenado con éxito!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Empleado almacenado con éxito!");

        }
        
    }
}
