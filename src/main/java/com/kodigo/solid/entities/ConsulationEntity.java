package com.kodigo.solid.entities;

import java.time.LocalDate;

public class ConsulationEntity {

    private int id;
    private AppointmentEntity appointmentPatient;
    private LocalDate consultationDate;

    public ConsulationEntity(int id, AppointmentEntity appointmentPatient, LocalDate consultationDate) {

        this.appointmentPatient = appointmentPatient;
        this.consultationDate = consultationDate;
    }

    @Override
    public String toString() {
        return "ConsultationEntity{"
                + "id="
                + ", appointmentPatient="
                + appointmentPatient
                + ", consultationDate="
                + consultationDate
                + '}';
    }
}