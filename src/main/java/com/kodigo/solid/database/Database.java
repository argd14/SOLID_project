package com.kodigo.solid.database;

import com.kodigo.solid.entities.AppointmentEntity;
import com.kodigo.solid.entities.ConsulationEntity;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Database {
    /*public List<ConsulationEntity> newConsultations = new ArrayList<>();

    public List<AppointmentEntity> getAppoiments() {
       var appoiment1 = new AppointmentEntity(1,  LocalDate.now(), LocalTime.now());
        var appoiment2 = new AppointmentEntity(2,  LocalDate.now().plusDays(7), LocalTime.now().plusHours(1));
        var appoiment3 = new AppointmentEntity(3, LocalDate.now().plusDays(14), LocalTime.now().plusHours(2));
        var appoiment4 = new AppointmentEntity(4, LocalDate.now().plusDays(19), LocalTime.now().plusHours(3));

        return Stream.of(appoiment1, appoiment2, appoiment3, appoiment4).collect(Collectors.toList());
    }

    public List<ConsulationEntity> getConsultations() {
        List<AppointmentEntity> appoiments = this.getAppoiments();
        int consultId = 0;
        for (AppointmentEntity appointment :
                appoiments) {
            this.newConsultations.add(new ConsulationEntity(++consultId, appointment, LocalDate.now()));
        }
        return this.newConsultations;
    }*/
}
