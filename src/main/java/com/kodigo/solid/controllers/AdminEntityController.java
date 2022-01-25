package com.kodigo.solid.controllers;

import com.kodigo.solid.entities.UserEntity;
import com.kodigo.solid.fakeRepository.FakeUsersDb;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

@Data
@NoArgsConstructor
public class AdminEntityController extends AbstractAdminController {

    //private int rol;
    private Scanner sc = new Scanner(System.in);

    //dependencia
    FakeUsersDb fakeUsers = new FakeUsersDb();

    //metodo carga los datos inicales de fakeDB //metodo nuevo
    @Override
    public void loadDatabase() {
        UsersEntityList = fakeUsers.userDatabase();
    }

    //metodo agregado
    @Override
    public UserEntity getUser(Long id) {
        for (int i = 0; i < UsersEntityList.size(); i++) {
            if (id == UsersEntityList.get(i).getId()) {
                return UsersEntityList.get(i);
            }
        }
        return null;
    }

    //metodo agregado
    @Override
    public void findByRol(int rol) {
        for (int i = 0; i < UsersEntityList.size(); i++) {
            if (rol == UsersEntityList.get(i).getRole()) {
                System.out.println(UsersEntityList.get(i));
            }
        }

    }

    @Override
    public void createUser() {

        System.out.println("--------INGRESANDO DATOS DEL USUARIO-----");
        System.out.println("ingrese el id del Usuario: ");

       @NotNull
        Long id = sc.nextLong();
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
        System.out.println("El registro fue creado exitosamente\n");

        UserEntity user = new UserEntity(id, username, name, date, phone, email, password, rol);
        UsersEntityList.add(user);
        writeFile();
/*
        if (this.rol == 1) {
            AdminEntity admin = new AdminEntity(id, username, name, date, phone, email, password, rol);
            AdminEntityList.add(admin);

        } else if (this.rol == 2) {
            DoctorEntity doctor = new DoctorEntity(id, username, name, date, phone, email, password, rol);
            DoctorEntityList.add(doctor);
        } else if (this.rol == 3) {
            PatientEntity patient = new PatientEntity(id, username, name, date, phone, email, password, rol);
            PatientEntityList.add(patient);
        }*/
    }

    @Override
    public void updateUser(@NotNull UserEntity user) {
        UserEntity userDB = getUser(user.getId());
        for (int i = 0; i < UsersEntityList.size(); i++) {
            if (UsersEntityList.get(i) == userDB) {
                System.out.println("ingrese el userName: ");
                userDB.setUsername(sc.next());
                System.out.println("ingrese el nombre del usuario: ");
                userDB.setName(sc.next());
                System.out.println("ingrese la fecha de nacimiento: ");
                userDB.setBirthday(LocalDate.parse(sc.next()));
                System.out.println("ingrese el numero de telefono: ");
                userDB.setPhoneNumber(sc.next());
                System.out.println("ingrese el email del usuario: ");
                userDB.setEmail(sc.next());
                System.out.println("ingrese la contraseña: ");
                userDB.setPassword(sc.next());
                System.out.println("ingrese el rol del usuario: ");
                userDB.setRole(sc.nextInt());
                System.out.println("El registro fue actualizado exitosamente\n");
                UsersEntityList.set(i, userDB);
            }
        }
    }

    @Override
    public void deleteUser(Long id) {
        for (int i = 0; i < UsersEntityList.size(); i++) {
            if (id == UsersEntityList.get(i).getId()) {
                UsersEntityList.remove(i);
                System.out.println("Usuario eliminado exitosamente\n");
            }
        }
    }

    @Override
    public void lisAllUsers() {
       /* try {
            String linea;
            BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\angel\\IdeaProjects\\SOLID_project\\fileUsers.text"));
            linea = bf.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = bf.readLine();
            }

        } catch (Exception e) {

            System.err.println("error -->" + e.getMessage());
        }*/
        System.out.println(UsersEntityList);

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