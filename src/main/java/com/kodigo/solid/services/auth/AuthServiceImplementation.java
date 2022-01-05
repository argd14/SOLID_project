package com.kodigo.solid.services.auth;

import com.kodigo.solid.entities.UserEntity;
import com.kodigo.solid.views.MenuAdminEntity;
import com.kodigo.solid.views.MenuDoctorEntity;
import com.kodigo.solid.views.MenuPatientEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


@NoArgsConstructor
@Data
@AllArgsConstructor
public class AuthServiceImplementation {

    private Integer userRol;
    private String username;
    private String password;
    private int idAuth;
    private String userAuth;
    private ArrayList<UserEntity> users = new ArrayList<>();
    private Boolean verified = false;
    private MenuAdminEntity adminMenu = new MenuAdminEntity();
    private MenuDoctorEntity doctorMenu = new MenuDoctorEntity();
    private MenuPatientEntity userMenu = new MenuPatientEntity();
   // private AdminEntityController loadUsers ;

    //PaymentDataBase data ;
    Scanner sc = new Scanner(System.in);


    //Metodos o funcionalidades
    public void userLogin() {
        userDatabase();
        try {
            System.out.println("\n---INICIO DE SESIÓN---");
            System.out.println("======================");
            System.out.println("Usuario: ");
            username = sc.nextLine();
            System.out.println("Contraseña: ");
            password = sc.nextLine();

            for (int i = 0; i < users.size(); i++) {
                if (username.equals(users.get(i).getUsername()) && password.equals(users.get(i).getPassword())) {
                    verified = true;
                    userRol = users.get(i).getRole();
                    idAuth = users.get(i).getId();
                    userAuth = users.get(i).getName();
                    userMenu.idAuth(this.idAuth, this.userAuth);
                }
            }

            if (getUserRol().equals(1)) {
                adminMenu.viewMenuAdmin();
            } else if (getUserRol().equals(2)) {
                doctorMenu.viewMenuDoctor();
            } else if (getUserRol().equals(3)) {
                userMenu.viewMenuPatient();
            } else if(userRol != 3){
                System.out.println("\nUsuario o contraseña no validos. Intentelo de nuevo\n");

                userLogin();
            }
        } catch (
                Exception e) {
            userLogin();
        }


    }

    public void userDatabase() {
        UserEntity admin = new UserEntity(
                1,
                "Admin",
                "admin",
                LocalDate.parse("1985-11-11"),
                "77895641",
                "admin@admin.com",
                "admin",
                1);

        users.add(admin);

        UserEntity patient1 = new UserEntity(
                2,
                "Roxy",
                "roxy",
                LocalDate.parse("1998-05-11"),
                "77895641",
                "roxy@gmail.com",
                "1234",
                3);
        users.add(patient1);

        UserEntity patient2 = new UserEntity(
                4,
                "Juan",
                "juan",
                LocalDate.parse("1998-05-11"),
                "77895641",
                "roxy@gmail.com",
                "1234",
                3);
        users.add(patient2);
        UserEntity doctor = new UserEntity(
                3,
                "Rivas",
                "rivas",
                LocalDate.parse("1973-10-08"),
                "77895641",
                "doctorrivas@gmail.com",
                "1234",
                2);
        users.add(doctor);
    }



}
