package main.java.com.kodigo.solid.views;

import main.java.com.kodigo.solid.commands.patient.AppointmentBookEntity;
import main.java.com.kodigo.solid.commands.PaymentManagerEntity;
import main.java.com.kodigo.solid.entities.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class PatientMenu implements IMenu {
    String Option;
    Login login = new Login();
    int id;
    Scanner sc = new Scanner(System.in);
    AppointmentBookEntity appointmentBook = new AppointmentBookEntity();
    PaymentManagerEntity paymentManager = new PaymentManagerEntity();

    public PatientMenu(int id) {
        this.id = id;
    }

    public void Print() {
        System.out.println("User Options\n********************");
        System.out.println("1. Citas\n2. Pagos\n3. Historial Medico\n4. Agenda\n5. Salir");
        System.out.println("Ingrese una opcion");
        Option = sc.next();
        NavigateMenu();
    }

    public void NavigateMenu()  {
        switch (Option){
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
                PaymentEntity newPayment = new PaymentEntity(id,"Pago de consulta", 15.00);
                paymentManager.add(newPayment);
                PaymentEntity newPayment2 = new PaymentEntity(id,"Pago de receta", 25.00);
                paymentManager.add(newPayment2);
                System.out.println("*******************-");
                paymentManager.listPatientPayments(id);
                System.out.println("Presione cualquier tecla para continuar");
                sc.next();
                break;

            case "4":
                appointmentBook.listPatientAppointments(id);
                System.out.println("Presione cualquier tecla para continuar");
                sc.next();
                break;

            case "5":
                login.userLogin();
                break;

            default: break;
        }
        Print();
    }
}

