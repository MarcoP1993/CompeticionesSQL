package com.example.competicionessql.modelos;

import android.graphics.Bitmap;
import android.util.Log;

import com.example.competicionessql.clases.Escuderias;
import com.example.competicionessql.clases.FotoEscuderia;
import com.example.competicionessql.vistas.ImagenesBlobBitmap;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EscuderiaDB {

    public static ArrayList<Escuderias> obtenerEscuderias() {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if (conexion == null) {
            return null;
        }

        ArrayList<Escuderias> escuderiasDevueltas = new ArrayList<Escuderias>();
        try {
            Statement sentencia = conexion.createStatement();
            String ordenSQL = "select * from escuderias";
            ResultSet resultado = sentencia.executeQuery(ordenSQL);
            while (resultado.next()) {
                int idEscuderias = resultado.getInt("idEscuderias");
                String nombre = resultado.getString("nombre");
                int fundadaAno = resultado.getInt("FundadaAno");
                int idCampeonato = resultado.getInt("idCampeonato");
                String pais = resultado.getString("Pais");
                Escuderias esc = new Escuderias(idEscuderias, nombre, fundadaAno, idCampeonato, pais);
                escuderiasDevueltas.add(esc);
            }
            resultado.close();
            sentencia.close();
            conexion.close();
            return escuderiasDevueltas;
        } catch (SQLException e) {
            Log.i("sql", "error sql");
            return null;
        }
    }

    public static ArrayList<FotoEscuderia> obtenerFotosEscuderia(int width, int height) {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if (conexion == null) {
            return null;
        }
        ArrayList<FotoEscuderia> fotosEscuderiaDevueltas = new ArrayList<FotoEscuderia>();
        try {
            Statement sentencia = conexion.createStatement();
            String ordenSQL = "select * from fotos_Escuderia";
            ResultSet resultado = sentencia.executeQuery(ordenSQL);
            while (resultado.next()) {
                int idfoto = resultado.getInt("idfoto");
                Blob foto = resultado.getBlob("foto");
                Bitmap bm_foto = ImagenesBlobBitmap.blob_to_bitmap(foto, width, height);
                int idciudad = resultado.getInt("idciudad");
                FotoEscuderia fc = new FotoEscuderia(idfoto, bm_foto, idciudad);
                fotosEscuderiaDevueltas.add(fc);
            }
            resultado.close();
            sentencia.close();
            conexion.close();
            return fotosEscuderiaDevueltas;
        } catch (SQLException e) {
            Log.i("sql", "error sql");
            return null;
        }

    }

    public static boolean insertarEscuderiaTabla(Escuderias esc) {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if (conexion == null) {
            return false;
        }
        //----------------------------
        try{
            System.out.println(esc.toString());
            String ordenSQL = "INSERT INTO escuderias (nombre, FundadaAno, idCampeonato, pais) VALUES (?,?,?,?);";
            PreparedStatement pst = conexion.prepareStatement(ordenSQL);
            pst.setString(1, esc.getNombre());
            pst.setInt(2, esc.getFundadaAno());
            pst.setInt(3, esc.getCampeonato());
            pst.setString(4, esc.getPais());
            int filasAfectadas = pst.executeUpdate();
            pst.close();
            conexion.close();
            if(filasAfectadas > 0){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            return false;
        }
    }

    //----------------------------------------------------------------

    public static boolean borrarEscuderiaTabla(Escuderias esc) {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if (conexion == null) {
            return false;
        }
        //----------------------------
        try {
            String ordensql = "DELETE FROM escuderias WHERE idescuderia = ?;";
            PreparedStatement pst = conexion.prepareStatement(ordensql);
            pst.setInt(1, esc.getIdEscuderias());
            int filasAfectadas = pst.executeUpdate();
            pst.close();
            conexion.close();
            if (filasAfectadas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    //----------------------------------------------------------------

    public static boolean actualizarCiudadTabla(Escuderias esc) {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if (conexion == null) {
            return false;
        }
        //----------------------------
        try {
            String ordensql = "UPDATE escuderias SET nombre = ?, fundadaAno = ?, idCampeonato = ? WHERE (idescuderia = ?);";
            PreparedStatement pst = conexion.prepareStatement(ordensql);
            pst.setString(1, esc.getNombre());
            pst.setInt(2, esc.getFundadaAno());
            pst.setString(3, String.valueOf(esc.getCampeonato()));
            pst.setInt(4, esc.getIdEscuderias());
            int filasAfectadas = pst.executeUpdate();
            pst.close();
            conexion.close();
            if (filasAfectadas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    //-----------------------------------------------------------------------------

    public static Escuderias buscarCiudadTabla(String nombre) {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if (conexion == null) {
            return null;
        }
        //---------------------------------
        Escuderias escuderiaEncontrada = null;
        try {
            String ordensql = "select * from escuderias where nombre like ?";
            PreparedStatement pst = conexion.prepareStatement(ordensql);
            pst.setString(1, nombre);
            ResultSet resultadosql = pst.executeQuery();
            //------------------------------------------------
            while (resultadosql.next()) {
                int idEscuderia = resultadosql.getInt("idEscuderia");
                String nombreEscuderia = resultadosql.getString("nombre");
                int fundadaAno = resultadosql.getInt("FundadaAno");
                int idCampeonato = resultadosql.getInt("idCampeonato");
                String pais = resultadosql.getString("Pais");
                escuderiaEncontrada = new Escuderias(idEscuderia, nombreEscuderia, fundadaAno, idCampeonato, pais);
            }
            resultadosql.close();
            pst.close();
            conexion.close();
            return escuderiaEncontrada;
        } catch (SQLException e) {
            return null;
        }
    }

    //---------------------------------------------------------------------------


}
