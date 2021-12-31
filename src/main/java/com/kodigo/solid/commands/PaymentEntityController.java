package com.kodigo.solid.commands;
import com.kodigo.solid.entities.PaymentEntity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PaymentEntityController {
    public List<PaymentEntity> payments = new ArrayList<>();

    public void printPayment(PaymentEntity payment){
        System.out.println(payment.toString());
    }

    public void listPayments(){
        payments.sort(Comparator.comparing(PaymentEntity::getDatetime));
        for (PaymentEntity p : payments)
        {
            if (p != null)
            {
                System.out.println(p.toString());
            }
        }
    }

    public void listPatientPayments(int id){
        payments.sort(Comparator.comparing(PaymentEntity::getDatetime));
        for (PaymentEntity p : payments)
        {
            if (p != null && p.getPatientId() == id )
            {
                System.out.println(p.toString());
            }
        }
    }

    public void add(PaymentEntity p)
    {
        payments.add(p);
        p.setId(payments.indexOf(p) + 1);
        System.out.println("Added payment " + p + "\n");
    }
}
