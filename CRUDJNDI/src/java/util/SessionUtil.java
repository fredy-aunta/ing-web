/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
public class SessionUtil {
    private static SessionUtil sessionUtil = null;
    
    protected SessionUtil() {
        
    }
    
    public static SessionUtil getInstance() {
        if (sessionUtil == null) {
            sessionUtil = new SessionUtil();
        }
        return sessionUtil;
    }
    
    public static String getFlashMessage(HttpSession session) {
        String flashMessage = (String) session.getAttribute("flashMessage");
        if (flashMessage != null && !flashMessage.equals("")) {
            session.removeAttribute("flashMessage");
            return flashMessage;
        }
        return null;
    }
    
    public static void setFalshMessage(HttpSession session, String flashMessage) {
        session.setAttribute("flashMessage", flashMessage);
    }
}
