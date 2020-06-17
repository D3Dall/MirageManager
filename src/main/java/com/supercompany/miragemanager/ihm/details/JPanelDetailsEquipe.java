package com.supercompany.miragemanager.ihm.details;

import com.supercompany.miragemanager.ihm.Canvas;
import com.supercompany.miragemanager.ihm.table.TableModel.MatriceCompetenceTableModel;
import com.supercompany.miragemanager.ihm.table.CellRenderer.MatriceTableColoredCellRenderer;
import fr.jaschavolp.m1.jee.mirageshared.equipe.DetailsEquipeVM;
import fr.jaschavolp.m1.jee.mirageshared.equipe.Matrice.MatriceCollaborateurVM;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Structure une JPanel personnalisé pour afficher toutes les informations sur une équipe
 * @author FlorianDELSOL
 */
public class JPanelDetailsEquipe extends javax.swing.JPanel {
    
    /**
     * Données de l'équipe
     */
    private DetailsEquipeVM data;

    /**
     * Créer une nouvelle instance de classe JPanelDetailsEquipe
     */
    public JPanelDetailsEquipe() {
        initComponents();
    }
    /**
     * Créer une nouvelle instance de classe JPanelDetailsEquipe
     * @param data Les données de l'équipe
     */
    public JPanelDetailsEquipe( DetailsEquipeVM data ) {
        this();
        this.data = data;
        this.actualize();
    }
    
    /**
     * Prépare l'affichage en fonction des données de l'équipe
     */
    private void actualize (){
        if(data != null){
            this.jLabelIdentifiantData.setText(data.getIdentifiant().toString());
        
            String skillTXT = "";
            List<String> teamSkills = getListOfSkills();
            if(teamSkills.isEmpty()){
                skillTXT = "Pas de compétences disponible dans cette équipe";
            }else{
                for (int i=0; i< teamSkills.size();i++){
                    skillTXT += teamSkills.get(i) + "  (" + getNumberOfCollaboratorWithThisSkill(teamSkills.get(i)) + ")" + (i!=teamSkills.size() - 1 ? ", " : "");
                }
            }
            this.jLabelCompetencesData.setText(skillTXT);
            
            //Préparation de la matrice de compétence
            JTable matrice = new JTable(new MatriceCompetenceTableModel(teamSkills, data.getCollaborateurs()));
            
            for(int i = 0; i<matrice.getColumnModel().getColumnCount(); i++){
                matrice.getColumnModel().getColumn(i).setCellRenderer(new MatriceTableColoredCellRenderer());
            }
            
            jPanelMatrice.add(new JScrollPane(matrice), BorderLayout.CENTER);

            
        }
    }
    
    /**
     * Calcul le combre de personne dans l'équipe disposant d'une compétence précise
     * @param competence Le nom de la compétence
     * @return Le nombre de personne disposant de cette compétence dans l'équipe
     */
    private int getNumberOfCollaboratorWithThisSkill(String competence){
        int numberOfCollaborators = 0;
        for (MatriceCollaborateurVM collaborateur : data.getCollaborateurs()){
            if(collaborateur.getCompetences().contains(competence)){
                numberOfCollaborators++;
            }
        }
        return numberOfCollaborators;
    }
    
    /**
     * Calcul la liste des compétences (sans duplicat) dont dispose dans l'équipe
     * @return Une liste des compétences dans l'équipe sans duplicat 
     */
    private List<String> getListOfSkills(){
      List<String> competences = new ArrayList<>();
      if (data.getCollaborateurs().isEmpty())  {
          return competences;
      }
      data.getCollaborateurs().stream().filter((collaborateur) -> (!collaborateur.getCompetences().isEmpty())).forEachOrdered((collaborateur) -> {
          collaborateur.getCompetences().stream().filter((competenceDuCollaborateur) -> (!competences.contains(competenceDuCollaborateur))).forEachOrdered((competenceDuCollaborateur) -> {
              competences.add(competenceDuCollaborateur);
          });
        });
      return competences;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelIdentifiant = new javax.swing.JPanel();
        jLabelIdentifiantTitre = new javax.swing.JLabel();
        jLabelIdentifiantData = new javax.swing.JLabel();
        jPanelCompetences = new javax.swing.JPanel();
        jLabelCompetencesTitre = new javax.swing.JLabel();
        jLabelCompetencesData = new javax.swing.JLabel();
        jPanelMatriceCompetences = new javax.swing.JPanel();
        jLabelMatriceCompetenceTitre = new javax.swing.JLabel();
        jPanelMatrice = new javax.swing.JPanel();
        jPanelAction = new javax.swing.JPanel();
        jButtonCreerDemandeDeCompetences = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));

        jPanelIdentifiant.setBackground(new java.awt.Color(250, 250, 255));

        jLabelIdentifiantTitre.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabelIdentifiantTitre.setText("Identifiant :");

        jLabelIdentifiantData.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabelIdentifiantData.setText("identifiant");

        javax.swing.GroupLayout jPanelIdentifiantLayout = new javax.swing.GroupLayout(jPanelIdentifiant);
        jPanelIdentifiant.setLayout(jPanelIdentifiantLayout);
        jPanelIdentifiantLayout.setHorizontalGroup(
            jPanelIdentifiantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIdentifiantLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelIdentifiantTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelIdentifiantData)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelIdentifiantLayout.setVerticalGroup(
            jPanelIdentifiantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIdentifiantLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelIdentifiantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIdentifiantTitre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelIdentifiantData))
                .addContainerGap())
        );

        jPanelCompetences.setBackground(new java.awt.Color(250, 250, 255));

        jLabelCompetencesTitre.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabelCompetencesTitre.setText("Compétences disponible :");

        jLabelCompetencesData.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabelCompetencesData.setText("compétence 1 (4 pers), compétence 2 (1 personne)");
        jLabelCompetencesData.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanelCompetencesLayout = new javax.swing.GroupLayout(jPanelCompetences);
        jPanelCompetences.setLayout(jPanelCompetencesLayout);
        jPanelCompetencesLayout.setHorizontalGroup(
            jPanelCompetencesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCompetencesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCompetencesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCompetencesLayout.createSequentialGroup()
                        .addComponent(jLabelCompetencesTitre)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabelCompetencesData, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelCompetencesLayout.setVerticalGroup(
            jPanelCompetencesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCompetencesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCompetencesTitre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCompetencesData)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelMatriceCompetences.setBackground(new java.awt.Color(250, 250, 255));

        jLabelMatriceCompetenceTitre.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabelMatriceCompetenceTitre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMatriceCompetenceTitre.setText("Matrice des compétences");
        jLabelMatriceCompetenceTitre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanelMatrice.setBackground(new java.awt.Color(250, 250, 255));
        jPanelMatrice.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanelMatriceCompetencesLayout = new javax.swing.GroupLayout(jPanelMatriceCompetences);
        jPanelMatriceCompetences.setLayout(jPanelMatriceCompetencesLayout);
        jPanelMatriceCompetencesLayout.setHorizontalGroup(
            jPanelMatriceCompetencesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelMatriceCompetenceTitre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelMatrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelMatriceCompetencesLayout.setVerticalGroup(
            jPanelMatriceCompetencesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMatriceCompetencesLayout.createSequentialGroup()
                .addComponent(jLabelMatriceCompetenceTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMatrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelAction.setBackground(new java.awt.Color(50, 50, 98));

        jButtonCreerDemandeDeCompetences.setBackground(new java.awt.Color(100, 100, 206));
        jButtonCreerDemandeDeCompetences.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonCreerDemandeDeCompetences.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCreerDemandeDeCompetences.setText("Faire une demande de compétences");
        jButtonCreerDemandeDeCompetences.setFocusable(false);
        jButtonCreerDemandeDeCompetences.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCreerDemandeDeCompetences.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonCreerDemandeDeCompetences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreerDemandeDeCompetencesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelActionLayout = new javax.swing.GroupLayout(jPanelAction);
        jPanelAction.setLayout(jPanelActionLayout);
        jPanelActionLayout.setHorizontalGroup(
            jPanelActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelActionLayout.createSequentialGroup()
                .addComponent(jButtonCreerDemandeDeCompetences, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelActionLayout.setVerticalGroup(
            jPanelActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonCreerDemandeDeCompetences)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelIdentifiant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelCompetences, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelAction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelMatriceCompetences, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelIdentifiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelCompetences, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelMatriceCompetences, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Traitement executé lors du clic sur le bouton de création d'une demande
     * @param evt 
     */
    private void jButtonCreerDemandeDeCompetencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreerDemandeDeCompetencesActionPerformed
        Canvas.getCanvasInstance().goToCreerDemandeCompetence();
    }//GEN-LAST:event_jButtonCreerDemandeDeCompetencesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreerDemandeDeCompetences;
    private javax.swing.JLabel jLabelCompetencesData;
    private javax.swing.JLabel jLabelCompetencesTitre;
    private javax.swing.JLabel jLabelIdentifiantData;
    private javax.swing.JLabel jLabelIdentifiantTitre;
    private javax.swing.JLabel jLabelMatriceCompetenceTitre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelAction;
    private javax.swing.JPanel jPanelCompetences;
    private javax.swing.JPanel jPanelIdentifiant;
    private javax.swing.JPanel jPanelMatrice;
    private javax.swing.JPanel jPanelMatriceCompetences;
    // End of variables declaration//GEN-END:variables
}
