package com.kodigo.solid.registration;

import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.*;

public class Main {

    public static void main(String[ ] args) {
        // Admin ingresara info por consola.
        Scanner input = new Scanner(in);
        // Creamos la lista donde seran almacenados los registros
        ArrayList<Registration> usersDatabase = new ArrayList<>();

        // El while sera ejecutado hasta que exit sea TRUE.
        boolean exit = false;
        while (!exit) {
            // campos que tiene que llenar el admin para gestionar un usario
            out.println();
            out.println("==============================");
            out.println(" GESTIÓN DE USUARIOS ");
            out.println(" 1 - Crear un nuevo usuario ");
            out.println(" 2 - Ver información de usuario ");
            out.println(" 3 - Modificar usuario ");
            out.println(" 4 - Eliminar usuario ");
            out.println(" 0 - Salir ");
            out.println();
            out.print(" Ingrese la opción que desea: ");
            int option = Integer.parseInt(input.nextLine());
            out.println("==============================");
            out.println();

            // obtenemos el numero ingresado por el usuario en la consola:


            // de acuerdo al numero seleccionado por el admin en la consola, se ejecutara el "case" correspondiente
            switch(option) {
                case 1: // "case" crear un nuevo usuario
                    // instanciamos una "Registration" vacia (Sin atributos)
                    Registration a = new Registration();
                    out.println("Ingrese el número de DUI: ");
                    // Obtenemos el numero de documento ingresado y lo guardamos en Registration.
                    a.setDui(input.nextLine());
                    out.println("Ingrese Nombre y Apellido: ");
                    // Obtenemos el nombre y apellido y lo guardamos en Registration.
                    a.setName(input.nextLine());
                    out.println("Ingrese fecha de nacimiento en formato DD/MM/AA: ");
                    // Obtenemos la fecha de nacimiento y lo guardamos en Registration.
                    a.setDateOfBirth(input.nextLine());
                    out.println("Ingrese número de teléfono: ");
                    // Obtenemos el numero de telefono y lo guardamos en Registration.
                    a.setPhoneNumber(Integer.parseInt(input.nextLine()));
                    out.println("Ingrese el correo electrónico: ");
                    // Obtenemos el correo electronico y lo guardamos en Registration.
                    a.setEmail(input.nextLine());
                    out.println();

                    // guardamos la informacion recopilada de la variable "a" en el array usersDatabase.
                    usersDatabase.add(a);

                    // confirmamos al admin la informacion recopilada.
                    out.println("------------------------------");
                    out.println("DETALLES DEL NUEVO REGISTRO: ");
                    out.println("------------------------------");
                    out.println("DUI: " + a.getDui());
                    out.println("Nombre: " + a.getName());
                    out.println("Fecha de nacimiento: " + a.getDateOfBirth());
                    out.println("Número de teléfono: " + a.getPhoneNumber());
                    out.println("Correo Electrónico: " + a.getEmail());
                    out.println();

                    break;

                case 2: // "case" leer informacion de un usuario ya existente.
                    out.println("Ingrese el número de DUI del usuario a revisar o 'Total' para ver cantidad total de usuarios registrados: ");
                    String dui = input.nextLine();
                    // for loop para recorrer todos los elementos almacenados en el array.
                    for (int i = 0; i < usersDatabase.size(); i++) {
                        // .get() para obtener el usario respectivo del array
                        Registration b = usersDatabase.get(i);
                        if (dui.equals(b.getDui())) {
                            out.println("------------------------------");
                            out.println("Nombre: " + b.getName());
                            out.println("Fecha de nacimiento: " + b.getDateOfBirth());
                            out.println("Número de teléfono: " + b.getPhoneNumber());
                            out.println("Correo electrónico: " + b.getEmail());
                            out.println("------------------------------");
                        } else if (dui.equals("Total")) {
                            out.println("------------------------------");
                            out.println("Total de usuarios registrados: " + (i + 1));
                            out.println("------------------------------");
                        } else {
                            out.println("------------------------------");
                            out.println("DUI no encontrado/invalido");
                            out.println("------------------------------");
                        }
                    }
                    out.println();

                    break;

                case 3: // "case" para actualizar/modificar usuario.
                    out.println("Ingrese el número de DUI del usuario a modificar: ");
                    dui = input.nextLine();
                    /* for loop en el cual buscaremos entre todos los DUI cual coincide con el que el admin ingrese para luego proceder a
                    ofrecer modificaciones de los campos */
                    for (int i = 0; i < usersDatabase.size(); i++) {
                        Registration b = usersDatabase.get(i);
                        if (dui.equals(b.getDui())) {
                            out.println("------------------------------");
                            out.println("Nombre: " + b.getName());
                            out.println("Fecha de nacimiento: " + b.getDateOfBirth());
                            out.println("Número de teléfono: " + b.getPhoneNumber());
                            out.println("Correo electrónico: " + b.getEmail());
                            out.println("------------------------------");
                            out.println();
                            out.print("¿Desea modificar el nombre del usuario? Y/N: ");
                            out.println();
                            String decisionName = input.nextLine();
                            if (decisionName.equals("Y")) {
                                out.println("Ingrese el nuevo nombre: ");
                                String newName = input.nextLine();
                                b.setName(newName);
                                out.println();
                                out.println("¡Los cambios han sido guardados!");
                                out.println();
                            } if (decisionName.equals("N")) {
                                out.print("¿Desea modificar la fecha de nacimiento? Y/N: ");
                                out.println();
                                String decisionDateOfBirth = input.nextLine();
                                if (decisionDateOfBirth.equals("Y")) {
                                    out.println("Ingrese la nueva fecha de nacimiento: ");
                                    String newDateOfBirth = input.nextLine();
                                    b.setDateOfBirth(newDateOfBirth);
                                    out.println();
                                    out.println("¡Los cambios han sido guardados!");
                                    out.println();
                                } if (decisionDateOfBirth.equals("N")) {
                                    out.print("¿Desea modificar el número de teléfono? Y/N: ");
                                    out.println();
                                    String decisionPhoneNumber = input.nextLine();
                                    if (decisionPhoneNumber.equals("Y")) {
                                        out.println("Ingrese el nuevo número telefónico: ");
                                        out.println();
                                        int newTelephoneNumber = Integer.parseInt(input.nextLine());
                                        b.setPhoneNumber(newTelephoneNumber);
                                        out.println("¡Cambios guardados!");
                                        out.println();
                                    } if (decisionPhoneNumber.equals("N")) {
                                        out.print("¿Desea modificar el correo electrónico? Y/N: ");
                                        out.println();
                                        String decisionEmail = input.nextLine();
                                        if (decisionEmail.equals("Y")) {
                                            out.println("Ingrese el nuevo correo electrónico: ");
                                            out.println();
                                            String newEmail = input.nextLine();
                                            b.setEmail(newEmail);
                                            out.println("¡Cambios guardados!");
                                            out.println();
                                        } if (decisionPhoneNumber.equals("N")) {
                                            out.println("------------------------------");
                                            out.println("Favor revisar los cambios hechos al usuario: ");
                                            out.println("Nombre: " + b.getName());
                                            out.println("Fecha de nacimiento: " + b.getDateOfBirth());
                                            out.println("Número de teléfono: " + b.getPhoneNumber());
                                            out.println("Correo electrónico: " + b.getEmail());
                                            out.println("------------------------------");
                                            out.println();

                                        }
                                    }
                                }
                            }
                        }
                    }

                    break;

                case 4: // "case" eliminar usuario del array
                    out.println("Ingrese el número de DUI del usuario a eliminar: ");
                    dui = input.nextLine();
                    for (int i = 0; i < usersDatabase.size(); i++) {
                        Registration b = usersDatabase.get(i);
                        // buscamos en el array el DUI que el admin ingrese.
                        if (dui.equals(b.getDui())) {
                            // eliminamos el elemento del array
                            usersDatabase.remove(i);
                            out.println("------------------------------------------------------");
                            out.println("El registro del usuario ha sido eliminado exitosamente");
                            out.println("------------------------------------------------------");
                            out.println();
                        }
                    }

                    break;

                case 0: // "case" salir del programa
                    exit = true;
                    out.println();
                    out.println("Saliendo del programa");
                    out.println();

                    break;

                default: // si el numero indicado no corresponde a ningun "case"
                    out.println("¡Opción Invalida!");
                    out.println();
            }

        }

    }
}
