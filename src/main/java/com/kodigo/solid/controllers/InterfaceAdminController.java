package com.kodigo.solid.controllers;

import com.kodigo.solid.entities.UserEntity;

public interface InterfaceAdminController {

    //metodo agregado
    public void findByRol(int rol);

    //metodo agregado
    public UserEntity getUser(Long id);

    public void createUser();

    public void updateUser(UserEntity user);

    public void deleteUser(Long id);

    public void lisAllUsers();

    void writeFile();
}
