package mnu.service.impl;

import mnu.exc.InvalidParameterException;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidParameterExceptionMapper implements ExceptionMapper<InvalidParameterException> {
    @Override
    public Response toResponse(InvalidParameterException exception) {
        return Response.status(Response.Status.NOT_ACCEPTABLE).entity(exception.getMessage()).build();
    }
}
