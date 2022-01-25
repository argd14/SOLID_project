package com.kodigo.solid.views;

import com.kodigo.solid.controllers.AdminEntityController;

import com.kodigo.solid.controllers.AppointmentBookController;
import com.kodigo.solid.controllers.PaymentEntityController;
import com.kodigo.solid.services.auth.AuthServiceImplementation;
import com.kodigo.solid.utils.menuMethods.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

@Data
@RequiredArgsConstructor
public class MenuAdminEntity {

    private Boolean exit = false;
    private String option;
    private Long id;
    private Scanner sc = new Scanner(System.in);

    ////////////////////////////////
    private final AdminEntityController adminEntityController;
    private final PaymentEntityController paymentEntityController;
    private final AppointmentBookController appointmentBook;
   private final AuthServiceImplementation auth;
    /////////////////////////////////


    public void viewMenuAdmin() {
        while (!exit) {
            adminMenu.printAdminMenu();
            option = sc.nextLine();

            switch (option) {

                case "1":
                    System.out.println("=============================\n");
                    System.out.println("-------AGREGAR NUEVO USUARIO-------");
                    System.out.println("===================================");
                    adminEntityController.createUser();
                    break;
                case "2":
                    System.out.println("==============================\n");
                    System.out.println("----------ACTUALIZAR USUARIO-----------");
                    System.out.println("=======================================");
                    System.out.println("Ingrese el ID del usuario a actualizar: ");
                    id = sc.nextLong();
                    adminEntityController.updateUser(adminEntityController.getUser(id));
                    break;
                case "3":
                    System.out.println("==============================\n");
                    System.out.println("-----------ELIMINAR USUARIO----------");
                    System.out.println("=====================================");
                    System.out.println("Ingrese el ID del usuario a eliminar: ");
                    id = sc.nextLong();
                    adminEntityController.deleteUser(id);
                    break;
                case "4":
                    System.out.println("==============================\n");
                    System.out.println("-------MOSTRAR USUARIOS-------");
                    System.out.println("1-Mostrar todos los usuarios");
                    System.out.println("2-Buscar usuarios por rol");
                    System.out.println("2-Buscar usuario por ID");
                    option = sc.nextLine();
                    switch (option) {

                        case "1":
                            adminEntityController.lisAllUsers();
                            System.out.println("\n0 - Regresar");
                            back(sc.nextLine());
                            break;
                        case "2":
                            System.out.println("Ingrese el rol a buscar");
                            int rol = sc.nextInt();
                            adminEntityController.findByRol(rol);
                            System.out.println("\n0 - Regresar");
                            sc.nextLine();
                            back(sc.nextLine());
                            sc.nextLine();
                            break;
                        case "3":
                            System.out.println("Ingrese el ID del usuario");
                            Long id = sc.nextLong();
                            System.out.println(adminEntityController.getUser(id));
                            System.out.println("\n0 - Regresar");
                            sc.nextLine();
                            back(sc.nextLine());
                            break;
                        default:
                            System.out.println("Opcion invalida, Ingrese una option correcta\n");
                            break;
                    }
                case "5":
                    System.out.println("==============================\n");
                    System.out.println("-------CITAS AGENDADAS-------");
                    System.out.println(appointmentBook.getAppointments());
                    System.out.println("\n0 - Regresar");
                    back(sc.nextLine());

                    break;
                case "6":
                    System.out.println("==============================\n");
                    System.out.println("-------PAGOS EFECTUADOS-------");
                    System.out.println(paymentEntityController.getPayments());
                    System.out.println("\n0 - Regresar");
                    back(sc.nextLine());
                    break;

                case "0":
                    exit = true;
                    auth.userLogin();
                    break;
                default:
                    System.out.println("Opcion invalida, Ingrese una option correcta\n");
                    break;

            }
        }
    }

    //Metodo nuevo para regresar
    public void back(String back) {
        if (back == "0") {
            viewMenuAdmin();
        } else {
            viewMenuAdmin();
        }
    }
}