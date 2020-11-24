package com.springboot.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Book;
import com.springboot.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {

	// Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	BookService bookService;

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks() {
		// logger.trace("get all books");
		return ResponseEntity.ok(bookService.getAllBooks());

	}

	@GetMapping("/book/{id}")
	public ResponseEntity<Optional<Book>> getBookByName(@PathVariable String id) {
		return ResponseEntity.ok(bookService.getBookByName(id));

	}

	@PostMapping("/book")
	public void addBook(@RequestBody Book book) {
		bookService.addBook(book);
	}

	@PutMapping("/book/{id}")
	public void updateBook(@RequestBody Book book, @PathVariable String id) {
		bookService.updateBook(book, id);
	}

	@DeleteMapping("/book/{id}")
	public void deleteBook(@RequestBody Book book, @PathVariable String id) {
		bookService.deleteBook(id);
	}

}
