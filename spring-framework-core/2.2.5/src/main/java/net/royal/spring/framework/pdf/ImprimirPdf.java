package net.royal.spring.framework.pdf;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import net.royal.spring.framework.core.dominio.DominioArchivo;
import net.royal.spring.framework.util.UString;

public class ImprimirPdf {

	public static DominioArchivo imprimirExcel(String titulo, String usuario, List<String> cabeceras,
			List<String> atributos, List<?> objetos, String rutaFinal, String rutaImagen) throws Exception {

		DominioArchivo dto = new DominioArchivo();

		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet(titulo);

		org.apache.poi.ss.usermodel.Font font = wb.createFont();
		font.setBold(true);

		CellStyle style = wb.createCellStyle();
		style.setFont(font);

		InputStream inputStream = new FileInputStream(rutaImagen);
		byte[] bytes = IOUtils.toByteArray(inputStream);

		CreationHelper helper = wb.getCreationHelper();
		Drawing drawing = sheet.createDrawingPatriarch();
		ClientAnchor anchor = helper.createClientAnchor();
		anchor.setAnchorType(ClientAnchor.MOVE_AND_RESIZE);
		int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);

		anchor.setCol1(0);
		anchor.setRow1(2);

		Picture pict = drawing.createPicture(anchor, pictureIdx);
		pict.resize(2, 3);

		inputStream.close();

		int rowCount = 9;
		int columnCount = 0;

		int letraTitulo = 4;

		Row rowUsuario = sheet.createRow(3);
		Row rowFecha = sheet.createRow(4);
		Row rowCountt = sheet.createRow(5);

		if (cabeceras.size() == letraTitulo) {
			Cell celUsuario = rowUsuario.createCell(cabeceras.size() + 1);
			celUsuario.setCellValue(usuario);

			Cell celTitulo = rowUsuario.createCell(letraTitulo - 1);
			celTitulo.setCellValue(titulo);
			celTitulo.setCellStyle(style);

			Cell celFecha = rowFecha.createCell(cabeceras.size() + 1);
			celFecha.setCellValue(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
			
			Cell celCount = rowCountt.createCell(cabeceras.size() + 1);
			celCount.setCellValue("Registros encontrados : "+objetos.size());

		} else {

			Cell celUsuario = rowUsuario
					.createCell((cabeceras.size() - 1) == letraTitulo ? letraTitulo + 1 : cabeceras.size() - 1);
			celUsuario.setCellValue(usuario);

			Cell celTitulo = rowUsuario.createCell(letraTitulo);
			celTitulo.setCellValue(titulo);
			celTitulo.setCellStyle(style);

			Cell celFecha = rowFecha
					.createCell((cabeceras.size() - 1) == letraTitulo ? letraTitulo + 1 : cabeceras.size() - 1);
			celFecha.setCellValue(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
			
			Cell celCount = rowCountt
					.createCell((cabeceras.size() - 1) == letraTitulo ? letraTitulo + 1 : cabeceras.size() - 1);
			celCount.setCellValue("Registros : "+objetos.size());
		}

		Row row = sheet.createRow(rowCount++);

		for (String fieldName : cabeceras) {
			Cell cel = row.createCell(columnCount++);
			cel.setCellValue(fieldName);
			cel.setCellStyle(style);
		}

//		for (int i = 0; i < cabeceras.size(); i++) {
//			sheet.autoSizeColumn(i);
//		}

		for (Object objeto : objetos) {
			row = sheet.createRow(rowCount++);
			for (int i = 0; i < atributos.size(); i++) {
				row.createCell(i).setCellValue(BeanUtils.getProperty(objeto, atributos.get(i)));
			}
		}

		try (OutputStream fileOut = new FileOutputStream(rutaFinal)) {
			wb.write(fileOut);
		}
		wb.close();

		dto.setRutaCompleta(rutaFinal);
		dto.setArchivoFile(new File(rutaFinal));
		dto.obtenerMimeType();
		dto.setNombre(dto.getArchivoFile().getName());

		return dto;
	}

	public static void imprimirPdf(String titulo, String usuario, List<String> cabeceras, List<String> atributos,
			List<?> objetos, boolean vertical, String rutaFinal, String rutaImagen) throws Exception {

		HeaderFooterPageEvent event = new HeaderFooterPageEvent(titulo,
				new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()), usuario, vertical, rutaImagen, objetos.size());

		Document document = new Document();

		Rectangle r = PageSize.A4;
		Rectangle r2 = null;

		if (vertical) {
			r2 = new Rectangle(r.getWidth(), r.getHeight());
		} else {
			r2 = new Rectangle(r.getHeight(), r.getWidth());
		}

		document.setPageSize(r2);
		document.setMargins(50, 45, 100, 100);
		document.setMarginMirroring(false);

		FileOutputStream foo = new FileOutputStream(new File(rutaFinal));
		PdfWriter writer = PdfWriter.getInstance(document, foo);
		writer.setPageEvent(event);
		document.open();

		float[] colsWidth = new float[cabeceras.size()];

		for (int i = 0; i < colsWidth.length; i++) {
			colsWidth[i] = 1f;
		}

		Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
		Font fontCells = new Font(Font.FontFamily.TIMES_ROMAN, 9);
		PdfPTable table = new PdfPTable(colsWidth);

		table.setHeaderRows(1);

		table.setWidthPercentage(100);
		table.setHorizontalAlignment(Element.ALIGN_LEFT);

		for (String cabecera : cabeceras) {
			Phrase celda = new Phrase(cabecera, boldFont);
			table.addCell(celda);
		}

		for (Object objeto : objetos) {
			for (String atributo : atributos) {
				Phrase celda = new Phrase(BeanUtils.getProperty(objeto, atributo), fontCells);
				table.addCell(celda);
			}
		}

		document.add(table);
		document.close();
	}

	public static DominioArchivo imprimirXML(String titulo, String usuario, List<String> cabeceras,
			List<String> atributos, List<?> objetos, String rutaCompletaXML) throws Exception {
		DominioArchivo dto = new DominioArchivo();
		StringBuilder contenidoXML = new StringBuilder("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>");
		
		contenidoXML.append("<reporte>");
		contenidoXML.append("<nombre>");
		contenidoXML.append(titulo);
		contenidoXML.append("</nombre>");
		contenidoXML.append("<usuario>");
		contenidoXML.append(usuario);
		contenidoXML.append("</usuario>");
		contenidoXML.append("<fecha>");
		contenidoXML.append(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
		contenidoXML.append("</fecha>");
		contenidoXML.append("<registrosEncontrados>");
		contenidoXML.append(objetos.size());
		contenidoXML.append("</registrosEncontrados>");
		contenidoXML.append("<datos>");

		for (Object row : objetos) {
			contenidoXML.append("<item>");
			for (int i = 0; i < cabeceras.size(); i++) {
				contenidoXML.append("<" + atributos.get(i) + ">");
				String val = BeanUtils.getProperty(row, atributos.get(i));
				if (!UString.estaVacio(val)) {
					val = val.replace("&", "&amp;");
					contenidoXML.append(val);
				}
				contenidoXML.append("</" + atributos.get(i) + ">");
			}
			contenidoXML.append("</item>");
		}
		
		contenidoXML.append("</datos>");
		contenidoXML.append("</reporte>");
		
		BufferedWriter writer = Files.newBufferedWriter(Paths.get(rutaCompletaXML), 
                StandardCharsets.ISO_8859_1);
		encode( contenidoXML.toString().getBytes() );
		writer.write(contenidoXML.toString());
		writer.close();
		
		dto = new DominioArchivo();
		dto.setRutaCompleta(rutaCompletaXML);
		dto.setArchivoFile(new File(rutaCompletaXML));
		dto.obtenerMimeType();
		dto.setNombre(dto.getArchivoFile().getName());
		
		return dto;
	}
	
	public static byte[] encode(byte[] arr){
         Charset utf8charset = Charset.forName("UTF-8");
         Charset iso88591charset = Charset.forName("ISO-8859-15");

         ByteBuffer inputBuffer = ByteBuffer.wrap( arr );

         // decode UTF-8
         CharBuffer data = utf8charset.decode(inputBuffer);

         // encode ISO-8559-1
         ByteBuffer outputBuffer = iso88591charset.encode(data);
         byte[] outputData = outputBuffer.array();

         return outputData;
     }
}
