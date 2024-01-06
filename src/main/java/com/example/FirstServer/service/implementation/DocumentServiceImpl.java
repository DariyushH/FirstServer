package com.example.FirstServer.service.implementation;

import com.example.FirstServer.enums.DocType;
import com.example.FirstServer.model.main.MainDocument;
import com.example.FirstServer.model.paydocs.DocPayDoc;
import com.example.FirstServer.model.paydocs.PayDoc;
import com.example.FirstServer.model.report.ReportDoc;
import com.example.FirstServer.service.DocumentService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Override
    public void unpack(MultipartFile file) throws Exception {
        PayDoc payDocList = (PayDoc) parseXML(file, DocType.PAYDOC);
        ReportDoc reportDocList = (ReportDoc) parseXML(file, DocType.REPORT);
        List<MainDocument> mainDocuments = new ArrayList<>();
        if (payDocList != null && reportDocList != null) {
            for (DocPayDoc docPayDoc : payDocList.getAll()) {
                mainDocuments.add(new MainDocument(docPayDoc, reportDocList.getByGUID(docPayDoc.getGUID())));
            }
        }
        for (MainDocument doc : mainDocuments) {
            System.out.println(doc);
        }
    }

    private Object parseXML(MultipartFile file, DocType type) throws Exception {
        Object doc = type.getRequiredClass().getDeclaredConstructor().newInstance();
        try (ZipInputStream zin = new ZipInputStream(file.getInputStream())) {
            ZipEntry entry;
            while ((entry = zin.getNextEntry()) != null) {
                String str = IOUtils.toString(zin, StandardCharsets.UTF_8);
                if (entry.getName().equals(type.getFileName())) {
                    StringReader reader = new StringReader(str);
                    try {
                        JAXBContext context = JAXBContext.newInstance(type.getRequiredClass());
                        Unmarshaller unmarshaller = context.createUnmarshaller();
                        doc = unmarshaller.unmarshal(reader);
                    } catch (JAXBException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("while ended");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;
    }
}
