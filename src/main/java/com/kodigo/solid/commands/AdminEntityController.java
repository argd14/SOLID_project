package com.kodigo.solid.commands;
import com.kodigo.solid.entities.DoctorEntity;
import com.kodigo.solid.data.fakedb.DataPDF;
import com.kodigo.solid.entities.UserEntity;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


@Data
public class AdminEntityController {

    private boolean addDoctor = false;
    DataPDF data = new DataPDF();
    UserEntity user= new UserEntity();
    Scanner sc = new Scanner(System.in);
    private int id;


    public void  addUserEntity() {
        Scanner sc = new Scanner(System.in);

        System.out.println("--------INGRESANDO DATOS DEL USUARIO-----r");
        System.out.println("ingrese el id del doctor: ");
        user.setId(sc.nextInt());
        System.out.println("ingrese el userName: ");
        user.setUsername(sc.next());
        System.out.println("ingrese el nombre del usuario: ");
        user.setName(sc.next());
        System.out.println("ingrese la fecha de nacimiento: ");
        user.setBirthday(LocalDate.parse(sc.next()));
        System.out.println("ingrese el numero de telefono: ");
        user.setPhoneNumber(sc.next());
        System.out.println("ingrese el email del usuario: ");
        user.setEmail(sc.next());
        System.out.println("ingrese la contraseña: ");
        user.setPassword(sc.next());
        System.out.println("ingrese el rol del usuario: ");
        user.setRole(sc.nextInt());

        data.addlistUser(user);

    }

    /*public void showDoctorEntity() {

        System.out.println("Ingrese el número de DUI del usuario a revisar: ");
        String dui = sc.next();
        String duiDoctor;

        for (int i = 0; i < data.getData().size(); i++) {

            duiDoctor = user.getDui();

            if (dui.equals(duiDoctor)) {
                System.out.println("------------------------------");
                //aqui mostrara los datos del usuario traido con el dui

            } else {
                System.out.println("No se encuentro el numero de usuario");
            }
        }

    }
*/
    public void updateUserEntity(){
        System.out.println("Ingrese el ID del usuario a actualizar: ");
        id = sc.nextInt();
        for (int i = 0; i < data.getData().size(); i++) {

            if (id == user.getId()) {
                System.out.println("==============================");
                System.out.println("--------ACTUALIZANDO DATOS DEL USUARIO-----r");
                System.out.println("ingrese el userName: ");
                user.setUsername(sc.next());
                System.out.println("ingrese el nombre del usuario: ");
                user.setName(sc.next());
                System.out.println("ingrese la fecha de nacimiento: ");
                user.setBirthday(LocalDate.parse(sc.next()));
                System.out.println("ingrese el numero de telefono: ");
                user.setPhoneNumber(sc.next());
                System.out.println("ingrese el email del usuario: ");
                user.setEmail(sc.next());
                System.out.println("ingrese la contraseña: ");
                user.setPassword(sc.next());
                System.out.println("ingrese el rol del usuario: ");
                user.setRole(sc.nextInt());

            } else {
                System.out.println("No se encuentro el numero de usuario");
            }
        }
    }

    public  void deleteUserEntity(){

        System.out.println("Ingrese el ID del usuario a actualizar: ");
        id = sc.nextInt();
        for (int i = 0; i < data.getData().size(); i++) {

            if (id == user.getId()) {
                data.getData().remove(i);

            } else {
                System.out.println("No se encuentro el numero de usuario");
            }
        }

    }

    public void showUserEntity() {
        System.out.println("usuarios-->"+ user.toString());
    }
}


