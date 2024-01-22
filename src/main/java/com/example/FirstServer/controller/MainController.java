package com.example.FirstServer.controller;

import com.example.FirstServer.model.main.MainDocument;
import com.example.FirstServer.service.DocumentService;
import com.example.FirstServer.service.implementation.DocumentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/index")

public class MainController {

    public final RestTemplate restTemplate;
    public final DocumentService documentService;

    @Autowired
    public MainController(RestTemplate restTemplate, DocumentService documentService, DocumentServiceImpl documentServiceimpl) {
        this.restTemplate = restTemplate;
        this.documentService = documentService;

    }


    @GetMapping()
    public String index() {
        return "/index";
    }

    @PostMapping()
    public String sendPostRequest(@RequestParam("file") MultipartFile file) throws Exception {
        if (file != null) {
            List<MainDocument> mainDocument = documentService.unpack(file);
            String url = "http://localhost:8081/index";
            restTemplate.postForLocation(url, mainDocument);
        } else {
            System.out.println("No file");
        }
        return "redirect:/index";
    }
}