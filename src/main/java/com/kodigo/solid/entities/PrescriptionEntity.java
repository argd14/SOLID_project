package com.kodigo.solid.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionEntity {
    private int id;
    private String medicineName;
    private String dosage;

    @Override
    public String toString() {
        return ("\nPrescripcion: " +
                "\nNombre medicina: " + medicineName +
                "\nDosis: " + dosage );
    }
}
