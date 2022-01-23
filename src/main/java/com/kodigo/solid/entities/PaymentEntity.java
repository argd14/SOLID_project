package com.kodigo.solid.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentEntity {

    private Long id;
    private String name;
    private Long idUser;
    private LocalDate datetime;
    private String concept;
    private double amount;

    public PaymentEntity(Long id, String name, Long idUser,String concept, double amount) {
        this.id = id;
        this.name = name;
        this.idUser = idUser;
        this.datetime = LocalDate.from(LocalDateTime.now());
        this.concept = concept;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "\nRegistro de pago: " +
                "\nnumero de pago "+id+
                "\nid cliente " + idUser +
                "\nnombre cliente "+ name+
                "\nfecha: " + datetime +
                "\nconcepto: " + concept +
                "\nmonto: \n" + amount+"\n";
    }
}
