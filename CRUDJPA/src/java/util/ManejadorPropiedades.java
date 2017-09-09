package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Sala 8
 */
public class ManejadorPropiedades {
    private static final Logger logger = LogManager.getLogger(ManejadorPropiedades.class);
    private static Properties prop ;
    static {
        try {
            prop = new Properties();
            prop.load(new FileInputStream("C:\\apl\\configuracion\\crudjpa.properties"));
        } catch (FileNotFoundException ex) {
            logger.error("Archivo de propiedades no existe", ex);
            prop = null;
        } catch (IOException ex) {
            logger.error("Archivo de propiedades no pudo ser leido", ex);
            prop = null;
        }
    }
    private ManejadorPropiedades(){
        
    }
    
    public static String obtenerValor(String llave)
    {
        if (prop!= null)
        {
            return prop.getProperty(llave);
        }
        return "";
    }
}
