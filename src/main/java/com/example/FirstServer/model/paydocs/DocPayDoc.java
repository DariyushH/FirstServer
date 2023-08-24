package com.example.FirstServer.model.paydocs;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;


@XmlRootElement(name = "Doc")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class DocPayDoc {
    @XmlElement(name = "Inf_PAY")
    private ParticipantInfo infPay;

    @XmlElement(name = "Bank_PAY")
    private BankInfo bankPay;

    @XmlElement(name = "Inf_RCP")
    private ParticipantInfo infRcp;

    @XmlElement(name = "Bank_RCP")
    private BankInfo bankRcp;

    @XmlElement(name = "Purpose")
    private String purpose;

    @XmlElement(name = "GUID")
    private String GUID;
}
