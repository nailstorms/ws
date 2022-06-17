package mnu.service.impl;

import mnu.exc.MySQLException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MySQLExceptionMapper implements ExceptionMapper<MySQLException> {
    @Override
    public Response toResponse(MySQLException exception) {
        return Response.status(Response.Status.NOT_MODIFIED).entity(exception.getMessage()).build();
    }
}
