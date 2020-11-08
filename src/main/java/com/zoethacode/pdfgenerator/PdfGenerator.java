package com.zoethacode.pdfgenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.zoethacode.pdfgenerator.model.User;

public class PdfGenerator {
	
	public static final Text NEWLINE = new Text("\n");
	
	public static void main(String[] args) throws IOException {
		
		List<User> users = new ArrayList<>();
		
		User thais = new User();
		thais.setName("Thais");
		thais.setEmail("thais@zoethacode.com");
		thais.setWeigth(19.5f);
		thais.setHeight(0.55f);
		
		User zoe = new User();
		zoe.setName("Zoe");
		zoe.setEmail("zoe@zoethacode.com");
		zoe.setWeigth(3.5f);
		zoe.setHeight(0.25f);
		
		users.add(thais);
		users.add(zoe);
		
		pdfGenerator(users);

		System.out.println("Awesome PDF just got created.");
	}

	public static void pdfGenerator(List<User> users) throws IOException {
		PdfDocument pdf = new PdfDocument(new PdfWriter("/tmp/docPDF.pdf"));
		
		try (Document document = new Document(pdf)) {
			// Definimos los tipos de letras a utilizar.
			PdfFont romanFont = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
			PdfFont helveticaFont = PdfFontFactory.createFont(StandardFonts.HELVETICA);
			
			// Creamos un estilo para el título.
			Style titleStyle = new Style();
			titleStyle.setFont(romanFont).setFontSize(22).setBold();
			
			// Creamos un estilo para texto normal.
			Style normalStyle = new Style();
			normalStyle.setFont(helveticaFont).setFontSize(12);
			
			// Creamos un estilo para texto normal.
			Style boldStyle = new Style();
			boldStyle.setFont(helveticaFont).setFontSize(12).setBold();
			
			// Insertamos el título.
			Text title = new Text("Reporte");
			title.addStyle(titleStyle);
			document.add(new Paragraph(title).setTextAlignment(TextAlignment.CENTER));
			
			// Insertamos el subtítulo.
			Text subtitle = new Text("Listado de usuarios:");
			document.add(new Paragraph(subtitle.addStyle(boldStyle)));
			
			// Insertamos los usuarios.
			for (User user : users) {
				Paragraph paragraph = new Paragraph();
				
				paragraph.setMarginLeft(25f);
				
				paragraph.add(new Text("Nombre: ").addStyle(boldStyle));
				paragraph.add(new Text(user.getName()).addStyle(normalStyle));
				paragraph.add(NEWLINE);
				paragraph.add(new Text("Email: ").addStyle(boldStyle));
				paragraph.add(new Text(user.getEmail()).addStyle(normalStyle));
				paragraph.add(NEWLINE);
				paragraph.add(new Text("Peso: ").addStyle(boldStyle));
				paragraph.add(new Text(user.getWeigth() + " kg").addStyle(normalStyle));
				paragraph.add(NEWLINE);
				paragraph.add(new Text("Altura: ").addStyle(boldStyle));
				paragraph.add(new Text(user.getHeight() + " m").addStyle(normalStyle));
				paragraph.add(NEWLINE);
				paragraph.add(new Text("------------------------------------").addStyle(normalStyle));
				paragraph.add(NEWLINE);
				
				document.add(paragraph);
			}
		}
	}
}
