package com.example.FirstServer.model.report;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "SKP_REPORT_KS")
public class ReportDoc {
    @XmlElement(name = "Doc")
    @XmlElementWrapper(name = "Docs")
    public List<DocReport> documentList;
}

