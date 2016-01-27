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
    public void insertarPesos(float valor)throws SQLException{
        String statement="INSERT INTO peso VALUES(default,?)";
        PreparedStatement insert=(PreparedStatement) Conexion.prepareStatement(statement,PreparedStatement.RETURN_GENERATED_KEYS);
        insert.setFloat(1, valor);
        insert.execute();
        insert.close();      
    }
}
