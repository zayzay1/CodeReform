package com.dependable.codereform.service;

import com.dependable.codereform.model.CRDocument;
import com.dependable.codereform.model.CRDocumentScore;
import com.dependable.codereform.service.contract.CRDocumentService;
import com.dependable.codereform.util.CRUtil;
import org.springframework.stereotype.Service;

@Service
public class CRDocumentServiceImpl implements CRDocumentService {
    @Override
    public CRDocumentScore calculateScore(CRDocument document) {
        CRDocumentScore resultScore = new CRDocumentScore();

        System.out.println(document.getContent());
        System.out.println("Number of lines: " + CRUtil.countLines(document));
        System.out.println("Number distinct operators: " + CRUtil.countDistinctOperators(document));
        System.out.println("Number of total operators: " + CRUtil.countTotalOperators(document));
        System.out.println("Number of total operands: " + CRUtil.countTotalOperands(document));

        return resultScore;
    }
}
