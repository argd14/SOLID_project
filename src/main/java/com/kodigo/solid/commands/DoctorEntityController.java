package com.kodigo.solid.commands;

import com.kodigo.solid.entities.PrescriptionEntity;
import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

@Data
public class DoctorEntityController {
    private String medicine;
    private int idPatient;
    private ArrayList<PrescriptionEntity> prescriptionsList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public  void addPrescription() {
        System.out.println("--------INGRESANDO DATOS DE LA RECETA--------");
        System.out.println("Ingrese el ID del paciente:");
        idPatient = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese el Nombre del medicamento:");
        medicine = sc.nextLine();
        System.out.println("Ingrese la dosis del medicamento");
        String dosage = sc.nextLine();
        PrescriptionEntity Prescription = new PrescriptionEntity(this.idPatient,this.medicine, dosage);
        prescriptionsList.add(Prescription);
        fileWrite();

    }

    public void showPrescription() {
        try {
            String linea ;
            BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\angel\\IdeaProjects\\SOLID_project\\filePrescription.text"));
            linea = bf.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = bf.readLine();
            }

        } catch (Exception e) {

            System.err.println("error -->" + e.getMessage());
        }
    }

    public void deletePrescription() {
        System.out.println("Ingrese el ID del paciente: ");
        int id = sc.nextInt();
        for (int i = 0; i < prescriptionsList.size(); i++) {
            if (id == prescriptionsList.get(i).getId()) {
                prescriptionsList.remove(i);
                System.out.println("¡Prescripción eliminada exitosamente!");
                System.out.println(prescriptionsList);
            }
        }
    }

    public void fileWrite() {
        try {

            File directory = new File(".");
            File fileUser = new File(directory, "filePrescription.text");
            FileWriter write = new FileWriter(fileUser);
            BufferedWriter writeBuff = new BufferedWriter(write);

            for (int i = 0; i < prescriptionsList.size(); i++) {
                writeBuff.write("\nId paciente: "+ prescriptionsList.get(i).getId()+"\nNombre de medicamento: " + prescriptionsList.get(i).getMedicineName() +
                        "\nDosis recomendada: " + prescriptionsList.get(i).getDosage()) ;
            }

            System.out.println("\nPrescripción añadida exitosamente\n");
            writeBuff.close();
        } catch (Exception e) {

            System.out.println("Error -->" + e.getMessage());
        }
    }

}