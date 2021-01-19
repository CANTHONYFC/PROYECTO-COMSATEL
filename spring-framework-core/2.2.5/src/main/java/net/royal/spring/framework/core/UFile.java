package net.royal.spring.framework.core;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.lowagie.text.pdf.PdfReader;

import net.royal.spring.framework.util.UFechaHora;
import net.royal.spring.framework.util.UString;

public class UFile {

	private static final Log LOGGER = LogFactory.getLog(UFile.class);

	public static String rutaFisicaWebServer() {		
		return rutaFisicaWeb("webserver");
	}
	public static String rutaFisicaWebApp() {		
		String rutaWS = System.getProperty("user.dir");
		String sos = System.getProperty("os.name");
		//String rutaIo = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
		//String rutaPA = Paths.get("").toAbsolutePath().toString();
		//System.out.println("rutaWS:"+rutaWS);
		//System.out.println("rutaIo:"+rutaIo);
		//System.out.println("rutaPA:"+rutaPA);
		//System.out.println("sos:"+sos);
		
		String search = File.separator + "bin";
		int index = rutaWS.lastIndexOf(search);
		if (index>-1) {
			//System.out.println("cuando es bin:windows");
			rutaWS = rutaWS.substring(0, index);
			// esto se aplica cuando va en un tomcat
			//System.out.println(rutaWS);
			return rutaWS;
		}
		
		//System.out.println("h3 -api:windows");
		search = "-api";
		index = rutaWS.lastIndexOf(search);
		if (index>-1) {
			//System.out.println("cuando es -api:windows");
			index = rutaWS.lastIndexOf(File.separator);
			rutaWS = rutaWS.substring(0, index);
			// esto se aplica cuando va en un tomcat
			//System.out.println(rutaWS);
			return rutaWS;
		}
		
		//System.out.println("h4 TOMCAT");
		search = "TOMCAT";
		index = rutaWS.toUpperCase().lastIndexOf(search);
		if (index>-1) {
			//System.out.println("cuando es TOMCAT");
			rutaWS = rutaWS + File.separator + "webapps";
			//System.out.println(rutaWS);
			return rutaWS;
		}
		
		//System.out.println("h5 jar eclipse:boot");
		int jarIndex = rutaWS.lastIndexOf(File.separator);
		if (jarIndex>-1) {
			//System.out.println("cuando es un jar eclipse:boot");
			// esto se aplica cuando es un jar
			if (sos.contains("Windows")) {
				//System.out.println("windows");
				rutaWS = rutaWS.substring(0, jarIndex);
				//System.out.println(rutaWS);
			}	else {
				//System.out.println("linux");
			}
			return rutaWS;
		}
		return rutaWS;
	}
	private static String rutaFisicaWeb(String tipo) {		
		//System.out.println("h1 main");
		String sos = System.getProperty("os.name");
		//System.out.println("sos");
		//System.out.println(sos);
		//System.out.println(System.getProperty("os.arch"));
		if (UString.esNuloVacio(tipo))
			return null;
		String rutaWS = System.getProperty("user.dir");
		//System.out.println("rutaWS");
		//System.out.println(rutaWS);
		if (tipo.equals("webserver")) {
			//System.out.println("h2 webserver devolviendo");
			//System.out.println(rutaWS);
			String search = File.separator + "bin";
			int index = rutaWS.lastIndexOf(search);
			if (index>-1) {
				//System.out.println("cuando es bin:windows");
				rutaWS = rutaWS.substring(0, index);
				// esto se aplica cuando va en un tomcat
				//System.out.println(rutaWS);
				return rutaWS;
			}
			
			//System.out.println("h3 -api:windows");
			search = "-api";
			index = rutaWS.lastIndexOf(search);
			if (index>-1) {
				//System.out.println("cuando es -api:windows");
				index = rutaWS.lastIndexOf(File.separator);
				rutaWS = rutaWS.substring(0, index);
				// esto se aplica cuando va en un tomcat
				//System.out.println(rutaWS);
				return rutaWS;
			}
			
			//System.out.println("h4 TOMCAT");
			search = "TOMCAT";
			index = rutaWS.toUpperCase().lastIndexOf(search);
			if (index>-1) {
				//System.out.println("cuando es TOMCAT");
				//System.out.println(rutaWS);
				return rutaWS;
			}
			
			//System.out.println("h5 jar eclipse:boot");
			int jarIndex = rutaWS.lastIndexOf(File.separator);
			if (jarIndex>-1) {
				//System.out.println("cuando es un jar eclipse:boot");
				// esto se aplica cuando es un jar
				if (sos.contains("Windows")) {
					//System.out.println("windows");
					rutaWS = rutaWS.substring(0, jarIndex);
					//System.out.println(rutaWS);
				}	else {
					//System.out.println("linux");
				}
				return rutaWS;
			}
			return rutaWS;
		}
		if (tipo.equals("webcontext")) {
			
		}
		if (tipo.equals("webapp")) {
			
		}
		return null;
	}
	public static Boolean existeArchivo(String ruta, String archivo){
		File f = new File(UString.obtenerSinNulo(ruta) + File.separator + UString.obtenerSinNulo(archivo));
		return f.exists();
	}
	
	public static Boolean exists(String rutaCompleta) {
		if (UString.estaVacio(rutaCompleta))
			return false;
		return Files.exists(Paths.get(rutaCompleta));
	}

	public static Properties leerPropiedades(String file) {

		InputStream input = UFile.class.getClassLoader().getResourceAsStream(file);
		Properties appProps = new Properties();
		try {
			appProps.load(input);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return appProps;
	}

	public static String extraerNombreArchivo(String fileName) {
		String extension = "";
		if (fileName == null)
			return null;
		int i = fileName.lastIndexOf(File.separator);
		if (i > 0) {
			extension = fileName.substring(i + 1);
		}
		return extension;
	}

	public static String extraerExtension(String fileName) {
		String extension = "";
		if (fileName == null)
			return null;
		int i = fileName.lastIndexOf('.');
		if (i > 0) {
			extension = fileName.substring(i + 1);
		}
		return extension;
	}

	// public static String obtenerRutaAbsoluta(String rutaRelativa) throws
	// IOException {
	// Resource resource = new ClassPathResource(rutaRelativa);
	// return resource.getFile().getAbsolutePath();
	// }
	
	/*public static String obtenerRutaActual() throws IOException {
		return new java.io.File(".").getCanonicalPath();
	}*/

	public static boolean carpetaBorrar(File folder) {
		if (folder.isDirectory()) {
			String[] children = folder.list();
			for (int i = 0; i < children.length; i++) {
				LOGGER.debug(">>> Iterando file " + i);
				boolean success = carpetaBorrar(new File(folder, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		LOGGER.debug("Carpeta borrada satisfactoriamente");
		return folder.delete();
	}

	public static boolean archivoBorrar(String rutaCumpleta) {
		File fichero = new File(rutaCumpleta);
		if (!fichero.exists())
			return false;
		return fichero.delete();
	}

	/**
	 * incluye la ruta desde la raiz, web
	 * 
	 * @return
	 */

	public static String getInputStreamToString(InputStream is) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();
	}

	public static String getSeparador() {
		return File.separator;
	}

	public static String archivoUnico() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmssSSS");
		String nombreCarpetaSession = df.format(new Date());
		return nombreCarpetaSession;
	}

	public static String copiarArchivoGeneral(String archiv, byte[] archivo, String opcion, String extension,
			String ruta) {

		if (UValidador.estaVacio(opcion)) {
			opcion = "";
		}
		if (!UValidador.estaVacio(extension)) {
			archiv = archiv + "." + extension;
		}

		InputStream stream;

		try {

			byte[] bytes = new byte[1024];
			bytes = archivo;

			LOGGER.debug("archivo copiar::" + archiv);
			stream = new ByteArrayInputStream(bytes);

			File targetFolder = new File(ruta + UFile.getSeparador() + opcion);
			OutputStream out = new FileOutputStream(new File(targetFolder, archiv));

			int read = 0;

			while ((read = stream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			stream.close();
			out.flush();
			out.close();

		} catch (Exception e) {
			LOGGER.error(e);
		}
		return archiv;

	}

	public static String obtenerContenidoFile(String rutaArchivo) throws IOException {

		StringBuilder contenido = new StringBuilder("");

		File archivo = new File(rutaArchivo);

		if (archivo.exists()) {
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);

			String linea;
			while ((linea = br.readLine()) != null)
				contenido.append(linea);

			fr.close();
		}

		return contenido.toString();
	}

	public static byte[] obtenerArregloByte(String ruta) {
		byte[] bytesrespaldo = null;
		File file = new File(ruta);

		try {
			//LOGGER.debug("entro a try");
			FileInputStream fis = new FileInputStream(file);
			//LOGGER.debug("file::" + file.getName());
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];

			for (int readNum; (readNum = fis.read(buf)) != -1;) {
				bos.write(buf, 0, readNum);
			}
			byte[] bytes = bos.toByteArray();
			//LOGGER.debug("bytes::" + bytes);
			bytesrespaldo = bytes;
			fis.close();
		} catch (Exception e) {
			LOGGER.error(e);
		}

		return bytesrespaldo;
	}

	public static byte[] obtenerArregloByte(InputStream input) throws IOException {
		byte[] buffer = new byte[8192];
		int bytesRead;
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		while ((bytesRead = input.read(buffer)) != -1) {
			output.write(buffer, 0, bytesRead);
		}
		return output.toByteArray();
	}

	public static void guardarContenidoFile(String rutaArchivo, String contenidoCadena) throws IOException {

		File archivo = new File(rutaArchivo);

		FileWriter fichero = new FileWriter(archivo);
		PrintWriter pw = new PrintWriter(fichero);

		pw.println(contenidoCadena);

		fichero.close();
	}

	public static void guardarContenidoFile(String rutaComleta, byte[] archivo) throws IOException {
		WriteFile w = new WriteFile(rutaComleta, archivo);
		w.start();
	}
	
	public static void guardarContenidoFileByte(String rutaComleta, byte[] archivo) throws IOException {
		WriteFile w = new WriteFile(rutaComleta, archivo);
		w.start();
	}

	/**
	 * Crea un documento f�sico en la carpeta temporal de la aplicaci�n.
	 * 
	 * @param ruta    directorio de carpeta
	 * @param nombre  nombre del documento
	 * @param archivo bytes del documento
	 * @throws IOException
	 */
	public static void guardarContenidoFile(String ruta, String nombre, byte[] archivo) throws IOException {
		File uploadedFile = new File(ruta + File.separator + nombre);
		if (uploadedFile.exists()) {
			uploadedFile.delete();
		}

		byte[] bytes = new byte[1024];
		bytes = archivo;

		new File(ruta + File.separator).mkdirs();

		Path path = Paths.get(ruta + File.separator + nombre);
		Files.write(path, bytes);

		/*
		 * InputStream stream;
		 * 
		 * byte[] bytes = new byte[1024]; bytes = archivo;
		 * 
		 * LOGGER.debug("archivo copiar::" + nombre); stream = new
		 * ByteArrayInputStream(bytes);
		 * 
		 * OutputStream out = new FileOutputStream(uploadedFile);
		 * 
		 * int read = 0;
		 * 
		 * while ((read = stream.read(bytes)) != -1) { out.write(bytes, 0, read); }
		 * stream.close(); out.flush(); out.close();
		 */

	}

	public static String verArchivo(byte data[], String nombreArchivo, HttpServletResponse response) throws Exception {

		response.setHeader("Content-Disposition", "attachment;filename=" + nombreArchivo);
		ServletOutputStream ouputStream = response.getOutputStream();
		ouputStream.write(data);
		ouputStream.flush();
		ouputStream.close();

		return null;
	}
	
	public static Boolean existeArchivo(String ruta){
		File f = new File(UString.obtenerSinNulo(ruta));
		return f.exists();
	}
	
	public static void eliminarArchivo(String archivo){

	     File fichero = new File(archivo);
	   
	     if(fichero.delete()){

	          System.out.println("archivo eliminado");
	    
	     }

	}   

	public static HashMap<String, Object> obtenerMetadata(byte[] archivo, String nombre) throws Exception {

		HashMap<String, Object> resultado = new HashMap<>();
		String extension = nombre.substring(nombre.lastIndexOf(".") + 1, nombre.length());

		// SI ES UN PDF
		if (extension.equals(UConstante.CONSTANTE_NOMBRE_EXTENSION_PDF)) {
			PdfReader lector = new PdfReader(archivo);
			@SuppressWarnings("unchecked")
			HashMap<String, Object> info = lector.getInfo();

			if (!info.isEmpty()) {
				resultado.put("TITULO", info.get("Title"));
				resultado.put("AUTOR", info.get("Author"));
				resultado.put("ASUNTO", info.get("Subject"));
				resultado.put("COMENTARIOS", info.get("Keywords"));
				resultado.put("UBICACION", null);
				resultado.put("TAMANIO", lector.getFileLength());
				resultado.put("NROPAGINAS", lector.getNumberOfPages());

				String fechac = UValidador.estaVacio(info.get("CreationDate")) ? null
						: (String) info.get("CreationDate");
				String fecham = UValidador.estaVacio(info.get("ModDate")) ? null : (String) info.get("ModDate");

				if (!UValidador.estaVacio(fechac)) {
					fechac = fechac.substring(fechac.indexOf(":") + 1, 16);
					resultado.put("FECHACREACION", UFechaHora.convertirCadenaFecha(fechac, "ddMMyyyyHHmmss"));

				}

				if (!UValidador.estaVacio(fecham)) {
					fecham = fecham.substring(fecham.indexOf(":") + 1, 16);
					resultado.put("FECHAMODIFICACION", UFechaHora.convertirCadenaFecha(fecham, "ddMMyyyyHHmmss"));
				}
			}
		}
		// SI ES UN WORD
		if (extension.equals(UConstante.CONSTANTE_NOMBRE_EXTENSION_WORD)) {
		}
		// SI ES UN EXCEL
		if (extension.equals(UConstante.CONSTANTE_NOMBRE_EXTENSION_EXCEL)) {
		}
		// SI ES UN TXT
		if (extension.equals(UConstante.CONSTANTE_NOMBRE_EXTENSION_TXT)) {
		}

		return resultado;

	}

	public void cargarArchivoXByte(byte[] cuerpo, String nombrePdf, String directorio, String realPath)
			throws Exception {
		InputStream stream;

		LOGGER.debug("PATH:" + realPath + UFile.getSeparador() + directorio);

		byte[] bytes = new byte[1024];
		bytes = cuerpo;

		stream = new ByteArrayInputStream(bytes);

		File targetFolder = new File(realPath + UFile.getSeparador() + directorio);
		OutputStream out = new FileOutputStream(new File(targetFolder, nombrePdf));
		int read = 0;

		while ((read = stream.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		stream.close();
		out.flush();
		out.close();

	}

	public static String binaryToString(byte[] bytes) {
		try {
			return new String(bytes, 0, bytes.length, "ASCII");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String htmlBasicStructure = "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>Mensaje</title></head><body><!DOCTYPE html><html lang=\"es\"><head><meta charset=\"UTF-8\"/></head><body>[REPLACE]</body></html>";

}

class WriteFile extends Thread {

	String rutaComleta;
	byte[] archivo;

	public WriteFile(String rutaComleta, byte[] archivo) {
		this.rutaComleta = rutaComleta;
		this.archivo = archivo;
	}

	@Override
	public void run() {
		try {
			File uploadedFile = new File(rutaComleta);
			if (uploadedFile.exists()) {
				uploadedFile.delete();
			}
			InputStream stream;

			byte[] bytes = new byte[1024];
			bytes = archivo;

			stream = new ByteArrayInputStream(bytes);

			OutputStream out;

			out = new FileOutputStream(uploadedFile);

			int read = 0;

			while ((read = stream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			stream.close();
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
