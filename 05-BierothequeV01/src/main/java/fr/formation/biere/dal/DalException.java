package fr.formation.biere.dal;

public class DalException extends Exception {
	public DalException() {
	        super();
	    }

    public DalException(String message) {
        super(message);
    }

    public DalException(String message, Throwable exception) {
        super(message, exception);
    }

    @Override
    public String getMessage() {
        StringBuffer sb = new StringBuffer("DAL Layer - ");
        sb.append(super.getMessage());

        return sb.toString();
    }

}
