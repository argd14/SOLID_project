package com.kodigo.solid.controllers;

import com.kodigo.solid.entities.AdminEntity;
import com.kodigo.solid.entities.DoctorEntity;
import com.kodigo.solid.entities.PatientEntity;
import com.kodigo.solid.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminEntityController extends AbstractAdminController {

    private UserEntity user;
    private int rol;
    private Scanner sc = new Scanner(System.in);

    @Override
    public void addEntity() {
        System.out.println("--------INGRESANDO DATOS DEL USUARIO-----");
        System.out.println("ingrese el id del Usuario: ");
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
        rol = sc.nextInt();

        user = new UserEntity(id, username, name, date, phone, email, password, rol);
        UsersEntityList.add(user);
        writeFile();

        if (this.rol == 1) {
            AdminEntity admin = new AdminEntity(id, username, name, date, phone, email, password, rol);
            AdminEntityList.add(admin);

        } else if (this.rol == 2) {
            DoctorEntity doctor = new DoctorEntity(id, username, name, date, phone, email, password, rol);
            DoctorEntityList.add(doctor);
        } else if (this.rol == 3) {
            PatientEntity patient = new PatientEntity(id, username, name, date, phone, email, password, rol);
            PatientEntityList.add(patient);
        }
    }

    @Override
    public void updateEntity() {
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
        System.out.println("El registro fue actualizado exitosamente\n");

    }

    @Override
    public void deleteEntity(int id) {
        for (int i = 0; i < UsersEntityList.size(); i++) {
            if (id == UsersEntityList.get(i).getId()) {
                UsersEntityList.remove(i);
                System.out.println("Usuario eliminado exitosamente\n");
            } else {
                System.out.println("No se encuentro el numero de usuario\n");
            }
        }

    }

    @Override
    public void showAllEntity() {
        try {
            String linea;
            BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\angel\\IdeaProjects\\SOLID_project\\fileUsers.text"));
            linea = bf.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = bf.readLine();
            }

        } catch (Exception e) {

            System.err.println("error -->" + e.getMessage());
        }
    }



    @Override
    public void writeFile() {
        try {

            File directory = new File(".");
            File fileUser = new File(directory, "fileUsers.text");
            FileWriter write = new FileWriter(fileUser);
            BufferedWriter writeBuff = new BufferedWriter(write);

            for (int i = 0; i < UsersEntityList.size(); i++) {
                writeBuff.write("\nNombre de usuario: " + UsersEntityList.get(i).getUsername() +
                        "\nfecha de nacimiento: " + UsersEntityList.get(i).getBirthday() +
                        "\nnumero de telefono: " + UsersEntityList.get(i).getPhoneNumber() +
                        "\nemail: " + UsersEntityList.get(i).getEmail() +
                        "\ncontraseña:\n" + UsersEntityList.get(i).getPassword());
            }

            System.out.println("\nUsuario añadido exitosamente\n");
            writeBuff.close();
        } catch (Exception e) {

            System.out.println("Error -->" + e.getMessage());
        }
    }
}