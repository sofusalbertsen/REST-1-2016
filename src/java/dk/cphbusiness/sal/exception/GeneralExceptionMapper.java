/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.sal.exception;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dk.cphbusiness.sal.entity.ErrorMessage;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author sofus
 */
@Provider
public class GeneralExceptionMapper implements ExceptionMapper<Throwable>{

    @Override
    public Response toResponse(Throwable e) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Response out = Response.status(500).entity(new ErrorMessage("Internal server error, sorry for the inconveniance", 500)).build();
        return out;
    }
    
    
}
