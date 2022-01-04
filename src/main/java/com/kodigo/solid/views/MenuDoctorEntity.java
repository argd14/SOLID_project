package com.kodigo.solid.views;

import com.kodigo.solid.commands.AppointmentBookController;
import com.kodigo.solid.commands.DoctorEntityController;
import com.kodigo.solid.entities.LoginEntity;
import com.kodigo.solid.services.auth.ConsultationService;
import com.kodigo.solid.services.auth.PrintConsultationsService;

import java.io.IOException;
import java.util.Scanner;

public class MenuDoctorEntity {
  LoginEntity login = new LoginEntity();
  Scanner sc = new Scanner(System.in);
  DoctorEntityController DoctorEntity = new DoctorEntityController();
  AppointmentBookController appointmentBook = new AppointmentBookController();
  private boolean exit = false;
  private int option, option3;
  private int option2;
  int idAuth;
  String userAuth;

  public void idAuth(int id, String nombre) {
    this.idAuth = id;
    this.userAuth =nombre;
  }
  public void viewMenuDoctor() throws IOException {
    while (!exit) {

      System.out.println("----------MENÚ DOCTOR----------");
      System.out.println("===============================");
      System.out.println("--- 1 - GESTIÓN HISTORIAL -----");
      System.out.println("===============================");
      System.out.println("--- 2 - GESTIÓN DE RECETAS ----");
      System.out.println("  - Prescribir receta");
      System.out.println("  - Consultar receta");
      System.out.println("  - Eliminar receta");
      System.out.println("  - Enviar receta por email");
      System.out.println("===============================");
      System.out.println("--- 3 - AGENDA ----------------");
      System.out.println("===============================");
      System.out.println("--- 0 - Salir ");
      System.out.println();
      System.out.print("Ingrese la opción que desea: ");
      option = sc.nextInt();

      switch (option) {
        case 1:
          // Gestion Historial
          ConsultationService consultationService = new ConsultationService();
          PrintConsultationsService printConsultationsService = new PrintConsultationsService();
          while (!exit) {
            System.out.println("===============================");
            System.out.println(
                    "GESTIÓN HISTORIAL MÉDICO\n"
                            + "1 - Registrar consulta\n"
                            + "2 - Ver consultas\n"
                            + "3 - Imprimir hoja de consulta \n"
            );
            int option = sc.nextInt();
            switch (option) {
              case 1 -> {
                System.out.println("===============================");
              //  consultationService.createConsultation(2);
              }
              case 2 -> {
                System.out.println("===============================");
              //  consultationService.showAll();
              }
              case 3 -> {
                System.out.println("===============================");
               // printConsultationsService.createPdf();
              }
              default -> System.out.println("Opción inválida");
            }
          }
          break;

        case 2:
          // Gestion de recetas
          while (!exit) {
            System.out.println("===============================");
            System.out.println(
                    "GESTIÓN RECETAS\n"
                            + "1 - Preescribir receta\n"
                            + "2 - Consultar recetas\n"
                            + "3 - Eliminar recetas \n"
                            + "4 - Enviar receta por correo");
            option2 = sc.nextInt();
            switch (option2) {
              case 1:
                System.out.println("===============================");
                // preescribir receta
                DoctorEntity.addPrescription();
                break;
              case 2:
                System.out.println("===============================");
                // Consultar Recetas
                DoctorEntity.showPrescription();
                break;
              case 3:
                System.out.println("===============================");
                // eliminar recetas
                DoctorEntity.deletePrescription();
                break;
              case 4:
                System.out.println("===============================");
                exit = true;
                break;
              default:
                break;
            }
          }
          break;

        case 3:
          // Agenda
          System.out.println("===============================");
          System.out.println("-----AGENDA----");
          appointmentBook.ShowAppointmentsEntity();
          System.out.println("0 - Regresar");
          int op = sc.nextInt();
          if (op == 0) {
            viewMenuDoctor();
          }
          break;

        case 0:
          // Salir
          exit = true;
          login.userLogin();
          break;

        default:
          break;
      }
    }
  }
}