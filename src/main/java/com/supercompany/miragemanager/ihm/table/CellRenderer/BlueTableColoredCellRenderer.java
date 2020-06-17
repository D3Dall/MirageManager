package com.supercompany.miragemanager.ihm.table.CellRenderer;

import java.awt.Color;
import javax.swing.JLabel;

/**
 * Structure une classe de Rendu de cellule de JTable qui alterne les couleurs de chaque ligne entre le bleu et blanche
 * @author FlorianDELSOL
 */
public class BlueTableColoredCellRenderer extends TablesColoredCellRenderer{
    
    /**
     * Instancie une nouvelle instance de classe BlueTableColoredCellRenderer
     */
    public BlueTableColoredCellRenderer() {
        super(new Color(235, 235, 255), new Color(255, 255, 255));
        this.setHorizontalAlignment(JLabel.CENTER);
    }
    
}
