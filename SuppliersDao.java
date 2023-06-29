
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SuppliersDao {
    
      //instanciar la conexion
    //van los metodos que permite interactuar java con mysql
    connectionMySQL cn = new connectionMySQL(); // aca estan los metodos para conectarse a la db
    Connection conn;
    PreparedStatement pst;           //sirve para las consultas
    ResultSet rs;                   // para los datos de las conosultas
    
    //REGISTRAR PROVEEDOR
        public boolean registerSuppliersQuery (Suppliers supplier){
                var query = "INSERT INTO suppliers (name, description,address, telephone,email,city,created, updated)"
                        + "updated VALUES(?,?,?,?,?,?)";
                       
                //Timestamp datetime = new Timestamp(new Date().getTime)());
                Timestamp datetime = new Timestamp(System.currentTimeMillis());
                try{
                conn = cn.getConnection();
                pst = conn.prepareStatement(query);
                pst.setString (1, supplier.getName());
                pst.setString (2, supplier.getDescription());
                pst.setString (3, supplier.getAddress());
                pst.setString (4, supplier.getTelephone());
                pst.setString (5, supplier.getEmail());
                pst.setString (6, supplier.getCity());
                pst.setTimestamp (7, datetime);
                pst.setTimestamp (8, datetime);

                pst.execute();
                return true;
            
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error al registrar Proveedor" +e);
                return false;
            }
       }

        
        //METODO PARA LISTAR PROVEEDORES
             public List listSuppliersQuery(String values){
                List<Suppliers> list_suppliers = new ArrayList();
                String query = "SELECT * FROM supplier";//CONSULTA 
                String value = null;
                String query_search_supplier = "SELECT * FROM supplier WHERE name LIKE '%" + value + "%'";
               
                try{
                   conn = cn.getConnection();
                   if (value.equalsIgnoreCase("")){
                       pst = conn.prepareStatement(query);
                       rs = pst.executeQuery();
                    }else {
                       pst = conn.prepareStatement(query_search_supplier);
                       rs = pst.executeQuery();
                   }
                   
                while (rs.next()){
                    Suppliers supplier = new Suppliers();
                    supplier.setName (rs.getString("name"));
                    supplier.setDescription(rs.getString("description"));                   
                    supplier.setAddress(rs.getString("address"));
                    supplier.setTelephone(rs.getString("telephone"));
                    supplier.setEmail(rs.getString("email"));
                    supplier.setCity(rs.getString("city"));
                    list_suppliers.add(supplier);
                }   
                }catch(SQLException e){
                    JOptionPane.showMessageDialog (null, e.toString());
               
                }
                    return list_suppliers;
                }

             //MODIFICAR PROVEEDOR
      public boolean updateSuppliersQuery (Suppliers supplier){
                var query = "UPDATE suppliers SET name=?,description=?, address=?,telephone=?, email=?,city=? UPDATED=?"
                + "WHERE id = ?";
                        
                       
                //Timestamp datetime = new Timestamp(new Date().getTime)());
                Timestamp datetime = new Timestamp(System.currentTimeMillis());
                try{
                conn = cn.getConnection();
                pst = conn.prepareStatement(query);
                
                pst.setString (1, supplier.getName());
                pst.setString (2, supplier.getDescription());
                pst.setString (3, supplier.getAddress());
                pst.setString (4, supplier.getTelephone());
                pst.setString (5, supplier.getEmail());     
                pst.setString (6, supplier.getCity());
                pst.setTimestamp (7, datetime);
                pst.setInt(8,supplier.getId());
                pst.execute();
                return true;
            
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error al modificar datos del Proveedor" +e);
                return false;
            }
       }
      
      //ELIMINAR PROVEEDOR
       public boolean deleteSuppliersQuery(int id){
     String query = "DELETE FROM suppliers WHERE id = " + id;
     try{
         conn = cn.getConnection();
         pst = conn.prepareStatement(query);
         pst.execute();
         return true;
     }
 catch(SQLException e){
     JOptionPane.showMessageDialog(null, "No puede eliminar el proveedor que tenga relacion con otra tabla");
     return false;
     
       }
    }
}
