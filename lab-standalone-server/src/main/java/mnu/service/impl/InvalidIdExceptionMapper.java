package mnu.service.impl;

import mnu.exc.InvalidIdException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidIdExceptionMapper implements ExceptionMapper<InvalidIdException> {
    @Override
    public Response toResponse(InvalidIdException exception) {
        return Response.status(Response.Status.NOT_ACCEPTABLE).entity(exception.getMessage()).build();
    }
}
