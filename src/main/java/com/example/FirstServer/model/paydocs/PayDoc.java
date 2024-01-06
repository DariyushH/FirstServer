package com.example.FirstServer.model.paydocs;

import jakarta.xml.bind.annotation.*;
import lombok.NoArgsConstructor;

import java.util.List;

@XmlRootElement(name = "Inf_Pay_Doc")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
public class PayDoc {
    @XmlElement(name = "Doc")
    @XmlElementWrapper(name = "Docs")
    private List<DocPayDoc> documentList;

    public List<DocPayDoc> getAll() {
        return documentList;
    }

    public DocPayDoc getByGUID(String guid) throws Exception {
        return documentList.stream()
          .filter(payDoc -> payDoc.getGUID().equals(guid))
          .findFirst()
          .orElseThrow(Exception::new);
    }
}
