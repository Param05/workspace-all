package com.library.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.model.Loan;
import com.library.service.IDownloadService;
import com.library.write.WriteRecordInExcelFile;
import com.library.write.WriteRecordInPDFFile;

@RestController
public class DownloadBooksLoanStudentController {

	@Autowired
	private IDownloadService iDownloadService;

	@Autowired
	private WriteRecordInExcelFile writeListToExcelFile;

	@Autowired
	private WriteRecordInPDFFile writeRecordInPDFFile;

	final String pathForExcel = "E://poc/online/books.xlsx";

	final String pathForPdf = "E://poc/online/booksDetails.pdf";

	@RequestMapping(value = "/api/download/{type}", method = RequestMethod.GET, produces = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
	public void getFile(@PathVariable("type") String type, HttpServletResponse response)
			throws IOException, ParseException {
		List<Loan> listOfBooks = iDownloadService.getBooksBorrowedDetailsInExcel();
		writeListToExcelFile.writeData(pathForExcel, listOfBooks);
		writeRecordInPDFFile.createPDF(pathForPdf, listOfBooks);

		try {
			if (type.equals("xls")) {
				InputStream is = new FileInputStream(pathForExcel);
				org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.flushBuffer();

			} else if (type.equals("pdf")) {
				InputStream is = new FileInputStream(pathForPdf);
				org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
				response.setContentType("application/pdf");
				response.flushBuffer();
			} else {
				response.getWriter().println("Invalid url neither excel nor pdf ");
			}

		} catch (IOException ex) {
			throw new RuntimeException("IOError writing file to output stream");
		}

	}
}
