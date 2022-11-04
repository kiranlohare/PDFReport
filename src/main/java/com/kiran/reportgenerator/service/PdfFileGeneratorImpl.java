package com.kiran.reportgenerator.service;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.kiran.reportgenerator.entity.Student;

@Component
public class PdfFileGeneratorImpl implements PdfFileGenerator {
	private static final Logger log= LoggerFactory.getLogger(PdfFileGeneratorImpl.class);
	@Override
	public void pdfFileGenrator(Student student) {
		log.info("Inside method PdfFileGeneratorImpl class pdfGenarator method");
		try {

			String path = "C:/Users/Kiran Lohare/Downloads/Student.pdf";
			File file = new File(path);

			FileOutputStream stream = new FileOutputStream(file);
			Document document = new Document();
			PdfWriter.getInstance(document, stream);
			document.open();

			PdfPTable table1 = new PdfPTable(4);

			Paragraph para3 = new Paragraph();
			para3.setAlignment(Element.ALIGN_CENTER);
			Font font4 = new Font(FontFamily.TIMES_ROMAN, 20, Font.BOLDITALIC);
			para3.setFont(font4);
			para3.add("* SHIVRAY HIGH SCHOOL BHALKI *\n\n");
			document.add(para3);

			Paragraph para = new Paragraph();
			para.setAlignment(Element.ALIGN_CENTER);
			Font font = new Font(FontFamily.TIMES_ROMAN, 20, Font.BOLDITALIC);
			para.setFont(font);
			para.add("Student Report\n\n");

			Font cellFont = new Font(FontFamily.TIMES_ROMAN, 8, Font.BOLD);
			Phrase phrase1 = new Phrase();
			phrase1.setFont(cellFont);
			phrase1.add("Name : " + student.getStudentName());
			PdfPCell cell = new PdfPCell(phrase1);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(30);
			table1.addCell(cell);

			Phrase phrase2 = new Phrase();
			phrase2.setFont(cellFont);
			phrase2.add("ID : " + student.getStudentId());
			table1.addCell(new PdfPCell(phrase2));

			Phrase phrase3 = new Phrase();
			phrase3.setFont(cellFont);
			phrase3.add("Date : " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			table1.addCell(new PdfPCell(phrase3));

			Phrase phrase4 = new Phrase();
			phrase4.setFont(cellFont);
			phrase4.add("Time : " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
			table1.addCell(new PdfPCell(phrase4));

			document.add(para);

			PdfPTable table2 = new PdfPTable(10);

			Phrase p1 = new Phrase();
			p1.setFont(cellFont);
			p1.add("Subjects");
			table2.addCell(new PdfPCell(p1));

			Phrase p2 = new Phrase();
			p2.setFont(cellFont);
			p2.add("Total Marks");
			table2.addCell(new PdfPCell(p2));

			Phrase p3 = new Phrase();
			p3.setFont(cellFont);
			p3.add("Obtained");
			table2.addCell(new PdfPCell(p3));

			Phrase p4 = new Phrase();
			p4.setFont(cellFont);
			p4.add("Status");
			table2.addCell(new PdfPCell(p4));

			Phrase p5 = new Phrase();
			p5.setFont(cellFont);
			p5.add("Total Marks");
			table2.addCell(new PdfPCell(p5));

			Phrase p6 = new Phrase();
			p6.setFont(cellFont);
			p6.add("Obtained");
			table2.addCell(new PdfPCell(p6));

			Phrase p7 = new Phrase();
			p7.setFont(cellFont);
			p7.add("Status");
			table2.addCell(new PdfPCell(p7));

			Phrase p8 = new Phrase();
			p8.setFont(cellFont);
			p8.add("Total Marks");
			table2.addCell(new PdfPCell(p8));

			Phrase p9 = new Phrase();
			p9.setFont(cellFont);
			p9.add("Obtained");
			table2.addCell(new PdfPCell(p9));

			Phrase p10 = new Phrase();
			p10.setFont(cellFont);
			p10.add("Status");
			table2.addCell(new PdfPCell(p10));

			PdfPTable table3 = new PdfPTable(10);

			Phrase ps11 = new Phrase();
			ps11.setFont(cellFont);
			ps11.add("          ");
			table3.addCell(new PdfPCell(ps11));

			Paragraph p11 = new Paragraph();
			p11.setFont(cellFont);
			p11.setAlignment(Element.ALIGN_CENTER);
			p11.add("First Term");
			PdfPCell cell2 = new PdfPCell();
			cell2.setColspan(3);
			cell2.addElement(p11);
			table3.addCell(cell2);

			Paragraph p12 = new Paragraph();
			p12.setFont(cellFont);
			p12.setAlignment(Element.ALIGN_CENTER);
			p12.add("Second Term");
			PdfPCell cell3 = new PdfPCell();
			cell3.setColspan(3);
			cell3.addElement(p12);
			table3.addCell(cell3);

			Paragraph p13 = new Paragraph();
			p13.setFont(cellFont);
			p13.setAlignment(Element.ALIGN_CENTER);
			p13.add("Final Term");
			PdfPCell cell4 = new PdfPCell();
			cell4.setColspan(3);
			cell4.addElement(p13);
			table3.addCell(cell4);

			PdfPTable table4 = new PdfPTable(10);
			Paragraph s1 = new Paragraph();
			s1.setFont(cellFont);
			s1.setAlignment(Element.ALIGN_CENTER);
			s1.add("Marathi");
			table4.addCell(new PdfPCell(s1));

			Paragraph s2 = new Paragraph();
			s2.setFont(cellFont);
			s2.setAlignment(Element.ALIGN_CENTER);
			s2.add("100");
			PdfPCell cell5 = new PdfPCell();
			cell5.addElement(s2);
			table4.addCell(cell5);

			Paragraph s3 = new Paragraph();
			s3.setFont(cellFont);
			s3.setAlignment(Element.ALIGN_CENTER);
			Integer marathiMarks1 = student.getFirstTerm().getMarathiMarks();
			s3.add("" + marathiMarks1);
			PdfPCell cell6 = new PdfPCell();
			cell6.addElement(s3);
			table4.addCell(cell6);

			Paragraph s4 = new Paragraph();
			s4.setFont(cellFont);
			s4.setAlignment(Element.ALIGN_CENTER);
			if (marathiMarks1 >= 35 ? s4.add("Pass") : s4.add("Fail"))
				;
			PdfPCell cell7 = new PdfPCell();
			cell7.addElement(s4);
			table4.addCell(cell7);

			Paragraph s5 = new Paragraph();
			s5.setFont(cellFont);
			s5.setAlignment(Element.ALIGN_CENTER);
			s5.add("100");
			PdfPCell cell8 = new PdfPCell();
			cell8.addElement(s5);
			table4.addCell(cell8);

			Paragraph s6 = new Paragraph();
			s6.setFont(cellFont);
			s6.setAlignment(Element.ALIGN_CENTER);
			Integer marathiMark2 = student.getSecondTerm().getMarathiMarks();
			s6.add("" + marathiMark2);
			PdfPCell cell9 = new PdfPCell();
			cell9.addElement(s6);
			table4.addCell(cell9);

			Paragraph s7 = new Paragraph();
			s7.setFont(cellFont);
			s7.setAlignment(Element.ALIGN_CENTER);
			if (marathiMark2 >= 35 ? s7.add("Pass") : s7.add("Fail"))
				;
			PdfPCell cell10 = new PdfPCell();
			cell10.addElement(s7);
			table4.addCell(cell10);

			Paragraph s8 = new Paragraph();
			s8.setFont(cellFont);
			s8.setAlignment(Element.ALIGN_CENTER);
			s8.add("100");
			PdfPCell cell11 = new PdfPCell();
			cell11.addElement(s8);
			table4.addCell(cell11);

			Paragraph s9 = new Paragraph();
			s9.setFont(cellFont);
			s9.setAlignment(Element.ALIGN_CENTER);
			Integer marathiMarks3 = student.getFinalTerm().getMarathiMarks();
			s9.add("" + marathiMarks3);
			PdfPCell cell12 = new PdfPCell();
			cell12.addElement(s9);
			table4.addCell(cell12);

			Paragraph s10 = new Paragraph();
			s10.setFont(cellFont);
			s10.setAlignment(Element.ALIGN_CENTER);
			if (marathiMarks3 >= 35 ? s10.add("pass") : s10.add("Fail"))
				;
			PdfPCell cell13 = new PdfPCell();
			cell13.addElement(s10);
			table4.addCell(cell13);

			Paragraph a1 = new Paragraph();
			a1.setFont(cellFont);
			a1.setAlignment(Element.ALIGN_CENTER);
			a1.add("Hindi");
			table4.addCell(new PdfPCell(a1));

			Paragraph a2 = new Paragraph();
			a2.setFont(cellFont);
			a2.setAlignment(Element.ALIGN_CENTER);
			a2.add("100");
			PdfPCell aa2 = new PdfPCell();
			aa2.addElement(a2);
			table4.addCell(aa2);

			Paragraph a3 = new Paragraph();
			a3.setFont(cellFont);
			a3.setAlignment(Element.ALIGN_CENTER);
			Integer hindiMarks1 = student.getFirstTerm().getHindiMarks();
			a3.add("" + hindiMarks1);
			PdfPCell aa3 = new PdfPCell();
			aa3.addElement(a3);
			table4.addCell(aa3);

			Paragraph a4 = new Paragraph();
			a4.setFont(cellFont);
			a4.setAlignment(Element.ALIGN_CENTER);
			if (hindiMarks1 >= 35 ? a4.add("pass") : a4.add("Fail"))
				;
			PdfPCell aa4 = new PdfPCell();
			aa4.addElement(a4);
			table4.addCell(aa4);

			Paragraph a5 = new Paragraph();
			a5.setFont(cellFont);
			a5.setAlignment(Element.ALIGN_CENTER);
			a5.add("100");
			PdfPCell aa5 = new PdfPCell();
			aa5.addElement(a5);
			table4.addCell(aa5);

			Paragraph a6 = new Paragraph();
			a6.setFont(cellFont);
			a6.setAlignment(Element.ALIGN_CENTER);
			Integer hindiMarks2 = student.getSecondTerm().getHindiMarks();
			a6.add("" + hindiMarks2);
			PdfPCell aa6 = new PdfPCell();
			aa6.addElement(a6);
			table4.addCell(aa6);

			Paragraph a7 = new Paragraph();
			a7.setFont(cellFont);
			a7.setAlignment(Element.ALIGN_CENTER);
			if (hindiMarks2 >= 35 ? a7.add("pass") : a7.add("Fail"))
				;
			PdfPCell aa7 = new PdfPCell();
			aa7.addElement(a7);
			table4.addCell(aa7);

			Paragraph a8 = new Paragraph();
			a8.setFont(cellFont);
			a8.setAlignment(Element.ALIGN_CENTER);
			a8.add("100");
			PdfPCell aa8 = new PdfPCell();
			aa8.addElement(a8);
			table4.addCell(aa8);

			Paragraph a9 = new Paragraph();
			a9.setFont(cellFont);
			a9.setAlignment(Element.ALIGN_CENTER);
			Integer hindiMarks3 = student.getFinalTerm().getHindiMarks();
			a9.add("" + hindiMarks3);
			PdfPCell aa9 = new PdfPCell();
			aa9.addElement(a9);
			table4.addCell(aa9);

			Paragraph a10 = new Paragraph();
			a10.setFont(cellFont);
			a10.setAlignment(Element.ALIGN_CENTER);
			if (hindiMarks3 >= 35 ? a10.add("pass") : a10.add("Fail"))
				;
			PdfPCell aa10 = new PdfPCell();
			aa10.addElement(a10);
			table4.addCell(aa10);

			Paragraph b1 = new Paragraph();
			b1.setFont(cellFont);
			b1.setAlignment(Element.ALIGN_CENTER);
			b1.add("English");
			table4.addCell(new PdfPCell(b1));

			Paragraph b2 = new Paragraph();
			b2.setFont(cellFont);
			b2.setAlignment(Element.ALIGN_CENTER);
			b2.add("100");
			PdfPCell bb2 = new PdfPCell();
			bb2.addElement(b2);
			table4.addCell(bb2);

			Paragraph b3 = new Paragraph();
			b3.setFont(cellFont);
			b3.setAlignment(Element.ALIGN_CENTER);
			Integer englishMarks = student.getFirstTerm().getEnglishMarks();
			b3.add("" + englishMarks);
			PdfPCell bb3 = new PdfPCell();
			bb3.addElement(b3);
			table4.addCell(bb3);

			Paragraph b4 = new Paragraph();
			b4.setFont(cellFont);
			b4.setAlignment(Element.ALIGN_CENTER);
			if (englishMarks >= 35 ? b4.add("pass") : b4.add("Fail"))
				;
			PdfPCell bb4 = new PdfPCell();
			bb4.addElement(b4);
			table4.addCell(bb4);

			Paragraph b5 = new Paragraph();
			b5.setFont(cellFont);
			b5.setAlignment(Element.ALIGN_CENTER);
			b5.add("100");
			PdfPCell bb5 = new PdfPCell();
			bb5.addElement(b5);
			table4.addCell(bb5);

			Paragraph b6 = new Paragraph();
			b6.setFont(cellFont);
			b6.setAlignment(Element.ALIGN_CENTER);
			Integer englishMarks2 = student.getSecondTerm().getEnglishMarks();
			b6.add("" + englishMarks2);
			PdfPCell bb6 = new PdfPCell();
			bb6.addElement(b6);
			table4.addCell(bb6);

			Paragraph b7 = new Paragraph();
			b7.setFont(cellFont);
			b7.setAlignment(Element.ALIGN_CENTER);
			if (englishMarks2 >= 35 ? b7.add("pass") : b7.add("Fail"))
				;

			PdfPCell bb7 = new PdfPCell();
			bb7.addElement(b7);
			table4.addCell(bb7);

			Paragraph b8 = new Paragraph();
			b8.setFont(cellFont);
			b8.setAlignment(Element.ALIGN_CENTER);
			b8.add("100");
			PdfPCell bb8 = new PdfPCell();
			bb8.addElement(b8);
			table4.addCell(bb8);

			Paragraph b9 = new Paragraph();
			b9.setFont(cellFont);
			b9.setAlignment(Element.ALIGN_CENTER);
			Integer englishMarks3 = student.getFinalTerm().getEnglishMarks();
			b9.add("" + englishMarks3);
			PdfPCell bb9 = new PdfPCell();
			bb9.addElement(b9);
			table4.addCell(bb9);

			Paragraph b10 = new Paragraph();
			b10.setFont(cellFont);
			b10.setAlignment(Element.ALIGN_CENTER);
			if (englishMarks3 >= 35 ? b10.add("pass") : b10.add("Fail"))
				;
			PdfPCell bb10 = new PdfPCell();
			bb10.addElement(b10);
			table4.addCell(bb10);

			Font f1 = new Font(FontFamily.TIMES_ROMAN, 8, Font.BOLDITALIC);
			PdfPTable table5 = new PdfPTable(10);

			PdfPCell cell14 = new PdfPCell();
			cell14.setColspan(5);
			Paragraph p = new Paragraph();
			p.setAlignment(Element.ALIGN_CENTER);
			p.setFont(f1);
			if (marathiMarks1 >= 35 && marathiMark2 >= 35 && marathiMarks3 >= 35 && hindiMarks1 >= 35
					&& hindiMarks2 >= 35 && hindiMarks3 >= 35 && englishMarks >= 35 && englishMarks2 >= 35
					&& englishMarks3 >= 35) {
				p.add("Congratualations.......!");
			} else {
				p.add("Better luck next time....!");
			}
			cell14.addElement(p);
			table5.addCell(cell14);

			PdfPCell cell15 = new PdfPCell();
			cell15.setColspan(5);
			Paragraph para1 = new Paragraph();
			para1.setAlignment(Element.ALIGN_CENTER);
			para1.setFont(f1);
			para1.add("Parent Sign.......................");
			cell15.addElement(para1);
			table5.addCell(cell15);

			Font font2 = new Font(FontFamily.TIMES_ROMAN, 10, Font.BOLD);
			Paragraph headmasterSign = new Paragraph();
			headmasterSign.setAlignment(Element.ALIGN_CENTER);
			headmasterSign.setFont(f1);
			headmasterSign.add(
					"\n\n                                                     HeadMaster : _________________________\n");
			headmasterSign.setFont(font2);
			headmasterSign
					.add("                                                               Shivray High School Bhalki.");

			document.add(table1);
			document.add(table3);
			document.add(table2);
			document.add(table4);
			document.add(table5);
			document.add(headmasterSign);

			document.close();
		} 
		catch (Exception e) 
		{
			log.info ("Exception in PdfFileGenerator class");
			e.printStackTrace();
		}
	}
}
