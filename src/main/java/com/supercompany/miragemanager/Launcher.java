/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supercompany.miragemanager;

import com.supercompany.miragemanager.ihm.connexion.CanvasDeConnexion;
import com.supercompany.miragemanager.ihm.popup.ErrorPopUp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author FlorianDELSOL
 */
public class Launcher {
    
    private Launcher(){}
    
    public static void main(String[] args){
        try {
            CanvasDeConnexion canvas = new CanvasDeConnexion();
            canvas.setVisible(true);
        } catch (NamingException ex) {
            ErrorPopUp popUp = new ErrorPopUp("erreur : " + ex.getMessage());
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
