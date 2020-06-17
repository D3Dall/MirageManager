package com.supercompany.miragemanager.ihm.table.CellRenderer;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Structure une classe de Rendu de cellule de JTable qui alterne les couleurs de chaque ligne entre deux couleurs
 * @author FlorianDELSOL
 */
public class TablesColoredCellRenderer extends DefaultTableCellRenderer {
    /**
     * Première couleur
     */
    private Color colorOne;
    
    /**
     * Seconde couleur
     */
    private Color colorTwo;

    /**
     *  Instancie une nouvelle instance de classe TablesColoredCellRenderer
     * @param colorOne Première couleur
     * @param colorTwo Seconde couleur
     */
    public TablesColoredCellRenderer(Color colorOne, Color colorTwo) {
        this.colorOne = colorOne;
        this.colorTwo = colorTwo;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setBackground(row % 2 == 0 ? colorOne : colorTwo);
        return c;
    }
    
    
}
