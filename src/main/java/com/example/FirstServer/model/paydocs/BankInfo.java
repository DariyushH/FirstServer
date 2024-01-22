package com.example.FirstServer.model.paydocs;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class BankInfo {
    @XmlElement(name = "BS_PAY")
    private String bs;
    @XmlElement(name = "BIC_PAY")
    private String bic;
    @XmlElement(name = "BS_KS_PAY")
    private String bsKs;
}
