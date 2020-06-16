/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supercompany.miragemanager.services;

import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import fr.jaschavolp.m1.jee.mirageshared.shared.services.ServicesManagerRemote;
import javax.naming.Context;

/**
 *
 * @author FlorianDELSOL
 */
public class RMIManagerClientService {
    private final static String URI = "fr.jaschavolp.m1.jee.mirageshared.shared.services.ServicesManagerRemote";
    
    private Context ctx;
    private ServicesManagerRemote remoteSvc;
    
    public RMIManagerClientService () throws NamingException{
        this.ctx = new InitialContext();
        remoteSvc = (ServicesManagerRemote) ctx.lookup(URI);
    }
    

    public ServicesManagerRemote getDabRemoteSvc() {
        return remoteSvc;
    }

    
}
