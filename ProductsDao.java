/*
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProductsDao {
    
    //instanciar la conexion
    //van los metodos que permite interactuar java con mysql
    connectionMySQL cn = new connectionMySQL(); // aca estan los metodos para conectarse a la db
    Connection conn;
    PreparedStatement pst;           //sirve para las consultas
    ResultSet rs;                   // para los datos de las conosultas
    
    //REGISTRAR PRODUCTOS
    //insertar info
    public boolean registerProdutsQuery (Products product){
                var query = "INSERT INTO product(code,name,description,unit_price,created,category_id"
                        + "updated VALUES(?,?,?,?,?,?,?,)";
                       
                //Timestamp datetime = new Timestamp(new Date().getTime)());
                Timestamp datetime = new Timestamp(System.currentTimeMillis());
                try{
                conn = cn.getConnection();
                pst = conn.prepareStatement(query);
                pst.setInt (1,product.getId());
                pst.setString (2, product.getName());
                pst.setString (3, product.getDescription());
                pst.setDouble(4, product.getunit_price());
                pst.setString (5, product.getCategory_id());
                pst.setTimestamp (7, datetime);
                pst.setTimestamp (7, datetime);

                pst.execute();
                return true;
            
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error al registrar al Producto" +e);
                return false;
            }
       }
    
      //LISTAR PRODUCTOS
     public List lisProductsQuery(String values){
     List<Products> list_products = new ArrayList();
     String query = "SELECT pro.*, ca.name AS category_name FROM products pro, categories ca WHERE pro.category_id = ca.id";
        String value;
     String query_search_product = "SELECT pro.*,ca.name AS category_name FROM products pro INNER JPIN categories ca ON pro.category_id = ca.id WHERE pro.name LIKE '%" + values + "%'";
     
    try{
                   conn = cn.getConnection();
                   if (values.equalsIgnoreCase("")){
                       pst = conn.prepareStatement(query);
                       rs = pst.executeQuery();
                    }else {
                       pst = conn.prepareStatement(query_search_product);
                       rs = pst.executeQuery();
                   }
                   
                while (rs.next()){
                    Products products = new Products();
                    products.setId (rs.getInt("id"));
                    products.setCode(rs.getString("code"));                   
                    products.setName(rs.getString("name"));
                    products.setDescription(rs.getString("description"));
                    products.setUnit_price(values);
                  //  products.setUnit_price(rs.getDouble("unit_price"));
                    products.setCategory_name(rs.getString("category_name"));

                    list_products.add(products);
                }   
                }catch(SQLException e){
                    JOptionPane.showMessageDialog (null, e.toString());
               
                }
                    return list_products;

         }
     
     //MODIFICAR PRODUCTOS
      public boolean updateProductsQuery (Products products){
                var query = "UPDATE products SET code=?, name=?,description=?,unit_price=?,updated=?,category_id=? "
                + "WHERE id = ?";
                        
                       
                //Timestamp datetime = new Timestamp(new Date().getTime)());
                Timestamp datetime = new Timestamp(System.currentTimeMillis());
                try{
                conn = cn.getConnection();
                pst = conn.prepareStatement(query);
                
                pst.setString (1, products.getCode());
                pst.setString (2, products.getName());
                pst.setString (3, products.getDescription());
                pst.setString (4, products.getUnit_price()); 
                pst.setString (5, products.getCategory_id());               
                pst.setTimestamp (6, datetime);
                pst.setInt(7,products.getId());
                pst.execute();
                return true;
            
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error al modificar datos del Producto" +e);
                return false;
            }
       }
             
          //ELIMINAR PRODUCTOS
       public boolean deleteProductsQuery(int id){
     String query = "DELETE FROM product WHERE id = " + id;
     try{
         conn = cn.getConnection();
         pst = conn.prepareStatement(query);
         pst.execute();
         return true;
     }
 catch(SQLException e){
     JOptionPane.showMessageDialog(null, "No puede eliminar Producto que tenga relacion con otra tabla");
     return false;
     
       }
    }
       
       //METODO PARA BUSCAR PRODUCTOS
       public boolean searchProduct(int id){
           String query = "SELECT pro.*, ca.name AS category_name FROM products pro INNER JOIN categories ca ON pro.category_id = ca.id WHERE pro.id = ?";
           Products product = new Products ();
           try{
               conn = cn.getConnection();
               pst = conn.prepareStatement(query);
               pst.setInt(1,id);
               rs = pst.executeQuery();
               
               if (rs.next()){
                   product.setId (rs.getInt(id));
                  // product.setCode(rs.getInt("code"));
                   product.setName(rs.getString("name"));
                   product.setDescription(rs.getString("description"));
                 //  product.setUnit_price(rs.getDouble("unit_price"));
                  // product.setCategory_id(rs.getInt("category_id"));
                   product.setCategory_name(rs.getString("category_name"));
              
               }
       }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }   
          //  return product;
   }
}
//ME FALTA COMPLETAR 3.7 PARTE 2

*/