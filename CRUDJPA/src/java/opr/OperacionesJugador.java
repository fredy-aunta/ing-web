/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package opr;

import dao.Jugador;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.Conexion;

/**
 *
 * @author DELL
 */
public class OperacionesJugador implements OperacionesBasicasJugador{

    @Override
    public boolean insertar(Jugador dto) {
        try {
            Conexion con = new Conexion();
            EntityManager em = con.obtenerEM();
            em.getTransaction().begin();
            em.persist(dto);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean actualizar(Jugador dto) {
        try {
            Conexion con = new Conexion();
            EntityManager em = con.obtenerEM();
            em.getTransaction().begin();
            em.merge(dto);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean borrar(long pk_dto) {
        try {
            Conexion con = new Conexion();
            EntityManager em = con.obtenerEM();
            em.getTransaction().begin();
            em.remove(em.find(Jugador.class, pk_dto));
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(OperacionesJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Jugador consultar(long pk_dto) {
        try {
            Conexion con = new Conexion();
            EntityManager em = con.obtenerEM();
            return em.find(Jugador.class, pk_dto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Jugador> consultar() {
        try {
            Conexion con = new Conexion();
            EntityManager em = con.obtenerEM();
            Query q = em.createNamedQuery("Equipo.findAll");
            return q.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }
    
}
