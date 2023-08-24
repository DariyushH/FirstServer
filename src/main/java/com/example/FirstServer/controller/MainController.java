package com.example.FirstServer.controller;

import com.example.FirstServer.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/index")
public class MainController {
    public final RestTemplate restTemplate;
    public final DocumentService documentService;

    @Autowired
    public MainController(RestTemplate restTemplate, DocumentService documentService) {
        this.restTemplate = restTemplate;
        this.documentService = documentService;
    }

    @GetMapping()
    public String index() {
        return "index";
    }

    @PostMapping()
    public String sendPostRequest(@RequestParam("file") MultipartFile file) {
        if (file != null) {
            documentService.unpack(file);
        } else {
            System.out.println("No file");
        }

//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        URI url = new URI("http://localhost:8081/index");
//        UserInfo objUser = new UserInfo();
//        objUser.setFirstName("Roman");
//        objUser.setSecondName("Matrenin");
//
//        HttpEntity<UserInfo> requestEntity = new HttpEntity<>(objUser, headers);
//        ResponseEntity<UserInfo> responseEntity = restTemplate.postForEntity(url, requestEntity, UserInfo.class);

        return "redirect:/index";
    }

}
