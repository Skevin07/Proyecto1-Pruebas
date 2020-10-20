/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//OK PRUEBA
package com.unab.edu.dao;

import com.unab.edu.conexion.Conexion;
import com.unab.edu.entidades.Empleado;
import java.sql.*;
import java.util.ArrayList;
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
            JOptionPane.showMessageDialog(null, "Datos almacenados con éxito!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos");

        }

    }

    public void actualizarEmpleado(Empleado empleado) {
        try {
            CallableStatement statement = con.prepareCall("call sp_u_Empleado(?,?,?,?,?,?,?,?,?,?)");
            statement.setInt("pId", empleado.getId());
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
            JOptionPane.showMessageDialog(null, "Datos actualizados con éxito!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar los datos");

        }

    }

    public void eliminarEmpleado(Empleado empleado) {
         try {
            CallableStatement statement = con.prepareCall("call sp_d_Empleado(?);");
            statement.setInt("pIdEmpleado", empleado.getId());
            //Esto devuelve un dato al realizar la consulta
            //ResultSet resultado= Statement.executeQuery();
            statement.execute();
            JOptionPane.showMessageDialog(null, "Datos eliminados correntamente");
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar los Datos " + e);

        }
    }

    public ArrayList<Empleado> MostrarEmpleados() {
        var listado = new ArrayList<Empleado>();
        try {
            CallableStatement statement = con.prepareCall("call sp_s_Empleado;");
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                Empleado emple = new Empleado();
                emple.setId(res.getInt("idEmpleado"));
                emple.setNombre(res.getString("Nombre"));
                emple.setApellido(res.getString("Apellido"));
                emple.setSexo(res.getString("Sexo"));
                emple.setDireccion(res.getString("Direccion"));
                emple.setTelefono(res.getString("Telefono"));
                emple.setDui(res.getString("Dui"));
                emple.setNit(res.getString("Nit"));
                emple.setCargo(res.getString("Cargo"));
                emple.setDepartamento(res.getString("Departamento"));
                listado.add(emple);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargaron los Empleados " + e);
        }

        return listado;
    }
}
