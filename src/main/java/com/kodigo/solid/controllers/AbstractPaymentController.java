package com.kodigo.solid.controllers;

import com.kodigo.solid.entities.PaymentEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class AbstractPaymentController implements InterfacePaymentController, InterfaceWriteFile{
  List<PaymentEntity> payments = new ArrayList<>();
}
