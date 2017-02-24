package com.lyc88.utils.html2docx;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

/**
 * Created by Administrator on 2017/2/16.
 */
public class TestDoc {

    public static void main(String[] args) throws Docx4JException {
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();
        wordMLPackage.getMainDocumentPart().addParagraphOfText("Hello Word!");
        wordMLPackage.save(new java.io.File("d://HelloWord1.docx"));
    }
}
