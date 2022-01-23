package com.kodigo.solid.fakeDB;

import com.kodigo.solid.entities.PaymentEntity;
import com.kodigo.solid.entities.PrescriptionEntity;

import java.time.LocalDate;
import java.util.ArrayList;

public class FakePaymentsDb {

    public ArrayList<PaymentEntity> paymentDatabase() {

        ArrayList<PaymentEntity> payments = new ArrayList<>();

        PaymentEntity payment1 = PaymentEntity.builder()
                .id(1L)
                .name("Roxy")
                .idUser(12L)
                .concept("Cita medica")
                .datetime(LocalDate.ofEpochDay(2020-12-12))
                .amount(120)
                .build();
        payments.add(payment1);

        PaymentEntity payment2 = PaymentEntity.builder()
                .id(2L)
                .name("Juan")
                .idUser(14L)
                .concept("Cita medica")
                .datetime(LocalDate.ofEpochDay(2020-12-12))
                .amount(130)
                .build();
        payments.add(payment2);

        PaymentEntity payment3 = PaymentEntity.builder()
                .id(3L)
                .name("Roxy")
                .idUser(12L)
                .concept("Medicamento")
                .datetime(LocalDate.ofEpochDay(2020-12-12))
                .amount(50)
                .build();
        payments.add(payment1);

        return payments;
    }
}