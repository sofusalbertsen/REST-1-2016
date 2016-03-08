/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.sal.exception;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author sofus
 */
@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException>{

    @Override
    public Response toResponse(NotFoundException e) {
        Gson g = new GsonBuilder().setPrettyPrinting().create();
       return Response.status(400).entity(g.toJson(e)).type(MediaType.APPLICATION_JSON).build();
    }
    
}
