package com.kodigo.solid.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class PrescriptionEntity {
    private int id;
    private String medicineName;
    private String dosage;


    public PrescriptionEntity(int idPatient, String medicine, String dosage) {
        this.id =idPatient;
        this.medicineName = medicine;
        this.dosage = dosage;
    }
}
