package com.example.BookFinderProject.controller;
import com.example.BookFinderProject.DTO.BookDTO;
import com.example.BookFinderProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

    @RestController
    @RequestMapping("/books")
    public class BookController {

        @Autowired
        private BookService bookService;

        @GetMapping("/search/{title}")
        public List<BookDTO> searchBooks(@PathVariable String title) {
            return bookService.searchBooks(title);
        }
    }


