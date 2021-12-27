package com.kodigo.solid.commands;
import com.kodigo.solid.entities.DoctorEntity;
import com.kodigo.solid.data.fakedb.DataPDF;
import lombok.Data;

import java.util.ArrayList;
import java.util.Scanner;


@Data
public class addDoctorEntity {

    private boolean addDoctor = false;
    DataPDF data = new DataPDF();
    DoctorEntity doctor = new DoctorEntity();
    Scanner sc = new Scanner(System.in);


    public DoctorEntity addDoctorEntity() {
        Scanner sc = new Scanner(System.in);

        System.out.println("--------INGRESANDO DATOS DEL DOCTOR-----r");
        System.out.println("ingrese el DUI del doctor");
        doctor.setDui(sc.next());
        System.out.println("ingrese el nombre del doctor");
        doctor.setName(sc.next());
        System.out.println("ingrese la fecha de nacimiento del doctor dd/MM/yy");
        //System.out.println("ingrese el dia");
        doctor.setBirthday(sc.nextLine());
        System.out.println("ingrese el numero de telefono del doctor");
        doctor.setPhoneNumber(sc.next());
        System.out.println("ingrese el email del doctor");
        doctor.setEmail(sc.next());
        System.out.println("ingrese la contraseña del doctor");
        doctor.setPassword(sc.next());

        data.addlistDoctor(doctor);

        return doctor;

    }

    public void showDoctorEntity() {

        System.out.println("Ingrese el número de DUI del usuario a revisar: ");
        String dui = sc.next();
        String duiDoctor;

        for (int i = 0; i < data.getData().size(); i++) {

            duiDoctor = doctor.getDui();

            if (dui.equals(duiDoctor)) {
                System.out.println("------------------------------");
                //aqui mostrara los datos del usuario traido con el dui

            } else {
                System.out.println("No se encuentro el numero de usuario");
            }
        }

    }

    public void updateDoctorEntity(){


        System.out.println("Ingrese el número de DUI del usuario a actualizar: ");
        String dui = sc.next();
        String duiDoctor;

        for (int i = 0; i < data.getData().size(); i++) {

            duiDoctor = doctor.getDui();

            if (dui.equals(duiDoctor)) {
                System.out.println("==============================");

                    System.out.println("ingrese el DUI del doctor");
                    doctor.setDui(sc.next());
                    System.out.println("ingrese el nombre del doctor");
                    doctor.setName(sc.next());
                    System.out.println("ingrese la fecha de nacimiento del doctor dd/MM/yy");
                    //System.out.println("ingrese el dia");
                    doctor.setBirthday(sc.nextLine());
                    System.out.println("ingrese el numero de telefono del doctor");
                    doctor.setPhoneNumber(sc.next());
                    System.out.println("ingrese el email del doctor");
                    doctor.setEmail(sc.next());
                    System.out.println("ingrese la contraseña del doctor");
                    doctor.setPassword(sc.next());

            } else {
                System.out.println("No se encuentro el numero de usuario");
            }
        }
    }

    public  void deleteDoctorEntity(){

        System.out.println("Ingrese el número de DUI del usuario a eliminar: ");
        String dui = sc.next();
        String duiDoctor;

        for (int i = 0; i < data.getData().size(); i++) {

            duiDoctor = doctor.getDui();

            if (dui.equals(duiDoctor)) {
                System.out.println("------------------------------");
                data.getData().remove(i);

            } else {
                System.out.println("No se encuentro el numero de usuario");
            }
        }

    }
}


