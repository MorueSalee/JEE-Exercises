package fr.eni.ecole.bll;

@SuppressWarnings("serial")
public class BllException extends Exception {
	public BllException() {
        super();
    }

	public BllException(String message) {
	    super(message);
	}
	
	public BllException(String message, Throwable exception) {
	    super(message, exception);
	}
	
	@Override
	public String getMessage() {
	    StringBuffer sb = new StringBuffer("BLL Layer - ");
	    sb.append(super.getMessage());
	
	    return sb.toString();
	}
}
