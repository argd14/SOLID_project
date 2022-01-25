package com.kodigo.solid.utils.menuMethods;

import java.util.logging.Level;
import java.util.logging.Logger;

public class doctorMenu {

    public doctorMenu() {}

    private static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void printDoctorMenu(){
        logger.log(Level.INFO, "\n-----MENÚ DOCTOR----- \n==============================\n-----GESTIÓN HISTORIAL ----- \n 1 - Registrar consulta \n 2 - Ver consulta\n==============================\n -----GESTIÓN DE RECETAS----- \n 3 - Prescribir receta\n 4 - Consultar receta\n 5 - Enviar receta por email\n==============================\n-----AGENDA----- \n 6 - Consultar agenda\n 0 - Salir \n Ingrese la opción que desea: ");
    }
}
