package com.kodigo.solid.controllers;

import com.kodigo.solid.entities.AppointmentEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class AbstractAppointmentController implements InterfaceAppointmentController , InterfaceWriteFile {
    List<AppointmentEntity> appointments = new ArrayList<>();
}
