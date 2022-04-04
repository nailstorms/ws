package mnu.service;


import mnu.service.impl.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        System.out.println("Using standalone server config.");

        String urlString = "http://localhost:8080/EmployeeService?wsdl";
        URL url = new URL(urlString);
        EmployeeService service = new EmployeeService(url);

        Employee employee;
        List<Employee> employeeList;
        int employeeId;
        boolean result;

        try {
            System.out.println("-----------------------------------------------");
            System.out.println("Fetching all employees.");
            employeeList = service.getEmployeeWebServiceImplPort().findAll();
            printEmployees(employeeList);
        } catch (MySQLException sqlExc) {
            System.err.println("Error message: " + sqlExc.getFaultInfo().getMessage());
        }

        try {
            System.out.println("-----------------------------------------------");
            System.out.println("Fetching employee by id -1.");
            employee = service.getEmployeeWebServiceImplPort().findById(-1);
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
            employeeList = service.getEmployeeWebServiceImplPort().findByName(null);
            printEmployees(employeeList);
        } catch (InvalidParameterException ipExc) {
            System.err.println("Error message: " + ipExc.getFaultInfo().getMessage());
        } catch (MySQLException sqlExc) {
            System.err.println("Error message: " + sqlExc.getFaultInfo().getMessage());
        }

        try {
            System.out.println("-----------------------------------------------");
            System.out.println("Fetching employee by passing gibberish in birthday.");
            employeeList = service.getEmployeeWebServiceImplPort().findByBirthday("jkdnfgrfjngkh");
            printEmployees(employeeList);
        } catch (InvalidParameterException ipExc) {
            System.err.println("Error message: " + ipExc.getFaultInfo().getMessage());
        } catch (MySQLException sqlExc) {
            System.err.println("Error message: " + sqlExc.getFaultInfo().getMessage());
        }

        try {
            System.out.println("-----------------------------------------------");
            System.out.println("Creating new employee.");
            employeeId = service.getEmployeeWebServiceImplPort().create("Алексей", "Коков", "M", "1999-09-21", 5000);
            System.out.println("New employee's id - " + employeeId);

            System.out.println("-----------------------------------------------");
            System.out.printf("Fetching employee by id %d.\n", employeeId);
            employee = service.getEmployeeWebServiceImplPort().findById(employeeId);
            printEmployee(employee);

            System.out.println("-----------------------------------------------");
            System.out.printf("Updating employee with id %d.\n", employeeId);
            result = service.getEmployeeWebServiceImplPort().update(employeeId, "Евгения", "Иванова", "F", "1986-01-24", 100);
            System.out.println("Update result - " + result);

            System.out.println("-----------------------------------------------");
            System.out.printf("Fetching employee by id %d.\n", employeeId);
            employee = service.getEmployeeWebServiceImplPort().findById(employeeId);
            printEmployee(employee);

            System.out.println("-----------------------------------------------");
            System.out.printf("Deleting employee with id %d.\n", employeeId);
            result = service.getEmployeeWebServiceImplPort().delete(employeeId);
            System.out.println("Delete result - " + result);

            System.out.println("-----------------------------------------------");
            System.out.println("Fetching employees with full name 'Евгения Иванова'.");
            employeeList = service.getEmployeeWebServiceImplPort().findByFullName("Евгения", "Иванова");
            printEmployees(employeeList);

            System.out.println("-----------------------------------------------");
            System.out.println("Fetching employee with id " + employeeId);
            employee = service.getEmployeeWebServiceImplPort().findById(employeeId);
            printEmployee(employee);
        } catch (InvalidIdException idExc) {
            System.err.println("Error message: " + idExc.getFaultInfo().getMessage());
        } catch (InvalidParameterException ipExc) {
            System.err.println("Error message: " + ipExc.getFaultInfo().getMessage());
        } catch (MySQLException sqlExc) {
            System.err.println("Error message: " + sqlExc.getFaultInfo().getMessage());
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
