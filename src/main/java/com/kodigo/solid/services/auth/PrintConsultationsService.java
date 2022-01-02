package com.kodigo.solid.services.auth;

import com.kodigo.solid.database.Database;
import com.kodigo.solid.entities.ConsulationEntity;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import java.io.IOException;
import java.time.LocalDate;

public class PrintConsultationsService {
    private Database database = new Database();

    public void createPdf() throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream content = new PDPageContentStream(document, page);
        int lines = 1;
        for (ConsulationEntity consulation : this.database.newConsultations) {
            content.beginText();
            content.newLineAtOffset(100, 100 - 20f * lines);
            content.showText("Consulta ID >" + consulation.getId() + "Fecha: " + consulation.getConsultationDate());
            content.endText();
            ++lines;
        }

        content.close();
        document.save(LocalDate.now().toString() + ".pdf");
        System.out.println("Archivo generado exitosamente");

    }
}
