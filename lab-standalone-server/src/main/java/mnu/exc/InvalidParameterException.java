package mnu.exc;

public class InvalidParameterException extends Exception {
    private static final long serialVersionUID = -6647544772732631047L;
    public static InvalidParameterException DEFAULT_INSTANCE = new
            InvalidParameterException("Input param cannot be null or empty");

    public InvalidParameterException(String message) {
        super(message);
    }
}
