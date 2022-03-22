package mnu.service.impl;

import mnu.dao.impl.EmployeeDaoImpl;
import mnu.model.Employee;
import mnu.service.EmployeeWebService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebService(serviceName = "EmployeeService")
public class EmployeeWebServiceImpl implements EmployeeWebService {

    private final EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

    @WebMethod(operationName = "findAll")
    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @WebMethod(operationName = "findById")
    @Override
    public Employee findById(@WebParam(name = "id") int id) {
        return employeeDao.findById(id);
    }

    @WebMethod(operationName = "findByName")
    @Override
    public List<Employee> findByName(@WebParam(name = "name") String name) {
        return employeeDao.findByName(name);
    }

    @WebMethod(operationName = "findBySurname")
    @Override
    public List<Employee> findBySurname(@WebParam(name = "surname") String surname) {
        return employeeDao.findBySurname(surname);
    }

    @WebMethod(operationName = "findByGender")
    @Override
    public List<Employee> findByGender(@WebParam(name = "gender") String gender) {
        return employeeDao.findByGender(gender);
    }

    @WebMethod(operationName = "findByBirthday")
    @Override
    public List<Employee> findByBirthday(@WebParam(name = "birthday") String birthday) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedBirthday = formatter.parse(birthday);
            return employeeDao.findByBirthday(parsedBirthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @WebMethod(operationName = "findBySalary")
    @Override
    public List<Employee> findBySalary(@WebParam(name = "salary") double salary) {
        return employeeDao.findBySalary(salary);
    }

    @WebMethod(operationName = "findByFullName")
    @Override
    public List<Employee> findByFullName(@WebParam(name = "name") String name,
                                         @WebParam(name = "surname") String surname) {
        return employeeDao.findByFullName(name, surname);
    }

    @WebMethod(operationName = "findByNameAndGender")
    @Override
    public List<Employee> findByNameAndGender(@WebParam(name = "name") String name,
                                              @WebParam(name = "gender") String gender) {
        return employeeDao.findByNameAndGender(name, gender);
    }

    @WebMethod(operationName = "findByGenderAndBirthday")
    @Override
    public List<Employee> findByGenderAndBirthday(@WebParam(name = "gender") String gender,
                                                  @WebParam(name = "birthday") String birthday) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedBirthday = formatter.parse(birthday);
            return employeeDao.findByGenderAndBirthday(gender, parsedBirthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @WebMethod(operationName = "findByGenderAndSalary")
    @Override
    public List<Employee> findByGenderAndSalary(@WebParam(name = "gender") String gender,
                                                @WebParam(name = "salary") double salary) {
        return employeeDao.findByGenderAndSalary(gender, salary);
    }

    @WebMethod(operationName = "findByFullInfo")
    @Override
    public List<Employee> findByFullInfo(@WebParam(name = "name") String name,
                                         @WebParam(name = "surname") String surname,
                                         @WebParam(name = "gender") String gender,
                                         @WebParam(name = "birthday") String birthday) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedBirthday = formatter.parse(birthday);
            return employeeDao.findByFullInfo(name, surname, gender, parsedBirthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
