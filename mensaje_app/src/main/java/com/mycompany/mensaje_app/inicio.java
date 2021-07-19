package com.mycompany.mensaje_app;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author edflo
 */
public class inicio {

    public static void main(String[] args) {
        //MENU
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("-----------------------");
            System.out.println("Aplicacion de mensajes");
            System.out.println("1. Crear un mensaje");
            System.out.println("2. Listar mesajes");
            System.out.println("3. Editar mensaje");
            System.out.println("4. Eliminar mensaje");
            System.out.println("5. Salir");

            //Leer opcion usuario
            opcion = Integer.valueOf(sc.nextLine());

            switch (opcion) {
                case 1:
                    MensajesServices.crearMensaje();
                    break;
                case 2:
                    MensajesServices.listarMensajes();
                    break;

                case 3:
                    MensajesServices.borrarMensaje();
                    break;

                case 4:
                    MensajesServices.editarMensaje();
                    break;

                default:
                    break;

            }

        } while (opcion != 5);

        Conexion conexion = new Conexion();
        try (Connection cnx = conexion.get_connection()) {

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
