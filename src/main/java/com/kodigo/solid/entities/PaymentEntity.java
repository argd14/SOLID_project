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

    public PaymentEntity(int id, int patientId, String concept, double amount)
    {
        this.id = id;
        this.patientId = patientId;
        this.datetime = LocalDateTime.now();
        this.concept = concept;
        this.amount = amount;
    }

    public LocalDateTime getDatetime(){
        return datetime;
    }


}
