package com.kodigo.solid.utils.menuMethods;

import java.util.logging.Level;
import java.util.logging.Logger;

public class patientMenu {

    private patientMenu(){}

    private static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void printPatientMenu(){
        logger.log(Level.INFO,"\n------MENÚ PACIENTE------\n==============================\n1------GESTIÓN DE CITAS------\n-Crear cita\n-Actualizar cita\n-Cancelar cita\n==============================\n2------GESTIÓN DE PAGOS------\n-Historial de pago\n-Imprimir factura\n==============================\n4 - Agenda\n0 - Salir\nIngrese la opción que desea: ");
    }
}