package itmo.mnu.service.impl;

import itmo.mnu.dao.impl.EmployeeDaoImpl;
import itmo.mnu.model.Employee;
import itmo.mnu.service.EmployeeWebService;
import itmo.mnu.util.ConnectionUtil;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestScoped
@Path("/employees")
@Produces({MediaType.APPLICATION_JSON})
public class EmployeeWebServiceImpl implements EmployeeWebService {
    @Resource(lookup = "jdbc/MnuDB")
    private DataSource dataSource;

    @GET
    @Path("/findAll")
    @Override
    public List<Employee> findAll() {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(ConnectionUtil.getConnection(dataSource));
        return employeeDao.findAll();
    }

    @GET
    @Path("/findById")
    @Override
    public Employee findById(@QueryParam("id") int id) {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(ConnectionUtil.getConnection(dataSource));
        return employeeDao.findById(id);
    }

    @GET
    @Path("/findByName")
    @Override
    public List<Employee> findByName(@QueryParam("name") String name) {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(ConnectionUtil.getConnection(dataSource));
        return employeeDao.findByName(name);
    }

    @GET
    @Path("/findBySurname")
    @Override
    public List<Employee> findBySurname(@QueryParam("surname") String surname) {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(ConnectionUtil.getConnection(dataSource));
        return employeeDao.findBySurname(surname);
    }

    @GET
    @Path("/findByGender")
    @Override
    public List<Employee> findByGender(@QueryParam("gender") String gender) {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(ConnectionUtil.getConnection(dataSource));
        return employeeDao.findByGender(gender);
    }

    @GET
    @Path("/findByBirthday")
    @Override
    public List<Employee> findByBirthday(@QueryParam("birthday") String birthday) {
        try {
            EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(ConnectionUtil.getConnection(dataSource));
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedBirthday = formatter.parse(birthday);
            return employeeDao.findByBirthday(parsedBirthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GET
    @Path("/findBySalary")
    @Override
    public List<Employee> findBySalary(@QueryParam("salary") int salary) {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(ConnectionUtil.getConnection(dataSource));
        return employeeDao.findBySalary(salary);
    }

    @GET
    @Path("/findByFullName")
    @Override
    public List<Employee> findByFullName(@QueryParam("name") String name,
                                         @QueryParam("surname") String surname) {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(ConnectionUtil.getConnection(dataSource));
        return employeeDao.findByFullName(name, surname);
    }

    @GET
    @Path("/findByNameAndGender")
    @Override
    public List<Employee> findByNameAndGender(@QueryParam("name") String name,
                                              @QueryParam("gender") String gender) {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(ConnectionUtil.getConnection(dataSource));
        return employeeDao.findByNameAndGender(name, gender);
    }

    @GET
    @Path("/findByGenderAndBirthday")
    @Override
    public List<Employee> findByGenderAndBirthday(@QueryParam("gender") String gender,
                                                  @QueryParam("birthday") String birthday) {
        try {
            EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(ConnectionUtil.getConnection(dataSource));
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedBirthday = formatter.parse(birthday);
            return employeeDao.findByGenderAndBirthday(gender, parsedBirthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GET
    @Path("/findByGenderAndSalary")
    @Override
    public List<Employee> findByGenderAndSalary(@QueryParam("gender") String gender,
                                                @QueryParam("salary") int salary) {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(ConnectionUtil.getConnection(dataSource));
        return employeeDao.findByGenderAndSalary(gender, salary);
    }

    @GET
    @Path("/findByFullInfo")
    @Override
    public List<Employee> findByFullInfo(@QueryParam("name") String name,
                                         @QueryParam("surname") String surname,
                                         @QueryParam("gender") String gender,
                                         @QueryParam("birthday") String birthday) {
        try {
            EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(ConnectionUtil.getConnection(dataSource));
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedBirthday = formatter.parse(birthday);
            return employeeDao.findByFullInfo(name, surname, gender, parsedBirthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
