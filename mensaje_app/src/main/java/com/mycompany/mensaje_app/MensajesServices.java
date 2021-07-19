
package com.mycompany.mensaje_app;

import java.util.Scanner;

/**
 *
 * @author edflo
 */
public class MensajesServices {
 
    public static void crearMensaje(){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();
        
        System.out.println("Ingresa tu nombre");
        String nombre = sc.nextLine();
        
        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutorMensaje(nombre);
        
        MensajesDAO.crearMensajeDB(registro);
        
        
    }
    
    public static void listarMensajes(){
        MensajesDAO.leerMensajes();
    }
    
    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el mensaje a borrar");
        int id_mensaje = sc.nextInt();
        MensajesDAO.borrarMensajeDB(id_mensaje);
    }
    
    public static void editarMensaje(){
        
    }
    
}
