/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.sal.facade;

import dk.cphbusiness.sal.entity.Book;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sofus
 */
public class BookFacade {
   static Map<String,Book> books= new HashMap(){{
       put("12345678", new Book("Borte med blaesten", "Sehumbing Mangaze", "Gyldendal", "12345678"));
   }};
   
    public static Book getBook(String iSBN){
    return books.get(iSBN);
    }
    public static void createBook(Book book){
    books.putIfAbsent(book.getiSBN(), book);
    }
    public static void deleteBook(String iSBN){
    books.remove(iSBN);
    }
    public static Book editBook(Book book){
        return books.put(book.getiSBN(), book);
    }
    public static List<Book> getAllBooks(){
        return new ArrayList<Book>(books.values());
    }
}
