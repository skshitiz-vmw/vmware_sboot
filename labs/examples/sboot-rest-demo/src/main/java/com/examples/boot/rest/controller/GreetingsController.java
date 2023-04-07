package com.examples.boot.rest.controller;

import com.examples.boot.rest.model.Greetings;
import com.examples.boot.rest.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class GreetingsController {
// http://localhost:8080/greetings
// POST	/greetings	[JSON/XML]
// GET	/greetings
// GET	/greetings/{id}
// PUT	/greetings/{id}
// DELETE /greetings/{id}

    @Autowired
    GreetingService service;

//    @RequestMapping(path = "/greetings", method = {RequestMethod.POST}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PostMapping(path = "/greetings", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String createGreetings(@RequestBody  Greetings greetings){
        service.createGreetings(greetings);
        return "Greetings created successfully";
    }

    @GetMapping("/greetings")
    public Collection<Greetings> viewAllGreetings() {
//        return "Hello, Welcome to Spring Boot REST!!!";
        return service.viewAllGreetings();
    }

    @GetMapping("/greetings/{id}")
    public Greetings viewGreetings(@PathVariable int id) {
        return service.viewGreetings(id);
    }

    @PutMapping("/greetings/{id}")
    public String updateGreetings(@PathVariable int id, @RequestBody  Greetings greetings) {
        greetings.setId(id);
        service.updateGreetings(id, greetings);
        return "Greetings updated successfully";
    }

    @DeleteMapping("/greetings/{id}")
    public String deleteGreetings(@PathVariable int id) {
        service.deleteGreetings(id);
        return "Greetings deleted successfully";
    }


}
