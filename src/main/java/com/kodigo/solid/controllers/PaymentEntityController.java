package com.kodigo.solid.controllers;

import com.kodigo.solid.entities.PaymentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class PaymentEntityController extends AbstractPaymentController {

    @Override
    public void printPayment(int id) {
        System.out.println(payments);

        if (payments.isEmpty()) {
            System.out.println("Pago no encontrado o no existen pagos actualmente\n");

        } else {
            for (int i = 0; i < payments.size(); i++) {
                if (id == payments.get(i).getId()) {
                    System.out.println(payments.get(i).toString());
                }
            }
        }

    }

    @Override
    public void listPatientPayments(int id) {
        /*for (int i = 0; i < payments.size(); i++) {
            if (id == payments.get(i).getId()) {
                System.out.println(payments);
                break;
            } else {
                System.out.println("Pago no encontrado");
            }
        }*/
       try {
            String linea;
            BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\angel\\IdeaProjects\\SOLID_project\\filePayments.text"));
            linea = bf.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = bf.readLine();
            }

        } catch (Exception e) {

            System.err.println("error -->" + e.getMessage());
        }

    }

    @Override
    public void addPayment(PaymentEntity p) {
        payments.add(p);
        writeFile();
    }

    @Override
    public void writeFile() {
        try {

            File directory = new File(".");
            File fileAppointment = new File(directory, "filePayments.text");
            FileWriter write = new FileWriter(fileAppointment);
            BufferedWriter writeBuff = new BufferedWriter(write);

            for (int i = 0; i < payments.size(); i++) {
                writeBuff.write("\nId usuario: " + payments.get(i).getPatientId() +
                        "\nConcepto: " + payments.get(i).getConcept() +
                        "\nMonto: " + payments.get(i).getAmount());

            }
            writeBuff.close();
        } catch (Exception e) {

            System.out.println("Error -->" + e.getMessage());
        }
    }
}
