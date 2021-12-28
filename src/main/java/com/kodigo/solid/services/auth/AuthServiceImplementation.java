package main.java.com.kodigo.solid.services.auth;

import com.kodigo.solid.entities.UserEntity;
import main.java.com.kodigo.solid.entities.LoginEntity;
import main.java.com.kodigo.solid.views.DoctorMenu;
import main.java.com.kodigo.solid.views.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AuthServiceImplementation implements AuthService {
  //private DoctorRepository doctorRepository;
LoginEntity loginEntity = new LoginEntity();
UserEntity user = loginEntity.user;
String Username = user.Username;
String Password = user.password;
List<UserEntity> users =  loginEntity.users;
boolean Verified;
  //public AuthServiceImplementation(DoctorRepository doctorRepository) {
   // this.doctorRepository = doctorRepository;
  //}

  @Override
  public void userLogin() {
    userDatabase();
    Scanner sc = new Scanner(System.in);
    System.out.println("Login");
    System.out.println("Usuario");
    Username = sc.nextLine();
    System.out.println("Password");
    Password = sc.nextLine();

    for (UserEntity u : users) {
      //check if it is in list
      if (Username.equals(u.Username) && Password.equals(u.password))
      {
        Verified = true;
        user = u;
        break;
      }
      else
      {
        Verified = false;
      }
    }
    System.out.println("\nVerificando usuario...");
    if (Verified == true)
    {
      System.out.println("\nUsuario verificado");
      if (user.Role == 1)
      {
        MenuDoctorEntity adminMenu = new MenuDoctorEntity();
        adminMenu.viewMenuDoctor();
      }
      else if (user.Role == 2)
      {
        DoctorMenu doctorMenu = new DoctorMenu();

      }
      else
      {
        PatientMenu userMenu = new PatientMenu(user.id);
        userMenu.Print();
      }
    }
    else
    {
      System.out.println("\nUsuario o contraseña no validos.\n 1. Intentelo de nuevo");
      String option = sc.next();
      if (option.equals("1"))
      {
        userLogin();
      }

    }
  }

  public void userDatabase(){
    UserEntity admin = new UserEntity(1,"Admin", LocalDate.parse("1985-11-11"), "77895641","admin@admin.com", "Admin", "Admin", 1);
    users.add(admin);
    UserEntity patient1 = new UserEntity(2,"Roxy",LocalDate.parse("1998-05-11"), "77895641","roxy@gmail.com", "roxy", "1234", 3);
    users.add(patient1);
    UserEntity doctor = new UserEntity(3,"Dr. Rivas",LocalDate.parse("1973-10-08"), "77895641","doctorrivas@gmail.com", "drRivas", "1234", 2);
    users.add(doctor);
  }

  @Override
  public void logout() {
    System.out.println("..User logout");
  }

  @Override
  public void signUp() {
    System.out.println("Welcome new user.");
  }
}
