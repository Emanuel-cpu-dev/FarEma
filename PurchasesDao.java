/*
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PurchasesDao {
       //instanciar la conexion
    //van los metodos que permite interactuar java con mysql
    connectionMySQL cn = new connectionMySQL(); // aca estan los metodos para conectarse a la db
    Connection conn;
    PreparedStatement pst;           //sirve para las consultas
    ResultSet rs;                   // para los datos de las conosultas
    
    //REGISTRAR COMPRA
    public boolean registerPurchasesQuery(int supplier_id, int employee_id, double total){
        String query = "INSERT INTO purchases (supplier_id , employee_id, total, created, VALUES (?,?,?,?)";
        Timestamp datetime = new Timestamp(new Date().getTime());
        
        try{
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setInt(1, employee_id);
            pst.setInt(2,employee_id);
            pst.setDouble(3, total);
            pst.execute();
            
            return true;
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Err al insertar la compra");
           return false;
        }
    }
    
    //REGISTRAR DETALLES DE LA COMPRA
    public boolean registerPurchaseDetailQuery(int purchase_id, double purchase_price, int purchase_amount,
            double purchase_subtotal, int product_id){
        
        String query = "INSERT INTO purchase_details (purchase_id, purchase_price, purchase_amount,"
                + "purchase_subtotal, purchase_date, purchase_id) VALUES(?,?,?,?,?,?)";
                
                Timestamp datetime = new Timestamp(new Date().getTime());
        
        try{
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setInt(1, purchase_id);
            pst.setDouble(2,purchase_price);
            pst.setInt(3, purchase_amount);
            pst.setDouble(4, purchase_subtotal);
            pst.setTimestamp(5, datetime);
            pst.setInt(6, product_id);
            pst.execute();
       
            return true;
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Err al registrar detalles de compra");
           return false;
        }
    }
    
    //METODO PARA OBTENER ID DE LA COMPRA
    public int purchasesId(){
        int id = 0;
        String query = "SELECT MAX (id) AS id FROM purchases";
        try{
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            if(rs.next()){
                id = rs.getInt ("id");
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
            return id;
        }
    }
}

*/