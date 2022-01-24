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


    @Override
    public String toString() {
        return "\nRegistro de pago: " +
                "\nnumero de pago "+id+
                "\nnombre cliente "+ name+
                "\nfecha: " + datetime +
                "\nconcepto: " + concept +
                "\nmonto: \n" + amount+"\n";
    }
}
