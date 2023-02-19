package com.diazz.blOg.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@RestController
@RequestMapping("/api")
public class ErrorController {

    @GetMapping("/data")
    public String getData() {
        try {
            // code for retrieving data
            return "Data retrieved successfully!";
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
                // handle 404 error
                return "Data not found";
            } else {
                // handle other client errors
                return "Client error: " + ex.getMessage();
            }
        } catch (HttpServerErrorException ex) {
            // handle server errors
            return "Server error: " + ex.getMessage();
        } catch (Exception ex) {
            // handle other exceptions
            return "Error: " + ex.getMessage();
        }
    }

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleHttpClientErrorException(HttpClientErrorException ex) {
        return "Client error: " + ex.getMessage();
    }

    @ExceptionHandler(HttpServerErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleHttpServerErrorException(HttpServerErrorException ex) {
        return "Server error: " + ex.getMessage();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception ex) {
        return "Error: " + ex.getMessage();
    }
}
