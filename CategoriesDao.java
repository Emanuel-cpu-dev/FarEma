
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CategoriesDao {
        //instanciar la conexion
    //van los metodos que permite interactuar java con mysql
    connectionMySQL cn = new connectionMySQL(); // aca estan los metodos para conectarse a la db
    Connection conn;
    PreparedStatement pst;           //sirve para las consultas
    ResultSet rs;                   // para los datos de las conosultas
    
    //REGISTRAR CATEGORIAS
    //insertar info
    public boolean registerCategoriesQuery (Categories categoriy){
                var query = "INSERT INTO categoriey(name, created,"
                        + "updated VALUES(?,?)";
                       
                //Timestamp datetime = new Timestamp(new Date().getTime)());
                Timestamp datetime = new Timestamp(System.currentTimeMillis());
                try{
                conn = cn.getConnection();
                pst = conn.prepareStatement(query);
                pst.setString (1, categoriy.getName());
                pst.setTimestamp (2, datetime);
                pst.setTimestamp (3, datetime);

                pst.execute();
                return true;
            
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error al registrar la Categoria" +e);
                return false;
            }
       }
    
     //Metodo para consultar info de la db categorias
     //listar categorias   
     public List listCategoriesQuery(String values){
                List<Categories> list_category = new ArrayList();
                String query = "SELECT * FROM category ";//CONSULTA Y ORDENADO
                String value = null;
                String query_search_category = "SELECT * FROM category WHERE name LIKE '%" + value + "%'";
               
                try{
                   conn = cn.getConnection();
                   if (value.equalsIgnoreCase("")){
                       pst = conn.prepareStatement(query);
                       rs = pst.executeQuery();
                    }else {
                       pst = conn.prepareStatement(query_search_category);
                       rs = pst.executeQuery();
                   }
                   
                while (rs.next()){
                    Categories category = new Categories();
                    category.setId(rs.getInt("id"));
                    category.setName (rs.getString("name"));
                    list_category.add(category);
                }   
                }catch(SQLException e){
                    JOptionPane.showMessageDialog (null, e.toString());
               
                }
                    return list_category;
                }
     
     //MODIFICAR CATEGORIA
      public boolean updateCategoriesQuery (Categories category){
                var query = "UPDATE category SET name=?, UPDATED=?"
                + "WHERE id = ?";
                        
                       
                //Timestamp datetime = new Timestamp(new Date().getTime)());
                Timestamp datetime = new Timestamp(System.currentTimeMillis());
                try{
                conn = cn.getConnection();
                pst = conn.prepareStatement(query);
                pst.setString (1, category.getName());
                pst.setTimestamp (2, datetime);
                 pst.setInt (3, category.getId());

                pst.execute();
                return true;
            
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error al modificar datos de Categorias" +e);
                return false;
            }
       }

      //ELIMINAR CLIENTE
       public boolean deleteCategoriessQuery(int id){
     String query = "DELETE FROM categories WHERE id = " + id;
     try{
         conn = cn.getConnection();
         pst = conn.prepareStatement(query);
         pst.execute();
         return true;
     }
 catch(SQLException e){
     JOptionPane.showMessageDialog(null, "No puede eliminar categorias que tenga relacion con otra tabla");
     return false;
     
       }
    }
}
