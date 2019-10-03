package com.pskwierc.swaggerannotations.controller;

import com.pskwierc.swaggerannotations.exception.ResourceNotFoundException;
import com.pskwierc.swaggerannotations.model.Book;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Api(value = "Book Rest API", description = "Operations on books via Rest API")
public interface BookControllerApi {

    @ApiOperation(value = "View a list of available books", produces = "application/json", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/book")
    List<Book> getAllBooks();

    @ApiOperation(value = "Get book by Id", produces = "application/json")
    @GetMapping("/book/{id}")
    ResponseEntity<Book> getBookById(
            @ApiParam(value = "Book id from which book object will retrieve", required = true) @PathVariable(value = "id") Long bookId)
            throws ResourceNotFoundException;

    @ApiOperation(value = "Add book", produces = "application/json")
    @PostMapping("/book")
    Book createBook(
            @ApiParam(value = "Book object store in database", required = true) @Valid @RequestBody Book book);

    @ApiOperation(value = "Update book", produces = "application/json")
    @PutMapping("/book/{id}")
    ResponseEntity<Book> updateBook(
            @ApiParam(value = "Book Id to update book object", required = true) @PathVariable(value = "id") Long bookId,
            @ApiParam(value = "Updated book object", required = true) @Valid @RequestBody Book bookDetails)
            throws ResourceNotFoundException;

    @ApiOperation(value = "Delete book", produces = "application/json", response = Map.class)
    @DeleteMapping("/book/{id}")
    Map<String, Boolean> deleteBook(
            @ApiParam(value = "Book Id from which book will be deleted ", required = true) @PathVariable(value = "id") Long bookId)
            throws ResourceNotFoundException;
}
