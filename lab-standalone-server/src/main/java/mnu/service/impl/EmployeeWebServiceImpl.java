package mnu.service.impl;

import mnu.dao.impl.EmployeeDaoImpl;
import mnu.exc.InvalidIdException;
import mnu.exc.InvalidParameterException;
import mnu.exc.MySQLException;
import mnu.exc.UnauthorizedUserException;
import mnu.model.BooleanValue;
import mnu.model.Employee;
import mnu.model.IntValue;
import mnu.service.EmployeeWebService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeWebServiceImpl implements EmployeeWebService {

    private final EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

    @GET
    @Path("/findAll")
    @Override
    public List<Employee> findAll() throws MySQLException {
        return employeeDao.findAll();
    }

    @GET
    @Path("/findById")
    @Override
    public Employee findById(@QueryParam("id") int id) throws InvalidIdException, InvalidParameterException, MySQLException {
        validateIntParam("id", id);
        return employeeDao.findById(id);
    }

    @GET
    @Path("/findByName")
    @Override
    public List<Employee> findByName(@QueryParam("name") String name) throws InvalidParameterException, MySQLException {
        validateStrParam("name", name);
        return employeeDao.findByName(name);
    }

    @GET
    @Path("/findBySurname")
    @Override
    public List<Employee> findBySurname(@QueryParam("surname") String surname) throws InvalidParameterException, MySQLException {
        validateStrParam("surname", surname);
        return employeeDao.findBySurname(surname);
    }

    @GET
    @Path("/findByGender")
    @Override
    public List<Employee> findByGender(@QueryParam("gender") String gender) throws InvalidParameterException, MySQLException {
        validateStrParam("gender", gender);
        return employeeDao.findByGender(gender);
    }

    @GET
    @Path("/findByBirthday")
    @Override
    public List<Employee> findByBirthday(@QueryParam("birthday") String birthday) throws InvalidParameterException, MySQLException {
        validateStrParam("birthday", birthday);
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedBirthday = formatter.parse(birthday);
            return employeeDao.findByBirthday(parsedBirthday);
        } catch (ParseException e) {
            String message = "Birthday has an incorrect format (should be 'yyyy-MM-dd')";
            throw new InvalidParameterException(message);
        }
    }

    @GET
    @Path("/findBySalary")
    @Override
    public List<Employee> findBySalary(@QueryParam("salary") int salary) throws InvalidIdException, InvalidParameterException, MySQLException {
        validateIntParam("salary", salary);
        return employeeDao.findBySalary(salary);
    }

    @GET
    @Path("/findByFullName")
    @Override
    public List<Employee> findByFullName(@QueryParam("name") String name,
                                         @QueryParam("surname") String surname) throws InvalidParameterException, MySQLException {
        validateStrParam("name", name);
        validateStrParam("surname", surname);
        return employeeDao.findByFullName(name, surname);
    }

    @GET
    @Path("/findByNameAndGender")
    @Override
    public List<Employee> findByNameAndGender(@QueryParam("name") String name,
                                              @QueryParam("gender") String gender) throws InvalidParameterException, MySQLException {
        validateStrParam("name", name);
        validateStrParam("gender", gender);
        return employeeDao.findByNameAndGender(name, gender);
    }

    @GET
    @Path("/findByGenderAndBirthday")
    @Override
    public List<Employee> findByGenderAndBirthday(@QueryParam("gender") String gender,
                                                  @QueryParam("birthday") String birthday) throws InvalidParameterException, MySQLException {
        validateStrParam("gender", gender);
        validateStrParam("birthday", birthday);
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedBirthday = formatter.parse(birthday);
            return employeeDao.findByGenderAndBirthday(gender, parsedBirthday);
        } catch (ParseException e) {
            String message = "Birthday has an incorrect format (should be 'yyyy-MM-dd')";
            throw new InvalidParameterException(message);
        }
    }

    @GET
    @Path("/findByGenderAndSalary")
    @Override
    public List<Employee> findByGenderAndSalary(@QueryParam("gender") String gender,
                                                @QueryParam("salary") int salary) throws InvalidIdException, InvalidParameterException, MySQLException {
        validateStrParam("gender", gender);
        validateIntParam("salary", salary);
        return employeeDao.findByGenderAndSalary(gender, salary);
    }

    @GET
    @Path("/findByFullInfo")
    @Override
    public List<Employee> findByFullInfo(@QueryParam("name") String name,
                                         @QueryParam("surname") String surname,
                                         @QueryParam("gender") String gender,
                                         @QueryParam("birthday") String birthday) throws InvalidParameterException, MySQLException {
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
            throw new InvalidParameterException(message);
        }
    }

    @POST
    @Path("/create")
    @Override
    public IntValue create(@QueryParam("name") String name,
                           @QueryParam("surname") String surname,
                           @QueryParam("gender") String gender,
                           @QueryParam("birthday") String birthday,
                           @QueryParam("salary") int salary,
                           @HeaderParam("Authorization") String auth) throws InvalidIdException, InvalidParameterException, MySQLException, UnauthorizedUserException, UnsupportedEncodingException {
        validateAuthentication(auth);
        validateStrParam("name", name);
        validateStrParam("surname", surname);
        validateStrParam("gender", gender);
        validateStrParam("birthday", birthday);
        validateIntParam("salary", salary);
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedBirthday = formatter.parse(birthday);
            return new IntValue(employeeDao.create(name, surname, gender, parsedBirthday, salary));
        } catch (ParseException e) {
            String message = "Birthday has an incorrect format (should be 'yyyy-MM-dd')";
            throw new InvalidParameterException(message);
        }
    }

    @POST
    @Path("/update")
    @Override
    public BooleanValue update(@QueryParam("id") int id,
                               @QueryParam("name") String name,
                               @QueryParam("surname") String surname,
                               @QueryParam("gender") String gender,
                               @QueryParam("birthday") String birthday,
                               @QueryParam("salary") int salary,
                               @HeaderParam("Authorization") String auth) throws InvalidIdException, InvalidParameterException, MySQLException, UnauthorizedUserException, UnsupportedEncodingException {
        validateAuthentication(auth);
        validateIntParam("id", id);
        validateStrParam("name", name);
        validateStrParam("surname", surname);
        validateStrParam("gender", gender);
        validateStrParam("birthday", birthday);
        validateIntParam("salary", salary);
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedBirthday = formatter.parse(birthday);
            return new BooleanValue(employeeDao.update(id, name, surname, gender, parsedBirthday, salary));
        } catch (ParseException e) {
            String message = "Birthday has an incorrect format (should be 'yyyy-MM-dd')";
            throw new InvalidParameterException(message);
        }
    }

    @DELETE
    @Path("/delete")
    @Override
    public BooleanValue delete(@QueryParam("id") int id,
                               @HeaderParam("Authorization") String auth) throws InvalidIdException, InvalidParameterException, MySQLException, UnauthorizedUserException, UnsupportedEncodingException {
        validateAuthentication(auth);
        validateIntParam("id", id);
        return new BooleanValue(employeeDao.delete(id));
    }

    private void validateStrParam(String paramName, String paramValue) throws InvalidParameterException {
        if (paramValue == null || paramValue.trim().isEmpty()) {
            String message = String.format("%s is not specified", paramName);
            throw new InvalidParameterException(message);
        }
    }

    private void validateIntParam(String paramName, int paramValue) throws InvalidIdException, InvalidParameterException {
        if (paramName.equals("id")) {
            if (paramValue < 1) {
                String message = String.format("%s cannot be less than 1", paramName);
                throw new InvalidIdException(message);
            }
        } else {
            if (paramValue < 1) {
                String message = String.format("%s cannot be less than 1", paramName);
                throw new InvalidParameterException(message);
            }
        }
    }

    private void validateAuthentication(String auth) throws UnauthorizedUserException, UnsupportedEncodingException {
        String[] tokens = (new String(Base64.getDecoder().decode(auth.split(" ")[1]), "UTF-8"))
                .split(":");

        if (!tokens[0].equals("test") || !tokens[1].equals("test")) {
            throw UnauthorizedUserException.DEFAULT_INSTANCE;
        }
    }
}
