package mnu.dao;

import mnu.model.Employee;

import java.util.Date;
import java.util.List;

public interface EmployeeDao {

    public List<Employee> findAll();

    public Employee findById(int id);

    public List<Employee> findByName(String name);

    public List<Employee> findBySurname(String surname);

    public List<Employee> findByGender(String gender);

    public List<Employee> findByBirthday(Date birthday);

    public List<Employee> findBySalary(double salary);

    public List<Employee> findByFullName(String name, String surname);

    public List<Employee> findByNameAndGender(String name, String gender);

    public List<Employee> findByGenderAndBirthday(String gender, Date birthday);

    public List<Employee> findByGenderAndSalary(String gender, double salary);

    public List<Employee> findByFullInfo(String name, String surname, String gender, Date birthday);
}
