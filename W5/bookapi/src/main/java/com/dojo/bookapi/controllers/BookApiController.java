package com.dojo.bookapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dojo.bookapi.models.BookModel;
import com.dojo.bookapi.services.BookService;

@RestController
public class BookApiController {
	
	
	//Inyeccion Depencioas
//	 private final bookservice bookservice;
//	    public BookApiController(bookservice bookservice){
//	        this.bookservice = bookservice;
//	    }
	    
	    @Autowired
	    private BookService bookservice;
	    
	    //Mostrar informacion de todos los libros
	    @GetMapping("/api/books")
	    public List<BookModel> index() {
	        return bookservice.allBooks();
	    }
	    
	    //Crear un libro
	    @PostMapping(value="/api/books")
	    public BookModel create(@RequestParam(value="title") String title, 
	    		@RequestParam(value="description") String desc,
	    		@RequestParam(value="language") String lang, 
	    		@RequestParam(value="pages") Integer numOfPages) {
	        BookModel book = new BookModel(title, desc, lang, numOfPages);
	        return bookservice.createBook(book);
	    }
	    
	    //Mostrar informacion de un libro especifico
	    @GetMapping("/api/books/{id}")
	    public BookModel show(@PathVariable("id") Long id) {
	        BookModel book = bookservice.findBook(id);
	        return book;
	    }
	    
	    //Actualizar informacion de un libro especifico
	    @PutMapping("/api/books/{id}")
	    public BookModel actualizar(@PathVariable("id")Long id,
	    		@RequestParam(value="title") String title, 
	    		@RequestParam(value="description") String desc,
	    		@RequestParam(value="language") String lang, 
	    		@RequestParam(value="pages") Integer numOfPages) {
	    	BookModel book = new BookModel(id, title, desc, lang,numOfPages);
//	    	return bookservice.actualizarLibro(book);
	    	return bookservice.actualizarLibro(id, title, desc, lang,numOfPages );
	    	
	    }
	    
	    
	    //Borra registro
	    @DeleteMapping("/api/books/{id}")
	    public void borrarRegistro(@PathVariable("id")Long id) {
	    	bookservice.borrarRegistro(id);
	    }
	    	
	    

	
}
