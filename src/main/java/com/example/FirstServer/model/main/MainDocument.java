package com.example.FirstServer.model.main;

import com.example.FirstServer.model.paydocs.BankInfo;
import com.example.FirstServer.model.paydocs.DocPayDoc;
import com.example.FirstServer.model.paydocs.ParticipantInfo;
import com.example.FirstServer.model.report.DocReport;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MainDocument {
    /** Аттрибуты из Report **/
    private String docNumber;
    private String docDate;
    private String docGUID;
    private String operationType;
    private Double amount;
    /** Аттрибуты из PayDoc **/
    private ParticipantInfo receiverInfo;
    private ParticipantInfo payerInfo;
    private BankInfo receiverBankInfo;
    private BankInfo payerBankInfo;
    private String purpose;

    public MainDocument(DocPayDoc docPayDoc, DocReport reportDoc) {
        docNumber = reportDoc.getDocNum();
        docDate = reportDoc.getDocDate();
        docGUID = reportDoc.getDocGUID();
        operationType = reportDoc.getOperType();
        amount = reportDoc.getAmountOut();
        receiverInfo = docPayDoc.getInfRcp();
        payerInfo = docPayDoc.getInfPay();
        receiverBankInfo = docPayDoc.getBankRcp();
        payerBankInfo = docPayDoc.getBankPay();
        purpose = docPayDoc.getPurpose();
    }
}