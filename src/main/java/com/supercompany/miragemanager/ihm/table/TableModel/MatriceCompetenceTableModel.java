package com.supercompany.miragemanager.ihm.table.TableModel;

import fr.jaschavolp.m1.jee.mirageshared.equipe.Matrice.MatriceCollaborateurVM;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Strucure une classe de modèle de JTable pour la matrice de compétence
 * @author FlorianDELSOL
 */
public class MatriceCompetenceTableModel extends AbstractTableModel {
    
    private final List<String> competence;
    private final List<MatriceCollaborateurVM> data;

    /**
     * Créer une nouvelle instance de classe MatriceCompetenceTableModel
     * @param competence liste des compétences existantes
     * @param data La liste des collaborateurs et leurs compétences
     */
    public MatriceCompetenceTableModel(List<String> competence, List<MatriceCollaborateurVM> data) {
        super();
        this.competence = competence;
        this.data = data;
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return competence.size() + 1;
    }
    
    @Override
    public String getColumnName(int columnIndex){
        if(columnIndex == 0){
            return "Collaborateurs";
        }
        return competence.get(columnIndex - 1);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0){
            return data.get(rowIndex).getPrenom() + " " + data.get(rowIndex).getNom().toUpperCase();
        }else{
            if(data.get(rowIndex).getCompetences().contains(competence.get(columnIndex - 1))){
                return "OK";
            }else{
                return "";
            }
        }
    }
    
    @Override
    public Class getColumnClass(int columnIndex){
        return String.class;
    }
    
}
