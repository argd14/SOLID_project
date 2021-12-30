package com.kodigo.solid.views;
import com.kodigo.solid.commands.DoctorEntityController;

import java.util.Scanner;

public class MenuDoctorEntity {

    private boolean exit = false;
    Scanner sc = new Scanner(System.in);
    private int option;
    private int option2;
    DoctorEntityController DoctorEntity = new DoctorEntityController();

    public void viewMenuDoctor() {
        while (!exit) {

            System.out.println("-----MENU DOCTOR----- ");
            System.out.println("==============================");
            System.out.println("-----GESTION HISTORIAL ----- ");
            System.out.println(" 1 - Registrar consulta ");
            System.out.println(" 2 - Ver consulta");
            System.out.println("==============================");
            System.out.println("-----GESTION DE RECETAS----- ");
            System.out.println(" 3 - Prescribir receta");
            System.out.println(" 4 - Consultar receta");
            System.out.println(" 5 - Enviar receta por email");
            System.out.println("==============================");
            System.out.println("-----AGENDA----- ");
            System.out.println(" 6 - Consultar agenda");
            System.out.println(" 0 - Salir ");
            System.out.println();
            System.out.print(" Ingrese la opción que desea: ");
            option = sc.nextInt();

            switch(option) {

                case 4:
                    while (!exit) {
                        System.out.println("==============================");
                        System.out.println("GESTION RECETAS\n" + "1 - Preescribir receta\n" + "2 - Consultar recetas\n" + "3 - Eliminar recetas \n" + "4 - Enviar receta por correo");
                        option2 = sc.nextInt();

                        switch (option2) {

                            case 1:
                                System.out.println("==============================");
                                //preescribir receta
                                DoctorEntity.addPrescription();
                                break;
                            case 2:
                                System.out.println("==============================");
                                // Consultar Recetas
                                DoctorEntity.showPrescription();
                                break;
                            case 3:
                                System.out.println("==============================");
                                //eliminar recetas
                                DoctorEntity.deletePrescription();
                                break;
                            case 4:
                                System.out.println("==============================");
                                exit = true;
                                break;

                        }

                        break;

                    }
            }
        }
    }
}
