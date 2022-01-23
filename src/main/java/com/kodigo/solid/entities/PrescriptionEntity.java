package com.kodigo.solid.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrescriptionEntity {
    private String namePatient;
    private int id;
    private String medicineName;
    private String dosage;

    public PrescriptionEntity(int id, String name, String medicine, String dosage) {
        this.id = id;
        this.namePatient = name;
        this.medicineName = medicine;
        this.dosage = dosage;
    }

    @Override
    public String toString() {
        return ("\nNumero prescripcion: " + id +
                "\nNombre paciente" + namePatient+
                "\nNombre medicina: " + medicineName +
                "\nDosis: " + dosage);
    }
}
