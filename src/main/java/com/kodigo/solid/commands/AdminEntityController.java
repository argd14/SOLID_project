package com.kodigo.solid.commands;

import com.kodigo.solid.entities.AdminEntity;
import com.kodigo.solid.entities.DoctorEntity;
import com.kodigo.solid.entities.PatientEntity;
import com.kodigo.solid.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static org.apache.pdfbox.pdmodel.font.PDType1Font.*;
import static org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName.TIMES_BOLD;


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
                        "\nfecha de nacimiento: " + UsersEntityList.get(i).getBirthday() +
                        "\nnumero de telefono: " + UsersEntityList.get(i).getPhoneNumber() +
                        "\nemail: " + UsersEntityList.get(i).getEmail() +
                        "\ncontraseña: " + UsersEntityList.get(i).getPassword());
            }

            System.out.println("\nUsuario añadido exitosamente\n");
            writeBuff.close();
        } catch (Exception e) {

            System.out.println("Error -->" + e.getMessage());
        }
    }

    public void updateUserEntity() {

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

    public void deleteUserEntity(int id) {

        for (int i = 0; i < getUsersEntityList().size(); i++) {

            if (id == UsersEntityList.get(i).getId()) {
                UsersEntityList.remove(i);
                System.out.println("Usuario eliminado exitosamente\n");
            } else {
                System.out.println("No se encuentro el numero de usuario\n");
            }
        }

    }

    public void showUserEntity() {

      /*  try {
            File directory = new File(".");
            File fileRead = new File(directory, "fileUser.text");

            FileReader read = new FileReader(fileRead);
            BufferedReader readBuff = new BufferedReader(read);
            List<UserEntity> ListBuff = new LinkedList<>();
            String linea = null;


            for (int i = 0; i < UsersEntityList.size(); i++) {

                if (id == UsersEntityList.get(i).getId()) {
                    System.out.println(UsersEntityList.get(i));

                }


            }

        }catch(Exception e){

        }*/
        try {

            BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\angel\\IdeaProjects\\SOLID_project\\fileUsers.txt\\"));
            String temp = "";
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                temp = temp + bfRead;
            }
            System.out.println(temp);
        } catch (Exception e) {

            System.err.println("error -->" + e.getMessage());
        }

    }
}