package com.example.FirstServer.enums;

import com.example.FirstServer.model.paydocs.PayDoc;
import com.example.FirstServer.model.report.ReportDoc;
import lombok.Getter;

@Getter
public enum DocType {
    PAYDOC("PayDocs.xml", PayDoc.class),
    REPORT("Report.xml", ReportDoc.class);

    private final String fileName;
    private final Class requiredClass;

    DocType(String fileName, Class requiredClass) {
        this.fileName = fileName;
        this.requiredClass = requiredClass;
    }
}
