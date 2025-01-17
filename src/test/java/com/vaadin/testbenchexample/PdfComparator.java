package com.vaadin.testbenchexample;

import java.io.File;
import java.util.logging.Logger;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.util.logging.Logger;

public class PdfComparator {
	private static final Logger logger = Logger.getLogger(PdfComparator.class.getName());

	// Method to compare two PDFs while ignoring date patterns
	public static boolean comparePdfTextIgnoringDates(File file1, File file2) throws Exception {
		// Load both PDFs
		PDDocument pdf1 = PDDocument.load(file1);
		PDDocument pdf2 = PDDocument.load(file2);

		// Extract text from PDFs
		String text1 = new PDFTextStripper().getText(pdf1);
		String text2 = new PDFTextStripper().getText(pdf2);

		// Close the documents
		pdf1.close();
		pdf2.close();

		// Remove dates from the extracted text
		String cleanText1 = removeDates(text1);
		String cleanText2 = removeDates(text2);

		// Compare the cleaned text and log the differences if they don't match
		if (!cleanText1.equals(cleanText2)) {
			logger.severe("PDFs do not match. Showing differences:");
			showTextDifferences(cleanText1, cleanText2);
			return false;
		}

		return true;
	}

	// Method to remove date patterns, including "Month Day, Year"
	private static String removeDates(String text) {
		// Regex pattern for dates like "dd/MM/yyyy", "MM-dd-yyyy", and "Month Day, Year"
		String datePattern = "(\\d{2}/\\d{2}/\\d{4})" +             // Matches "dd/MM/yyyy"
							 "|(\\d{2}-\\d{2}-\\d{4})" +            // Matches "MM-dd-yyyy"
							 "|((January|February|March|April|May|June|July|August|September|October|November|December) \\d{1,2}, \\d{4})";  // Matches "Month Day, Year"

		// Remove all detected date patterns
		return text.replaceAll(datePattern, "");
	}

	// Utility method to log text differences between two strings
	private static void showTextDifferences(String text1, String text2) {
		String[] lines1 = text1.split("\\r?\\n");
		String[] lines2 = text2.split("\\r?\\n");

		for (int i = 0; i < Math.max(lines1.length, lines2.length); i++) {
			String line1 = i < lines1.length ? lines1[i] : "";
			String line2 = i < lines2.length ? lines2[i] : "";

			if (!line1.equals(line2)) {
				logger.severe("Difference found on line " + (i + 1) + ":");
				logger.severe("File 1: " + line1);
				logger.severe("File 2: " + line2);
			}
		}
	}
}

