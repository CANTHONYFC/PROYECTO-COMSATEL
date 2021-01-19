package net.royal.spring.framework.excel;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import net.royal.spring.framework.excel.reflection.ClassMapper;

//@Log4j
public class Excel {
	private String[] columnas = null;
	private ExcelWorkbook workbook = null;
	private List<String> fieldNames = new ArrayList<String>();
	
	private final ClassMapper classMapper = new ClassMapper();
	
	public ClassMapper getClassMapper() {
		return classMapper;
	}
	
	public List<String> getFieldNames() {
		return fieldNames;
	}
	
	public ExcelWorkbook getWorkbook() {
		return workbook;
	}
	
	public Excel(String workbookName,String[] columnas) throws InvalidFormatException, IOException {
		this.workbook = new ExcelWorkbook(workbookName);
		this.columnas=columnas;
		new File(workbookName);
	}
	
	public Excel(String workbookName) throws InvalidFormatException, IOException {
		this.workbook = new ExcelWorkbook(workbookName);
		new File(workbookName);
	}

	/**
	 * Lê arquivo EXCEL, sendo que encontra a planilha certa para o objeto pelo ClassName.
	 * Exemplo: quero ler uma planilha para carregar um objeto da classe com.totvs.fluig.User, logo
	 * 	a planilha no arquivo deverá ter o nome com.totvs.fluig.User.
	 * @param className String
	 * @return objectList List<T>
	 * @throws Exception 
	 */
	public <T> List<T> read(String className) throws Exception {
		return read(className, className);
	}
	
	/**
	 * Lê arquivo EXCEL, sendo que encontra a planilha pelo sheetName e carrega objetos de acordo com o className.
	 * @param className String
	 * @param sheetName String
	 * @return objectList List<T>
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> read(String className, String sheetName) throws Exception {
		this.getWorkbook().initializeForRead();
		//log.debug(this.getWorkbook().toString() + " - " + (this.getWorkbook() == null));
		//log.debug(this.getWorkbook().getSheetByName(sheetName) + " - " + sheetName);
		Sheet sheet = this.getWorkbook().getSheetByName(sheetName);

		List<T> result = new ArrayList<T>();
		if(sheet!=null){
			//log.info("The sheet is: " + sheet.getSheetName());
			@SuppressWarnings("rawtypes")
			Class clazz = Class.forName(className);
			this.fieldNames = this.getClassMapper().getFieldsForClass(clazz);
			
			Row row;
			for (int rowCount = 1; rowCount < 4; rowCount++) {
				T one = (T) clazz.newInstance();
				row = sheet.getRow(rowCount);
				int colCount = 0;
				result.add(one);
				for (Cell cell : row) {
					int type = cell.getCellType();
					String fieldName = fieldNames.get(colCount++);
					//log.debug("Method: set" + StringUtil.capitalize(fieldName));
					//log.debug("Cell type: " + type);
					
					Method method = null;
					method = this.getClassMapper().setMethod(clazz, fieldName);
					
					if (type ==  1) {
						String value = cell.getStringCellValue();
						Object[] values = new Object[1];
						values[0] = value;
						//log.debug("METHOD = " + (method == null) + " - one = " + (one == null) + " - value = " + (values == null));
						//log.debug("METHOD = " + method.getName() + " - one = " + one.toString() + " - value = " + values[0]);
						method.invoke(one, values);
					} else if (type == 0) {
						Double num = cell.getNumericCellValue();
	                    Class<?> returnType = this.getClassMapper().getGetterReturnClass(clazz,fieldName);
	                    if(returnType == Integer.class){
	                    	method.invoke(one, num.intValue());
	                    } else if(returnType == Double.class){
	                    	method.invoke(one, num);
	                    } else if(returnType == Float.class){
	                    	method.invoke(one, num.floatValue());
	                    }
	
					} else if (type == 3) {
						double num = cell.getNumericCellValue();
						Object[] values = new Object[1];
						values[0] =num;
						method.invoke(one, values);
					}
				}
			}
	
			//log.info("The result set contains: " + result.size() + " items.");
		}
		return result;
	}

	/**
	 * Gera arquivo EXCEL, sendo que define a planilha
	 * e gera dados de acordo com a classe do primeiro objeto da lista.
	 * @param data List<T>
	 * @throws Exception 
	 */
	public <T> void write(List<T> data) throws Exception {
		write(data.get(0).getClass().getName(), data);
	}
	
	/**
	 * Gera arquivo EXCEL, sendo que define a planilha pelo sheetName 
	 * e gera dados de acordo com a classe do primeiro objeto da lista.
	 * @param data List<T>
	 * @throws Exception 
	 */
	public <T> void write(String sheetName, List<T> data) throws Exception {
		Sheet sheet = this.getWorkbook().getWorkbook().createSheet(sheetName);
		this.fieldNames = this.getClassMapper().getFieldsForClass(data.get(0).getClass());
		// Create a row and put some cells in it. Rows are 0 based.
		int rowCount = 0;
		int columnCount = 0;

		Row row = sheet.createRow(rowCount++);
		//log.debug("FIELD NAMES SIZE - " + this.fieldNames.size());
		if (columnas!=null) {
			if (columnas.length>0) {
				this.fieldNames.clear();
				for (int i = 0; i < this.columnas.length; i++) {
					this.fieldNames.add(this.columnas[i]);		
				}
			}	
		}
				
		for (String fieldName : this.fieldNames) {
			Cell cel = row.createCell(columnCount++);
			cel.setCellValue(fieldName);
		}
		Class<? extends Object> clazz = data.get(0).getClass();
		for (T t : data) {
			row = sheet.createRow(rowCount++);
			columnCount = 0;
			for (String fieldName : this.fieldNames) {
				Cell cel = row.createCell(columnCount);
				Method method = null;
				try{
//					 method = classz.getMethod("get" + StringUtil.capitalize(fieldName));
					method = this.classMapper.getMethod(clazz, fieldName);
				} catch (NoSuchMethodException e){
					//log.warn("NoSuchMethod: " + e.getMessage() + " - " + e.getMessage().endsWith("Logger()"));
					if(!e.getMessage().endsWith("Logger()")){
						throw e;
					}
					else{
						continue;
					}
				}
				Object value = method.invoke(t, (Object[]) null);
				if (value != null) {
					if (value instanceof String) {
						cel.setCellValue((String) value);
					} else if (value instanceof Long) {
						cel.setCellValue((Long) value);
					} else if (value instanceof Integer) {
						cel.setCellValue((Integer)value);
					}else if (value instanceof Double) {
						cel.setCellValue((Double) value);
					} else {
						cel.setCellValue(value.toString());
					}
				}
				columnCount++;
			}
		}
	}
	
	/**
	 * Libera memória dos streams para não ocorrer leak (estouro).
	 */
	public void close() {
		this.getWorkbook().closeWorksheet();
	}
}