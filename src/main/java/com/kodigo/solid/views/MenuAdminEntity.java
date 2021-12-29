package com.kodigo.solid.views;

import com.kodigo.solid.commands.AdminEntityController;
import com.kodigo.solid.commands.AdminEntityController;
import com.kodigo.solid.data.fakedb.DataPDF;
import com.kodigo.solid.entities.UserEntity;

import java.util.Scanner;

public class MenuAdminEntity {

    Scanner sc = new Scanner(System.in);
    private boolean exit = false;
    AdminEntityController userController = new AdminEntityController();
    UserEntity user ;
    int option;


    public void viewMenuAdmin()
    {
        while (!exit) {

            System.out.println("-----MENU ADMINISTRADOR----- ");
            System.out.println("==============================");
            System.out.println("-----GESTION DE USUARIOS----- ");
            System.out.println(" 1 - Crear un nuevo usuario ");
            System.out.println(" 2 - Modificar usuario ");
            System.out.println(" 3 - Eliminar usuario ");
            System.out.println("==============================");
            System.out.println("-----GESTION DE REPORTES----- ");
            System.out.println(" 4 - Reportes ");
            System.out.println(" 0 - Salir ");
            System.out.println();
            System.out.print(" Ingrese la opción que desea: ");
            int option = sc.nextInt();

           switch(option){

               case 1:
                   System.out.println("==============================");
                   System.out.println("AGREGAR USUARIO");
                   userController.addUserEntity();
                   break;
               case 2:
                   System.out.println("==============================");
                   System.out.println("ACTUALIZAR USUARIO");
                   System.out.println("Desea actualizar el registro 1-si/2-no");
                   option = sc.nextInt();
                   if(option==1){
                       userController.updateUserEntity();
                   }else{
                       viewMenuAdmin();
                   }

                   break;
               case 3:
                   System.out.println("==============================");
                   System.out.println("ELIMINAR USUARIO");
                   userController.deleteUserEntity();
                   break;
               case 4:
                   userController.showUserEntity();
                   break;
               case 0:
                   exit = true;
                   break;

           }
        }
    }
}
