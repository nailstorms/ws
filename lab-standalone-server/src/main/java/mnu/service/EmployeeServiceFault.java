package mnu.service;

public class EmployeeServiceFault {
    private static final String DEFAULT_MESSAGE = "Invalid query argument (null or wrong type)";
    protected String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static EmployeeServiceFault defaultInstance() {
        EmployeeServiceFault fault = new EmployeeServiceFault();
        fault.message = DEFAULT_MESSAGE;
        return fault;
    }
}
