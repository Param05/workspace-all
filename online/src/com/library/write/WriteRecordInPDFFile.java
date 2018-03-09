package com.library.write;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.library.model.Book;
import com.library.model.Loan;

public class WriteRecordInPDFFile {
	public static void main(String[] args) {
		Loan loan = new Loan();
		Book book = new Book();
		book.setBookName("java");
		book.setBookName("jav2");
		loan.setBook(book);
		List<Loan> list = new ArrayList<>();
		list.add(loan);
		// printReport.createPDF("E://poc/online/booksDetails.pdf", list);

	}

	public void createPDF(String pdfFilename, List<Loan> loan) {
		Document doc = new Document();
		PdfWriter docWriter = null;

		try {

			// special font sizes
			Font headerFont = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(135, 206, 250));
			Font dataFont = new Font(FontFamily.TIMES_ROMAN, 12);

			// file path
			String path = pdfFilename;
			docWriter = PdfWriter.getInstance(doc, new FileOutputStream(path));

			// open document
			doc.open();

			// create a paragraph
			Paragraph paragraph = new Paragraph("Books List");

			PdfPTable table = new PdfPTable(8);
			// set table width a percentage of the page width
			table.setWidthPercentage(90f);

			// insert column headings
			insertCell(table, "ISBN", Element.ALIGN_RIGHT, 1, headerFont);
			insertCell(table, "Book Name", Element.ALIGN_LEFT, 1, headerFont);
			insertCell(table, "Edision Name", Element.ALIGN_LEFT, 1, headerFont);
			insertCell(table, "Author", Element.ALIGN_CENTER, 1, headerFont);
			insertCell(table, "Publisher", Element.ALIGN_CENTER, 1, headerFont);
			insertCell(table, "Genre", Element.ALIGN_CENTER, 1, headerFont);
			insertCell(table, "Assigned To", Element.ALIGN_CENTER, 1, headerFont);
			insertCell(table, "Date of Issue", Element.ALIGN_CENTER, 1, headerFont);
			table.setHeaderRows(1);

			for (Loan loanDetails : loan) {
				insertCell(table, String.valueOf(loanDetails.getId()), Element.ALIGN_RIGHT, 1, dataFont);
				insertCell(table, loanDetails.getBook().getBookName(), Element.ALIGN_RIGHT, 1, dataFont);
				insertCell(table, String.valueOf(loanDetails.getBook().getEdision()), Element.ALIGN_RIGHT, 1, dataFont);
				insertCell(table, loanDetails.getBook().getAuthor().getAuthorFirstName(), Element.ALIGN_RIGHT, 1,
						dataFont);
				insertCell(table, loanDetails.getBook().getBookPublisherID().getPublisherName(), Element.ALIGN_RIGHT, 1,
						dataFont);
				insertCell(table, loanDetails.getBook().getGenre().getGenreName(), Element.ALIGN_RIGHT, 1, dataFont);
				insertCell(table, loanDetails.getStudent().getStudentFirstName(), Element.ALIGN_RIGHT, 1, dataFont);
				insertCell(table, String.valueOf(loanDetails.getDateOfIssue()), Element.ALIGN_RIGHT, 1, dataFont);
			}
			paragraph.add(table);
			doc.add(paragraph);

		} catch (

		DocumentException dex) {
			dex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (doc != null) {
				// close the document
				doc.close();
			}
			if (docWriter != null) {
				// close the writer
				docWriter.close();
			}
		}
	}

	private void insertCell(PdfPTable table, String text, int align, int colspan, Font font) {

		PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
		cell.setHorizontalAlignment(align);
		cell.setColspan(colspan);
		// cell.setBackgroundColor(new BaseColor(135, 206, 250));
		if (text.trim().equalsIgnoreCase("")) {
			cell.setMinimumHeight(10f);
		}
		table.addCell(cell);

	}

}
