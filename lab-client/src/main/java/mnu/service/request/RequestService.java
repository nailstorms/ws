package mnu.service.request;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import mnu.service.exc.ParamException;
import mnu.service.model.BooleanValue;
import mnu.service.model.Employee;
import mnu.service.model.IntValue;

import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

public class RequestService {
    //private static final String URL = "http://localhost:8080/rest/employees";
    private static final String URL = "http://localhost:8080/j2ee-rest/rest/employees";

    public static List<Employee> findAllEmployees(Client client) throws SQLException, ParamException {
        WebResource webResource = client.resource(URL + "/findAll");
        ClientResponse response = executeGet(webResource, "");
        GenericType<List<Employee>> type = new GenericType<List<Employee>>() {
        };
        return response.getEntity(type);
    }

    public static Employee findEmployeeById(Client client, int id) throws SQLException, ParamException {
        WebResource webResource = client.resource(URL + "/findById");
        webResource = webResource.queryParam("id", String.valueOf(id));
        ClientResponse response = executeGet(webResource, "Param id is incorrect");
        GenericType<Employee> type = new GenericType<Employee>() {
        };
        return response.getEntity(type);
    }

    public static List<Employee> findEmployeesByName(Client client, String name) throws SQLException, ParamException {
        WebResource webResource = client.resource(URL + "/findByName");
        if (name != null) {
            webResource = webResource.queryParam("name", name);
        }
        ClientResponse response = executeGet(webResource, "Param name is incorrect");
        GenericType<List<Employee>> type = new GenericType<List<Employee>>() {
        };
        return response.getEntity(type);
    }

    public static List<Employee> findEmployeesBySurname(Client client, String surname) throws SQLException, ParamException {
        WebResource webResource = client.resource(URL + "/findBySurname");
        if (surname != null) {
            webResource = webResource.queryParam("surname", surname);
        }
        ClientResponse response = executeGet(webResource, "Param surname is incorrect");
        GenericType<List<Employee>> type = new GenericType<List<Employee>>() {
        };
        return response.getEntity(type);
    }

    public static List<Employee> findEmployeesByGender(Client client, String gender) throws SQLException, ParamException {
        WebResource webResource = client.resource(URL + "/findByGender");
        if (gender != null) {
            webResource = webResource.queryParam("gender", gender);
        }
        ClientResponse response = executeGet(webResource, "Param gender is incorrect");
        GenericType<List<Employee>> type = new GenericType<List<Employee>>() {
        };
        return response.getEntity(type);
    }

    public static List<Employee> findEmployeesByBirthday(Client client, String birthday) throws SQLException, ParamException {
        WebResource webResource = client.resource(URL + "/findByBirthday");
        if (birthday != null) {
            webResource = webResource.queryParam("birthday", birthday);
        }
        ClientResponse response = executeGet(webResource, "Param birthday is incorrect");
        GenericType<List<Employee>> type = new GenericType<List<Employee>>() {
        };
        return response.getEntity(type);
    }

    public static List<Employee> findEmployeesBySalary(Client client, int salary) throws SQLException, ParamException {
        WebResource webResource = client.resource(URL + "/findBySalary");
        webResource = webResource.queryParam("salary", String.valueOf(salary));
        ClientResponse response = executeGet(webResource, "Param salary is incorrect");
        GenericType<List<Employee>> type = new GenericType<List<Employee>>() {
        };
        return response.getEntity(type);
    }

    public static List<Employee> findEmployeesByFullName(Client client, String name, String surname) throws SQLException, ParamException {
        WebResource webResource = client.resource(URL + "/findByFullName");
        if (surname != null) {
            webResource = webResource.queryParam("name", name).queryParam("surname", surname);
        }
        ClientResponse response = executeGet(webResource, "Param name or surname is incorrect");
        GenericType<List<Employee>> type = new GenericType<List<Employee>>() {
        };
        return response.getEntity(type);
    }

    public static List<Employee> findEmployeesByNameAndGender(Client client, String name, String gender) throws SQLException, ParamException {
        WebResource webResource = client.resource(URL + "/findByNameAndGender");
        if (gender != null) {
            webResource = webResource.queryParam("name", name).queryParam("gender", gender);
        }
        ClientResponse response = executeGet(webResource, "Param name or gender is incorrect");
        GenericType<List<Employee>> type = new GenericType<List<Employee>>() {
        };
        return response.getEntity(type);
    }

    public static List<Employee> findEmployeesByGenderAndBirthday(Client client, String gender, String birthday) throws SQLException, ParamException {
        WebResource webResource = client.resource(URL + "/findByGenderAndBirthday");
        if (gender != null && birthday != null) {
            webResource = webResource.queryParam("gender", gender).queryParam("birthday", birthday);
        }
        ClientResponse response = executeGet(webResource, "Param gender or birthday is incorrect");
        GenericType<List<Employee>> type = new GenericType<List<Employee>>() {
        };
        return response.getEntity(type);
    }

    public static List<Employee> findEmployeesByGenderAndSalary(Client client, String gender, int salary) throws SQLException, ParamException {
        WebResource webResource = client.resource(URL + "/findByGenderAndSalary");
        if (gender != null) {
            webResource = webResource.queryParam("gender", gender).queryParam("salary", String.valueOf(salary));
        }
        ClientResponse response = executeGet(webResource, "Param gender or salary is incorrect");
        GenericType<List<Employee>> type = new GenericType<List<Employee>>() {
        };
        return response.getEntity(type);
    }

    public static List<Employee> findEmployeesByFullInfo(
            Client client,
            String name,
            String surname,
            String gender,
            String birthday) throws SQLException, ParamException {
        WebResource webResource = client.resource(URL + "/findByFullInfo");
        if (name != null && surname != null && gender != null && birthday != null) {
            webResource = webResource
                    .queryParam("name", name)
                    .queryParam("surname", surname)
                    .queryParam("gender", gender)
                    .queryParam("birthday", birthday);
        }
        ClientResponse response = executeGet(webResource, "Param name, surname, gender or birthday is incorrect");
        GenericType<List<Employee>> type = new GenericType<List<Employee>>() {
        };
        return response.getEntity(type);
    }

    public static int createEmployee(Client client,
                                     String name,
                                     String surname,
                                     String gender,
                                     String birthday,
                                     int salary) throws SQLException, ParamException {
        WebResource webResource = client.resource(URL + "/create");
        if (name != null && surname != null && gender != null && birthday != null) {
            webResource = webResource
                    .queryParam("name", name)
                    .queryParam("surname", surname)
                    .queryParam("gender", gender)
                    .queryParam("birthday", birthday)
                    .queryParam("salary", String.valueOf(salary));
        }
        ClientResponse response = executePost(webResource,
                MediaType.APPLICATION_JSON,
                "Param name, surname, gender or birthday is incorrect");
        GenericType<IntValue> type = new GenericType<IntValue>() {
        };
        return response.getEntity(type).getValue();
    }

    public static Boolean deleteEmployee(Client client, int id) throws SQLException, ParamException {
        WebResource webResource = client.resource(URL + "/delete");
        webResource = webResource.queryParam("id", String.valueOf(id));
        ClientResponse response = executeDelete(webResource, "Param id is incorrect");
        GenericType<BooleanValue> type = new GenericType<BooleanValue>() {
        };
        return response.getEntity(type).isValue();
    }

    public static Boolean updateEmployee(Client client,
                                         int id,
                                         String name,
                                         String surname,
                                         String gender,
                                         String birthday,
                                         int salary) throws SQLException, ParamException {
        WebResource webResource = client.resource(URL + "/update");
        if (name != null && surname != null && gender != null && birthday != null) {
            webResource = webResource
                    .queryParam("id", String.valueOf(id))
                    .queryParam("name", name)
                    .queryParam("surname", surname)
                    .queryParam("gender", gender)
                    .queryParam("birthday", birthday)
                    .queryParam("salary", String.valueOf(salary));
        }
        ClientResponse response = executePost(webResource, MediaType.APPLICATION_JSON,"Param name, surname, gender or birthday is incorrect");
        GenericType<BooleanValue> type = new GenericType<BooleanValue>() {
        };
        return response.getEntity(type).isValue();
    }

    private static ClientResponse executeGet(WebResource webResource, String excStr) throws ParamException, SQLException {
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        checkExceptions(response, excStr);
        return response;
    }


    private static ClientResponse executePost(WebResource webResource, String contentType, String excStr) throws SQLException, ParamException {
        ClientResponse response = webResource.accept(contentType).post(ClientResponse.class);
        checkExceptions(response, excStr);
        return response;
    }

    private static ClientResponse executeDelete(WebResource webResource, String excStr) throws SQLException, ParamException {
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);
        checkExceptions(response, excStr);
        return response;
    }

    private static void checkExceptions(ClientResponse response, String excStr) throws ParamException, SQLException {
        if (response.getStatus() == ClientResponse.Status.NOT_ACCEPTABLE.getStatusCode()) {
            throw new ParamException(excStr);
        }
        if (response.getStatus() == ClientResponse.Status.NOT_MODIFIED.getStatusCode()) {
            throw new SQLException();
        }
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
    }
}
