package mnu.service.impl;

import mnu.exc.UnauthorizedUserException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UnauthorizedUserExceptionMapper implements ExceptionMapper<UnauthorizedUserException> {
    @Override
    public Response toResponse(UnauthorizedUserException exception) {
        return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
    }
}
