package com.kodigo.solid.services.auth;

import com.kodigo.solid.controllers.*;
import com.kodigo.solid.views.MenuAdminEntity;
import com.kodigo.solid.views.MenuDoctorEntity;
import com.kodigo.solid.views.MenuPatientEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;


@NoArgsConstructor
@Data
@AllArgsConstructor
public class AuthServiceImplementation {


    private Integer userRol;
    private Long idAuth;
    private String userAuth;
    private Boolean verified = false;
    Scanner sc = new Scanner(System.in);

    private AdminEntityController adminController = new AdminEntityController();
    private DoctorPrescriptionController doctorController = new DoctorPrescriptionController();
    private PaymentEntityController paymentController = new PaymentEntityController();
    private AppointmentBookController appointmentBookController = new AppointmentBookController();
    private AuthServiceImplementation auth;


    private MenuAdminEntity adminMenu = new MenuAdminEntity(adminController, paymentController, appointmentBookController,auth);
    private MenuDoctorEntity doctorMenu = new MenuDoctorEntity(doctorController, appointmentBookController,auth);
    private MenuPatientEntity patientMenu = new MenuPatientEntity(appointmentBookController, paymentController,auth);


    //Metodos o funcionalidades
    public void userLogin() {
        adminController.loadDatabase();
        doctorController.loadDatabase();
        paymentController.loadDatabase();
        appointmentBookController.loadDatabase();

        try {
            System.out.println("======================");
            System.out.println("\n---INICIO DE SESIÓN---");
            System.out.println("======================");
            System.out.println("Usuario: ");
            String username = sc.nextLine();
            System.out.println("Contraseña: ");
            String password = sc.nextLine();

            for (int i = 0; i < adminController.getUsersEntityList().size(); i++) {
                if (username.equals(adminController.getUsersEntityList().get(i).getUsername()) && password.equals(adminController.getUsersEntityList().get(i).getPassword())) {
                    verified = true;
                    idAuth = adminController.getUsersEntityList().get(i).getId();
                    userAuth = adminController.getUsersEntityList().get(i).getName();
                    userRol = adminController.getUsersEntityList().get(i).getRole();
                    patientMenu.setIdAuth(this.idAuth);
                    patientMenu.setUserAuth(this.userAuth);
                    appointmentBookController.setIdAuth(this.idAuth);
                    appointmentBookController.setNameAuth(this.userAuth);
                    appointmentBookController.setRolAuth(this.userRol);
                    doctorMenu.setIdAuth(this.idAuth);
                    doctorMenu.setUserAuth(this.userAuth);

                }
            }

            if (getUserRol().equals(1)) {
                adminMenu.viewMenuAdmin();
            } else if (getUserRol().equals(2)) {
                doctorMenu.viewMenuDoctor();
            } else if (getUserRol().equals(3)) {
                patientMenu.viewMenuPatient();
            } else if (userRol != 3) {
                System.out.println("\nUsuario o contraseña no validos. Intentelo de nuevo\n");

                userLogin();
            }
        } catch (
                Exception e) {
            System.out.println(e.getMessage());
            try {
                userLogin();
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }


    }


}
