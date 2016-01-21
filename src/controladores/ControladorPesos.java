/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import static basedatos.BDConector.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author usuario
 */
public class ControladorPesos {
    public void insertarPesos(float valor,int capa_entrada,int capa_salida,int neurona_entrada,int neurona_salida)throws SQLException{
        String statement="INSERT INTO peso VALUES(default,?)";
        PreparedStatement insert=(PreparedStatement) Conexion.prepareStatement(statement,PreparedStatement.RETURN_GENERATED_KEYS);
        insert.setFloat(1, valor);
        insert.executeUpdate();
        ResultSet rs=insert.getGeneratedKeys();
        if(rs != null && rs.next()){
            int id = rs.getInt(1);
            String statement2="INSERT INTO peso_neurona VALUES(?,?,?)";
            insert=(PreparedStatement) Conexion.prepareStatement(statement2);
            insert.setInt(1, id);
            insert.setInt(2, capa_entrada);
            insert.setInt(3,neurona_entrada);
            insert.execute();

            insert=(PreparedStatement) Conexion.prepareStatement(statement2);
            insert.setInt(1, id);
            insert.setInt(2, capa_salida);
            insert.setInt(3,neurona_salida);
            insert.execute();
            insert.close(); 
        }     
    }
    
    public void insertarPesos(float valor,int capa,int neurona)throws SQLException{
        String statement="INSERT INTO peso VALUES(default,?)";
        PreparedStatement insert=(PreparedStatement) Conexion.prepareStatement(statement,PreparedStatement.RETURN_GENERATED_KEYS);
        insert.setFloat(1, valor);
        insert.executeUpdate();
        ResultSet rs=insert.getGeneratedKeys();
        if(rs != null && rs.next()){
            int id = rs.getInt(1);
            String statement2="INSERT INTO peso_neurona VALUES(?,?,?)";
            insert=(PreparedStatement) Conexion.prepareStatement(statement2);
            insert.setInt(1, id);
            insert.setInt(2, capa);
            insert.setInt(3,neurona);
            insert.execute();
            insert.close();  
        }       
    }
    
    public void insertarNeuronas(int capa,int numero)throws SQLException{
        String statement="INSERT INTO neurona VALUES(?,?)";
        PreparedStatement insert=(PreparedStatement) Conexion.prepareStatement(statement);
        insert.setInt(1, capa);
        insert.setInt(2, numero);               
        insert.execute();
        insert.close();
    }
}
