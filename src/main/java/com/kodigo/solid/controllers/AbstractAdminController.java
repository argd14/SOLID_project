package com.kodigo.solid.controllers;

import com.kodigo.solid.entities.UserEntity;
import lombok.Data;

import java.util.ArrayList;

@Data
public abstract class AbstractAdminController implements InterfaceAdminController, InterfaceWriteFile {
    ArrayList<UserEntity> UsersEntityList = new ArrayList<>();
    ArrayList<UserEntity> AdminEntityList = new ArrayList<>();
    ArrayList<UserEntity> DoctorEntityList = new ArrayList<>();
    ArrayList<UserEntity> PatientEntityList = new ArrayList<>();
}
