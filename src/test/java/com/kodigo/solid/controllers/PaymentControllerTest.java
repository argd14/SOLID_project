package com.kodigo.solid.controllers;

import com.kodigo.solid.entities.PaymentEntity;
import com.kodigo.solid.entities.PrescriptionEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PaymentControllerTest {

    PaymentEntityController paymentEntityController;
    List<PaymentEntity> paymentEntityList;
    PaymentEntity payment;

    @BeforeEach
    public void setup() {
        paymentEntityController = new PaymentEntityController();
        paymentEntityList = paymentEntityController.paymentDb.paymentDatabase();
        payment = PaymentEntity.builder()
                .id(1L)
                .name("Roxy")
                .idUser(12L)
                .concept("Cita medica")
                .datetime(LocalDate.ofEpochDay(2020-12-12))
                .amount(120)
                .build();
    }

    @Test
    @DisplayName("Method listAllPayments - Should return a list with all payments")
    void listAllPayments() {
        assertFalse(paymentEntityList.isEmpty());
        assertEquals(4, paymentEntityList.size());
    }

    @Test
    @DisplayName("Method deletePayment - Should remove new payment from paymentList")
    void deletePayment() {
        paymentEntityList.remove(payment);
        assertFalse(paymentEntityList.contains(payment));
    }

}