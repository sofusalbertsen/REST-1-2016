/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.sal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dk.cphbusiness.sal.entity.Book;
import dk.cphbusiness.sal.facade.BookFacade;
import java.util.Collection;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author sofus
 */
@Path("book")
public class BookEndpoint {
    Gson gson;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of BookEndpoint
     */
    public BookEndpoint() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    /**
     * Retrieves representation of an instance of dk.cphbusiness.sal.BookEndpoint
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON) //"application/json"
    public String getJson() {
        return gson.toJson(BookFacade.getAllBooks());
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postBook(String bookJson){
        Book book = gson.fromJson(bookJson, Book.class);
        BookFacade.createBook(book);
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteBook(@PathParam("id") String iSBN){
        BookFacade.deleteBook(iSBN);
    }

    /**
     * PUT method for updating or creating an instance of BookEndpoint
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
