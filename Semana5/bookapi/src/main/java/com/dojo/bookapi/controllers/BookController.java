package com.dojo.bookapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.dojo.bookapi.models.BookModel;
import com.dojo.bookapi.services.BookService;

import jakarta.validation.Valid;

@Controller
public class BookController {

//	    private final BookService bookService;
//	    
//	    public BooksController(BookService bookService) {
//	        this.bookService = bookService;
//	    }

	@Autowired
	private BookService bookservice;

	@GetMapping("/")
	public String raiz() {
		return "redirect:/books";

	}

	// TODOS LOS LIBROS
	@GetMapping("/books")
	public String index(Model model) {
		List<BookModel> books = bookservice.allBooks();
		model.addAttribute("books", books);
		return "/books/index.jsp";
	}

	//CREAR UN NUEVO LIBRO
	@GetMapping("/books/new")
	public String formularioLibro(@ModelAttribute("libro") BookModel book) {
		return "/books/formlibro.jsp";
	}

	@PostMapping("/books")
	public String crearLibro(@Valid @ModelAttribute("libro") BookModel book, BindingResult result, Model viewModel) {
		if (result.hasErrors()) {
			return "/books/formlibro.jsp";
		} else {
			bookservice.createBook(book);
			return "redirect:/books";
		}
	}

	//BORRAR UN LIBRO
	@DeleteMapping("/books/{id}")
	public String destroy(@PathVariable("id") Long id) {
		bookservice.borrarRegistro(id);
		return "redirect:/books";
	}
	
	//EDITAR UN LIBRO
	@GetMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        BookModel book = bookservice.findBook(id);
        model.addAttribute("libro", book);
        return "/books/editarlibro.jsp";
      
    }
    
    @PutMapping("/books/{id}")
    public String update(@Valid @ModelAttribute("libro") BookModel book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/editarlibro.jsp";
        } else {
            bookservice.actualizarLibro(book);
            return "redirect:/books";
        }
    }
}
