/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Capa_Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author gustavovargas
 */
public class Conexion {
    private Connection conexion;
    
    public Connection getConexion()
{
   return conexion;
}
 
/**
* Método utilizado para establecer la conexión con la base de datos
* @return estado regresa el estado de la conexión, true si se estableció la conexión,
* falso en caso contrario
*/
public boolean crearConexion()
{
   try {
      Class.forName("com.mysql.jdbc.Driver");
      conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
       System.out.println("Se creo la conexion");
   } catch (SQLException ex) {
      ex.printStackTrace();
      return false;
   } catch (ClassNotFoundException ex) {
      ex.printStackTrace();
      return false;
   }
 
   return true;
}
 
/**
*
*Método utilizado para realizar las instrucciones: INSERT, DELETE y UPDATE
*@param sql Cadena que contiene la instrucción SQL a ejecutar
*@return estado regresa el estado de la ejecución, true(éxito) o false(error)
*
*/
public boolean ejecutarSQL(String sql)
{
   try {
      Statement sentencia = conexion.createStatement();
      sentencia.executeUpdate(sql);
   } catch (SQLException ex) {
      ex.printStackTrace();
   return false;
   }
 
   return true;
}
 
/**
*
*Método utilizado para realizar la instrucción SELECT
*@param sql Cadena que contiene la instrucción SQL a ejecutar
*@return resultado regresa los registros generados por la consulta
*
*/
public ResultSet ejecutarSQLSelect(String sql)
{
   ResultSet resultado;
   try {
      Statement sentencia = conexion.createStatement();
      //conexion.prepareStatement(sql);
      resultado = sentencia.executeQuery(sql);
   } catch (SQLException ex) {
      ex.printStackTrace();
      return null;
   }
 
   return resultado;
}
    
}
