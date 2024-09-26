package com.employee.demo.controller;

import com.employee.demo.domain.Book;
import com.employee.demo.domain.ObjectWithId;
import com.employee.demo.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book")
@Service
public class BookRestController {

    @Autowired
    private BookService bookService;

    private Logger logger=LoggerFactory.getLogger(BookRestController.class);

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Book getBook(@PathVariable("id") Long id) {
        logger.debug("Provider has received request to get person with id: " + id);
        return bookService.getBook(id);
    }

    @RequestMapping(value = "/add",  method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ObjectWithId addBook(@RequestBody Book book)
    {
        return new ObjectWithId(bookService.addBook(book));
    }

    @GetMapping("/view")
    public String viewTweets() {
        return "success";
    }
}
