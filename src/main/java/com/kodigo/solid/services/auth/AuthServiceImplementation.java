package com.kodigo.solid.services.auth;
import com.kodigo.solid.entities.*;
import com.kodigo.solid.views.MenuDoctorEntity;
import com.kodigo.solid.views.MenuPatientEntity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
//import com.kodigo.solid.entities.LoginEntity;

public class AuthServiceImplementation implements main.java.com.kodigo.solid.services.auth.AuthService {

    main.java.com.kodigo.solid.entities.LoginEntity loginEntity = new main.java.com.kodigo.solid.entities.LoginEntity();
    ArrayList<UserEntity> users = new ArrayList<>();
    MenuDoctorEntity doctorMenu = new MenuDoctorEntity();
    MenuPatientEntity patientMenu = new MenuPatientEntity();
    com.kodigo.solid.views.MenuAdminEntity adminMenu = new com.kodigo.solid.views.MenuAdminEntity();

    private String Username;
    private String Password;
    boolean Verified = false;
    private int user;


    public AuthServiceImplementation() {

    }

    @Override
    public void userLogin() {
        userDatabase();
        Scanner sc = new Scanner(System.in);
        System.out.println("Login");
        System.out.println("Usuario");
        Username = sc.nextLine();
        System.out.println("Password");
        Password = sc.nextLine();

        for (int i = 0; i < users.size(); i++) {

            if (Username.equals(this.users.get(i).getUsername()) && Password.equals(this.users.get(i).getPassword())) {
                Verified = true;
                user = users.get(i).getRole();

                System.out.println("\nVerificando usuario...");
                if (Verified == true) {
                    System.out.println("\nUsuario verificado");

                    System.out.println(user);
                    if (user == 1) {
                        //Rol Administrador: Muestra MenuAdmin
                        adminMenu.viewMenuAdmin();

                    } else if (user == 2) {

                        //Rol Doctor Muestra MenuDcctor

                        doctorMenu.viewMenuDoctor();


                    } else if (user == 3){
                        //Rol Paciente Muestra menuPaciente
                        patientMenu.viewMenuPatient();

                    }

                } else {
                    System.out.println("\nUsuario o contraseña no validos.\n 1. Intentelo de nuevo");
                    String option = sc.next();
                    if (option.equals("1")) {
                        userLogin();
                    }

                }

            } else {
                Verified = false;
            }
        }


    }

    public void userDatabase() {
        UserEntity admin = new UserEntity(1, "Admin", "admin", LocalDate.parse("1985-11-11"), "77895641", "admin@admin.com", "admin", 1);
        users.add(admin);
        UserEntity patient1 = new UserEntity(2, "Roxy", "roxy", LocalDate.parse("1998-05-11"), "77895641", "roxy@gmail.com", "1234", 3);
        users.add(patient1);
        UserEntity doctor = new UserEntity(3, "Rivas", "rivas", LocalDate.parse("1973-10-08"), "77895641", "doctorrivas@gmail.com", "1234", 2);
        users.add(doctor);
    }

   /* public void loginUser() throws IOException, ClassNotFoundException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Login");
        System.out.println("Usuario");
        Username = sc.nextLine();
        System.out.println("Password");
        Password = sc.nextLine();

        List<Entity<DoctorEntity>> ListDoctorEntity = this.doctorRepository.findAll();
        List<Entity<PatientEntity>> ListPatientEntity = this.patientRepository.findAll();
        List<Entity<AdminEntity>> ListAdminEntity = this.adminRepository.findAll();

        List<Entity<? extends UserEntity>> allUser = Stream.concat(ListDoctorEntity.stream(), Stream.concat(ListAdminEntity.stream(), ListPatientEntity.stream())).toList();
        int option;
        boolean verified2 = false;

        option = ListAdminEntity.stream().filter();


        if (Username.equals(allUser)) {
            Verified = true;
            user = users.get(i);
            //
            break;
        } else {
            Verified = false;
        }


    }*/

    @Override
    public void logout() {
        System.out.println("..User logout");
    }

    @Override
    public void signUp() {
        System.out.println("Welcome new user.");
    }
}
