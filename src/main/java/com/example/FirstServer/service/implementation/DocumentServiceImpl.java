package com.example.FirstServer.service.implementation;

import com.example.FirstServer.model.paydocs.DocPayDoc;
import com.example.FirstServer.model.paydocs.PayDoc;
import com.example.FirstServer.model.report.DocReport;
import com.example.FirstServer.model.report.ReportDoc;
import com.example.FirstServer.service.DocumentService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Override
    public void unpack(MultipartFile file) {
        try (ZipInputStream zin = new ZipInputStream(file.getInputStream())) {
            ZipEntry entry;
            while ((entry = zin.getNextEntry()) != null) {

                System.out.printf("File name: %s \n", entry.getName());
                switch (entry.getName()) {
                    case "PayDocs.xml":{
                        String str = IOUtils.toString(zin, StandardCharsets.UTF_8);
                        StringReader reader = new StringReader(str);
                        JAXBContext context = JAXBContext.newInstance(PayDoc.class);
                        PayDoc payDoc = (PayDoc) context.createUnmarshaller()
                                .unmarshal(reader);
                        for (DocPayDoc doc : payDoc.documentList) {
                            System.out.println(doc.toString());
                        }
                        break;
                     }
                    case "Report.xml": {
                        String str = IOUtils.toString(zin, StandardCharsets.UTF_8);
                        StringReader reader = new StringReader(str);
                        JAXBContext context = JAXBContext.newInstance(ReportDoc.class);
                        ReportDoc reportDoc = (ReportDoc) context.createUnmarshaller()
                                .unmarshal(reader);
                        for (DocReport doc : reportDoc.documentList) {
                            System.out.println(doc.toString());
                        }
                        break;
                    }
                }
//                if(entry.getName().equals("PayDocs.xml")){
//                    String str = IOUtils.toString(zin, StandardCharsets.UTF_8);
//                    StringReader reader = new StringReader(str);
//                    JAXBContext context = JAXBContext.newInstance(PayDoc.class);
//                    PayDoc payDoc = (PayDoc) context.createUnmarshaller()
//                            .unmarshal(reader);
//                    for (DocPayDoc doc : payDoc.documentList) {
//                        System.out.println(doc.toString());
//                    }
//                }
//                if(entry.getName().equals("Report.xml")){
//                    String str = IOUtils.toString(zin, StandardCharsets.UTF_8);
//                    StringReader reader = new StringReader(str);
//                    JAXBContext context = JAXBContext.newInstance(ReportDoc.class);
//                    ReportDoc reportDoc = (ReportDoc) context.createUnmarshaller()
//                            .unmarshal(reader);
//                    for (DocReport doc : reportDoc.documentList) {
//                        System.out.println(doc.toString());
//                    }
//                }
            }
        } catch (IOException | JAXBException e) {
            throw new RuntimeException(e);
        }

    }
}
