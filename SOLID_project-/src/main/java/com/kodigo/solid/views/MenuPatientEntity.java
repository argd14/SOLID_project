package com.kodigo.solid.views;

import com.kodigo.solid.commands.AppointmentBookController;
import com.kodigo.solid.commands.PaymentEntityController;
import com.kodigo.solid.entities.AppointmentEntity;
import com.kodigo.solid.entities.LoginEntity;
import com.kodigo.solid.entities.PaymentEntity;
import lombok.SneakyThrows;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class MenuPatientEntity implements IMenu {
  private String option, option2;
  LoginEntity login = new LoginEntity();
  private int id;
  Scanner sc = new Scanner(System.in);
  AppointmentBookController appointmentBook = new AppointmentBookController();
  PaymentEntityController paymentManager = new PaymentEntityController();
  private boolean exit = false;

  public MenuPatientEntity(int id) {}

  public void Print() {
    System.out.println("MENU PACIENTE\n********************");
    System.out.println("1. Citas\n2. Pagos\n3. Recetas\n4. Agenda\n5. Historial Medico\n6. Salir");
    System.out.println("Ingrese una opcion");
    option = sc.next();
    NavigateMenu();
  }

  @SneakyThrows
  public void NavigateMenu() {
    while (!exit) {
      switch (option) {
        case "1":
          System.out.println("==============================");
          System.out.println("GESTION CITAS");
          System.out.println("==============================");
          System.out.println("1. Nueva Cita\n2.Actualizar Cita\n3.Cancelar Cita\n4.Regresar");
          System.out.println("Ingrese una opcion");
          option2 = sc.next();
          switch (option2) {
            case "1":
              System.out.println("Pedir Cita");
              System.out.println("Ingrese Fecha");
              LocalDate d = LocalDate.parse(sc.next());
              System.out.println("Ingrese Hora");
              LocalTime t = LocalTime.parse(sc.next());
              AppointmentEntity newAppointment = new AppointmentEntity(id, d, t);
              appointmentBook.add(newAppointment);
              System.out.println("-----------------------");
              System.out.println("Presione cualquier tecla para continuar");
              System.in.read();
              break;
            case "2":
              // Actualizar cita
              System.out.println("Actualizar Cita");
              System.out.println("Ingrese Cita ID");
              int appointmentId = sc.nextInt();
              System.out.println("Ingrese nueva fecha");
              LocalDate da = LocalDate.parse(sc.next());
              System.out.println("Ingrese nueva hora");
              LocalTime ta = LocalTime.parse(sc.next());
              for (AppointmentEntity a : appointmentBook.Appointments) {
                if(appointmentId == a.getId()){
                  appointmentBook.update(a, da, ta);
                  break;
                } else {
                  System.out.println("Cita no encontrada");
                }
              }
              System.out.println("-----------------------");
              System.out.println("Presione cualquier tecla para continuar");
              System.in.read();
              break;

            case "3":
              // Eliminar una cita
              System.out.println("Cancelar Cita");
              System.out.println("Ingrese Cita ID");
              appointmentId = sc.nextInt();
              for (AppointmentEntity a : appointmentBook.Appointments) {
                if(appointmentId == a.getId()){
                  appointmentBook.remove(a);
                  break;
                } else {
                  System.out.println("Cita no encontrada");
                }
              }
              System.out.println("-----------------------");
              System.out.println("Presione cualquier tecla para continuar");
              System.in.read();
              break;
            case "4":
              // Regresar
              Print();
              break;

            default: break;
          }
          System.out.println("Presione cualquier tecla para continuar");
          System.in.read();
          break;

        case "2":
          System.out.println("==============================");
          System.out.println("PAGOS");
          System.out.println("==============================");
          System.out.println("1. Historial de Pagos\n2.Imprimir factura");
          System.out.println("Ingrese una opcion");
          option2 = sc.next();
          switch (option2) {
            case "1":
             //historial de pagos
              PaymentEntity newPayment = new PaymentEntity(id, "Pago de consulta", 15.00);
              paymentManager.add(newPayment);
              PaymentEntity newPayment2 = new PaymentEntity(id, "Pago de receta", 25.00);
              paymentManager.add(newPayment2);
              System.out.println("*******************-");
              paymentManager.listPatientPayments(id);
              System.out.println("-----------------------");
              System.out.println("Presione cualquier tecla para continuar");
              System.in.read();
              break;
            case "2":
              // factura
              System.out.println("Imprimir Factura");
              System.out.println("Ingrese Pago ID");
              int paymentId = sc.nextInt();
              for (PaymentEntity p : paymentManager.payments) {
                if(paymentId == p.getId()){
                  paymentManager.printPayment(p);
                  break;
                } else {
                  System.out.println("Pago no encontrado");
                }
              }
              System.out.println("-----------------------");
              System.out.println("Presione cualquier tecla para continuar");
              System.in.read();
              break;

              default: break;
          }
          System.out.println("Presione cualquier tecla para continuar");
          System.in.read();
          break;

        case "3":
          //RECETAS
          break;

        case "4":
          appointmentBook.listPatientAppointments(id);
          System.out.println("Presione cualquier tecla para continuar");
          System.in.read();
          break;

        case "5":
          //HISTORIAL MEDICO
          break;

        case "6":
          exit = true;
          login.userLogin();
          break;

        default:
          break;
      }
      Print();
    }
  }
}
