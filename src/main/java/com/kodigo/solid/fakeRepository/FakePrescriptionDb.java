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

        PrescriptionEntity prescription3 = PrescriptionEntity.builder()
                .id(3)
                .medicineName("Paracetamol")
                .namePatient("roxy")
                .dosage("1 c/6h")
                .build();
        prescriptions.add(prescription3);

        PrescriptionEntity prescription4 = PrescriptionEntity.builder()
                .id(4)
                .namePatient("juan")
                .medicineName("Amoxicilina 500mg")
                .dosage("1 c/8h")
                .build();
        prescriptions.add(prescription4);

        return prescriptions;

        }
    }

