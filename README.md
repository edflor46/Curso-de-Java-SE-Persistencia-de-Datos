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

## Flujo y lógica de la aplicación

**Clase Mensajes**
<pre>
    <code>
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
    </code>
</pre>

**Clase MensajesServices**
<pre>
    <code>
        
package com.mycompany.mensaje_app;

/**
 *
 * @author edflo
 */
public class MensajesServices {
 
    public static void crearMensaje(){
        
    }
    
    public static void listarMensajes(){
        
    }
    
    public static void borrarMensaje(){
        
    }
    
    public static void editarMensaje(){
        
    }
    
}
    </code>
</pre>

**Clase MensajesDAO**
<pre>
    <code>
        package com.mycompany.mensaje_app;

/**
 *
 * @author edflo
 */
public class MensajesDAO {
    public static void crearMensajeDB(Mensajes mensaje){
        
    }
    
    public static void leerMensajes(){
        
    }
    
    public static void borrarMensajeDB(int id_mensaje){
        
    }
    
    public static void actualizarMensajeDB(Mensajes mensaje){
        
    }
}
    </code>
</pre>

**Clase Inicio**
<pre>
    <code>
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
    </code>
</pre>


## CRUD: Inserción de datos
**Clase MensajesService**
<pre>
    <code>
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
    </code>
</pre>

**Clase MensajesDAO**
<pre>
    <code>
             public static void crearMensajeDB(Mensajes mensaje) {

        Conexion dbConnect = new Conexion();

        try (Connection conexion = dbConnect.get_connection()) {

            PreparedStatement ps = null;
            try {
                String query = " INSERT INTO mensajes (mensaje, autor_,mensaje) VALUES (?,? current_timestamp())";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getFecha_mensaje());
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
    </code>
</pre>

**Aplicación Java**
![aplicacion](https://res.cloudinary.com/dvhl6xkqf/image/upload/v1626702306/Academia-Java.-CDMX/persistencia/Captura_de_pantalla_176_ugj0sa.png)

**phpMyAdmin**
![phpMyAdmin](https://res.cloudinary.com/dvhl6xkqf/image/upload/v1626702306/Academia-Java.-CDMX/persistencia/Captura_de_pantalla_177_t5gtgq.png)