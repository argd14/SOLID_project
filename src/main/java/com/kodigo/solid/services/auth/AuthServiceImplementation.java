package com.kodigo.solid.services.auth;

//import com.kodigo.solid.data.fakedb.AdminDataManagement;
//import com.kodigo.solid.data.fakedb.DoctorDataManagement;
//import com.kodigo.solid.data.fakedb.PatientDataManagement;
//import com.kodigo.solid.data.repositories.AdminRepository;
//import com.kodigo.solid.data.repositories.DoctorRepository;
//import com.kodigo.solid.data.repositories.PatientRepository;

import com.kodigo.solid.entities.LoginEntity;
import com.kodigo.solid.entities.UserEntity;
import com.kodigo.solid.views.MenuAdminEntity;
import com.kodigo.solid.views.MenuDoctorEntity;
import com.kodigo.solid.views.MenuPatientEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AuthServiceImplementation
        implements main.java.com.kodigo.solid.services.auth.AuthService {

    LoginEntity loginEntity = new LoginEntity();
    UserEntity user = new UserEntity();
    String Username;
    String Password;

    List<UserEntity> users = loginEntity.users;

    //  private DoctorRepository doctorRepository;
//  private PatientRepository patientRepository;
//  private AdminRepository adminRepository;
    boolean Verified = false;
    MenuAdminEntity adminMenu = new MenuAdminEntity();

    public AuthServiceImplementation() {
//    this.doctorRepository = new DoctorRepository(new DoctorDataManagement());
//    this.patientRepository = new PatientRepository(new PatientDataManagement());
//    this.adminRepository = new AdminRepository(new AdminDataManagement());
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

        for (int i = 1; i <= users.size(); i++) {
            System.out.println(users.get(i).getUsername());

            if (Username != null) {
                Verified = true;
                user = users.get(i);
                //
                break;
            } else {
                Verified = false;
            }
        }

        System.out.println("\nVerificando usuario...");

        if (Verified == true) {
            System.out.println("\nUsuario verificado");
            System.out.println(user.getRole());
            System.out.println(users);

            if (user.getRole() == 1) {

                // Rol Administrador: Muestra MenuAdmin
                adminMenu.viewMenuAdmin();

            } else if (user.getRole() == 2) {

                // Rol Doctor Muestra MenuDcctor
                MenuDoctorEntity doctorMenu = new MenuDoctorEntity();
                doctorMenu.viewMenuDoctor();

            } else {
                // Rol Paciente Muestra menuPaciente
                MenuPatientEntity userMenu = new MenuPatientEntity(user.getId());
                userMenu.Print();
                //MenuDoctorEntity doctorMenu = new MenuDoctorEntity();
                //doctorMenu.viewMenuDoctor();
            }

        } else {
            System.out.println("\nUsuario o contraseña no validos.\n 1. Intentelo de nuevo");
            String option = sc.next();
            if (option.equals("1")) {
                userLogin();
            }
        }
    }

    public void userDatabase() {
        UserEntity admin =
                new UserEntity(
                        1,
                        "Admin",
                        "admin",
                        LocalDate.parse("1985-11-11"),
                        "77895641",
                        "admin@admin.com",
                        "admin",
                        1);
        users.add(admin);
        UserEntity patient1 =
                new UserEntity(
                        2,
                        "Roxy",
                        "roxy",
                        LocalDate.parse("1998-05-11"),
                        "77895641",
                        "roxy@gmail.com",
                        "1234",
                        3);
        users.add(patient1);
        UserEntity doctor =
                new UserEntity(
                        3,
                        "Dr. Rivas",
                        "rivas",
                        LocalDate.parse("1973-10-08"),
                        "77895641",
                        "doctorrivas@gmail.com",
                        "1234",
                        2);
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
      List<Entity<Admin>> ListAdminEntity = this.adminRepository.findAll();

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
