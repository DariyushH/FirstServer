package com.example.FirstServer.model.paydocs;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class BankInfo {
    @XmlElement(name = "BS_PAY")
    private String bsPay;
    @XmlElement(name = "BIC_PAY")
    private String bicPAy;
    @XmlElement(name = "BS_KS_PAY")
    private String bsKsPay;
}
