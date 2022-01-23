package com.kodigo.solid.controllers;

import com.kodigo.solid.entities.PaymentEntity;
import com.kodigo.solid.entities.PrescriptionEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface InterfacePaymentController {
    PaymentEntity getPayment(int id);
    void listAllPayments(Long id);
    void deletePayment(int id);
}
