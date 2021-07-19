package com.mycompany.mensaje_app;

/**
 *
 * @author edflo
 */
public class Mensajes {

    int id_mensaje;
    String mensaje;
    String autorMensaje;
    String fecha_mensaje;

//Constructor por defecto
    public Mensajes() {

    }

    public Mensajes(String mensaje, String autorMensaje, String fecha_mensaje) {
        this.mensaje = mensaje;
        this.autorMensaje = autorMensaje;
        this.fecha_mensaje = fecha_mensaje;
    }

//Constructor para la bd
//Get y set
    public int getId_mensaje() {
        return id_mensaje;
    }

    public void setId_mensaje(int id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAutorMensaje() {
        return autorMensaje;
    }

    public void setAutorMensaje(String autorMensaje) {
        this.autorMensaje = autorMensaje;
    }

    public String getFecha_mensaje() {
        return fecha_mensaje;
    }

    public void setFecha_mensaje(String fecha_mensaje) {
        this.fecha_mensaje = fecha_mensaje;
    }

}
