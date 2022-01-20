package com.kodigo.solid.views;

import com.kodigo.solid.commands.AdminEntityController;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Scanner;
import com.kodigo.solid.utils.menuMethods.adminMenu;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuAdminEntity {

    private Boolean exit = false;
    private int option;
    private int id;
    private AdminEntityController userController = new AdminEntityController();
    private Scanner sc = new Scanner(System.in);

    public void viewMenuAdmin()
    {
        while (!exit) {

            adminMenu.printAdminMenu();

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
                   System.out.println("1 - Buscar usuario por ID\n" + "0 - Regresar");
                   option = sc.nextInt();
                   System.out.println("Ingrese el ID del usuario a ver: ");
                   id = sc.nextInt();
                   if(option == 1){
                      // userController.showUserEntity(id);
                   }else if(option == 0){
                       this.viewMenuAdmin();
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
