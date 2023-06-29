
package Controlers;

import Models.Employees;
import Models.EmployeesDao;
import static Models.EmployeesDao.rol_user;
import Views.SystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EmployeesController implements ActionListener, MouseListener,KeyListener{
    
    private final Employees employee;
    private final EmployeesDao employeeDao;
    private final SystemView views;
    
    //ROL
    String rol = rol_user;
    //VARIABLE PARA INTERACTUAR CON LA TABLA
    DefaultTableModel model = new DefaultTableModel();
    
    
    //ESTE ES EL CONSTRUCTOR
    public EmployeesController(Employees employee, EmployeesDao employeeDao, SystemView views) {
        this.employee = employee;
        this.employeeDao = employeeDao;
        this.views = views;
        
        //BOTON DE REGISTRAR EMPLEADO
        //NO ME APARECIA PORQUE EL BOTON ESTABA EN PROVADO EN SYSTEMVIEW (CODE)
        this.views.btn_register_employee.addActionListener(this);
        //PONER LA TABLA EN ESCUCHA
        
        this.views.employees_table.addMouseListener(this);
        //ponemos en escucha el boton de buscar
        this.views.txt_search_employee.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== views.btn_register_employee){
           //VERIFICAR SI LOS CAMPOS ESTAN VACIOS
           if(views.txt_employee_id.getText().equals("")
               ||views.txt_employee_fullname.getText().equals("")
               ||views.txt_employee_username.getText().equals("")
               ||views.txt_employee_address.getText().equals("")
               ||views.txt_employee_telephone.getText().equals("")
               ||views.txt_employee_email.getText().equals("")
               ||views.cmb_rol.getSelectedItem().toString().equals("")
               ||String.valueOf(views.txt_employee_password.getPassword()).equals("")){
            
            JOptionPane.showMessageDialog(null, "Rellenar todos los campos");
        }else{
                employee.setId(Integer.parseInt(views.txt_employee_id.getText().trim()));
                employee.setFull_name(views.txt_employee_fullname.getText().trim());
                employee.setUsername(views.txt_employee_username.getText().trim());
                employee.setAddress(views.txt_employee_address.getText().trim());
                employee.setTelephone(views.txt_employee_telephone.getText().trim());
                employee.setEmail(views.txt_employee_email.getText().trim());
                employee.setPassword(String.valueOf(views.txt_employee_password.getPassword()));
                employee.setRol(views.cmb_rol.getSelectedItem().toString());
                
                //VERIFICAR SI TODO SALIO BIEN
                if(employeeDao.registerEmployeeQuery(employee)){
                    cleanTable();
                    JOptionPane.showMessageDialog(null,"Empleado registrado con exito");
                }else{
                    JOptionPane.showMessageDialog(null,"Error al registrar Empleado");
                }
                }     
        }
    }
    
    //Metodo para listar y buscar empleados
    
    public void ListAllEmployees(){
        if(rol.equals("Administrador")){
      List<Employees> list = employeeDao.listEmployeesQuery(views.txt_search_employee.getText());
            model = (DefaultTableModel) views.employees_table.getModel();
            
            Object[] row = new Object[7];
             for (int i = 0; i < list.size(); i++) {
                row[0] = list.get(i).getId_employee();//ubicacion de posisiones
                row[1] = list.get(i).getFull_name();
                row[2] = list.get(i).getUsername();
                row[3] = list.get(i).getAddress();
                row[4] = list.get(i).getTelephone();
                row[5] = list.get(i).getEmail();
                row[6] = list.get(i).getRol();
                model.addRow(row);
            }//llenado de las posiciones de la tabla
        }//fin de la condicion 
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()== views.employees_table){
            int row = views.employees_table.rowAtPoint(e.getPoint()); //Sirve para ver que en fila se hizo click
            
            views.txt_employee_id.setText(views.employees_table.getValueAt(row, 0).toString());
            views.txt_employee_fullname.setText(views.employees_table.getValueAt(row, 1).toString());
            views.txt_employee_username.setText(views.employees_table.getValueAt(row, 2).toString());
            views.txt_employee_address.setText(views.employees_table.getValueAt(row, 3).toString());
            views.txt_employee_telephone.setText(views.employees_table.getValueAt(row, 4).toString());
            views.txt_employee_email.setText(views.employees_table.getValueAt(row, 5).toString());
            views.cmb_rol.setSelectedItem(views.employees_table.getValueAt(row, 6).toString());
            
            //deshabilitar estos 3 botones
            views.txt_employee_id.setEditable(false);
            views.txt_employee_password.setEnabled(false);
            views.btn_register_employee.setEnabled(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    
    //Implementar para saber que esta escribiendo la persona en el buscador

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource()== views.txt_search_employee){
            cleanTable();
            listAllEmployees();
        }
    }
    public void cleanTable(){
        for(int i = 0; i<model.getRowCount(); i++){
            model.removeRow(i);
            i = i-1;
        }
    }

    private void listAllEmployees() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 }
    
 
