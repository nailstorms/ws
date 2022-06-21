package mnu.service;


import mnu.service.impl.*;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        System.out.println("Using standalone server config.");

        String urlString = "http://localhost:8080/EmployeeService?wsdl";
        URL url = new URL(urlString);
        
        EmployeeService service = new EmployeeService(url);
        EmployeeWebServiceImpl authenticatedService = service.getEmployeeWebServiceImplPort();

        Map<String, Object> requestContext = ((BindingProvider) authenticatedService).getRequestContext();
        requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, urlString);

        Map<String, List<String>> headers = new HashMap<>();
        headers.put("Username", Collections.singletonList("test"));
        headers.put("Password", Collections.singletonList("fail"));
        requestContext.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

        Employee employee;
        List<Employee> employeeList;
        int employeeId;
        boolean result;

        try {
            System.out.println("-----------------------------------------------");
            System.out.println("Fetching all employees.");
            employeeList = authenticatedService.findAll();
            printEmployees(employeeList);
        } catch (MySQLException sqlExc) {
            System.err.println("Error message: " + sqlExc.getFaultInfo().getMessage());
        }

        try {
            System.out.println("-----------------------------------------------");
            System.out.println("Fetching employee by id -1.");
            employee = authenticatedService.findById(-1);
            printEmployee(employee);
        } catch (InvalidIdException idExc) {
            System.err.println("Error message: " + idExc.getFaultInfo().getMessage());
        } catch (InvalidParameterException ipExc) {
            System.err.println("Error message: " + ipExc.getFaultInfo().getMessage());
        } catch (MySQLException sqlExc) {
            System.err.println("Error message: " + sqlExc.getFaultInfo().getMessage());
        }

        try {
            System.out.println("-----------------------------------------------");
            System.out.println("Fetching employee by inexistent name.");
            employeeList = authenticatedService.findByName(null);
            printEmployees(employeeList);
        } catch (InvalidParameterException ipExc) {
            System.err.println("Error message: " + ipExc.getFaultInfo().getMessage());
        } catch (MySQLException sqlExc) {
            System.err.println("Error message: " + sqlExc.getFaultInfo().getMessage());
        }

        try {
            System.out.println("-----------------------------------------------");
            System.out.println("Fetching employee by passing gibberish in birthday.");
            employeeList = authenticatedService.findByBirthday("jkdnfgrfjngkh");
            printEmployees(employeeList);
        } catch (InvalidParameterException ipExc) {
            System.err.println("Error message: " + ipExc.getFaultInfo().getMessage());
        } catch (MySQLException sqlExc) {
            System.err.println("Error message: " + sqlExc.getFaultInfo().getMessage());
        }

        try {
            System.out.println("-----------------------------------------------");
            System.out.println("Creating new employee.");
            employeeId = authenticatedService.create("Алексей", "Коков", "M", "1999-09-21", 5000);
            System.out.println("New employee's id - " + employeeId);

            System.out.println("-----------------------------------------------");
            System.out.printf("Fetching employee by id %d.\n", employeeId);
            employee = authenticatedService.findById(employeeId);
            printEmployee(employee);

            System.out.println("-----------------------------------------------");
            System.out.printf("Updating employee with id %d.\n", employeeId);
            result = authenticatedService.update(employeeId, "Евгения", "Иванова", "F", "1986-01-24", 100);
            System.out.println("Update result - " + result);

            System.out.println("-----------------------------------------------");
            System.out.printf("Fetching employee by id %d.\n", employeeId);
            employee = authenticatedService.findById(employeeId);
            printEmployee(employee);

            System.out.println("-----------------------------------------------");
            System.out.printf("Deleting employee with id %d.\n", employeeId);
            result = authenticatedService.delete(employeeId);
            System.out.println("Delete result - " + result);

            System.out.println("-----------------------------------------------");
            System.out.println("Fetching employees with full name 'Евгения Иванова'.");
            employeeList = authenticatedService.findByFullName("Евгения", "Иванова");
            printEmployees(employeeList);

            System.out.println("-----------------------------------------------");
            System.out.println("Fetching employee with id " + employeeId);
            employee = authenticatedService.findById(employeeId);
            printEmployee(employee);
        } catch (InvalidIdException idExc) {
            System.err.println("Error message: " + idExc.getFaultInfo().getMessage());
        } catch (InvalidParameterException ipExc) {
            System.err.println("Error message: " + ipExc.getFaultInfo().getMessage());
        } catch (MySQLException sqlExc) {
            System.err.println("Error message: " + sqlExc.getFaultInfo().getMessage());
        } catch (UnauthorizedUserException authExc) {
            System.err.println("Error message: " + authExc.getFaultInfo().getMessage());
        }
    }

    private static void printEmployees(List<Employee> employees) {
        System.out.printf("Total employees found: %d%n", employees.size());
        System.out.println();

        for (Employee employee : employees) {
            printEmployee(employee);
        }
    }

    private static void printEmployee(Employee employee) {
        System.out.println(
                    "id: " + employee.getId()
                + ", Name: " + employee.getName()
                + ", Surname: " + employee.getSurname()
                + ", Gender: " + employee.getGender()
                + ", Birthday: " + employee.getBirthday()
                + ", Salary: " + employee.getSalary()
        );
    }
}
