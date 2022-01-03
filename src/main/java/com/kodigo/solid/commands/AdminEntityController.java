package com.kodigo.solid.commands;

import com.kodigo.solid.entities.AdminEntity;
import com.kodigo.solid.entities.DoctorEntity;
import com.kodigo.solid.entities.PatientEntity;
import com.kodigo.solid.entities.UserEntity;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


@Data
public class AdminEntityController {

    UserEntity user;
    Scanner sc = new Scanner(System.in);
    int option;
    private boolean addDoctor = false;
    private ArrayList<AdminEntity> AdminEntityList = new ArrayList<>();
    private ArrayList<DoctorEntity> DoctorEntityList = new ArrayList<>();
    private ArrayList<PatientEntity> PatientEntityList = new ArrayList<>();
    private ArrayList<UserEntity> UsersEntityList = new ArrayList<>();
    private int id;
    private boolean exit;


    public void addUserEntity() {
        Scanner sc = new Scanner(System.in);

        System.out.println("--------INGRESANDO DATOS DEL USUARIO-----");
        System.out.println("ingrese el id del doctor: ");
        int id = sc.nextInt();
        System.out.println("ingrese el userName: ");
        String username = sc.next();
        System.out.println("ingrese el nombre del usuario: ");
        String name = sc.next();
        System.out.println("ingrese la fecha de nacimiento: ");
        LocalDate date = LocalDate.parse(sc.next());
        System.out.println("ingrese el numero de telefono: ");
        String phone = sc.next();
        System.out.println("ingrese el email del usuario: ");
        String email = sc.next();
        System.out.println("ingrese la contraseña: ");
        String password = sc.next();
        System.out.println("ingrese el rol del usuario: ");
        int rol = sc.nextInt();

        this.user = new UserEntity(id, username, name, date, phone, email, password, rol);
        UsersEntityList.add(this.user);
        if (rol == 1) {
            AdminEntity admin = new AdminEntity(id, username, name, date, phone, email, password, rol);
            AdminEntityList.add(admin);
        } else if (rol == 2) {
            DoctorEntity doctor = new DoctorEntity(id, username, name, date, phone, email, password, rol);
            DoctorEntityList.add(doctor);
        } else if (rol == 3) {
            PatientEntity patient = new PatientEntity(id, username, name, date, phone, email, password, rol);
            PatientEntityList.add(patient);
        }
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
    public void updateUserEntity() {
        System.out.println("Ingrese el ID del usuario a actualizar: ");
        id = sc.nextInt();
        for (int i = 0; i < getUsersEntityList().size(); i++) {

            if (id == getUsersEntityList().get(i).getId()) {
                System.out.println("==============================");
                System.out.println("--------ACTUALIZANDO DATOS DEL USUARIO-----r");
                System.out.println("ingrese el userName: ");
                String username = sc.next();
                System.out.println("ingrese el nombre del usuario: ");
                String name = (sc.next());
                System.out.println("ingrese la fecha de nacimiento: ");
                LocalDate birthday = (LocalDate.parse(sc.next()));
                System.out.println("ingrese el numero de telefono: ");
                String telephone = (sc.next());
                System.out.println("ingrese el email del usuario: ");
                String email = (sc.next());
                System.out.println("ingrese la contraseña: ");
                String password = (sc.next());
                System.out.println("ingrese el rol del usuario: ");
                int rol = (sc.nextInt());
                System.out.println("El registro fue actualizado exitosamente\n");
                this.user = new UserEntity(
                        1,
                        username,
                        name,
                        birthday,
                        telephone,
                        telephone,
                        password,
                        rol);

            } else {
                System.out.println("No se encuentro el numero de usuario");
            }
        }
    }

    public void deleteUserEntity() {

        System.out.println("Ingrese el ID del usuario a Eliminar: ");
        id = sc.nextInt();
        for (int i = 0; i < getUsersEntityList().size(); i++) {

            if (id == UsersEntityList.get(i).getId()) {
                UsersEntityList.remove(i);
                System.out.println("Usuario eliminado exitosamente");
            } else {
                System.out.println("No se encuentro el numero de usuario");
            }
        }

    }

    public void showUserEntity() {
        while (!exit) {
            System.out.println("1-mostrar todos los usuarios\n" + "2-buscar usuario por ID");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println(UsersEntityList);
                    break;
                case 2:

                    System.out.println("Ingrese el ID del usuario a ver: ");
                    id = sc.nextInt();
                    for (int i = 0; i < UsersEntityList.size(); i++) {

                        if (id == UsersEntityList.get(i).getId()) {
                            System.out.println(UsersEntityList.get(i));

                        }

                        break;
                    }

            }

        }
    }


}


