package com.library.write;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFAutoFilter;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.library.model.Loan;

public class WriteRecordInExcelFile {
	private final static short MY_LIGHT_BLUE = HSSFColor.LIGHT_BLUE.index;
	private final static short MY_LIGHT_GREEN = HSSFColor.LIGHT_GREEN.index;
	private final static short MY_LIGHT_RED = HSSFColor.RED.index;

	public void writeData(String fileName, List<Loan> loan) throws IOException, ParseException {

		XSSFWorkbook workbook = null;
		if (fileName.endsWith("xlsx")) {
			workbook = new XSSFWorkbook();
		} else {
			System.out.println("Not found any file");
		}

		XSSFFont fontBold = workbook.createFont();
		fontBold.setFontHeightInPoints((short) 12);
		fontBold.setFontName("Calibri");
		fontBold.setBold(true);

		CellStyle style = workbook.createCellStyle();

		style.setFillForegroundColor(MY_LIGHT_BLUE);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setFont(fontBold);

		String[][] headerOfLoan = {
				{ "ISBN", "BookName", "Edision", "Author", "Publisher", "Genre", "Assigned To", "Date of Issue" } };
		CreationHelper createHelper = workbook.getCreationHelper();
		Sheet sheet = workbook.createSheet("BookList");
		int rowCount = 0;
		for (String[] header : headerOfLoan) {
			Row row = sheet.createRow(0);
			int colNum = 0;
			for (String value : header) {
				Cell cell = row.createCell(colNum++);
				sheet.setColumnWidth(colNum, 5000);
				cell.setCellStyle(style);
				cell.setCellValue(value);
			}
			for (Loan loanDetails : loan) {

				row = sheet.createRow(++rowCount);
				Cell cell = row.createCell(0);
				cell.setCellValue(loanDetails.getBook().getBookId());
				cell = row.createCell(1);

				cell.setCellValue(loanDetails.getBook().getBookName());
				cell = row.createCell(2);
				cell.setCellValue(loanDetails.getBook().getEdision());
				cell = row.createCell(3);
				cell.setCellValue(loanDetails.getBook().getAuthor().getAuthorFirstName());
				cell = row.createCell(4);
				cell.setCellValue(loanDetails.getBook().getBookPublisherID().getPublisherName());
				cell = row.createCell(5);
				cell.setCellValue(loanDetails.getBook().getGenre().getGenreName());

				cell = row.createCell(6);
				cell.setCellValue(loanDetails.getStudent().getStudentFirstName());
				CellStyle cellStyle = workbook.createCellStyle();
				cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd"));

				Date dateOfIssue = loanDetails.getDateOfIssue();

				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				Date currentDate = format.parse(timeStamp);
				long difference = currentDate.getTime() - dateOfIssue.getTime();
				long diffDays = difference / (24 * 60 * 60 * 1000);
				if (diffDays < 14) {
					cell = row.createCell(7);
					cell.setCellValue(loanDetails.getDateOfIssue());
					cellStyle.setFillForegroundColor(MY_LIGHT_GREEN);
					cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
					cell.setCellStyle(cellStyle);

				} else {
					cell = row.createCell(7);
					cell.setCellValue(loanDetails.getDateOfIssue());
					cellStyle.setFillForegroundColor(MY_LIGHT_RED);
					cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
					cell.setCellStyle(cellStyle);
				}

			}
		}

		XSSFSheet mySheet = workbook.getSheetAt(0);
		XSSFAutoFilter autoFilter = mySheet.setAutoFilter(CellRangeAddress.valueOf("A1:H1"));
		FileOutputStream fos = new FileOutputStream(fileName);
		workbook.write(fos);
		fos.close();
		System.out.println(autoFilter);
	}

}
