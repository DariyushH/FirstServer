package com.example.FirstServer.service;

import com.example.FirstServer.model.main.MainDocument;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DocumentService {
    List<MainDocument> unpack(MultipartFile file) throws  Exception;
}
