package com.kodigo.solid.controllers;

import com.kodigo.solid.entities.PaymentEntity;
import com.kodigo.solid.fakeDB.FakePaymentsDb;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEntityController extends AbstractPaymentController {

   /* public void listPatientPayments(int id) {

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

    }*/

    //dependencia
    FakePaymentsDb paymentDb = new FakePaymentsDb();

    public void loadData(){
        payments = paymentDb.paymentDatabase();
    }
    @Override
    public PaymentEntity getPayment(int id) {
        System.out.println(id);
        for (int i = 0; i < payments.size(); i++) {
            if (id == payments.get(i).getId()) {
              return payments.get(i);
            }
        }
        return null;
    }

    @Override
    public void listAllPayments(Long id) {
        for(int i = 0; i < payments.size(); i++){
            if(id == payments.get(i).getIdUser()) {
                System.out.println(payments.get(i));
            }
        }

    }

    @Override
    public void deletePayment(int id) {
        for (int i = 0; i < payments.size(); i++) {
            if (id == payments.get(i).getId()) {
                payments.remove(i);
            }
        }
    }

    @Override
    public void writeFile() {
        try {

            File directory = new File(".");
            File fileAppointment = new File(directory, "filePayments.text");
            FileWriter write = new FileWriter(fileAppointment);
            BufferedWriter writeBuff = new BufferedWriter(write);

            for (int i = 0; i < payments.size(); i++) {
                writeBuff.write("\nId usuario: " +
                        "\nConcepto: " + payments.get(i).getConcept() +
                        "\nMonto: " + payments.get(i).getAmount());

            }
            writeBuff.close();
        } catch (Exception e) {

            System.out.println("Error -->" + e.getMessage());
        }
    }

}


