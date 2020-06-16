/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supercompany.miragemanager.ihm.table.CellRenderer;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Structure une classe de rendu de cellule pour la matrice de compétence
 * @author FlorianDELSOL
 */
public class MatriceTableColoredCellRenderer extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if( column != 0){
            this.setHorizontalAlignment(JLabel.CENTER);
        }
        if( column != 0 && ((String)value).equals("OK")){
            c.setBackground(Color.GREEN);
        }else{
            c.setBackground(Color.WHITE);
        }
        return c;
    }
}
