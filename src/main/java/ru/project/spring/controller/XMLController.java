package ru.project.spring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.spring.entity.Product;

@RestController
@RequestMapping("/xml")
public class XMLController {

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_XML_VALUE)
    public String getXml() throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.writeValueAsString(new Product(8, "pear", 111.5));
    }
}
