/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import dao.Jugador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import opr.OperacionesJugador;
import org.apache.logging.log4j.LogManager;
import util.SessionUtil;

/**
 *
 * @author fredyauntabeitech
 */
@WebServlet(name = "Eliminar", urlPatterns = {"/jugador/delete"})
public class Eliminar extends HttpServlet {
    private OperacionesJugador operacionesJugador = new OperacionesJugador();
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
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        String val = request.getParameter("id_jugador");
        Long idJugador = Long.parseLong(val);
        Jugador jugador = operacionesJugador.consultar(idJugador);
        LogManager.getLogger(Eliminar.class).debug("", jugador);
        if (jugador == null) {
            SessionUtil.setFalshMessage(session, "Jugador no existente");
            response.sendRedirect(request.getContextPath());
            return;
        }
        boolean borrado = operacionesJugador.borrar(idJugador);
        String mensaje;
        if (borrado) {
            mensaje = "Jugador eliminado";
            LogManager.getLogger(Eliminar.class).debug("Elminado id: " + idJugador);
        } else {
            mensaje = "Jugador no eliminado";
            LogManager.getLogger(Eliminar.class).error("No eliminado id: " + idJugador);
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
