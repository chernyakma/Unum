package com.vaadin.testbenchexample;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

	public static List<String[]> readExcelData(String filePath) {
		List<String[]> data = new ArrayList<>();
		try (FileInputStream file = new FileInputStream(filePath)) {
			Workbook workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheetAt(0);
			DecimalFormat df = new DecimalFormat("#"); // To format numeric values as plain text
			df.setMaximumFractionDigits(8); // Set maximum fraction digits to prevent scientific notation
			for (Row row : sheet) {
				List<String> rowData = new ArrayList<>();
				for (Cell cell : row) {
					switch (cell.getCellType()) {
						case STRING:
							rowData.add(cell.getStringCellValue());
							break;
						case NUMERIC:
							// Use DecimalFormat to get the exact numeric value as a string
							rowData.add(df.format(cell.getNumericCellValue()));
							break;
						case BOOLEAN:
							rowData.add(String.valueOf(cell.getBooleanCellValue()));
							break;
						case FORMULA:
							// Evaluate formula and get the result as a string
							FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
							CellValue cellValue = evaluator.evaluate(cell);
							switch (cellValue.getCellType()) {
								case STRING:
									rowData.add(cellValue.getStringValue());
									break;
								case NUMERIC:
									rowData.add(df.format(cellValue.getNumberValue()));
									break;
								case BOOLEAN:
									rowData.add(String.valueOf(cellValue.getBooleanValue()));
									break;
								default:
									rowData.add("");
							}
							break;
						default:
							rowData.add("");
					}
				}
				data.add(rowData.toArray(new String[0]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}
