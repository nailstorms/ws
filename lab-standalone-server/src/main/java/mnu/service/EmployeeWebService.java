package mnu.service;

import mnu.exc.InvalidIdException;
import mnu.exc.InvalidParameterException;
import mnu.exc.MySQLException;
import mnu.exc.UnauthorizedUserException;
import mnu.model.BooleanValue;
import mnu.model.Employee;
import mnu.model.IntValue;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface EmployeeWebService {
    public List<Employee> findAll() throws MySQLException;

    public Employee findById(int id) throws InvalidIdException, InvalidParameterException, MySQLException;

    public List<Employee> findByName(String name) throws InvalidParameterException, MySQLException;

    public List<Employee> findBySurname(String surname) throws InvalidParameterException, MySQLException;

    public List<Employee> findByGender(String gender) throws InvalidParameterException, MySQLException;

    public List<Employee> findByBirthday(String birthday) throws InvalidParameterException, MySQLException;

    public List<Employee> findBySalary(int salary) throws InvalidIdException, InvalidParameterException, MySQLException;

    public List<Employee> findByFullName(String name, String surname) throws InvalidParameterException, MySQLException;

    public List<Employee> findByNameAndGender(String name, String gender) throws InvalidParameterException, MySQLException;

    public List<Employee> findByGenderAndBirthday(String gender, String birthday) throws InvalidParameterException, MySQLException;

    public List<Employee> findByGenderAndSalary(String gender, int salary) throws InvalidIdException, InvalidParameterException, MySQLException;

    public List<Employee> findByFullInfo(String name, String surname, String gender, String birthday) throws InvalidParameterException, MySQLException;

    public IntValue create(String name, String surname, String gender, String birthday, int salary, String auth) throws InvalidIdException, InvalidParameterException, MySQLException, UnauthorizedUserException, UnsupportedEncodingException;

    public BooleanValue update(int id, String name, String surname, String gender, String birthday, int salary, String auth) throws InvalidIdException, InvalidParameterException, MySQLException, UnauthorizedUserException, UnsupportedEncodingException;

    public BooleanValue delete(int id, String auth) throws InvalidIdException, InvalidParameterException, MySQLException, UnauthorizedUserException, UnsupportedEncodingException;
}
