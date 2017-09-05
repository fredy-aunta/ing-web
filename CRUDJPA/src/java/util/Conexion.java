/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author DELL
 */
public class Conexion {
    private static final String PERSISTENCE_UNIT_NAME = "CRUDJPAPU";
    private static EntityManagerFactory factory;

    public Conexion() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }
    
    public EntityManager obtenerEM() throws Exception{
        return factory.createEntityManager();
    }
}
