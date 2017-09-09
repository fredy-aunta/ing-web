/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class Jugador  {
    private static final String DEFAULT_FORMAT_DATE = "yyyy-mm-dd";
    private Integer idJugador;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String cedula;

    public Jugador() {
    }

    public Jugador(Integer idJugador) {
        this.idJugador = idJugador;
    }

    public Jugador(Integer idJugador, String nombres, String apellidos, Date fechaNacimiento) {
        this.idJugador = idJugador;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public Jugador(Integer idJugador, String nombres, String apellidos, String fechaNacimiento) throws ParseException {
        this.idJugador = idJugador;
        this.nombres = nombres;
        this.apellidos = apellidos;
        SimpleDateFormat parser = new SimpleDateFormat(DEFAULT_FORMAT_DATE);
        this.fechaNacimiento = parser.parse(fechaNacimiento);
    }

    public Jugador(Integer idJugador, String nombres, String apellidos, String fechaNacimiento, String cedula) throws ParseException {
        this.idJugador = idJugador;
        this.nombres = nombres;
        this.apellidos = apellidos;
        SimpleDateFormat parser = new SimpleDateFormat(DEFAULT_FORMAT_DATE);
        this.fechaNacimiento = parser.parse(fechaNacimiento);
        this.cedula = cedula;
    }
    public Integer getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Integer idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public java.sql.Date getFechaNacimientoSql() {
        return new java.sql.Date(fechaNacimiento.getTime());
    }
    
    public String getFechaNacimiento(String format) {
        SimpleDateFormat formateador = new SimpleDateFormat(format);
        return formateador.format(fechaNacimiento);
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "dao.Jugador[ idJugador=" + idJugador + " ]";
    }
    
}
