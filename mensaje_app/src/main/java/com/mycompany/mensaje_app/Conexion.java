
package com.mycompany.mensaje_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author edflo
 */
public class Conexion {

    public Connection get_connection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app", "root", "");
//            if (connection != null) {
//                System.out.println("Conexion exitosa");
//            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return connection;

    }
}