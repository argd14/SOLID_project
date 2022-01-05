package com.kodigo.solid.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PaymentEntity {
    private int id;
    private int patientId;
    private LocalDateTime datetime;
    private String concept;
    private double amount;

    public PaymentEntity(int id, int patientId, String concept, double amount) {
        this.id = id;
        this.patientId = patientId;
        this.datetime = LocalDateTime.now();
        this.concept = concept;
        this.amount = amount;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    @Override
    public String toString() {
        return "\nRegistro de pago: " +
                "\nid: " + id +
                "\nid Paciente: " + patientId +
                "\nfecha: " + datetime +
                "\nconcepto: " + concept +
                "\nmonto: \n" + amount;
    }
}
