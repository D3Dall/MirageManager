/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supercompany.miragemanager.ihm.table.TableModel;

import fr.jaschavolp.m1.jee.mirageshared.dmdcompetences.DmdCompetencesVM;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Structure une classe de modèle de JTable pour les demandes de compétences
 * @author FlorianDELSOL
 */
public class DmdCompetenceTableModel extends AbstractTableModel{
    
    private final String[] entete = {"Identifiant", "Statut", "Compétences demandées"};
    private final List<DmdCompetencesVM> data;

    /**
     * Créer une nouvelle instance de classe DmdCompetenceTableModel
     * @param data la liste des demandes de coméptences
     */
    public DmdCompetenceTableModel(List<DmdCompetencesVM> data) {
        super();
        this.data = data;
    }
    

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return entete.length;
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return entete[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : 
                return data.get(rowIndex).getIdentifiant();
            case 1 : 
                return data.get(rowIndex).getNomFichePoste() != null ? "En cours de recrutement" :  data.get(rowIndex).getValidationCODIR() != null && data.get(rowIndex).getValidationCODIR() ? "Validé par le codir" : "En attente de traitement par le CODIR";
            case 2 :
                String txt = "";
                for(int i = 0; i<data.get(rowIndex).getCompetence().size(); i++){
                    txt += data.get(rowIndex).getCompetence().get(i) + (i<data.get(rowIndex).getCompetence().size()-1 ? ", " : "");
                }
                return txt;
            default: return "Problems";
        }
    }
    
}
