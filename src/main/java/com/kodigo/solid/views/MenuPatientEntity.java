package com.kodigo.solid.views;

import com.kodigo.solid.commands.AdminEntityController;
import com.kodigo.solid.commands.AppointmentBookController;
import com.kodigo.solid.commands.PaymentEntityController;
import com.kodigo.solid.entities.AppointmentEntity;
import com.kodigo.solid.entities.PaymentEntity;
import com.kodigo.solid.services.auth.AuthServiceImplementation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Scanner;

@Data
@NoArgsConstructor
public class MenuPatientEntity {
    private int option, option2;
    private int idCita, idAuth;
    private String userAuth;
    Scanner sc = new Scanner(System.in);
    AppointmentBookController appointmentBook = new AppointmentBookController();
    PaymentEntityController paymentManager = new PaymentEntityController();
    AppointmentEntity appointment;
    private boolean exit = false;

    public void idAuth(int id, String nombre) {
        this.idAuth = id;
        this.userAuth =nombre;
    }

    public void viewMenuPatient() {
        dataBase2();
        System.out.println("------MENU PACIENTE------");
        System.out.println("==============================");
        System.out.println("1------GESTION DE CITAS------");
        System.out.println("-Crear cita\n-Actualizar cita\n-Cancelar cita");
        System.out.println("==============================");
        System.out.println("2------GESTION DE PAGOS------");
        System.out.println("-Historial de pago\n-Imprimir factura");
        System.out.println("==============================");
        System.out.println("4 - Agenda");
        System.out.println("0 - Salir");

        System.out.print("Ingrese la opción que desea: ");
        option = sc.nextInt();
        while (!exit) {
            switch (option) {
                case 1:
                    System.out.println("==============================");
                    System.out.println("-------GESTION CITAS-------");
                    System.out.println("==============================");
                    System.out.println("1. Nueva Cita\n2.Actualizar Cita\n3.Cancelar Cita\n0.Regresar");
                    System.out.print("Ingrese la opción que desea: ");
                    option2 = sc.nextInt();
                    switch (option2) {
                        case 1:
                            appointmentBook.addAppointmentEntity(this.idAuth,this.userAuth);
                            break;
                        case 2:
                            System.out.println("Ingrese el ID de la cita ");
                            idCita = sc.nextInt();
                            if (idCita == this.idAuth) {
                                appointmentBook.updateAppointmentEntity();
                            }
                            break;
                        case 3:

                            System.out.println(appointmentBook.getAppointments());
                            System.out.println("ingrese la fecha de la cita a eliminar");
                            LocalDate date = LocalDate.parse(sc.next());
                            appointmentBook.deleteAppointmentEntity(date);
                            System.out.println("Cita eliminada exitosamente");
                            break;
                        case 0:
                            viewMenuPatient();
                            break;
                    }
                    break;

                case 2:
                    System.out.println("==============================");
                    System.out.println("-------GESTION PAGOS-------");
                    System.out.println("==============================");
                    System.out.println("1. Historial de Pagos\n2.Imprimir factura\n0.Regresar");
                    System.out.println("Ingrese una opcion");
                    option2 = sc.nextInt();
                    switch (option2) {
                        case 1:
                            //historial de pagos
                            System.out.println("*******************-");
                            paymentManager.listPatientPayments(this.idAuth,this.userAuth);
                            System.out.println("-----------------------");
                            break;
                        case 2:
                            // factura
                            System.out.println("Imprimir Factura");
                            System.out.println("Ingrese Pago ID");
                            int paymentId = sc.nextInt();
                            paymentManager.printPayment(paymentId);
                            break;
                        case 0:
                            exit = true;
                            break;
                    }

                    break;

                case 3:
                    //RECETAS
                    break;

                case 4:
                    appointmentBook.listPatientAppointments(this.idAuth,this.userAuth);
                    break;

                case 0:
                    exit = true;
                    break;

            }
            viewMenuPatient();
        }


    }

    public void dataBase2() {
        PaymentEntity newPayment = new PaymentEntity(1, this.idAuth, "Pago de consulta", 15.00);
        paymentManager.addPaymentEntity(newPayment);
        PaymentEntity newPayment2 = new PaymentEntity(2, this.idAuth, "Pago de receta", 25.00);
        paymentManager.addPaymentEntity(newPayment2);
    }
}
