package com.mycompany.mensaje_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author edflo
 */
public class MensajesDAO {

    public static void crearMensajeDB(Mensajes mensaje) {

        Conexion dbConnect = new Conexion();

        try (Connection conexion = dbConnect.get_connection()) {

            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutorMensaje());
                ps.executeUpdate();
                
                System.out.println("El mensaje fue creado correctamente");
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public static void leerMensajes() {

    }

    public static void borrarMensajeDB(int id_mensaje) {

    }

    public static void actualizarMensajeDB(Mensajes mensaje) {

    }
}
