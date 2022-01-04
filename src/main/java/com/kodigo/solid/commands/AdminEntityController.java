package com.kodigo.solid.commands;

import com.kodigo.solid.entities.AdminEntity;
import com.kodigo.solid.entities.DoctorEntity;
import com.kodigo.solid.entities.PatientEntity;
import com.kodigo.solid.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminEntityController {

    private ArrayList<AdminEntity> AdminEntityList = new ArrayList<>();
    private ArrayList<DoctorEntity> DoctorEntityList = new ArrayList<>();
    private ArrayList<PatientEntity> PatientEntityList = new ArrayList<>();
    private ArrayList<UserEntity> UsersEntityList = new ArrayList<>();
    private UserEntity user;
    Scanner sc = new Scanner(System.in);
    private int rol;


    public void addUserEntity() {

        System.out.println("---INGRESE LOS DATOS DEL USUARIO---");
        System.out.println("Ingrese el id del usuario: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese el UserName: ");
        String username = sc.nextLine();
        System.out.println("Ingrese el nombre de la persona: ");
        String name = sc.nextLine();
        System.out.println("Ingrese la fecha de nacimiento: ");
        LocalDate date = LocalDate.parse(sc.nextLine());
        System.out.println("Ingrese el número de telefono: ");
        String phone = sc.nextLine();
        System.out.println("Ingrese el email del usuario: ");
        String email = sc.nextLine();
        System.out.println("Ingrese la contraseña: ");
        String password = sc.nextLine();
        System.out.println("Ingrese el rol del usuario: ");
        rol = sc.nextInt();

        user = new UserEntity(id, username, name, date, phone, email, password, rol);
        UsersEntityList.add(user);
        fileWrite();

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

    public void fileWrite() {
        try {

            File directory = new File(".");
            File fileUser = new File(directory, "fileUsers.text");
            FileWriter write = new FileWriter(fileUser);
            BufferedWriter writeBuff = new BufferedWriter(write);

            for (int i = 0; i < UsersEntityList.size(); i++) {
                writeBuff.write("\nNombre de usuario: " + UsersEntityList.get(i).getUsername() +
                        "\nFecha de nacimiento: " + UsersEntityList.get(i).getBirthday() +
                        "\nNúmero de teléfono: " + UsersEntityList.get(i).getPhoneNumber() +
                        "\nEmail: " + UsersEntityList.get(i).getEmail() +
                        "\nContraseña: " + UsersEntityList.get(i).getPassword());
            }

            System.out.println("\n¡Usuario añadido exitosamente!\n");
            writeBuff.close();
        } catch (Exception e) {

            System.out.println("Error -->" + e.getMessage());
        }
    }

    public void updateUserEntity() {

        sc.nextLine();
        System.out.println("Ingrese el userName: ");
        user.setUsername(sc.nextLine());
        System.out.println("Ingrese el nombre de la persona: ");
        user.setName(sc.nextLine());
        System.out.println("Ingrese la fecha de nacimiento: ");
        user.setBirthday(LocalDate.parse(sc.nextLine()));
        System.out.println("Ingrese el número de teléfono: ");
        user.setPhoneNumber(sc.nextLine());
        System.out.println("Ingrese el email del usuario: ");
        user.setEmail(sc.nextLine());
        System.out.println("Ingrese la contraseña: ");
        user.setPassword(sc.nextLine());
        System.out.println("Ingrese el rol del usuario: ");
        user.setRole(sc.nextInt());
        System.out.println("\n¡El registro fue actualizado exitosamente!\n");

    }

    public void deleteUserEntity(int id) {

        for (int i = 0; i < getUsersEntityList().size(); i++) {

            if (id == UsersEntityList.get(i).getId()) {
                UsersEntityList.remove(i);
                System.out.println("\n¡Usuario eliminado exitosamente!\n");
            } else {
                System.out.println("\n¡No se encontró el numero de usuario!\n");
            }
        }

    }

    public void showUserEntity() {
        try {
            String linea ;
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
}