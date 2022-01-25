package com.kodigo.solid.views;

import com.kodigo.solid.controllers.*;
import com.kodigo.solid.serviceAuth.AuthServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@Data
@RequiredArgsConstructor
public class MenuDoctorEntity {

    //dependencia
    private final DoctorPrescriptionController DoctorEntity;
    private final AppointmentBookController appointmentBook;
    private final AuthServiceImpl auth;



    private boolean exit = false;
    private String option;
    private Long idAuth;
    private String userAuth;
    private Scanner sc = new Scanner(System.in);


    public void viewMenuDoctor(){
        while (!exit) {

            System.out.println("-----MENU DOCTOR----- ");
            System.out.println("==============================");
            System.out.println("--- 1 - GESTION MEDICA ----- ");
            System.out.println("  - Registrar consulta");
            System.out.println("  - Actualizar consulta ");
            System.out.println("  - Eliminar consulta");
            System.out.println("==============================");
            System.out.println("--- 2 - GESTION DE RECETAS----- ");
            System.out.println("  - Prescribir receta");
            System.out.println("  - Consultar receta");
            System.out.println("  - Eliminar receta");
            System.out.println("==============================");
            System.out.println("--- 3 - AGENDA----- ");
            System.out.println("--- 0 - Salir ");
            System.out.println();
            System.out.print(" Ingrese la opción que desea: ");
            option = sc.nextLine();

            switch (option) {
                case "1":
                    while (!exit) {
                        System.out.println("==============================");
                        System.out.println("GESTION HISTORIAL MEDICO\n"
                                + "1 - Registrar consulta\n"
                                + "2 - Actualizar consulta\n"
                                + "3 - Eliminar consultas\n");
                        option = sc.nextLine();
                        switch (option) {
                            case "1" -> {
                                System.out.println("==============================");
                                appointmentBook.createAppointment();
                                System.out.println("\n0 - Regresar");
                                back(sc.nextLine());
                            }
                            case "2" -> {
                                System.out.println("==============================");
                                System.out.println("Ingrese el ID de la consulta ");
                                int id = sc.nextInt();
                                appointmentBook.updateAppointment(appointmentBook.getAppointment(id));
                                System.out.println("\n0 - Regresar");
                                back(sc.nextLine());
                            }
                            case "3" -> {
                                System.out.println("==============================");
                                System.out.println("Ingrese el ID de la consulta ");
                                int id = sc.nextInt();
                                appointmentBook.deleteAppointment(id);
                                System.out.println("\n0 - Regresar");
                                sc.nextInt();
                                back(sc.nextLine());
                            }

                            default -> System.out.println("Opcion invalida, Ingrese una option correcta\n");

                        }
                    }
                    break;
                //funconando
                case "2":
                    // Gestion de recetas
                    while (!exit) {
                        System.out.println("==============================");
                        System.out.println("GESTION RECETAS\n"
                                + "1 - Preescribir receta\n"
                                + "2 - Consultar recetas\n"
                                + "3 - Actualizar receta\n"
                                + "4 - Eliminar recetas \n");
                        option = sc.nextLine();
                        switch (option) {
                            case "1":
                                System.out.println("==============================");
                                // preescribir receta
                                DoctorEntity.createPrescription();
                                System.out.println("\n0 - Regresar");
                                back(sc.nextLine());
                                break;
                            case "2":
                                System.out.println("==============================");
                                // Consultar Recetas
                                DoctorEntity.listAllPrescription();
                                System.out.println("\n0 - Regresar");
                                back(sc.nextLine());
                                break;
                            case "3":
                                System.out.println("Ingrese el ID de la receta ");
                                Long id = sc.nextLong();
                                DoctorEntity.updatePrescription(DoctorEntity.getPrescription(id));
                                System.out.println("\n0 - Regresar");
                                back(sc.nextLine());
                                break;
                            case "4":
                                System.out.println("==============================");
                                // eliminar recetas
                                System.out.println("Ingrese el ID de la receta ");
                                id = sc.nextLong();
                                DoctorEntity.deletePrescription(id);
                                System.out.println("\n0 - Regresar");
                                back(sc.nextLine());
                                break;
                            default:
                                System.out.println("Opcion invalida, Ingrese una option correcta\n");
                                break;
                        }
                    }
                    break;

                case "3":
                    // Agenda
                    System.out.println("==============================");
                    System.out.println("-----AGENDA----");
                    appointmentBook.listAllAppointments(idAuth);
                    System.out.println("\n0 - Regresar");
                    back(sc.nextLine());
                    break;

                case "0":
                    // Salir
                    exit = true;
                    auth.userLogin();
                    break;
                default:
                     System.out.println("Opcion invalida, Ingrese una option correcta\n");
                    break;
            }
        }
    }
    //metodo nuevo para regresar
    public void back(String back) {
        if (back == "0") {
            viewMenuDoctor();
        } else {
            viewMenuDoctor();
        }
    }
}