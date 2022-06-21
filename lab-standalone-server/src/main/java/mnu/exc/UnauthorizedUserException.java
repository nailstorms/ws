package mnu.exc;

public class UnauthorizedUserException extends Exception {
    private static final long serialVersionUID = -6647544772732631047L;

    public static UnauthorizedUserException DEFAULT_INSTANCE = new
            UnauthorizedUserException("Invalid credentials");

    public UnauthorizedUserException(String message) {
        super(message);
    }
}
