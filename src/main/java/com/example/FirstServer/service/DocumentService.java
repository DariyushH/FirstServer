package com.example.FirstServer.service;

import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {
    void unpack(MultipartFile file);
}
