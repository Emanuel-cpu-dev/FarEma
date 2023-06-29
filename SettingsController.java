
package Controlers;

import Views.SystemView;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class SettingsController implements MouseListener{

    private final SystemView views;
    
    public SettingsController(SystemView views){
       this.views= views;
       this.views.jLabelProducts.addMouseListener(this);
       this.views.jLabelCategories.addMouseListener(this);
       this.views.jLabelEmployees.addMouseListener(this);
       this.views.jLabelPurchases.addMouseListener(this);
       this.views.jPanelReports.addMouseListener(this);
       this.views.jPanelSetings.addMouseListener(this);
       this.views.jLabelCustomers.addMouseListener(this);
       this.views.jLabelSuplayers.addMouseListener(this);
       
       
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //CREAR CONDICIONAL
        if(e.getSource()== views.jLabelCategories){
            views.jLabelCategories.setBackground(new Color (152,202,63));
            
        } else if (e.getSource()== views.jLabelCustomers){
            views.jLabelCustomers.setBackground (new Color (152,202,63));
            } else if (e.getSource()== views.jLabelEmployees){
            views.jLabelEmployees.setBackground (new Color (152,202,63));
            } else if (e.getSource()== views.jLabelProducts){
            views.jLabelProducts.setBackground (new Color (152,202,63));
            } else if (e.getSource()== views.jLabelPurchases){
            views.jLabelPurchases.setBackground (new Color (152,202,63));
            } else if (e.getSource()== views.jLabelReports){
            views.jLabelReports.setBackground (new Color (152,202,63));
            } else if (e.getSource()== views.jLabelSetings){
            views.jLabelSetings.setBackground (new Color (152,202,63));
            } else if (e.getSource()== views.jLabelSuplayers){
            views.jLabelSuplayers.setBackground (new Color (152,202,63));
            } else if (e.getSource()== views.jPanelCategories){
            views.jPanelCategories.setBackground (new Color (152,202,63));    
        
    }
    }
    @Override
    public void mouseExited(MouseEvent e) {
          //CREAR CONDICIONAL
        if(e.getSource()== views.jLabelCategories){
            views.jLabelCategories.setBackground(new Color (18,45,61));
            
        } else if (e.getSource()== views.jLabelCustomers){
            views.jLabelCustomers.setBackground (new Color (18,45,61));
            } else if (e.getSource()== views.jLabelEmployees){
            views.jLabelEmployees.setBackground (new Color (18,45,61));
            } else if (e.getSource()== views.jLabelProducts){
            views.jLabelProducts.setBackground (new Color (18,45,61));
            } else if (e.getSource()== views.jLabelPurchases){
            views.jLabelPurchases.setBackground (new Color (18,45,61));
            } else if (e.getSource()== views.jLabelReports){
            views.jLabelReports.setBackground (new Color (18,45,61));
            } else if (e.getSource()== views.jLabelSetings){
            views.jLabelSetings.setBackground (new Color (18,45,61));
            } else if (e.getSource()== views.jLabelSuplayers){
            views.jLabelSuplayers.setBackground (new Color (18,45,61));
            } else if (e.getSource()== views.jPanelCategories){
            views.jPanelCategories.setBackground (new Color (18,45,61));
    }
    
}
}