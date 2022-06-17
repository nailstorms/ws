package mnu.exc;

public class InvalidIdException extends Exception {
    private static final long serialVersionUID = -6647544772732631047L;

    public static InvalidIdException DEFAULT_INSTANCE = new
            InvalidIdException("Input id cannot be less than 1 or NaN");

    public InvalidIdException(String message) {
        super(message);
    }
}
