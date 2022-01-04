package com.kodigo.solid.views;

import com.kodigo.solid.controllers.AbstractAdminController;
import com.kodigo.solid.controllers.InterfaceAdminController;
import com.kodigo.solid.services.auth.AuthServiceImplementation;
import lombok.Data;

import java.util.Scanner;

@Data
public class MenuAdminEntity {

    private Boolean exit = false;
    private AbstractAdminController AbsUserController;
    private InterfaceAdminController IntUserController;
    private AuthServiceImplementation auth;
    private int option;
    private int id;
    private Scanner sc = new Scanner(System.in);

    public void viewMenuAdmin()
    {
        while (!exit) {

            System.out.println("-----MENU ADMINISTRADOR------");
            System.out.println("=============================");
            System.out.println("-----GESTIÓN DE USUARIOS-----");
            System.out.println(" 1 - Crear un nuevo usuario ");
            System.out.println(" 2 - Modificar usuario ");
            System.out.println(" 3 - Eliminar usuario ");
            System.out.println("=============================");
            System.out.println("-----GESTIÓN DE REPORTES-----");
            System.out.println(" 4 - Reporte usuarios ");
            System.out.println(" 5 - Reporte citas ");
            System.out.println(" 6 - Reporte pagos ");
            System.out.println(" 0 - Salir ");
            System.out.print("Ingrese la opción que desea: ");
            option = sc.nextInt();

            switch(option){

                case 1:
                    System.out.println("=============================\n");
                    System.out.println("-------AGREGAR NUEVO USUARIO-------");
                    System.out.println("===================================");
                    IntUserController.addEntity();
                    break;
                case 2:
                    System.out.println("==============================\n");
                    System.out.println("----------ACTUALIZAR USUARIO-----------");
                    System.out.println("=======================================");
                    System.out.println("Ingrese el ID del usuario a actualizar: ");
                    id = sc.nextInt();

                        for (int i = 0; i < AbsUserController.getUsersEntityList().size(); i++) {
                            if (id == AbsUserController.getUsersEntityList().get(i).getId()) {
                                IntUserController.updateEntity();
                            } else{
                                viewMenuAdmin();
                            }


                        }


                    break;
                case 3:
                    System.out.println("==============================\n");
                    System.out.println("-----------ELIMINAR USUARIO----------");
                    System.out.println("=====================================");
                    System.out.println("Ingrese el ID del usuario a eliminar: ");
                    id = sc.nextInt();
                    IntUserController.deleteEntity(id);
                    break;
                case 4:
                    System.out.println("==============================\n");
                    System.out.println("-------MOSTRAR USUARIOS-------");
                    System.out.println("==============================");
                    IntUserController.showAllEntity();
                    System.out.println("\n0 - Regresar");
                    option = sc.nextInt();
                    if(option == 0){
                        viewMenuAdmin();
                    }else{
                        exit = true;
                    }

                    break;
                case 5:
                    //Reporte citas
                    break;
                case 6:
                    //Reporte pagos
                    break;
                case 0:
                    auth.userLogin();
                    break;

            }
        }
    }
}