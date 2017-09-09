/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opr;

import dao.Jugador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.Conexion;
/**
 *
 * @author Sala 8
 */
public class OperacionesJugador implements OperacionesBasicasJugador {
    private static final Logger logger = LogManager.getLogger(OperacionesJugador.class);
    
    @Override
    public boolean insertar(Jugador dto) {
        Conexion c = new Conexion();
        Connection conex = c.conectarse();
        if (conex != null) {
            try {
                PreparedStatement ps = conex.prepareStatement(
                        "INSERT INTO public.jugador(\n" +
"	nombres, apellidos, fecha_nacimiento, cedula)\n" +
"	VALUES (?, ?, ?, ?)");
                ps.setString(1, dto.getNombres());
                ps.setString(2, dto.getApellidos());
                ps.setDate(3, dto.getFechaNacimientoSql());
                ps.setString(4, dto.getCedula());
                return (ps.executeUpdate() > 0);

            } catch (SQLException ex) {
                logger.error("", ex);
            } finally {
                c.desconectarse(conex);
            }
        }
        return false;
    }

    @Override
    public boolean actualizar(Jugador dto) {
        Conexion c = new Conexion();
        Connection conex = c.conectarse();
        if (conex != null) {
            try {
                PreparedStatement ps = conex.prepareStatement(
                        "UPDATE public.jugador\n" +
"	SET nombres=?, apellidos=?, fecha_nacimiento=?, cedula=?\n" +
"	WHERE id_jugador = ?");
                ps.setString(1, dto.getNombres());
                ps.setString(2, dto.getApellidos());
                ps.setDate(3, dto.getFechaNacimientoSql());
                ps.setString(4, dto.getCedula());
                ps.setInt(5, dto.getIdJugador());
                return (ps.executeUpdate() > 0);
            } catch (SQLException ex) {
                logger.error("", ex);
            } finally {
                c.desconectarse(conex);
            }
        }
        return false;
    }

    @Override
    public Jugador consultar(long pkdto) {
        List<Jugador> lista = consultarG(pkdto);
        if (lista != null && lista.size() > 0) {
            return lista.get(0);
        }
        return null;
    }

    @Override
    public List<Jugador> consultar() {
        return consultarG(-111111);
    }

    private List<Jugador> consultarG(long pkdto) {
        boolean cpk = true;
        List<Jugador> lista = new ArrayList<>();
        String sql = "SELECT * FROM public.jugador WHERE id_jugador = ?";
        if (pkdto == -111111) {
            cpk = false;
        }
        Conexion c = new Conexion();
        Connection conex = c.conectarse();
        if (conex != null) {
            try {

                PreparedStatement ps = conex.prepareStatement(
                        sql);
                if (cpk) {
                    ps.setLong(1, pkdto);
                }
                ResultSet rta = ps.executeQuery();
                
                while (rta.next()) {
                    Jugador dtoJ = new Jugador();
                    dtoJ.setIdJugador(rta.getInt("id_jugador"));
                    dtoJ.setNombres(rta.getString("nombres"));
                    dtoJ.setApellidos(rta.getString("apellidos"));
                    dtoJ.setFechaNacimiento(rta.getDate("fecha_nacimiento"));
                    dtoJ.setCedula(rta.getString("cedula"));
                    lista.add(dtoJ);
                }
                return lista;
            } catch (SQLException ex) {
                logger.error("", ex);
            } finally {
                c.desconectarse(conex);
            }

        }
        return lista;
    }

    @Override
    public boolean borrar(long pk_dto) {
        Conexion c = new Conexion();
        Connection conex = c.conectarse();
        if (conex != null) {
            try {
                PreparedStatement ps = conex.prepareStatement(
                        "DELETE FROM public.jugador WHERE id_jugador = ?");
                ps.setLong(1, pk_dto);
                return (ps.executeUpdate() > 0);

            } catch (SQLException ex) {
                logger.error("", ex);
            } finally {
                c.desconectarse(conex);
            }
        }
        return false;
    }
}
