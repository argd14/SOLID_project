package com.kodigo.solid.commands;
import com.kodigo.solid.entities.PaymentEntity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PaymentEntityController {
    public List<PaymentEntity> payments = new ArrayList<>();

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
            if (p != null && p.patientId == id )
            {
                System.out.println(p.toString());
            }
        }
    }

    public void add(PaymentEntity p)
    {
        payments.add(p);
        System.out.println("Added payment " + p + "\n");
    }
}
