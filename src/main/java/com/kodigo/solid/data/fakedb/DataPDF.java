package com.kodigo.solid.data.fakedb;

import com.kodigo.solid.entities.DoctorEntity;
import com.kodigo.solid.entities.UserEntity;
import lombok.Data;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName.TIMES_BOLD;


@Data
public class DataPDF {

    private ArrayList<UserEntity> data = new ArrayList<>();

    public void addlistUser(UserEntity user){
        this.data.add(user);
    }


    /*public void documentPDF() {
        try {

            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A6);
            document.addPage(page);
            PDPageContentStream conten = new PDPageContentStream(document,page);

            conten.beginText();
            conten.setFont(new PDType1Font(TIMES_BOLD), 12);
            conten.newLineAtOffset(20,page.getMediaBox().getHeight()-52);
            conten.showText(this.data.toString());
            conten.endText();
            conten.close();
            document.save("C:\\Users\\angel\\IdeaProjects\\SOLID_project\\src\\main\\java\\com\\kodigo\\solid\\data\\fakedb\\doctorPDF");
        } catch (Exception x) {
            System.out.println("error "+ x.getMessage().toString());

        }
    }*/
}

