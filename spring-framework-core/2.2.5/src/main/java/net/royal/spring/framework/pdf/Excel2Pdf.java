package net.royal.spring.framework.pdf;

import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Created by cary on 6/15/17.
 */
public class Excel2Pdf extends PdfTool{
    protected List<ExcelObject> objects = new ArrayList<ExcelObject>();

    public Excel2Pdf(ExcelObject object , OutputStream os) {
        this.objects.add(object);
        this.os = os;
    }

    public Excel2Pdf(List<ExcelObject> objects , OutputStream os) {
        this.objects = objects;
        this.os = os;
    }

    public void convert() throws DocumentException, MalformedURLException, IOException {
        getDocument().setPageSize(PageSize.A4.rotate());
        PdfWriter writer = PdfWriter.getInstance(getDocument(), os);
        writer.setPageEvent(new PDFPageEvent());
        //Open document
        getDocument().open();
        //Single one
        if(this.objects.size() <= 1){
            PdfPTable table = this.toCreatePdfTable(this.objects.get(0) ,  getDocument() , writer);
            getDocument().add(table);
        }
        //Multiple ones
        if(this.objects.size() > 1){
            toCreateContentIndexes(writer , this.getDocument() , this.objects);
            //
            for (int i = 0; i < this.objects.size(); i++) {
                PdfPTable table = this.toCreatePdfTable(this.objects.get(i) , getDocument() , writer);
                getDocument().add(table);
            }
        }
        //
        getDocument().close();
    }

    protected PdfPTable toCreatePdfTable(ExcelObject object , Document document , PdfWriter writer) throws MalformedURLException, IOException, DocumentException{
        PdfPTable table = new PdfTableExcel(object).getTable();
        table.setKeepTogether(true);
//      table.setWidthPercentage(new float[]{100} , writer.getPageSize());
        table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        return table;
    }

    protected void toCreateContentIndexes(PdfWriter writer , Document document , List<ExcelObject> objects) throws DocumentException{
        PdfPTable table = new PdfPTable(1);
        table.setKeepTogether(true);
        table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        //
        Font font = new Font(Resource.BASE_FONT_CHINESE , 12 , Font.NORMAL);
        font.setColor(new BaseColor(0,0,255));
        //
        for (int i = 0; i < objects.size(); i++) {
            ExcelObject o = objects.get(i);
            String text = o.getAnchorName();
            Anchor anchor = new Anchor(text , font);
            anchor.setReference("#" + o.getAnchorName());
            //
            PdfPCell cell = new PdfPCell(anchor);
            cell.setBorder(0);
            //
            table.addCell(cell);
        }
        //
        document.add(table);
    }

    private static class PDFPageEvent extends PdfPageEventHelper {
        protected PdfTemplate template;
        public BaseFont baseFont;

        @Override
        public void onStartPage(PdfWriter writer, Document document) {
            try{
                this.template = writer.getDirectContent().createTemplate(100, 100);
                this.baseFont = new Font(Resource.BASE_FONT_CHINESE , 8, Font.NORMAL).getBaseFont();
            } catch(Exception e) {
                throw new ExceptionConverter(e);
            }
        }

        @Override
        public void onEndPage(PdfWriter writer, Document document) {
            PdfContentByte byteContent = writer.getDirectContent();
            String text = "第" + writer.getPageNumber() + "页";
            float textWidth = this.baseFont.getWidthPoint(text, 8);
            float realWidth = document.right() - textWidth;
            //
            byteContent.beginText();
            byteContent.setFontAndSize(this.baseFont , 10);
            byteContent.setTextMatrix(realWidth , document.bottom());
            byteContent.showText(text);
            byteContent.endText();
            byteContent.addTemplate(this.template , realWidth , document.bottom());
        }
    }
}