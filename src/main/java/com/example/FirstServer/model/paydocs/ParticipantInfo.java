package com.example.FirstServer.model.paydocs;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ParticipantInfo {
    @XmlElement(name = "INN_PAY")
    private String inn;
    @XmlElement(name = "KPP_PAY")
    private String kpp;
    @XmlElement(name = "CName_PAY")
    private String name;
}
