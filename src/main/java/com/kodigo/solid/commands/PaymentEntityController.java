package com.kodigo.solid.commands;
import com.kodigo.solid.entities.PaymentEntity;
import lombok.Data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
public class PaymentEntityController {
    private List<PaymentEntity> payments = new ArrayList<>();

    public void printPayment(int id){
        for (int i = 0; i < payments.size(); i++) {
            if (id == payments.get(i).getId()) {
               System.out.println("ID pago: "+payments.get(i).getId() +
                       "\nFecha de pago: " + payments.get(i).getDatetime()+
                       "\nconcepto: "+ payments.get(i).getConcept() +
                       "\nPago: "+ payments.get(i).getAmount());
                break;
            } else {
                System.out.println("Pago no encontrado");
            }
        }
    }

    public void listPayments(){
        payments.sort(Comparator.comparing(PaymentEntity::getDatetime));
        for (PaymentEntity p : payments)
        {
            if (p != null)
            {
                System.out.println(p.toString());
            }
        }
    }

    public void listPatientPayments(int id){

        for(int i = 0; i < payments.size(); i++){
            if(id == payments.get(i).getPatientId()){
                System.out.println(payments);
            }
        }
    }

    public void addPaymentEntity(PaymentEntity p)
    {
        payments.add(p);
        fileWrite();
    }
    public void fileWrite() {
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

            System.out.println("\npago añadido exitosamente\n");
            writeBuff.close();
        } catch (Exception e) {

            System.out.println("Error -->" + e.getMessage());
        }
    }
}
