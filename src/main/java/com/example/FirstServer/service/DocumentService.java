package com.example.FirstServer.service;

import jakarta.xml.bind.JAXBException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public interface DocumentService {
    void unpack(MultipartFile file) throws  Exception;
}
