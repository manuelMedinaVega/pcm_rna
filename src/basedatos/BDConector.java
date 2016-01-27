/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Oscar
 */
public class BDConector {
    
    public static boolean conectar_bd(){
        if(Conexion!=null) return true;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:Mysql://"+"localhost"+"/"+BD;
            Conexion=DriverManager.getConnection(url,USUARIO, CONTRASENIA);
            //Conexion.setAutoCommit(false);
            return true;
        } catch(ClassCastException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Mensaje de GESIS",JOptionPane.WARNING_MESSAGE);
            throw ex;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Mensaje de GESIS",JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(BDConector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Mensaje de GESIS",JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(BDConector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Mensaje de GESIS",JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(BDConector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static void desconectar_bd(){
    	if(Conexion==null) return;
    	try {
            Conexion.close();
            //Prueba.txtArea.append("Se finalizo la sesion...\n");
	} catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
        
    /*
    public ResultSet consulta(String sql)throws SQLException{
        try{
            Datos=Sentencias.executeQuery(sql);
        }
        catch(SQLException ex){
            throw ex;
        }
        return Datos;
    }
    */
    
    public static Connection Conexion;
    
    private static final String BD = "pcm_bd_agrupacion";
    private static final String USUARIO = "root";
    private static final String CONTRASENIA = "123456";
    
    public static final short NUEVO = 0;
    public static final short ALTERADO = 1;
    public static final short EXISTENTE = 2;
    public static final short INDEFINIDO = 3;
}
