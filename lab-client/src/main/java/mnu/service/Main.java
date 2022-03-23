package mnu.service;


import mnu.service.impl.Employee;
import mnu.service.impl.EmployeeService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        Scanner input = new Scanner(System.in);
        System.out.println("j2ee? (Y/N, default N)");
        String yesOrNo = input.nextLine().trim();
        String urlString;

        switch (yesOrNo) {
            case "Y":
                urlString = "http://localhost:8080/lab-j2ee-server-1.0-SNAPSHOT/EmployeeService?wsdl";
                System.out.println("Using J2EE application server config.");
                break;
            case "N":
            default:
                urlString = "http://localhost:8080/EmployeeService?wsdl";
                System.out.println("Using standalone server config.");
                break;
        }

        URL url = new URL(urlString);
        EmployeeService service = new EmployeeService(url);

        Employee employee;
        List<Employee> employeeList;

        System.out.println("-----------------------------------------------");
        System.out.println("Fetching all employees.");
        employeeList = service.getEmployeeWebServiceImplPort().findAll();
        printEmployees(employeeList);

        System.out.println("-----------------------------------------------");
        System.out.println("Fetching employee by id 1.");
        employee = service.getEmployeeWebServiceImplPort().findById(1);
        printEmployee(employee);

        System.out.println("-----------------------------------------------");
        System.out.println("Fetching all employees by name 'Иван'.");
        employeeList = service.getEmployeeWebServiceImplPort().findByName("Иван");
        printEmployees(employeeList);

        System.out.println("-----------------------------------------------");
        System.out.println("Fetching all employees by surname 'Иванов'.");
        employeeList = service.getEmployeeWebServiceImplPort().findBySurname("Иванов");
        printEmployees(employeeList);

        System.out.println("-----------------------------------------------");
        System.out.println("Fetching all employees by gender 'M'.");
        employeeList = service.getEmployeeWebServiceImplPort().findByGender("M");
        printEmployees(employeeList);

        System.out.println("-----------------------------------------------");
        System.out.println("Fetching all employees by birthday '2000-12-31'.");
        employeeList = service.getEmployeeWebServiceImplPort().findByBirthday("2000-12-31");
        printEmployees(employeeList);

        System.out.println("-----------------------------------------------");
        System.out.println("Fetching all employees by salary 5945.");
        employeeList = service.getEmployeeWebServiceImplPort().findBySalary(5945);
        printEmployees(employeeList);

        System.out.println("-----------------------------------------------");
        System.out.println("Fetching all employees by full name 'Иван Иванов'.");
        employeeList = service.getEmployeeWebServiceImplPort().findByFullName("Иван", "Иванов");
        printEmployees(employeeList);

        System.out.println("-----------------------------------------------");
        System.out.println("Fetching all employees by name 'Любовь' and gender 'F'.");
        employeeList = service.getEmployeeWebServiceImplPort().findByNameAndGender("Любовь", "F");
        printEmployees(employeeList);

        System.out.println("-----------------------------------------------");
        System.out.println("Fetching all employees by gender 'F' and birthday '1958-04-03'.");
        employeeList = service.getEmployeeWebServiceImplPort().findByGenderAndBirthday("F", "1958-04-03");
        printEmployees(employeeList);

        System.out.println("-----------------------------------------------");
        System.out.println("Fetching all employees by gender 'F' and salary 678.");
        employeeList = service.getEmployeeWebServiceImplPort().findByGenderAndSalary("M", 678);
        printEmployees(employeeList);

        System.out.println("-----------------------------------------------");
        System.out.println("Fetching all employees by full info (except salary).");
        employeeList = service.getEmployeeWebServiceImplPort().findByFullInfo("Маргарита", "Соболева", "F", "1946-03-08");
        printEmployees(employeeList);
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
