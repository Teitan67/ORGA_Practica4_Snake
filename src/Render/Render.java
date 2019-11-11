/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Render;

import java.awt.Component;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;


public class Render extends DefaultTableCellRenderer{
 
    @Override
    public Component getTableCellRendererComponent(JTable table,Object value,
            boolean isSelected, boolean hasFocus,int Row, int column){
        
        if(value instanceof JButton){
            JButton btn=(JButton) value;
            if(isSelected){
                btn.setBackground(table.getSelectionBackground());
                btn.setForeground(table.getSelectionForeground());
            }else{
             
               btn.setForeground(table.getForeground());
               btn.setBackground(UIManager.getColor("Button.background"));
            
            }
          return btn; 
        }
    return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, Row, column);
    
}
    
}