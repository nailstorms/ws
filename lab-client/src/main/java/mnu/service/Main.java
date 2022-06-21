package mnu.service;

import com.sun.jersey.api.client.Client;
import mnu.service.exc.ParamException;
import mnu.service.model.Employee;
import mnu.service.request.RequestService;

import javax.naming.AuthenticationException;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Client client = Client.create();

        Employee employee;
        List<Employee> employeeList;
        int employeeId;
        boolean result;

        try {
            System.out.println("-----------------------------------------------");
            System.out.println("Fetching all employees.");
            employeeList = RequestService.findAllEmployees(client);
            printEmployees(employeeList);
        } catch (SQLException | ParamException | AuthenticationException e) {
            System.out.println("An exception appeared: " + e.getMessage() + "; " + e.getClass());
        }

        try {
            System.out.println("-----------------------------------------------");
            System.out.println("Fetching employee by id -1.");
            employee = RequestService.findEmployeeById(client, -1);
            printEmployee(employee);
        } catch (SQLException | ParamException | AuthenticationException e) {
            System.out.println("An exception appeared: " + e.getMessage() + "; " + e.getClass());
        }

        try {
            System.out.println("-----------------------------------------------");
            System.out.println("Fetching employee by inexistent name.");
            employeeList = RequestService.findEmployeesByName(client,null);
            printEmployees(employeeList);
        } catch (SQLException | ParamException | AuthenticationException e) {
            System.out.println("An exception appeared: " + e.getMessage() + "; " + e.getClass());
        }
        
        try {
            System.out.println("-----------------------------------------------");
            System.out.println("Fetching employee by passing gibberish in birthday.");
            employeeList = RequestService.findEmployeesByBirthday(client,"jkdnfgrfjngkh");
            printEmployees(employeeList);
        } catch (SQLException | ParamException | AuthenticationException e) {
            System.out.println("An exception appeared: " + e.getMessage() + "; " + e.getClass());
        }
        
        try {
            System.out.println("-----------------------------------------------");
            System.out.println("Creating new employee.");
            employeeId = RequestService.createEmployee(client, "Алексей", "Коков", "M", "1999-09-21", 5000);
            System.out.println("New employee's id - " + employeeId);

            System.out.println("-----------------------------------------------");
            System.out.printf("Fetching employee by id %d.\n", employeeId);
            employee = RequestService.findEmployeeById(client, employeeId);
            printEmployee(employee);

            System.out.println("-----------------------------------------------");
            System.out.printf("Updating employee with id %d.\n", employeeId);
            result = RequestService.updateEmployee(client, employeeId, "Евгения", "Иванова", "F", "1986-01-24", 100);
            System.out.println("Update result - " + result);

            System.out.println("-----------------------------------------------");
            System.out.printf("Fetching employee by id %d.\n", employeeId);
            employee = RequestService.findEmployeeById(client, employeeId);
            printEmployee(employee);

            System.out.println("-----------------------------------------------");
            System.out.printf("Deleting employee with id %d.\n", employeeId);
            result = RequestService.deleteEmployee(client, employeeId);
            System.out.println("Delete result - " + result);

            System.out.println("-----------------------------------------------");
            System.out.println("Fetching employees with full name 'Евгения Иванова'.");
            employeeList = RequestService.findEmployeesByFullName(client, "Евгения", "Иванова");
            printEmployees(employeeList);

            System.out.println("-----------------------------------------------");
            System.out.println("Fetching employee with id " + employeeId);
            employee = RequestService.findEmployeeById(client, employeeId);
            printEmployee(employee);
        } catch (SQLException | ParamException | AuthenticationException e) {
            System.out.println("An exception appeared: " + e.getMessage() + "; " + e.getClass());
        }

/*
        // ------------------ FOR J2EE --------------------
        try {
            System.out.println("-----------------------------------------------");
            System.out.println("Fetching all employees.");
            employeeList = RequestService.findAllEmployees(client);
            printEmployees(employeeList);

            System.out.println("-----------------------------------------------");
            System.out.println("Fetching employee by id 1.");
            employee = RequestService.findEmployeeById(client, 1);
            printEmployee(employee);

            System.out.println("-----------------------------------------------");
            System.out.println("Fetching all employees by name 'Иван'.");
            employeeList = RequestService.findEmployeesByName(client, "Иван");
            printEmployees(employeeList);

            System.out.println("-----------------------------------------------");
            System.out.println("Fetching all employees by surname 'Иванов'.");
            employeeList = RequestService.findEmployeesBySurname(client, "Иванов");
            printEmployees(employeeList);

            System.out.println("-----------------------------------------------");
            System.out.println("Fetching all employees by gender 'M'.");
            employeeList = RequestService.findEmployeesByGender(client, "M");
            printEmployees(employeeList);

            System.out.println("-----------------------------------------------");
            System.out.println("Fetching all employees by birthday '2000-12-31'.");
            employeeList = RequestService.findEmployeesByBirthday(client, "2000-12-31");
            printEmployees(employeeList);

            System.out.println("-----------------------------------------------");
            System.out.println("Fetching all employees by salary 5945.");
            employeeList = RequestService.findEmployeesBySalary(client, 5945);
            printEmployees(employeeList);

            System.out.println("-----------------------------------------------");
            System.out.println("Fetching all employees by full name 'Иван Иванов'.");
            employeeList = RequestService.findEmployeesByFullName(client, "Иван", "Иванов");
            printEmployees(employeeList);

            System.out.println("-----------------------------------------------");
            System.out.println("Fetching all employees by name 'Любовь' and gender 'F'.");
            employeeList = RequestService.findEmployeesByNameAndGender(client, "Любовь", "F");
            printEmployees(employeeList);

            System.out.println("-----------------------------------------------");
            System.out.println("Fetching all employees by gender 'F' and birthday '1958-04-03'.");
            employeeList = RequestService.findEmployeesByGenderAndBirthday(client, "F", "1958-04-03");
            printEmployees(employeeList);

            System.out.println("-----------------------------------------------");
            System.out.println("Fetching all employees by gender 'F' and salary 678.");
            employeeList = RequestService.findEmployeesByGenderAndSalary(client, "M", 678);
            printEmployees(employeeList);

            System.out.println("-----------------------------------------------");
            System.out.println("Fetching all employees by full info (except salary).");
            employeeList = RequestService.findEmployeesByFullInfo(client, "Маргарита", "Соболева", "F", "1946-03-08");
            printEmployees(employeeList);
        } catch (SQLException | ParamException e) {
            System.out.println("An exception appeared: " + e.getMessage() + "; " + e.getClass());
        }
*/
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