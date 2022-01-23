package com.kodigo.solid.controllers;

import com.kodigo.solid.entities.PrescriptionEntity;

public interface InterfaceDoctorController {

    PrescriptionEntity getPrescription(Long id);
    void createPrescription();
    void updatePrescription(PrescriptionEntity prescription);
    void listAllPrescription();
    void deletePrescription(Long id);
}
