package mnu.dao.impl;

import mnu.dao.EmployeeDao;
import mnu.model.Employee;
import mnu.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public List<Employee> findAll() {
        return findListQuery("select * from employees");
    }

    @Override
    public Employee findById(int id) {
        Employee employee = null;
        try (Connection connection = ConnectionUtil.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(String.format("select * from employees where id = %d", id));
            rs.next();

            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String age = rs.getString("gender");
            Date birthday = rs.getDate("birthday");
            double salary = rs.getDouble("salary");

            employee = new Employee(name, surname, age, birthday, salary);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employee;
    }

    @Override
    public List<Employee> findByName(String name) {
        String query = String.format("select * from employees where name = '%s'", name);
        return findListQuery(query);
    }

    @Override
    public List<Employee> findBySurname(String surname) {
        String query = String.format("select * from employees where surname = '%s'", surname);
        return findListQuery(query);
    }

    @Override
    public List<Employee> findByGender(String gender) {
        String query = String.format("select * from employees where gender = '%s'", gender);
        return findListQuery(query);
    }

    @Override
    public List<Employee> findByBirthday(Date birthday) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedBirthday = formatter.format(birthday);

        String query = String.format("select * from employees where birthday = '%s'", formattedBirthday);
        return findListQuery(query);
    }

    @Override
    public List<Employee> findBySalary(double salary) {
        String query = String.format("select * from employees where name = %f", salary);
        return findListQuery(query);
    }

    @Override
    public List<Employee> findByFullName(String name, String surname) {
        String query = String.format("select * from employees where name = '%s' and surname = '%s'",
                name, surname);
        return findListQuery(query);
    }

    @Override
    public List<Employee> findByNameAndGender(String name, String gender) {
        String query = String.format("select * from employees where name = '%s' and gender = '%s'",
                name, gender);
        return findListQuery(query);
    }

    @Override
    public List<Employee> findByGenderAndBirthday(String gender, Date birthday) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedBirthday = formatter.format(birthday);

        String query = String.format("select * from employees where gender = '%s' and birthday = '%s'",
                gender, formattedBirthday);
        return findListQuery(query);
    }

    @Override
    public List<Employee> findByGenderAndSalary(String gender, double salary) {
        String query = String.format("select * from employees where gender = '%s' and salary = %f",
                gender, salary);
        return findListQuery(query);
    }

    @Override
    public List<Employee> findByFullInfo(String name, String surname, String gender, Date birthday) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedBirthday = formatter.format(birthday);

        String query = String.format("select * from employees where name = '%s' and surname = '%s' and gender = '%s' and birthday = '%s'",
                name, surname, gender, formattedBirthday);
        return findListQuery(query);
    }

    private List<Employee> findListQuery(String query) {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String age = rs.getString("gender");
                Date birthday = rs.getDate("birthday");
                double salary = rs.getDouble("salary");

                Employee employee = new Employee(name, surname, age, birthday, salary);
                employees.add(employee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employees;
    }
}
