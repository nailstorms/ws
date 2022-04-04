package mnu;

import mnu.service.impl.EmployeeWebServiceImpl;

import javax.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args) {
        System.out.println("lol");
        System.setProperty("com.sun.xml.ws.fault.SOAPFaultBuilder.disableCaptureStackTrace", "false");
        String url = "http://0.0.0.0:8080/EmployeeService";
        Endpoint.publish(url, new EmployeeWebServiceImpl());
    }
}
