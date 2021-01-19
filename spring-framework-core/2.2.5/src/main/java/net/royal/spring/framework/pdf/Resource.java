package net.royal.spring.framework.pdf;

import org.apache.poi.hssf.usermodel.HSSFFont;

import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.BaseFont;

/**
 * Created by cary on 6/15/17.
 */
public class Resource {
    
    protected static BaseFont BASE_FONT_CHINESE;
    static {
        try {
            BASE_FONT_CHINESE = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            
            FontFactory.registerDirectories();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static com.itextpdf.text.Font getFont(HSSFFont font) {
        try {
            com.itextpdf.text.Font iTextFont = FontFactory.getFont(font.getFontName(),
                    BaseFont.IDENTITY_H, BaseFont.EMBEDDED,
                    font.getFontHeightInPoints());
            return iTextFont;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}