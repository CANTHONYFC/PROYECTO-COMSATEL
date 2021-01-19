package net.royal.spring.framework.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import net.royal.spring.framework.core.dominio.DominioArchivo;
import net.royal.spring.framework.excel.Excel;
import net.royal.spring.framework.excel.reflection.ClassMapper;
import net.royal.spring.framework.pdf.Excel2Pdf;
import net.royal.spring.framework.pdf.ExcelObject;
import net.royal.spring.framework.util.UString;

public class UList {

	public static String rutaTemporal = null;
	
	public static enum FORMATO_EXPORTAR {
	    XLS("XLS"), 
	    PDF("PDF"), 
	    CSV("CSV"), 
	    TXT("TXT"),
	    JSON("JSON");
	    
	    private String formato;
	    private FORMATO_EXPORTAR (String formato){
			this.formato = formato;
		}
		public String getFormato() {
			return formato;
		}
		public void setFormato(String formato) {
			this.formato = formato;
		}	    
	}

	public static String generarNombreAleatorio(String extension) {
		String ruta = "";
		UUID uuid = UUID.randomUUID();
		ruta = uuid.toString();
		if (!UString.esNuloVacio(rutaTemporal))
			ruta = rutaTemporal + File.separator + ruta + "." + extension;		
		else
			ruta = ruta + "." + extension;
		return ruta;
	}


	public static DominioArchivo listToXls(List lstDatos) throws Exception {
		return listToXls(lstDatos,null);
	}
	public static DominioArchivo listToXls(List lstDatos,String[] arrColumnas) throws Exception {
		DominioArchivo dto=new DominioArchivo();
		String rfile = generarNombreAleatorio("xls");
		Excel excelReport = new Excel(rfile,arrColumnas);
		excelReport.write(lstDatos);
		excelReport.close();
		
		
		dto.setRutaCompleta(rfile);
		dto.setArchivoFile(new File(rfile));
		dto.obtenerMimeType();
		dto.setNombre(dto.getArchivoFile().getName());
		return dto;
	}
	
	public static DominioArchivo listToXml(List lstDatos) throws IOException {
		DominioArchivo dto = new DominioArchivo();
		String rfile = generarNombreAleatorio("xml");
		XmlMapper xmlMapper = new XmlMapper();
		String xml = xmlMapper.writeValueAsString(lstDatos);
		
		OutputStream os = new FileOutputStream(rfile); 
		os.write(xml.getBytes()); 
		os.close();
		
		dto.setArchivo(xml.getBytes());
		dto.setRutaCompleta(rfile);
		dto.setArchivoFile(new File(rfile));
		dto.obtenerMimeType();
		dto.setNombre(dto.getArchivoFile().getName());
		return dto;
	}
	
	public static String listToXlsFile(List lstDatos) throws Exception {
		return listToXlsFile(lstDatos,null);
	}
	public static String listToXlsFile(List lstDatos,String[] arrColumnas) throws Exception {
		String rfile = generarNombreAleatorio("xls");
		Excel excelReport = new Excel(rfile,arrColumnas);
		excelReport.write(lstDatos);
		excelReport.close();
		return rfile;
	}
	public static byte[] listToXlsArchivo(List lstDatos) throws Exception {
		return listToXlsArchivo(lstDatos,null);
	}
	public static byte[] listToXlsArchivo(List lstDatos,String[] arrColumnas) throws Exception {
		String rfile = listToXlsFile(lstDatos,arrColumnas);		
		File file = new File(rfile);
		byte[] bytesArray = new byte[(int) file.length()];
		FileInputStream fis = new FileInputStream(file);
		fis.read(bytesArray); 
		fis.close();		
		return bytesArray;
	}

	public static String listToPdfFile(List lstDatos) throws Exception {
		return listToPdfFile(lstDatos,null);
	}
	public static String listToPdfFile(List lstDatos,String[] arrColumnas) throws Exception {
		String rutaCompletaXls = listToXlsFile(lstDatos,arrColumnas);
		//System.out.println(rutaCompletaXls);
		String rutaCompletaPdf = generarNombreAleatorio("pdf");
		File initialFile = new File(rutaCompletaXls);
		InputStream in = new FileInputStream(initialFile);
		Excel2Pdf excel2Pdf = new Excel2Pdf(Arrays.asList(new ExcelObject(in)), new FileOutputStream(rutaCompletaPdf));
		excel2Pdf.convert();
		return rutaCompletaPdf;
	}
	public static byte[] listToPdfByte(List lstDatos) throws Exception {
		return listToPdfByte(lstDatos,null);
	}
	public static byte[] listToPdfByte(List lstDatos,String[] arrColumnas) throws Exception {
		String rfile = listToPdfFile(lstDatos,arrColumnas);
		File file = new File(rfile);
		byte[] bytesArray = new byte[(int) file.length()];
		FileInputStream fis = new FileInputStream(file);
		fis.read(bytesArray); 
		fis.close();		
		return bytesArray;
	}
	
	public static DominioArchivo listToPdf(List lstDatos) throws Exception {
		return listToPdf(lstDatos,null);
	}
	public static DominioArchivo listToPdf(List lstDatos,String[] arrColumnas) throws Exception {
		DominioArchivo dto = new DominioArchivo();
		String rutaCompletaXls = listToXlsFile(lstDatos,arrColumnas);
		//System.out.println(rutaCompletaXls);
		String rutaCompletaPdf = generarNombreAleatorio("pdf");
		File initialFile = new File(rutaCompletaXls);
		InputStream in = new FileInputStream(initialFile);
		Excel2Pdf excel2Pdf = new Excel2Pdf(Arrays.asList(new ExcelObject(in)), new FileOutputStream(rutaCompletaPdf));
		excel2Pdf.convert();

		dto.setRutaCompleta(rutaCompletaPdf);
		dto.setArchivoFile(new File(rutaCompletaPdf));
		dto.obtenerMimeType();
		dto.setNombre(dto.getArchivoFile().getName());
		return dto;
	}
	
	

	public static byte[] listToXmlByte(List lstDatos) throws JsonProcessingException {
		XmlMapper xmlMapper = new XmlMapper();
		String xml = xmlMapper.writeValueAsString(lstDatos);
		//System.out.println(xml);
		return xml.getBytes();
	}

	public static byte[] listToCsvByte(List lstDatos, Class clazz, String[] columnas) throws IOException {
		CsvSchema.Builder builder = CsvSchema.builder();
		for (int i = 0; i < columnas.length; i++) {
			builder.addColumn(columnas[i]);
		}
		CsvMapper mapper = new CsvMapper();
		mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
		CsvSchema schema = builder.build();
		ObjectWriter writer = mapper.writerFor(clazz).with(schema);
		StringWriter sw = new StringWriter();
		writer.writeValues(sw).writeAll(lstDatos);
		return sw.toString().getBytes();
	}
	
	public static DominioArchivo listToCsv(List lstDatos) throws Exception {
		return listToCsv(lstDatos,null);
	}
	public static DominioArchivo listToCsv(List lstDatos,String[] columnas) throws Exception {
		DominioArchivo dto= new DominioArchivo();
		String rutaCompletaCsv = generarNombreAleatorio("csv");
		
		if (lstDatos.size()==0) {
			String str = "";
            File fl = new File(rutaCompletaCsv);
            FileWriter fw = new FileWriter(fl);
            fw.write(str);
            fw.close();
		    
		    dto.setArchivo(str.getBytes());
			dto.setRutaCompleta(rutaCompletaCsv);
			dto.setArchivoFile(fl);
			dto.obtenerMimeType();
			dto.setNombre(dto.getArchivoFile().getName());
			return dto;
		}
		
		Class clazz = null;
		if (columnas==null) {
			ClassMapper classMapper = new ClassMapper();
			List<String> lstColumnas = classMapper.getFieldsForClass(lstDatos.get(0).getClass());
			clazz = lstDatos.get(0).getClass();
			int index=0;
			columnas=new String[lstColumnas.size()];
			for (String col : lstColumnas) {
				columnas[index] = col;
				index++;
			}
		}else {
			clazz = lstDatos.get(0).getClass();
		}
		
		CsvSchema.Builder builder = CsvSchema.builder();
		for (int i = 0; i < columnas.length; i++) {
			builder.addColumn(columnas[i]);
		}
		CsvMapper mapper = new CsvMapper();
		mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
		CsvSchema schema = builder.build();
		ObjectWriter writer = mapper.writerFor(clazz).with(schema);
		
		File fl = new File(rutaCompletaCsv);
		FileWriter sw = new FileWriter(fl);
		writer.writeValues(sw).writeAll(lstDatos);
		sw.close();
		
		dto.setArchivo(sw.toString().getBytes());
		dto.setRutaCompleta(rutaCompletaCsv);
		dto.setArchivoFile(fl);
		dto.obtenerMimeType();
		dto.setNombre(dto.getArchivoFile().getName());
		return dto;
	}
	public static DominioArchivo listToTxt(List lstDatos) throws Exception {
		return listToTxt(lstDatos,null);
	}
	public static DominioArchivo listToTxt(List lstDatos,String[] columnas) throws Exception {
		DominioArchivo dto= new DominioArchivo();
		String rutaCompletaCsv = generarNombreAleatorio("txt");
		
		if (lstDatos.size()==0) {
			String str = "";
            File fl = new File(rutaCompletaCsv);
            FileWriter fw = new FileWriter(fl);
            fw.write(str);
            fw.close();
		    
		    dto.setArchivo(str.getBytes());
			dto.setRutaCompleta(rutaCompletaCsv);
			dto.setArchivoFile(fl);
			dto.obtenerMimeType();
			dto.setNombre(dto.getArchivoFile().getName());
			return dto;
		}
		
		Class clazz = null;
		if (columnas==null) {
			ClassMapper classMapper = new ClassMapper();
			List<String> lstColumnas = classMapper.getFieldsForClass(lstDatos.get(0).getClass());
			clazz = lstDatos.get(0).getClass();
			int index=0;
			columnas=new String[lstColumnas.size()];
			for (String col : lstColumnas) {
				columnas[index] = col;
				index++;
			}
		}else {
			clazz = lstDatos.get(0).getClass();
		}
		
		CsvSchema.Builder builder = CsvSchema.builder();
		for (int i = 0; i < columnas.length; i++) {
			builder.addColumn(columnas[i]);
		}
		CsvMapper mapper = new CsvMapper();
		mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
		CsvSchema schema = builder.build();
		ObjectWriter writer = mapper.writerFor(clazz).with(schema);
		
		File fl = new File(rutaCompletaCsv);
		FileWriter sw = new FileWriter(fl);
		writer.writeValues(sw).writeAll(lstDatos);
		sw.close();
		
		dto.setArchivo(sw.toString().getBytes());
		dto.setRutaCompleta(rutaCompletaCsv);
		dto.setArchivoFile(fl);
		dto.obtenerMimeType();
		dto.setNombre(dto.getArchivoFile().getName());
		return dto;
	}
	
	
	
	public static byte[] listToCsvByte(List lstDatos) throws Exception{
		String rfile = listToCsvFile(lstDatos);
		File file = new File(rfile);
		byte[] bytesArray = new byte[(int) file.length()];
		FileInputStream fis = new FileInputStream(file);
		fis.read(bytesArray); 
		fis.close();		
		return bytesArray;
	}
	
	public static String listToCsvFile(List lstDatos) throws Exception{
		String rutaCompletaCsv = generarNombreAleatorio("csv");
		Writer writer2 = new FileWriter(rutaCompletaCsv);
		StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer2).build();
		beanToCsv.write(lstDatos);
		writer2.close();
		return rutaCompletaCsv;
	}
	
	public static String listToTxtFile(List lstDatos) throws Exception{
		String rutaCompletaCsv = generarNombreAleatorio("txt");
		Writer writer2 = new FileWriter(rutaCompletaCsv);
		StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer2).build();
		beanToCsv.write(lstDatos);
		writer2.close();
		return rutaCompletaCsv;
	}

	public static byte[] listToTxtByte(List lstDatos) throws Exception{
		String rfile = listToTxtFile(lstDatos);
		File file = new File(rfile);
		byte[] bytesArray = new byte[(int) file.length()];
		FileInputStream fis = new FileInputStream(file);
		fis.read(bytesArray); 
		fis.close();		
		return bytesArray;
	}
	
	public static byte[] listToTxt(List lstDatos, Class clazz, String[] columnas) throws IOException {
		CsvSchema.Builder builder = CsvSchema.builder();
		for (int i = 0; i < columnas.length; i++) {
			builder.addColumn(columnas[i]);
		}
		CsvMapper mapper = new CsvMapper();
		mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
		CsvSchema schema = builder.build();
		ObjectWriter writer = mapper.writerFor(clazz).with(schema);
		StringWriter sw = new StringWriter();
		writer.writeValues(sw).writeAll(lstDatos);
		return sw.toString().getBytes();
	}
	
	public static byte[] listToJson(List lstDatos) throws Exception{
		String rfile = listToTxtFile(lstDatos);
		File file = new File(rfile);
		byte[] bytesArray = new byte[(int) file.length()];
		FileInputStream fis = new FileInputStream(file);
		fis.read(bytesArray); 
		fis.close();		
		return bytesArray;
	}
}
