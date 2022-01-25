package com.kodigo.solid.views;

import com.kodigo.solid.controllers.AppointmentBookController;
import com.kodigo.solid.controllers.PaymentEntityController;
import com.kodigo.solid.serviceAuth.AuthServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@Data
@RequiredArgsConstructor
public class MenuPatientEntity {


    //dependencia
    private final AppointmentBookController appointmentBook;
    private final PaymentEntityController paymentController;
    private final AuthServiceImpl auth;

    private  Long idAuth;
    private  String userAuth;
    private String option;
    private int confirm, idApp;
    private boolean exit = false;

    private Scanner sc = new Scanner(System.in);


    public void viewMenuPatient() {
        System.out.println("---------MENÚ PACIENTE---------");
        System.out.println("===============================");
        System.out.println("--- 1 - GESTIÓN DE CITAS ------");
        System.out.println("-Crear cita\n-Actualizar cita\n-Eliminar cita");
        System.out.println("===============================");
        System.out.println("--- 2 - GESTIÓN DE PAGOS ------");
        System.out.println("-Historial de Pagos\n-Buscar pago \n-Eliminar pago");
        System.out.println("===============================");
        System.out.println("--- 3 - AGENDA ----------------");
        System.out.println("===============================");
        System.out.println("0 - Salir");

        System.out.print("Ingrese la opción que desea: ");
        option = sc.nextLine();
        while (!exit) {
            switch (option) {
                case "1":
                    System.out.println("===============================");
                    System.out.println("---------GESTIÓN CITAS---------");
                    System.out.println("===============================");
                    System.out.println("1. Nueva Cita\n2. Actualizar Cita\n3. Eliminar cita\n0. Regresar");
                    System.out.print("Ingrese la opción que desea: ");
                    option = sc.nextLine();
                    switch (option) {
                        case "1":
                            appointmentBook.createAppointment();
                            System.out.println("\n0 - Regresar");
                            back(sc.nextLine());
                            break;
                        case "2":
                            System.out.println("Ingrese el ID de la cita: ");
                            int idCita = sc.nextInt();
                            appointmentBook.updateAppointment(appointmentBook.getAppointment(idCita));
                            System.out.println("\n0 - Regresar");
                            back(sc.nextLine());
                            break;
                        case "3":
                            System.out.println("Ingrese el ID de la cita: ");
                            idCita = sc.nextInt();
                            appointmentBook.deleteAppointment(idCita);
                            System.out.println("\n0 - Regresar");
                            back(sc.nextLine());
                            break;

                        case "0":
                            viewMenuPatient();
                            break;
                        default:
                            System.out.println("Opcion invalida, Ingrese una option correcta\n");
                            break;

                    }
                    break;

                case "2":
                    System.out.println("===============================");
                    System.out.println("---------GESTIÓN PAGOS---------");
                    System.out.println("===============================");
                    System.out.println("1. Historial de Pagos\n2. Buscar pago \n3. Eliminar pago \n0. Regresar");
                    System.out.println("Ingrese la opción que desea: ");
                    option = sc.nextLine();
                    switch (option) {
                        case "1":
                            System.out.println("===============================");
                            System.out.println("-----Pagos realizados ");
                            paymentController.listAllPayments(idAuth);
                            System.out.println("\n0 - Regresar");
                            back(sc.nextLine());
                            break;
                        case "2":
                            System.out.println("Ingrese numero de pago");
                            idApp = sc.nextInt();
                            System.out.println(paymentController.getPayment(idApp));
                            System.out.println("\n0 - Regresar");
                            back(sc.nextLine());
                            break;
                        case "3":
                            System.out.println("Ingrese numero de pago");
                            idApp = sc.nextInt();
                            paymentController.deletePayment(idApp);
                            System.out.println("\n0 - Regresar");
                            back(sc.nextLine());
                            break;
                        case "0":
                            viewMenuPatient();
                            break;
                        default:
                            System.out.println("Opcion invalida, Ingrese una option correcta\n");
                            break;
                    }
                    break;

                case "3":
                    System.out.println("-----Citas agendadas-----");
                    appointmentBook.listAllAppointments(idAuth);
                    System.out.println("\n0 - Regresar");
                    back(sc.nextLine());
                    break;

                case "0":
                    auth.userLogin();
                    break;
                default:
                    System.out.println("Opcion invalida, Ingrese una option correcta\n");
                    break;

            }
            viewMenuPatient();
        }


    }

    //metodo nuevo para regresar
    public void back(String back) {
        if (back == "0") {
            viewMenuPatient();
        } else {
            viewMenuPatient();
        }
    }


}