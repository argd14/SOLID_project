package com.kodigo.solid.entities;

import lombok.Getter;

import java.time.LocalDate;

public class ConsulationEntity extends BaseEntity {

    @Getter
    private AppointmentEntity appointmentPatient;
    @Getter
    private LocalDate consultationDate;

    public ConsulationEntity(int id, AppointmentEntity appointmentPatient, LocalDate consultationDate) {
        super(id);
        this.appointmentPatient = appointmentPatient;
        this.consultationDate = consultationDate;
    }

    @Override
    public String toString() {
        return "ConsultationEntity{"
                + "id="
                + id
                + ", appointmentPatient="
                + appointmentPatient
                + ", consultationDate="
                + consultationDate
                + '}';
    }
}