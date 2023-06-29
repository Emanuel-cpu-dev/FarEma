
package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionMySQL {
    
    private final String database_name = "pharmacy_database";
    private final String user = "root";
    private final String password = "root";
    private final String url = "jdbc:mysql://localhost:3306/" + database_name;
    Connection conn = null;
    
    public Connection getConnection(){
        
        try{
          //Obtener el valor del driver
          Class.forName("com.mysql.cj.jdbc.Driver");
          //Obtener conexion
          conn = DriverManager.getConnection(url,user,password);
            
        }catch(ClassNotFoundException e){
            System.err.println("ha ocurrido un ClassNotFundExeption" + e.getMessage());
            
        }catch (SQLException e){
            System.err.println("Ha ocurrido un SQLException" + e.getMessage());
        }
        return conn;
      }
}
