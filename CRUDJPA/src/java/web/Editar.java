/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import dao.Jugador;
import java.io.IOException;
import java.text.ParseException;
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
 * @author fredyauntabeitech
 */
@WebServlet(name = "Editar", urlPatterns = {"/jugador/edit"})
public class Editar extends HttpServlet {
    OperacionesJugador operacionesJugador = new OperacionesJugador();
     private final static Logger logger = LogManager.getLogger(Editar.class);
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
        String mensaje = "Ha ocurrido un error inesperado";
        try {
            String val = request.getParameter("id_jugador");
            int idJugador = Integer.parseInt(val);
            val = request.getParameter("nombres");
            String nombres = String.valueOf(val);
            val = request.getParameter("apellidos");
            String apellidos = String.valueOf(val);
            val = request.getParameter("fecha_nacimiento");
            String fechaNacimiento = String.valueOf(val);
            
            Jugador jugador = new Jugador(idJugador, nombres, apellidos, fechaNacimiento);
            boolean actualizado = operacionesJugador.actualizar(jugador);
            if (actualizado) {
                mensaje = "Jugador actualizado";
                logger.debug("Actualizado id: " + idJugador);
            } else {
                mensaje = "Jugador no actualizado";
                logger.error("No actualizado id: " + idJugador);
            }
        } catch (ParseException | NumberFormatException ex) {
            logger.error("",ex);
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
