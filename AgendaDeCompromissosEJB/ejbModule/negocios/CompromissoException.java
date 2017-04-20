package negocios;

import javax.ejb.EJBException;

/**
 *
 * @author Tanise Mello
 */

public class CompromissoException extends EJBException {
    
	public CompromissoException() {
    }
    
    public CompromissoException(String message) {
        super(message);
    }
    public CompromissoException(String message, Exception ex) {
        super(message, ex);
    }
}