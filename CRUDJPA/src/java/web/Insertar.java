/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import dao.Jugador;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import opr.OperacionesJugador;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.SessionUtil;

/**
 *
 * @author DELL
 */
@WebServlet(name = "Insertar", urlPatterns = {"/jugador/insert"})
public class Insertar extends HttpServlet {
    private OperacionesJugador oj = new OperacionesJugador();
    private final static Logger logger = LogManager.getLogger(Insertar.class);
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String fechaNacimiento = request.getParameter("fecha_nacimiento");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimientoDate = null;
        try {
            fechaNacimientoDate = formatter.parse(fechaNacimiento);
        } catch (ParseException e) {
            logger.error("",e);
        }
        Jugador jugador = new Jugador();
        jugador.setNombres(nombres);
        jugador.setApellidos(apellidos);
        jugador.setFechaNacimiento(fechaNacimientoDate);
        
        boolean insertado = oj.insertar(jugador);
        String mensaje;
       
        if (insertado) {
            mensaje = "Jugador insertado";
            logger.debug("Insertado");
        } else {
            mensaje = "Jugador no insertado";
            logger.error("No insertado");
        }
        SessionUtil.setFalshMessage(session, mensaje);
        response.sendRedirect(request.getContextPath());
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
