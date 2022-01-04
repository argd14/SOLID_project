package com.kodigo.solid.services.auth;

public class PrintConsultationsService {
   /* private Database database = new Database();

    public void createPdf() throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        PDFont font = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
        List<ConsulationEntity> consults = this.database.getConsultations();

        PDPageContentStream content = new PDPageContentStream(document, page);
        int lines = 1;
        for (ConsulationEntity consulation : consults) {
            content.beginText();
            content.newLineAtOffset(100, 700 - 20f * lines);
            content.setFont(font, 12);
            content.showText("Consulta ID: " + consulation.getId() + ", Fecha: " + consulation.getConsultationDate());

            content.endText();
            ++lines;
        }

        content.close();
        document.save(this.buildFilename() + ".pdf");
        System.out.println("Archivo generado exitosamente");

    }

    private String buildFilename() {
        StringBuilder builder = new StringBuilder();
        builder.append(LocalDateTime.now().getDayOfMonth());
        builder.append("-");
        builder.append(LocalDateTime.now().getMonth().toString().toLowerCase());
        builder.append("-");
        builder.append(LocalDateTime.now().getHour());
        builder.append(":");
        builder.append(LocalDateTime.now().getMinute());
        builder.append(":");
        builder.append(LocalDateTime.now().getSecond());
        return builder.toString();
    }*/
}