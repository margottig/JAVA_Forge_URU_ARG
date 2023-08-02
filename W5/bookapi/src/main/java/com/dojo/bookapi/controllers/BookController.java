package com.dojo.bookapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojo.bookapi.models.BookModel;
import com.dojo.bookapi.services.BookService;

@Controller
public class BookController {

//	    private final BookService bookService;
//	    
//	    public BooksController(BookService bookService) {
//	        this.bookService = bookService;
//	    }

	@Autowired
	private BookService bookservice;

	//TODOS LOS LIBROS
	@GetMapping("/books")
	public String index(Model model) {
		List<BookModel> books = bookservice.allBooks();
		model.addAttribute("books", books);
		return "/books/index.jsp";
	}
	
	@GetMapping("/books/new")
	public String formularioLibro(@ModelAttribute("libro") BookModel book ) {
		return "/books/formlibro.jsp";
	}
	
	
	    @PostMapping("/books")
	    public String crearLibro(@ModelAttribute("libro") BookModel book,BindingResult result, Model viewModel) {
	        if (result.hasErrors()) {
	            return "/books/formlibro.jsp";
	        } else {
	            bookservice.createBook(book);
	            return "redirect:/books";
	        }
	    }

}
