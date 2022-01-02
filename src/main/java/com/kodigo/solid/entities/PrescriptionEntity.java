package com.kodigo.solid.entities;

import lombok.Getter;


public class PrescriptionEntity extends BaseEntity {

    @Getter
    private String medicineName;
    @Getter
    private String dosage;


    public PrescriptionEntity(int id, String medicineName, String dosage) {
        super(id);
        this.medicineName = medicineName;
        this.dosage = dosage;
    }
}
