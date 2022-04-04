package mnu.dao.impl;

import mnu.dao.EmployeeDao;
import mnu.exc.InvalidIdException;
import mnu.exc.InvalidParameterException;
import mnu.exc.MySQLException;
import mnu.model.Employee;
import mnu.service.EmployeeServiceFault;
import mnu.util.ConnectionUtil;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public List<Employee> findAll() throws MySQLException {
        return findListQuery("select * from employees");
    }

    @Override
    public Employee findById(int id) throws MySQLException {
        Employee employee = null;
        try (Connection connection = ConnectionUtil.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(String.format("select * from employees where id = %d", id));
            rs.next();

            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String age = rs.getString("gender");
            Date birthday = rs.getDate("birthday");
            int salary = rs.getInt("salary");

            employee = new Employee(id, name, surname, age, birthday, salary);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            String message = "Error while fetching employee";
            EmployeeServiceFault fault = EmployeeServiceFault.defaultInstance();
            fault.setMessage(message);
            throw new MySQLException(message, fault);
        }
        return employee;
    }

    @Override
    public List<Employee> findByName(String name) throws MySQLException {
        String query = String.format("select * from employees where name = '%s'", name);
        return findListQuery(query);
    }

    @Override
    public List<Employee> findBySurname(String surname) throws MySQLException {
        String query = String.format("select * from employees where surname = '%s'", surname);
        return findListQuery(query);
    }

    @Override
    public List<Employee> findByGender(String gender) throws MySQLException {
        String query = String.format("select * from employees where gender = '%s'", gender);
        return findListQuery(query);
    }

    @Override
    public List<Employee> findByBirthday(Date birthday) throws MySQLException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedBirthday = formatter.format(birthday);

        String query = String.format("select * from employees where birthday = '%s'", formattedBirthday);
        return findListQuery(query);
    }

    @Override
    public List<Employee> findBySalary(int salary) throws MySQLException {
        String query = String.format("select * from employees where salary = %d", salary);
        return findListQuery(query);
    }

    @Override
    public List<Employee> findByFullName(String name, String surname) throws MySQLException {
        String query = String.format("select * from employees where name = '%s' and surname = '%s'",
                name, surname);
        return findListQuery(query);
    }

    @Override
    public List<Employee> findByNameAndGender(String name, String gender) throws MySQLException {
        String query = String.format("select * from employees where name = '%s' and gender = '%s'",
                name, gender);
        return findListQuery(query);
    }

    @Override
    public List<Employee> findByGenderAndBirthday(String gender, Date birthday) throws MySQLException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedBirthday = formatter.format(birthday);

        String query = String.format("select * from employees where gender = '%s' and birthday = '%s'",
                gender, formattedBirthday);
        return findListQuery(query);
    }

    @Override
    public List<Employee> findByGenderAndSalary(String gender, int salary) throws MySQLException {
        String query = String.format("select * from employees where gender = '%s' and salary = %d",
                gender, salary);
        return findListQuery(query);
    }

    @Override
    public List<Employee> findByFullInfo(String name, String surname, String gender, Date birthday) throws MySQLException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedBirthday = formatter.format(birthday);

        String query = String.format("select * from employees where name = '%s' and surname = '%s' and gender = '%s' and birthday = '%s'",
                name, surname, gender, formattedBirthday);
        return findListQuery(query);
    }

    @Override
    public int create(String name, String surname, String gender, Date birthday, int salary) throws MySQLException {
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(
                    "insert into employees (name, surname, gender, birthday, salary) values (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String formattedBirthday = formatter.format(birthday);

            stmt.setString(1, name);
            stmt.setString(2, surname);
            stmt.setString(3, gender);
            stmt.setString(4, formattedBirthday);
            stmt.setInt(5, salary);

            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            String message = "Error while creating employee";
            EmployeeServiceFault fault = EmployeeServiceFault.defaultInstance();
            fault.setMessage(message);
            throw new MySQLException(message, fault);
        }
        return -200;
    }

    @Override
    public boolean update(int id, String name, String surname, String gender, Date birthday, int salary) throws MySQLException {
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(
                    "update employees set name=?, surname=?, gender=?, birthday=?, salary=? where id = ?");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String formattedBirthday = formatter.format(birthday);

            stmt.setString(1, name);
            stmt.setString(2, surname);
            stmt.setString(3, gender);
            stmt.setString(4, formattedBirthday);
            stmt.setInt(5, salary);
            stmt.setInt(6, id);

            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            String message = "Error while updating employee";
            EmployeeServiceFault fault = EmployeeServiceFault.defaultInstance();
            fault.setMessage(message);
            throw new MySQLException(message, fault);
        }
    }

    @Override
    public boolean delete(int id) throws MySQLException {
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(
                    "delete from employees where id = ?");
            stmt.setInt(1, id);

            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            String message = "Error while deleting employee";
            EmployeeServiceFault fault = EmployeeServiceFault.defaultInstance();
            fault.setMessage(message);
            throw new MySQLException(message, fault);
        }
    }

    private List<Employee> findListQuery(String query) throws MySQLException {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String age = rs.getString("gender");
                Date birthday = rs.getDate("birthday");
                int salary = rs.getInt("salary");

                Employee employee = new Employee(id, name, surname, age, birthday, salary);
                employees.add(employee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            String message = "Error while fetching employee";
            EmployeeServiceFault fault = EmployeeServiceFault.defaultInstance();
            fault.setMessage(message);
            throw new MySQLException(message, fault);
        }
        return employees;
    }
}
