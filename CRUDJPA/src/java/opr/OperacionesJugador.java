/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package opr;

import dao.Jugador;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.Conexion;

/**
 *
 * @author DELL
 */
public class OperacionesJugador implements OperacionesBasicasJugador{
    private final static Logger logger = LogManager.getLogger(OperacionesJugador.class);
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
            logger.error("", ex);
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
            logger.error("", ex);
        }
        return false;
    }

    @Override
    public boolean borrar(long pk_dto) {
        Jugador jugador = this.consultar(pk_dto);
        try {
            Conexion con = new Conexion();
            EntityManager em = con.obtenerEM();
            em.getTransaction().begin();
            em.remove(em.find(Jugador.class, jugador.getIdJugador()));
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            logger.error("", ex);
        }
        return false;
    }

    @Override
    public Jugador consultar(long pk_dto) {
        try {
            Conexion con = new Conexion();
            EntityManager em = con.obtenerEM();
            return em.find(Jugador.class, Math.toIntExact(pk_dto));
        } catch (ArithmeticException ex){
            logger.error("", ex);
        } catch (Exception ex) {
            logger.error("", ex);
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
            logger.error("", ex);
        }
        return new ArrayList<>();
    }
}
