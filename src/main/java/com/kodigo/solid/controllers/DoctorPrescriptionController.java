package com.kodigo.solid.controllers;

import com.kodigo.solid.entities.PrescriptionEntity;
import com.kodigo.solid.fakeDB.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.util.Random;
import java.util.Scanner;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorPrescriptionController extends AbstractDoctorController {

    //dependencia
    FakePrescriptionDb prescriptionDb = new FakePrescriptionDb();

    private Scanner sc = new Scanner(System.in);

    @Override
    public void loadDatabase() {
        prescriptionsList = prescriptionDb.prescriptiontDatabase();
    }

    @Override
    public void writeFile() {
        try {

            File directory = new File(".");
            File fileUser = new File(directory, "filePrescription.text");
            FileWriter write = new FileWriter(fileUser);
            BufferedWriter writeBuff = new BufferedWriter(write);

            for (int i = 0; i < prescriptionsList.size(); i++) {
                writeBuff.write("\nId paciente: " + prescriptionsList.get(i).getId() + "\nNombre de medicamento: " + prescriptionsList.get(i).getMedicineName() +
                        "\nDosis recomendada: " + prescriptionsList.get(i).getDosage());
            }

            System.out.println("\nPrescripcion añadida exitosamente\n");
            writeBuff.close();
        } catch (Exception e) {

            System.out.println("Error -->" + e.getMessage());
        }
    }

    @Override
    public PrescriptionEntity getPrescription(Long id) {
        for (int i = 0; i < prescriptionsList.size(); i++) {
            if (id == prescriptionsList.get(i).getId()) {
                return prescriptionsList.get(i);
            }
        }
        return null;
    }


    @Override
    public void createPrescription() {
        Random ram = new Random();
        System.out.println("--------INGRESANDO DATOS DE LA RECETA-----");
        int id = ram.nextInt(2000);
        System.out.println("Ingrese el nombre del paciente:");
        String name = sc.nextLine();
        System.out.println("Ingrese el Nombre del medicamento:");
        String medicine = sc.nextLine();
        System.out.println("Ingrese la dosis del medicamento");
        String dosage = sc.nextLine();
        PrescriptionEntity Prescription = new PrescriptionEntity(id,name, medicine, dosage);
        prescriptionsList.add(Prescription);
        writeFile();
    }

    //nuevo metodo
    @Override
    public void updatePrescription(PrescriptionEntity prescription) {
        PrescriptionEntity prescriptionDB = getPrescription((long) prescription.getId());
        for (int i = 0; i < prescriptionsList.size(); i++) {
            if (prescriptionsList.get(i) == prescriptionDB) {
                System.out.println("ingrese el nombre ");
                prescriptionDB.setMedicineName(sc.nextLine());
                System.out.println("ingrese la dosis ");
                prescriptionDB.setDosage(sc.nextLine());
                prescriptionsList.set(i,prescriptionDB);
            }
        }
    }

    @Override
    public void listAllPrescription() {
        System.out.println(prescriptionsList);
    }

    @Override
    public void deletePrescription(Long id) {
        for (int i = 0; i < prescriptionsList.size(); i++) {
            if (id == prescriptionsList.get(i).getId()) {
                prescriptionsList.remove(i);
                System.out.println("Usuario eliminado exitosamente\n");
            }
        }
    }
}