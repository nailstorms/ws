package mnu.exc;

public class MySQLException extends Exception {
    private static final long serialVersionUID = -6647544772732631047L;
    public static MySQLException DEFAULT_INSTANCE = new
            MySQLException("Error while fetching record");

    public MySQLException(String message) {
        super(message);
    }
}
