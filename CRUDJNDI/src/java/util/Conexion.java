package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Sala 8
 */
public class Conexion {
    private static final Logger logger = LogManager.getLogger(Conexion.class);
    public Connection conectarse()
    {
        String jndi = ManejadorPropiedades.obtenerValor("jndi");
        if (jndi != null)
        {
            try {
               Context initialContext = new InitialContext();
               DataSource data =  (DataSource) initialContext.lookup(jndi);
               return data.getConnection();
               
            } catch (NamingException | SQLException ex) {
                logger.error("", ex);
            }
        }
        return null;
    }
    public void desconectarse(Connection c)
    {
        if (c != null)
        {
            try {
                c.close();
            } catch (SQLException ex) {
                logger.error("", ex);
            }
        }
    }
    public void desconectarse(Connection c, PreparedStatement ps)
    {
        if (ps != null)
        {
            try {
                ps.close();
                desconectarse(c);
            } catch (SQLException ex) {
                logger.error("", ex);
            }
        }
        
    }
    public void desconectarse(Connection c, PreparedStatement ps, ResultSet rs)
    {
        if (rs != null)
        {
            try {
                rs.close();
                desconectarse(c, ps);
            } catch (SQLException ex) {
                logger.error("", ex);
            }
        }
        
    }
}
