package com.kodigo.solid.utils.menuMethods;

import java.util.logging.Level;
import java.util.logging.Logger;

public class adminMenu {

    private adminMenu() {}

    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void printAdminMenu() {
        logger.log(Level.INFO,"\n------MENÚ ADMINISTRADOR------\n==============================\n------GESTIÓN DE USUARIOS------\n 1 - Crear un nuevo usuario \n 2 - Modificar usuario \n 3 - Eliminar usuario \n==============================\n------GESTIÓN DE REPORTES------\n 4 - Reporte usuarios \n 5 - Reporte citas \n 6 - Reporte pagos \n 0 - Salir \nIngrese la opción que desea: \n");
    }
}
