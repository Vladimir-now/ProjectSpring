package ru.project.spring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.spring.Product;

@RestController
@RequestMapping("/json")
public class JSONController {

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(new Product(7, "pineapple", 100.5));
    }
}
