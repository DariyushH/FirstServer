package com.example.FirstServer.model.paydocs;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "Inf_Pay_Doc")
public class PayDoc {
    @XmlElement(name = "Doc")
    @XmlElementWrapper(name = "Docs")
    public List<DocPayDoc> documentList;
}
