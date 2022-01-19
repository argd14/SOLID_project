package com.kodigo.solid.utils.menuMethods;

public class patientMenu {
    public static void printPatientMenu(){
        System.out.println("------MENU PACIENTE------");
        System.out.println("==============================");
        System.out.println("1------GESTION DE CITAS------");
        System.out.println("-Crear cita\n-Actualizar cita\n-Cancelar cita");
        System.out.println("==============================");
        System.out.println("2------GESTION DE PAGOS------");
        System.out.println("-Historial de pago\n-Imprimir factura");
        System.out.println("==============================");
        System.out.println("4 - Agenda");
        System.out.println("0 - Salir");
        System.out.print("Ingrese la opción que desea: ");
    }


}
