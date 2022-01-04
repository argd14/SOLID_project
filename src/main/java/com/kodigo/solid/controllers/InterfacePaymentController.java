package com.kodigo.solid.controllers;

import com.kodigo.solid.entities.PaymentEntity;

public interface InterfacePaymentController {
    void printPayment(int id);

    void listPatientPayments(int id);

    void addPayment(PaymentEntity p);
}
