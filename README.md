# Curso de Java SE Persistencia de Datos

## Diseñando nuestra base de datos
![disenio_bd](https://res.cloudinary.com/dvhl6xkqf/image/upload/v1626676644/Academia-Java.-CDMX/persistencia/persistencia_xcstgy.png)

## Creando nuestra base de datos usando DDL

<pre>
    <code>
CREATE TABLE mensajes_app.mensajes(
id_mensaje INT(7) AUTO_INCREMENT,
mensaje VARCHAR(280) NOT NULL,
autor_mensaje VARCHAR(50) NOT NULL,
fecha_mensaje timestamp NOT NULL,
PRIMARY KEY(id_mensaje)
);
    </code>
</pre>

![data_base](https://res.cloudinary.com/dvhl6xkqf/image/upload/v1626677271/Academia-Java.-CDMX/persistencia/database_nsgblz.png)

## Conexión a MySQL desde Java
**Clase conexion**
<pre>
    <code>
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
            if (connection != null) {
                System.out.println("Conexion exitosa");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return connection;

    }
}
    </code>
</pre>

**Clase inicio**
<pre>
    <code>
        
package com.mycompany.mensaje_app;

import java.sql.Connection;

/**
 *
 * @author edflo
 */
public class inicio {

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        try (Connection cnx = conexion.get_connection()) {

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
    </code>
</pre>
![conexion](https://res.cloudinary.com/dvhl6xkqf/image/upload/v1626699148/Academia-Java.-CDMX/persistencia/conexion_zzvasf.png)