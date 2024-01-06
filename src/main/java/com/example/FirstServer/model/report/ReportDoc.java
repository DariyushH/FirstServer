package com.example.FirstServer.model.report;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.NoArgsConstructor;

import java.util.List;

@XmlRootElement(name = "SKP_REPORT_KS")
@NoArgsConstructor
public class ReportDoc {
    @XmlElement(name = "Doc")
    @XmlElementWrapper(name = "Docs")
    private List<DocReport> documentList;

    public List<DocReport> getAll() {
        return documentList;
    }

    public DocReport getByGUID(String guid) throws Exception {
        return documentList.stream()
          .filter(report -> report.getDocGUID().equals(guid))
          .findFirst()
          .orElseThrow(Exception::new);
    }
}

