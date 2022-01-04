package com.kodigo.solid.views;

import com.kodigo.solid.controllers.AbstractAppointmentController;
import com.kodigo.solid.controllers.AbstractPaymentController;
import com.kodigo.solid.controllers.AppointmentBookController;
import com.kodigo.solid.controllers.PaymentEntityController;
import com.kodigo.solid.entities.AppointmentEntity;
import fkDatabase.PaymentDataBase;
import com.kodigo.solid.services.auth.AuthServiceImplementation;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Scanner;

@Data
@NoArgsConstructor
public class MenuPatientEntity {
    private int option;
    private int idCita, idAuth;
    private String userAuth;
    private AbstractAppointmentController appointmentBook ;
    private AbstractPaymentController paymentManager ;
    private PaymentDataBase data = new PaymentDataBase();
    private AuthServiceImplementation auth;
    private boolean exit = false;
    private int confirm;
    private Scanner sc = new Scanner(System.in);

    public void idAuth(int id, String nombre) {
        this.idAuth = id;
        this.userAuth = nombre;
    }

    public void viewMenuPatient() {
        data.dataBase(this.idAuth);
        System.out.println("---------MENÚ PACIENTE---------");
        System.out.println("===============================");
        System.out.println("--- 1 - GESTIÓN DE CITAS ------");
        System.out.println("-Crear cita\n-Actualizar cita\n-Cancelar cita");
        System.out.println("===============================");
        System.out.println("--- 2 - GESTIÓN DE PAGOS ------");
        System.out.println("-Historial de pago\n-Imprimir factura");
        System.out.println("===============================");
        System.out.println("--- 3 - AGENDA ----------------");
        System.out.println("===============================");
        System.out.println("0 - Salir");

        System.out.print("Ingrese la opción que desea: ");
        option = sc.nextInt();
        while (!exit) {
            switch (option) {
                case 1:
                    System.out.println("===============================");
                    System.out.println("---------GESTIÓN CITAS---------");
                    System.out.println("===============================");
                    System.out.println("1. Nueva Cita\n2. Actualizar Cita\n3. Cancelar Cita\n0. Regresar");
                    System.out.print("Ingrese la opción que desea: ");
                    option = sc.nextInt();
                    switch (option) {
                        case 1:
                            appointmentBook.addAppointment(this.idAuth, this.userAuth);
                            break;
                        case 2:
                            System.out.println("Ingrese el ID de la cita: ");
                            idCita = sc.nextInt();
                            if (idCita == this.idAuth) {
                                appointmentBook.updateAppointment();
                            }
                            break;
                        case 3:
                            if (appointmentBook.getAppointments().isEmpty()) {
                                System.out.println(appointmentBook.getAppointments());
                                System.out.println("no existen citas en agenda\n");
                            } else {
                                System.out.println("Eliminar cita--> 1-- si / 0 Regresar ");
                                confirm = sc.nextInt();
                            }

                            switch (confirm) {
                                case 1:
                                    appointmentBook.deleteAppointment(this.idAuth);
                                    break;
                                case 2:
                                    viewMenuPatient();
                                    break;
                            }
                            break;
                        case 0:
                            viewMenuPatient();
                            break;
                    }
                    break;

                case 2:
                    System.out.println("===============================");
                    System.out.println("---------GESTIÓN PAGOS---------");
                    System.out.println("===============================");
                    System.out.println("1. Historial de Pagos\n2. Imprimir factura\n0. Regresar");
                    System.out.println("Ingrese la opción que desea: ");
                    option = sc.nextInt();
                    switch (option) {
                        case 1:
                            //historial de pagos
                            System.out.println("===============================");
                            System.out.println("-----Pagos realizados ");
                            paymentManager.listPatientPayments(this.idAuth);
                            System.out.println("-------------------------------");
                            break;
                        case 2:
                            // factura
                            System.out.println("Imprimir Factura");
                            System.out.println("Ingrese Pago ID:");
                            int paymentId = sc.nextInt();
                            paymentManager.printPayment(paymentId);
                            break;
                        case 0:
                            exit = true;
                            break;
                    }

                    break;

                case 3:
                    appointmentBook.listPatientAppointments(this.idAuth, this.userAuth);
                    break;

                case 0:
                    auth.userLogin();
                    break;

            }
            viewMenuPatient();
        }


    }


}