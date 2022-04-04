package mnu.service.impl;

import mnu.dao.impl.EmployeeDaoImpl;
import mnu.exc.InvalidIdException;
import mnu.exc.InvalidParameterException;
import mnu.exc.MySQLException;
import mnu.model.Employee;
import mnu.service.EmployeeServiceFault;
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
    public List<Employee> findAll() throws MySQLException {
        return employeeDao.findAll();
    }

    @WebMethod(operationName = "findById")
    @Override
    public Employee findById(@WebParam(name = "id") int id) throws InvalidIdException, InvalidParameterException, MySQLException {
        validateIntParam("id", id);
        return employeeDao.findById(id);
    }

    @WebMethod(operationName = "findByName")
    @Override
    public List<Employee> findByName(@WebParam(name = "name") String name) throws InvalidParameterException, MySQLException {
        validateStrParam("name", name);
        return employeeDao.findByName(name);
    }

    @WebMethod(operationName = "findBySurname")
    @Override
    public List<Employee> findBySurname(@WebParam(name = "surname") String surname) throws InvalidParameterException, MySQLException {
        validateStrParam("surname", surname);
        return employeeDao.findBySurname(surname);
    }

    @WebMethod(operationName = "findByGender")
    @Override
    public List<Employee> findByGender(@WebParam(name = "gender") String gender) throws InvalidParameterException, MySQLException {
        validateStrParam("gender", gender);
        return employeeDao.findByGender(gender);
    }

    @WebMethod(operationName = "findByBirthday")
    @Override
    public List<Employee> findByBirthday(@WebParam(name = "birthday") String birthday) throws InvalidParameterException, MySQLException {
        validateStrParam("birthday", birthday);
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedBirthday = formatter.parse(birthday);
            return employeeDao.findByBirthday(parsedBirthday);
        } catch (ParseException e) {
            String message = "Birthday has an incorrect format (should be 'yyyy-MM-dd')";
            EmployeeServiceFault fault = EmployeeServiceFault.defaultInstance();
            fault.setMessage(message);
            throw new InvalidParameterException(message, fault);
        }
    }

    @WebMethod(operationName = "findBySalary")
    @Override
    public List<Employee> findBySalary(@WebParam(name = "salary") int salary) throws InvalidIdException, InvalidParameterException, MySQLException {
        validateIntParam("salary", salary);
        return employeeDao.findBySalary(salary);
    }

    @WebMethod(operationName = "findByFullName")
    @Override
    public List<Employee> findByFullName(@WebParam(name = "name") String name,
                                         @WebParam(name = "surname") String surname) throws InvalidParameterException, MySQLException {
        validateStrParam("name", name);
        validateStrParam("surname", surname);
        return employeeDao.findByFullName(name, surname);
    }

    @WebMethod(operationName = "findByNameAndGender")
    @Override
    public List<Employee> findByNameAndGender(@WebParam(name = "name") String name,
                                              @WebParam(name = "gender") String gender) throws InvalidParameterException, MySQLException {
        validateStrParam("name", name);
        validateStrParam("gender", gender);
        return employeeDao.findByNameAndGender(name, gender);
    }

    @WebMethod(operationName = "findByGenderAndBirthday")
    @Override
    public List<Employee> findByGenderAndBirthday(@WebParam(name = "gender") String gender,
                                                  @WebParam(name = "birthday") String birthday) throws InvalidParameterException, MySQLException {
        validateStrParam("gender", gender);
        validateStrParam("birthday", birthday);
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedBirthday = formatter.parse(birthday);
            return employeeDao.findByGenderAndBirthday(gender, parsedBirthday);
        } catch (ParseException e) {
            String message = "Birthday has an incorrect format (should be 'yyyy-MM-dd')";
            EmployeeServiceFault fault = EmployeeServiceFault.defaultInstance();
            fault.setMessage(message);
            throw new InvalidParameterException(message, fault);
        }
    }

    @WebMethod(operationName = "findByGenderAndSalary")
    @Override
    public List<Employee> findByGenderAndSalary(@WebParam(name = "gender") String gender,
                                                @WebParam(name = "salary") int salary) throws InvalidIdException, InvalidParameterException, MySQLException {
        validateStrParam("gender", gender);
        validateIntParam("salary", salary);
        return employeeDao.findByGenderAndSalary(gender, salary);
    }

    @WebMethod(operationName = "findByFullInfo")
    @Override
    public List<Employee> findByFullInfo(@WebParam(name = "name") String name,
                                         @WebParam(name = "surname") String surname,
                                         @WebParam(name = "gender") String gender,
                                         @WebParam(name = "birthday") String birthday) throws InvalidParameterException, MySQLException {
        validateStrParam("name", name);
        validateStrParam("surname", surname);
        validateStrParam("gender", gender);
        validateStrParam("birthday", birthday);
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedBirthday = formatter.parse(birthday);
            return employeeDao.findByFullInfo(name, surname, gender, parsedBirthday);
        } catch (ParseException e) {
            String message = "Birthday has an incorrect format (should be 'yyyy-MM-dd')";
            EmployeeServiceFault fault = EmployeeServiceFault.defaultInstance();
            fault.setMessage(message);
            throw new InvalidParameterException(message, fault);
        }
    }

    @WebMethod(operationName = "create")
    @Override
    public int create(@WebParam(name = "name") String name,
                      @WebParam(name = "surname") String surname,
                      @WebParam(name = "gender") String gender,
                      @WebParam(name = "birthday") String birthday,
                      @WebParam(name = "salary") int salary) throws InvalidIdException, InvalidParameterException, MySQLException {
        validateStrParam("name", name);
        validateStrParam("surname", surname);
        validateStrParam("gender", gender);
        validateStrParam("birthday", birthday);
        validateIntParam("salary", salary);
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedBirthday = formatter.parse(birthday);
            return employeeDao.create(name, surname, gender, parsedBirthday, salary);
        } catch (ParseException e) {
            String message = "Birthday has an incorrect format (should be 'yyyy-MM-dd')";
            EmployeeServiceFault fault = EmployeeServiceFault.defaultInstance();
            fault.setMessage(message);
            throw new InvalidParameterException(message, fault);
        }
    }

    @WebMethod(operationName = "update")
    @Override
    public boolean update(@WebParam(name = "id") int id,
                          @WebParam(name = "name") String name,
                          @WebParam(name = "surname") String surname,
                          @WebParam(name = "gender") String gender,
                          @WebParam(name = "birthday") String birthday,
                          @WebParam(name = "salary") int salary) throws InvalidIdException, InvalidParameterException, MySQLException {
        validateIntParam("id", id);
        validateStrParam("name", name);
        validateStrParam("surname", surname);
        validateStrParam("gender", gender);
        validateStrParam("birthday", birthday);
        validateIntParam("salary", salary);
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedBirthday = formatter.parse(birthday);
            return employeeDao.update(id, name, surname, gender, parsedBirthday, salary);
        } catch (ParseException e) {
            String message = "Birthday has an incorrect format (should be 'yyyy-MM-dd')";
            EmployeeServiceFault fault = EmployeeServiceFault.defaultInstance();
            fault.setMessage(message);
            throw new InvalidParameterException(message, fault);
        }
    }

    @WebMethod(operationName = "delete")
    @Override
    public boolean delete(@WebParam(name = "id") int id) throws InvalidIdException, InvalidParameterException, MySQLException {
        validateIntParam("id", id);
        return employeeDao.delete(id);
    }

    private void validateStrParam(String paramName, String paramValue) throws InvalidParameterException {
        if (paramValue == null || paramValue.trim().isEmpty()) {
            String message = String.format("%s is not specified", paramName);
            EmployeeServiceFault fault = EmployeeServiceFault.defaultInstance();
            fault.setMessage(message);
            throw new InvalidParameterException(message, fault);
        }
    }

    private void validateIntParam(String paramName, int paramValue) throws InvalidIdException, InvalidParameterException {
        if (paramName.equals("id")) {
            if (paramValue < 1) {
                String message = String.format("%s cannot be less than 1", paramName);
                EmployeeServiceFault fault = EmployeeServiceFault.defaultInstance();
                fault.setMessage(message);
                throw new InvalidIdException(String.format(message, paramName), fault);
            }
        } else {
            if (paramValue < 1) {
                String message = String.format("%s cannot be less than 1", paramName);
                EmployeeServiceFault fault = EmployeeServiceFault.defaultInstance();
                fault.setMessage(message);
                throw new InvalidParameterException(message, fault);
            }
        }
    }
}
