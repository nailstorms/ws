package mnu.exc;

import mnu.service.EmployeeServiceFault;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "mnu.service.EmployeeServiceFault")
public class InvalidParameterException extends Exception {
    private static final long serialVersionUID = -6647544772732631047L;
    private final EmployeeServiceFault fault;

    public InvalidParameterException(String message, EmployeeServiceFault fault) {
        super(message);
        this.fault = fault;
    }

    public InvalidParameterException(String message, EmployeeServiceFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public EmployeeServiceFault getFaultInfo() {
        return fault;
    }
}
