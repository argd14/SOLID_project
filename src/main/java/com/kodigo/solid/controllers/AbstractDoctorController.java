package com.kodigo.solid.controllers;

import com.kodigo.solid.entities.PrescriptionEntity;
import lombok.Data;
import java.util.ArrayList;

@Data
public abstract class AbstractDoctorController implements InterfaceDoctorController, InterfaceWriteFile {
    ArrayList<PrescriptionEntity> prescriptionsList = new ArrayList<>();
}
