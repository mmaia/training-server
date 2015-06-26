package com.backbase.expert.training.services.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * User: bartv
 * Date: 23-07-14
 * Time: 13:35
 */
public class NotFoundException extends WebApplicationException {

    public NotFoundException(String message) {
        super(Response.status(Response.Status.NOT_FOUND)
                .entity(message).type(MediaType.APPLICATION_JSON).build());
    }
}
