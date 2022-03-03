package com.example.competicionessql.modelos;

import android.util.Log;

import com.example.competicionessql.clases.Campeonato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CampeonatoDB {

    public static boolean insertarCampeonatoTabla(Campeonato c) {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            System.out.println("No se pudo conectar con la base de datos");
            return false;
        }
        //----------------------------
        try {
            String ordensql = "INSERT INTO campeonato (nombre) VALUES (?);";
            PreparedStatement pst = conexion.prepareStatement(ordensql);
            pst.setString(1, c.getNombre());
            int filasAfectadas = pst.executeUpdate();
            pst.close();
            conexion.close();
            if(filasAfectadas > 0)
            {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    public static ArrayList<Campeonato> obtenerCampeonatos() {

        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return null;
        }
        ArrayList<Campeonato> campeonatosDevueltos = new ArrayList<Campeonato>();
        try {
            Statement sentencia = conexion.createStatement();
            String ordenSQL = "select * from campeonato";
            ResultSet resultado = sentencia.executeQuery(ordenSQL);
            while (resultado.next()){
                int idcampeonato = resultado.getInt("idcampeonato");
                String nombre = resultado.getString("nombre");
                Campeonato c = new Campeonato(idcampeonato, nombre);
                campeonatosDevueltos.add(c);
            }
            resultado.close();
            sentencia.close();
            conexion.close();
            return campeonatosDevueltos;
        }catch (SQLException throwables) {
            Log.i("SQL", "error SQL");
            return campeonatosDevueltos;
        }

    }

    public static boolean borrarCampeonatoTabla(Campeonato c) {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return false;
        }
        //----------------------------
        try {
            String ordensql = "DELETE FROM campeonato WHERE nombre LIKE ?";
            PreparedStatement pst = conexion.prepareStatement(ordensql);
            pst.setString(1, c.getNombre());
            int filasAfectadas = pst.executeUpdate();
            pst.close();
            conexion.close();
            if(filasAfectadas > 0)
            {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    //-----------------------------------------------------------

    public static boolean actualizarCampeonatoTabla(Campeonato c) {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return false;
        }
        //----------------------------
        try {
            String ordensql = "UPDATE campeonato SET nombre = ? WHERE idCampeonato = ?;";
            PreparedStatement pst = conexion.prepareStatement(ordensql);
            pst.setString(1, c.getNombre());
            pst.setInt(2, c.getIdCampeonato());
            int filasAfectadas = pst.executeUpdate();
            pst.close();
            conexion.close();
            if(filasAfectadas > 0)
            {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }


    }

//-----------------------------------------------------------

    public static Campeonato buscarCampeonatoTabla(String nombre)
    {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return null;
        }
        //---------------------------------
        Campeonato campeonatoEncontrado = null;
        try {
            ResultSet resultadosql = BaseDB.buscarFilasEnTabla(conexion, "campeonato", "nombre", nombre);
            //------------------------------------------------
            if(resultadosql == null)
            {
                return null;
            }
            while(resultadosql.next())
            {
                int idcampeonato = resultadosql.getInt("idcampeonato");
                String nombrecampeonato = resultadosql.getString("nombre");
                campeonatoEncontrado = new Campeonato(idcampeonato,nombrecampeonato);
            }
            resultadosql.close();
            conexion.close();
            return campeonatoEncontrado;
        } catch (SQLException e) {
            return null;
        }
    }


}
