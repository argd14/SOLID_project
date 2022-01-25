package com.kodigo.solid.controllers;

import com.kodigo.solid.entities.AppointmentEntity;
import com.kodigo.solid.entities.PrescriptionEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DoctorPrescriptionControllerTest {

    DoctorPrescriptionController doctorPrescriptionController;
    List<PrescriptionEntity> prescriptionEntityList;
    PrescriptionEntity prescription;

    @BeforeEach
    public void setup() {
        doctorPrescriptionController = new DoctorPrescriptionController();
        prescriptionEntityList = doctorPrescriptionController.prescriptionDb.prescriptiontDatabase();
        prescription = PrescriptionEntity.builder()
                .id(1)
                .medicineName("Ibuprofeno")
                .namePatient("Roxy")
                .dosage("1 c/8h")
                .build();
    }


    @Test
    @DisplayName("Method listAllPrescription - Should return a list with all prescriptions")
    void listAllPrescription() {
        assertFalse(prescriptionEntityList.isEmpty());
        assertEquals(4, prescriptionEntityList.size());
    }

    @Test
    @DisplayName("Method createPrescription - Should add new prescription to prescriptionEntityList")
    void createPrescription() {
        prescriptionEntityList.add(prescription);
        assertTrue(prescriptionEntityList.contains(prescription));
    }

    @Test
    @DisplayName("Method updatePrescription - Should update prescription's name")
    void updatePrescription() {
        prescription.setMedicineName("New medicine Name");
        assertEquals("New medicine Name", prescription.getMedicineName());
    }

    @Test
    @DisplayName("Method deletePrescription - Should remove new prescription from prescriptionEntityList")
    void deletePrescription() {
        prescriptionEntityList.remove(prescription);
        assertFalse(prescriptionEntityList.contains(prescription));
    }
}