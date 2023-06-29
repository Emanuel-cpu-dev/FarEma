
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CustomersDao {
      //instanciar la conexion
    //van los metodos que permite interactuar java con mysql
    connectionMySQL cn = new connectionMySQL(); // aca estan los metodos para conectarse a la db
    Connection conn;
    PreparedStatement pst;           //sirve para las consultas
    ResultSet rs;                   // para los datos de las conosultas
    
    
    //REGISTRAR EMPLEADOS
    //insertar info
    public boolean registerCustomerQuery (Customers customer){
                var query = "INSERT INTO employees(id, full_name, address,telephone, email,created,"
                        + "updated VALUES(?,?,?,?,?,?,?,)";
                       
                //Timestamp datetime = new Timestamp(new Date().getTime)());
                Timestamp datetime = new Timestamp(System.currentTimeMillis());
                try{
                conn = cn.getConnection();
                pst = conn.prepareStatement(query);
                pst.setInt(1,customer.getId());
                pst.setString (2, customer.getFull_name());
                pst.setString (3, customer.getAddress());
                pst.setString (4, customer.getTelephone());
                pst.setString (5, customer.getEmail());
                pst.setTimestamp (6, datetime);
                pst.setTimestamp (7, datetime);

                pst.execute();
                return true;
            
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error al registrar al Ciente" +e);
                return false;
            }
       }

                
          //Metodo para consultar info de la db EMPLEADOS
          //listar empleados      
                
     public List listCustomerQuery(String values){
                List<Customers> list_customers = new ArrayList();
                String query = "SELECT * FROM customers ORDER BY rol ASC";//CONSULTA Y ORDENADO
                String value = null;
                String query_search_customer = "SELECT * FROM customer WHERE id LIKE '%" + value + "%'";
               
                try{
                   conn = cn.getConnection();
                   if (value.equalsIgnoreCase("")){
                       pst = conn.prepareStatement(query);
                       rs = pst.executeQuery();
                    }else {
                       pst = conn.prepareStatement(query_search_customer);
                       rs = pst.executeQuery();
                   }
                   
                while (rs.next()){
                    Customers customer = new Customers();
                    customer.setId (rs.getInt("id"));
                    customer.setFull_name(rs.getString("Full_name"));                   
                    customer.setAddress(rs.getString("address"));
                    customer.setTelephone(rs.getString("telephone"));
                    customer.setEmail(rs.getString("email"));
                    list_customers.add(customer);
                }   
                }catch(SQLException e){
                    JOptionPane.showMessageDialog (null, e.toString());
               
                }
                    return list_customers;
                }
     
     
     //MODIFICAR CLIENTE
      public boolean updateCustomerQuery (Customers customer){
                var query = "UPDATE customers SET full_name=?, address=?,telephone=?, email=?, UPDATED=?"
                + "WHERE id = ?";
                        
                       
                //Timestamp datetime = new Timestamp(new Date().getTime)());
                Timestamp datetime = new Timestamp(System.currentTimeMillis());
                try{
                conn = cn.getConnection();
                pst = conn.prepareStatement(query);
                
                pst.setString (1, customer.getFull_name());
                pst.setString (2, customer.getAddress());
                pst.setString (3, customer.getTelephone());
                pst.setString (4, customer.getEmail());               
                pst.setTimestamp (5, datetime);
                pst.setInt(6,customer.getId());
                pst.execute();
                return true;
            
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error al modificar datos del Cliente" +e);
                return false;
            }
       }

      //ELIMINAR CLIENTE
       public boolean deleteCustomersQuery(int id){
     String query = "DELETE FROM customers WHERE id = " + id;
     try{
         conn = cn.getConnection();
         pst = conn.prepareStatement(query);
         pst.execute();
         return true;
     }
 catch(SQLException e){
     JOptionPane.showMessageDialog(null, "No puede eliminar cliente que tenga relacion con otra tabla");
     return false;
     
       }
    }
}
