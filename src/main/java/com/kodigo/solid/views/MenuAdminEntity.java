package com.kodigo.solid.views;

import com.kodigo.solid.commands.AdminEntityController;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Scanner;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuAdminEntity {

    private Boolean exit = false;
    private AdminEntityController userController = new AdminEntityController();
    private int option;
    private int id;
    private Scanner sc = new Scanner(System.in);

    public void viewMenuAdmin()
    {
        while (!exit) {

            System.out.println("------MENU ADMINISTRADOR------");
            System.out.println("==============================");
            System.out.println("------GESTION DE USUARIOS------");
            System.out.println(" 1 - Crear un nuevo usuario ");
            System.out.println(" 2 - Modificar usuario ");
            System.out.println(" 3 - Eliminar usuario ");
            System.out.println("==============================");
            System.out.println("------GESTION DE REPORTES------");
            System.out.println(" 4 - Reporte usuarios ");
            System.out.println(" 5 - Reporte citas ");
            System.out.println(" 6 - Reporte pagos ");
            System.out.println(" 0 - Salir ");
            System.out.print("Ingrese la opción que desea: ");
            option = sc.nextInt();

           switch(option){

               case 1:
                   System.out.println("==============================");
                   System.out.println("-------AGREGAR USUARIO-------");
                   userController.addUserEntity();
                   break;
               case 2:
                   System.out.println("==============================");
                   System.out.println("-------ACTUALIZAR USUARIO-----");
                   System.out.println("Ingrese el ID del usuario a actualizar: ");
                   id = sc.nextInt();
                   System.out.println("Desea actualizar el registro?--> 1 - si / 0 - Regresar");
                   option = sc.nextInt();
                       if(option == 1) {
                           for (int i = 0; i < userController.getUsersEntityList().size(); i++) {
                               if (id == userController.getUsersEntityList().get(i).getId()) {
                                   userController.updateUserEntity();
                               } else if (option == 0) {
                                   viewMenuAdmin();
                               }else {
                                 exit = true;
                               }
                           }
                       }

                   break;
               case 3:
                   System.out.println("==============================");
                   System.out.println("--------ELIMINAR USUARIO------");
                   System.out.println("Ingrese el ID del usuario a Eliminar: ");
                   id = sc.nextInt();
                   userController.deleteUserEntity(id);
                   break;
               case 4:
                   System.out.println("==============================");
                   System.out.println("-------MOSTRAR USUARIOS-------");
                   userController.showUserEntity();
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
                   exit = true;
                   break;

           }
        }
    }
}
