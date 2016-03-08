/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.sal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dk.cphbusiness.sal.entity.Book;
import dk.cphbusiness.sal.exception.NotFoundException;
import dk.cphbusiness.sal.facade.BookFacade;
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

    @GET
    @Produces(MediaType.APPLICATION_JSON) //"application/json"
    public String getJson() {
        return gson.toJson(BookFacade.getAllBooks());
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON) //"application/json"
    public String getBook(@PathParam("id") String iSBN) throws NotFoundException {
        Book book =BookFacade.getBook(iSBN);
        if (book ==null)
            throw new NotFoundException("No book with that ISBN");
        return gson.toJson(book);
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

    @PUT
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public String putJson(String bookJson){
        Book book = gson.fromJson(bookJson, Book.class);
        book=BookFacade.editBook(book);
        return gson.toJson(book);
    }
}
