package com.kodigo.solid.commands;

import com.kodigo.solid.entities.AdminEntity;
import com.kodigo.solid.entities.PatientEntity;
import com.kodigo.solid.entities.PrescriptionEntity;
import com.kodigo.solid.utils.usefullObjects.Prescription;
import lombok.Data;

import java.util.ArrayList;
import java.util.Scanner;

@Data
public class DoctorEntityController {
    private String medicine;
    private int idPatient;
    private ArrayList<PrescriptionEntity> prescriptionsList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public  void addPrescription() {
        System.out.println("--------INGRESANDO DATOS DE LA RECETA-----");
        System.out.println("Ingrese el ID del paciente:");
        idPatient = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese el Nombre del medicamento:");
        medicine = sc.nextLine();
        System.out.println("Ingrese la dosis del medicamento");
        String dosage = sc.nextLine();
        PrescriptionEntity Prescription = new PrescriptionEntity(this.idPatient,this.medicine, dosage);
        prescriptionsList.add(Prescription);


    }

    public void showPrescription() {
        System.out.println(prescriptionsList);
        System.out.println("Ingrese el ID del paciente ");
        int id = sc.nextInt();
        for (int i = 0; i < prescriptionsList.size(); i++) {
            if (id == prescriptionsList.get(i).getId()) {
                System.out.println("Mostrando datos receta: " +
                        " nombre medicamento: " + prescriptionsList.get(i).getMedicineName() + " Dosis: " + prescriptionsList.get(i).getDosage());
            }
        }
    }

    public void deletePrescription() {
        System.out.println("Ingrese el ID del paciente ");
        int id = sc.nextInt();
        for (int i = 0; i < prescriptionsList.size(); i++) {
            if (id == prescriptionsList.get(i).getId()) {
                prescriptionsList.remove(i);
            }
        }
    }
}