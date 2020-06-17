package com.supercompany.miragemanager.services;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import fr.jaschavolp.m1.jee.mirageshared.shared.services.ServicesManagerRemote;
import javax.naming.Context;

/**
 * Structure un service RMI pour l'interaction entre le serveur et un client MIA-Manager
 * @author FlorianDELSOL
 */
public class RMIManagerClientService {
    private final static String URI = "fr.jaschavolp.m1.jee.mirageshared.shared.services.ServicesManagerRemote";
    
    private Context ctx;
    private ServicesManagerRemote remoteSvc;
    
    /**
     * Créer une nouvelle instance
     * @throws NamingException 
     */
    public RMIManagerClientService () throws NamingException{
        this.ctx = new InitialContext();
        remoteSvc = (ServicesManagerRemote) ctx.lookup(URI);
    }

    /**
     * @return le service permettant la communication avec le serveur
     */
    public ServicesManagerRemote getDabRemoteSvc() {
        return remoteSvc;
    }

    
}
