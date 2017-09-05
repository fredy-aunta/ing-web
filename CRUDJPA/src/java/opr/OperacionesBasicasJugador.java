package opr;

import dao.Jugador;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public interface OperacionesBasicasJugador {
    public boolean insertar(Jugador dto);
    public boolean actualizar(Jugador dto);
    public boolean borrar(long pk_dto);
    public Jugador consultar(long pk_dto);
    public List<Jugador> consultar();
}
