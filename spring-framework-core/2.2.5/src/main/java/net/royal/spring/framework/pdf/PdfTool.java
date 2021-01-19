package net.royal.spring.framework.pdf;

import java.io.OutputStream;

import com.itextpdf.text.Document;

/**
 * Created by cary on 6/15/17.
 */
public class PdfTool {
    //
    protected Document document;
    //
    protected OutputStream os;

    public Document getDocument() {
        if (document == null) {
            document = new Document();
        }
        return document;
    }
}