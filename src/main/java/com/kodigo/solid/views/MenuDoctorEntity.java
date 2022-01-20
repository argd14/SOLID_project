package com.kodigo.solid.views;

import com.kodigo.solid.commands.AppointmentBookController;
import com.kodigo.solid.commands.DoctorEntityController;
import com.kodigo.solid.entities.LoginEntity;
import java.time.LocalDate;
import java.util.Scanner;
import com.kodigo.solid.utils.menuMethods.doctorMenu;

public class MenuDoctorEntity {

 // LoginEntity login = new LoginEntity();
  private boolean exit = false;
  Scanner sc = new Scanner(System.in);
  private int option, option3;
  private int option2;
  DoctorEntityController DoctorEntity = new DoctorEntityController();
  AppointmentBookController appointmentBook = new AppointmentBookController();

  public void viewMenuDoctor() {
    while (!exit) {

      doctorMenu.printDoctorMenu();
      option = sc.nextInt();

      switch (option) {
        case 1:
          // Gestion Historial
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
            option2 = sc.nextInt();
            switch (option2) {
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
                exit = true;
                break;
              default:
                break;
            }
          }
          break;

        case 3:
          // Agenda
            System.out.println("==============================");
            System.out.println("AGENDA\n"
                            + "1 - Todas las citas\n"
                            + "2 - Citas del dia");
            option3 = sc.nextInt();
          switch (option3) {
            case 1:
              System.out.println("==============================");
              // Listar todas las citas
              appointmentBook.listAppointments();
              break;
            case 2:
              System.out.println("==============================");
              // Listar citas de hoy
              appointmentBook.listAppointmentsByDay(LocalDate.now());
              break;
            default:
              break;
          }
          break;

        case 0:
          // Salir
          exit = true;
          //login.userLogin();
          break;

        default:
          break;
      }
    }
  }
}
