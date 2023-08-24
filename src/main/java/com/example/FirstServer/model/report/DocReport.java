package com.example.FirstServer.model.report;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
@XmlRootElement(name = "Doc")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class DocReport {
    @XmlElement(name="DocNum")
    private String docNum;
    @XmlElement(name="DocDate")
    private String docDate;
    @XmlElement(name="DocGUID")
    private String docGUID;
    @XmlElement(name="OperType")
    private String operType;
    @XmlElement(name="AmountOut")
    private double amountOut;

}
