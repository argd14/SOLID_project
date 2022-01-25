package com.kodigo.solid.fakeRepository;

import com.kodigo.solid.entities.PrescriptionEntity;
import lombok.Data;

import java.util.ArrayList;

@Data
public class FakePrescriptionDb {

    public ArrayList<PrescriptionEntity> prescriptiontDatabase(){

        ArrayList<PrescriptionEntity> prescriptions = new ArrayList<>();

        PrescriptionEntity prescription1 = PrescriptionEntity.builder()
                .id(1)
                .medicineName("ibu")
                .namePatient("roxy")
                .dosage("3/2d")
                .build();
        prescriptions.add(prescription1);

        PrescriptionEntity prescription2 = PrescriptionEntity.builder()
                .id(2)
                .namePatient("juan")
                .medicineName("aspi")
                .dosage("1/d")
                .build();
        prescriptions.add(prescription2);

        return prescriptions;

        }
    }

