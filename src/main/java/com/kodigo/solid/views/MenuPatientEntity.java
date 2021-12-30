package com.kodigo.solid.views;

import com.kodigo.solid.commands.patient.AppointmentBookEntity;
import com.kodigo.solid.commands.PaymentEntityController;
import com.kodigo.solid.entities.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;


@NoArgsConstructor
public class MenuPatientEntity {
    private String option, option2;
    main.java.com.kodigo.solid.entities.LoginEntity login = new main.java.com.kodigo.solid.entities.LoginEntity();
    private int id;
    Scanner sc = new Scanner(System.in);
    AppointmentBookEntity appointmentBook = new AppointmentBookEntity();
    PaymentEntityController paymentManager = new PaymentEntityController();
    private boolean exit = false;

    public MenuPatientEntity(int id) {
    }


    public void viewMenuPatient() {

        System.out.println("User Options\n********************");
        System.out.println("1. Gestionar Citas\n2. Pagos\n3. Historial Medico\n4. Agenda\n5. Salir");
        System.out.println("Ingrese una opcion");
        option = sc.next();
        NavigateMenu();
    }
        public void NavigateMenu () {
            while (!exit) {
                switch (option) {
                    case "1":
                        System.out.println("==============================");
                        System.out.println("GESTION CITAS");
                        System.out.println("==============================");
                        System.out.println("1. Crear\n2.Actualizar\n3.Eliminar\n4.Regresar");
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
                                sc.next();
                                break;
                            case "2":
                                //Actualzar cita
                                break;

                            case "3":
                                //Eliminar una cita
                                break;
                            case "4":
                                //Regresar
                                NavigateMenu();
                                break;
                        }


                        System.out.println("Pedir Cita");
                        System.out.println("Ingrese Fecha");
                        LocalDate d = LocalDate.parse(sc.next());
                        System.out.println("Ingrese Hora");
                        LocalTime t = LocalTime.parse(sc.next());
                        AppointmentEntity newAppointment = new AppointmentEntity(id, d, t);
                        appointmentBook.add(newAppointment);
                        System.out.println("-----------------------");
                        System.out.println("Presione cualquier tecla para continuar");
                        sc.next();
                        break;

                    case "2":
                        PaymentEntity newPayment = new PaymentEntity(id, "Pago de consulta", 15.00);
                        paymentManager.add(newPayment);
                        PaymentEntity newPayment2 = new PaymentEntity(id, "Pago de receta", 25.00);
                        paymentManager.add(newPayment2);
                        System.out.println("*******************-");
                        paymentManager.listPatientPayments(id);
                        System.out.println("Presione cualquier tecla para continuar");
                        sc.next();
                        break;
                    case "3":

                        break;

                    case "4":
                        appointmentBook.listPatientAppointments(id);
                        System.out.println("Presione cualquier tecla para continuar");
                        sc.next();
                        break;

                    case "5":
                        exit = true;
                        login.userLogin();
                        break;

                    default:
                        break;
                }
              viewMenuPatient();
            }
        }

}

