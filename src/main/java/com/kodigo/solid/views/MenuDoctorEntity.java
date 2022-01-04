package com.kodigo.solid.views;

import com.kodigo.solid.controllers.*;
import com.kodigo.solid.services.auth.AuthServiceImplementation;
import com.kodigo.solid.services.auth.ConsultationService;
import com.kodigo.solid.services.auth.PrintConsultationsService;
import lombok.Data;

import java.io.IOException;
import java.util.Scanner;

@Data
public class MenuDoctorEntity {

    private AbstractDoctorController DoctorEntity ;
    private AbstractAppointmentController appointmentBook ;
    private DoctorAppointmentController showAllAppointment ;
    private AuthServiceImplementation auth;
    private boolean exit = false;
    private int option;
    private int idAuth;
    private String userAuth;
    private Scanner sc = new Scanner(System.in);

    public void idAuth(int id, String nombre) {
        this.idAuth = id;
        this.userAuth = nombre;
    }

    public void viewMenuDoctor() throws IOException {
        while (!exit) {

            System.out.println("-----MENU DOCTOR----- ");
            System.out.println("==============================");
            System.out.println("--- 1 - GESTION HISTORIAL ----- ");
            System.out.println("==============================");
            System.out.println("--- 2 - GESTION DE RECETAS----- ");
            System.out.println("  - Prescribir receta");
            System.out.println("  - Consultar receta");
            System.out.println("  - Eliminar receta");
            System.out.println("  - Enviar receta por email");
            System.out.println("==============================");
            System.out.println("--- 3 - AGENDA----- ");
            System.out.println("--- 0 - Salir ");
            System.out.println();
            System.out.print(" Ingrese la opción que desea: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    // Gestion Historial
                    ConsultationService consultationService = new ConsultationService();
                    PrintConsultationsService printConsultationsService = new PrintConsultationsService();
                    while (!exit) {
                        System.out.println("==============================");
                        System.out.println(
                                "GESTION HISTORIAL MEDICO\n"
                                        + "1 - Registrar consulta\n"
                                        + "2 - Ver consultas\n"
                                        + "3 - Imprimir hoja de consulta \n"
                        );
                        int option = sc.nextInt();
                        switch (option) {
                            case 1 -> {
                                System.out.println("==============================");
                                //  consultationService.createConsultation();
                            }
                            case 2 -> {
                                System.out.println("==============================");
                                //  consultationService.showAppointmentEntity();
                            }
                            case 3 -> {
                                System.out.println("==============================");
                                // printConsultationsService.createPdf();
                            }
                            default -> System.out.println("Opcion invalida");
                        }
                    }
                    break;

                case 2:
                    // Gestion de recetas
                    while (!exit) {
                        System.out.println("==============================");
                        System.out.println(
                                "GESTION RECETAS\n"
                                        + "1 - Preescribir receta\n"
                                        + "2 - Consultar recetas\n"
                                        + "3 - Eliminar recetas \n"
                                        + "4 - Enviar receta por correo");
                        option = sc.nextInt();
                        switch (option) {
                            case 1:
                                System.out.println("==============================");
                                // preescribir receta
                                DoctorEntity.addPrescription();
                                break;
                            case 2:
                                System.out.println("==============================");
                                // Consultar Recetas
                                DoctorEntity.showPrescription();
                                break;
                            case 3:
                                System.out.println("==============================");
                                // eliminar recetas
                                DoctorEntity.deletePrescription();
                                break;
                            case 4:
                                System.out.println("==============================");
                                auth.userLogin();
                                break;
                            default:
                                break;
                        }
                    }
                    break;

                case 3:
                    // Agenda
                    System.out.println("==============================");
                    System.out.println("-----AGENDA----");
                    showAllAppointment.showAllAppointment();
                    System.out.println("0 - Regresar");
                    int op = sc.nextInt();
                    if (op == 0) {
                        viewMenuDoctor();
                    }
                    break;

                case 0:
                    // Salir
                    exit = true;
                    auth.userLogin();
                    break;

                default:
                    break;
            }
        }
    }
}