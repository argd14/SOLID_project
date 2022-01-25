/*
NOMBRE: Projecto SOLID
DESCRIPCION: Aplicar los principios solid para manejar una clinica que realice diferentes funcionalidades

1: Cada clase o método sólo debe hacer una cosa, sencilla y concreta.
Si un objeto tiene un sólo cometido, éste será más fácil de mantener.
(Utilizamos un patron de diseño que segrega las clases en funcion unicamente de lo que realiza cada una)

2: Una clase/método debe estar abierto a extensiones pero cerrado a modificaciones.

3: Cualquier subclase debería poder ser sustituible por la clase padre.
(AdminEntity, PatientEntity, DoctorEntity derivan de UserEntity. En este caso la clase padre si puede sustituir
a cualquiera de las subclases)

4: Cada clase implementará las interfaces que necesite y use, ninguna más. No contendrá métodos que no utilice.
(Se estan implementando las interface de manera correcta y sin asignar metodos que no se utilicen)

5: Que una clase pueda funcionar por sí sola sin depender de otra.
(El objetivo es conseguir que una clase interactúe con otras clases sin que las conozca directamente.)

*/

//se elimino la clase doctorappointmet y el paquete db se cambio

package com.kodigo.solid;

import com.kodigo.solid.serviceAuth.AuthServiceImpl;

public class Main {

    public static void main(String[] args) {
        AuthServiceImpl login = new AuthServiceImpl();
        login.userLogin();
    }
}