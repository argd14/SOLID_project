package com.kodigo.solid.entities;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentEntity {
    int id;
    int patientId;
    LocalDateTime datetime;
    String concept;
    double amount;

    public PaymentEntity(int patientId, String concept, double amount)
    {
        this.patientId = patientId;
        this.datetime = LocalDateTime.now();
        this.concept = concept;
        this.amount = amount;
    }

    public LocalDateTime getDatetime(){
        return datetime;
    }

    @Override
    public String toString()
    {
        return ("Paciente: " + this.patientId + ".\n" + "Fecha: " + this.datetime + ".\n" + "Concepto: " + this.concept + ".\n" + "Monto: " + this.amount);
    }
}
