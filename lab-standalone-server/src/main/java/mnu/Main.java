package mnu;

import mnu.service.impl.EmployeeWebServiceImpl;

import javax.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args) {
        String url = "http://0.0.0.0:8081/EmployeeServiceNew2";
        Endpoint.publish(url, new EmployeeWebServiceImpl());
    }
}
