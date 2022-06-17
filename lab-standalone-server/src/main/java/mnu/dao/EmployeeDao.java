package mnu.dao;

import mnu.exc.InvalidIdException;
import mnu.exc.MySQLException;
import mnu.model.Employee;

import java.util.Date;
import java.util.List;

public interface EmployeeDao {

    public List<Employee> findAll() throws MySQLException;

    public Employee findById(int id) throws InvalidIdException, MySQLException;

    public List<Employee> findByName(String name) throws MySQLException;

    public List<Employee> findBySurname(String surname) throws MySQLException;

    public List<Employee> findByGender(String gender) throws MySQLException;

    public List<Employee> findByBirthday(Date birthday) throws MySQLException;

    public List<Employee> findBySalary(int salary) throws MySQLException;

    public List<Employee> findByFullName(String name, String surname) throws MySQLException;

    public List<Employee> findByNameAndGender(String name, String gender) throws MySQLException;

    public List<Employee> findByGenderAndBirthday(String gender, Date birthday) throws MySQLException;

    public List<Employee> findByGenderAndSalary(String gender, int salary) throws MySQLException;

    public List<Employee> findByFullInfo(String name, String surname, String gender, Date birthday) throws MySQLException;

    public int create(String name, String surname, String gender, Date birthday, int salary) throws MySQLException;

    public boolean update(int id, String name, String surname, String gender, Date birthday, int salary) throws MySQLException;

    public boolean delete(int id) throws MySQLException;
}
