package com.kodigo.solid.commands;

import com.kodigo.solid.entities.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AppointmentBookController {
    public List<AppointmentEntity> Appointments = new ArrayList<>();

    public void listAppointments(){
        Appointments.sort(Comparator.comparing(AppointmentEntity::getDatetime));
        for (AppointmentEntity a : Appointments)
        {
            if (a != null)
            {
                System.out.println(a.toString());
            }
        }
    }

    public void listAppointmentsByDay(LocalDate date){
        Appointments.sort(Comparator.comparing(AppointmentEntity::getDatetime));
        for (AppointmentEntity a : Appointments)
        {
            if (a != null && a.getDate().equals(date))
            {
                System.out.println("Citas de Hoy");
                System.out.println(a.toString());
            }
            else
            {
                System.out.println("No hay citas para hoy");
            }
        }
    }

    public void listPatientAppointments(int id){
        Appointments.sort(Comparator.comparing(AppointmentEntity::getDatetime));
        for (AppointmentEntity a : Appointments)
        {
            if (a != null && a.getPatientId() == id )
            {
                System.out.println(a.toString());
            }
        }
    }

    public void remove(AppointmentEntity a)
    {

        if (Appointments.contains(a))
        {
            Appointments.remove(a);
            System.out.println("Removed appointment " + a.toString());
        }
        else
            System.out.println("Appointment not found");
    }

    public void add(AppointmentEntity a)
    {
        Appointments.add(a);
        a.setId(Appointments.indexOf(a) + 1);
        System.out.println("Added appointment " + a + "\n");
    }

    public void update(AppointmentEntity a, LocalDate date, LocalTime time){
        if (Appointments.contains(a))
        {
            a.setDate(date);
            a.setTime(time);
            a.setDatetime(date.atTime(time));
            System.out.println("Updated appointment " + a.toString());
        }
        else
            System.out.println("Appointment not found");
    }
}
