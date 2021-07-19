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

## CRUD: lectura de datos

**Clase MensajesDAO**
<pre>
    <code>
     public static void leerMensajes() {
        Conexion dbConnect = new Conexion();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection conexion = dbConnect.get_connection()) {
            String query = "SELECT * FROM mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha" + rs.getString("fecha_mensaje"));
                System.out.println("");
            }
        } catch (SQLException e) {
            System.out.println("Error al recuperar los mensajes");
            System.out.println(e);
        }
    }
    </code>
</pre>

**Clase MensajesService**
<pre>
    <code>
        public static void listarMensajes(){
        MensajesDAO.leerMensajes();
    }
    </code>
</pre>

**Listado de mensajes de la base de datos**

![get](https://res.cloudinary.com/dvhl6xkqf/image/upload/v1626703160/Academia-Java.-CDMX/persistencia/Captura_de_pantalla_178_rjgul9.png)

## CRUD: Elmininación de datos

**Clase MensajesDAO**
<pre>
    <code>
        public static void borrarMensajeDB(int id_mensaje) {

        Conexion dbConnect = new Conexion();

        try (Connection conexion = dbConnect.get_connection()) {
            PreparedStatement ps = null;
            
            try {
                String query = "DELETE FROM mensajes WHERE id = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("El mensaje fue borrado");
            } catch (SQLException e) {
                System.out.println(e);
            }
        } catch (SQLException e) { 
            System.out.println(e);
        }
    }
    </code>
</pre>

**Clase MensajesService**
<pre>
    <code>
        public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el mensaje a borrar");
        int id_mensaje = sc.nextInt();
        MensajesDAO.borrarMensajeDB(id_mensaje);
    }
    </code>
</pre>
**Eliminar mensaje**

![borrado](https://res.cloudinary.com/dvhl6xkqf/image/upload/v1626704011/Academia-Java.-CDMX/persistencia/Captura_de_pantalla_179_ojwo5p.png)

## CRUD: Actualizar datos
**Clase DAO**
<pre>
   <code>
      public static void actualizarMensajeDB(Mensajes mensaje) {

        Conexion dbConnect = new Conexion();

        try (Connection conexion = dbConnect.get_connection()) {
            PreparedStatement ps = null;

            try {
                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("El mensaje se actualizo correctamente");
            } catch (SQLException e) {
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
   </code>
</pre>

**Clase MensajesService**
<pre>
   <code>
        public static void editarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu nuevo mensaje");
        String mensaje = sc.nextLine();
        int id_mensaje = sc.nextInt();
        
        Mensajes actualizacion = new Mensajes();
        actualizacion.setId_mensaje(id_mensaje);
        actualizacion.setMensaje(mensaje);
        MensajesDAO.actualizarMensajeDB(actualizacion);
    }
   </code>
</pre>

# Proyecto Gatitos Java

## Creación del proyecto y APIKEY

**Clase Gatos**
<pre>
    <code>
    
package com.mycompany.gatos_app;

/**
 *
 * @author edflo
 */
public class Gatos {
    int id;
    String url;
    String apiKey;
    String image;

    
    //GET Y SET   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
}

    </code>
</pre>

**Clase Inicio**
<pre>
    <code>
    package com.mycompany.gatos_app;

import javax.swing.JOptionPane;

/**
 *
 * @author edflo
 */
public class Inicio {

    public static void main(String[] args) {
        int opcionMenu = -1;
        String[] botones = {"1. Ver gatos", "Salir"};

        do {
            //Menu principal
            String opcion = (String) JOptionPane.showInputDialog(null, "Gatitos java", "Menu principal",
                    JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);

            //Validar opcion por el usuario
            for (int i = 0; i < botones.length; i++) {
                if (opcion.equals(botones[i])) {
                    opcionMenu = i;

                }
            }

            switch (opcionMenu) {
                case 0:
                    break;

                default:
                    break;
            }
        } while (opcionMenu != 1);
    }
}

    </code>
</pre>

![gatos](https://res.cloudinary.com/dvhl6xkqf/image/upload/v1626708438/Academia-Java.-CDMX/persistencia/Captura_de_pantalla_180_h4acgd.png)

## Listado APIs Publicas

**Clase GatosService**
<pre>
    <code>
    
package com.mycompany.gatos_app;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author edflo
 */
public class GatosService {

    public static void verGatos() throws IOException {

        //Traer los datos de la api
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://api.thecatapi.com/v1/images/search").get().build();
        Response response = client.newCall(request).execute();
        
        String elJson = response.body().string();
        //Cortar corchetes
        elJson = elJson.substring(1, elJson.length());
        elJson = elJson.substring(0, elJson.length()-1);
        
        //Crear objeto  de la clsae Gson
        Gson gson = new Gson();
        Gatos gatos = gson.fromJson(elJson, Gatos.class);
        
        //Redimensionar
        Image image = null;
        try {
            URL url = new URL(gatos.getUrl());
            image = ImageIO.read(url);
            
            ImageIcon fondoGato  = new ImageIcon(image);
            
            if (fondoGato.getIconWidth() > 800) {
                //Redimensionar
                Image fondo = fondoGato.getImage();
                Image modificada = fondo.getScaledInstance(800, 800, java.awt.Image.SCALE_SMOOTH);
                fondoGato = new ImageIcon(modificada);
            }

            String menu = "Opciones: "
                    + "1. Ver otra imagen\n"
                    + "2. Marcar gato como favorito\n"
                    + "3. Volver al menu\n";

            String[] botones = {"1. Ver otra imagen", "Favorito", "Volver"};
            String id_gato = gatos.getId();
            String opcion = (String) JOptionPane.showInputDialog(null, menu, id_gato, JOptionPane.INFORMATION_MESSAGE,
                    fondoGato, botones, botones[0]);

            int selecccion = -1;
            for (int i = 0; i < botones.length; i++) {
                if (opcion.equals(botones[i])) {
                    selecccion = i;
                    GatosService.verGatos();
                }
            }

            switch (selecccion) {
                case 0:
                    verGatos();
                    break;

                case 1:
                    favoritoGato(gatos);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            
            System.out.println(e);
            
        }
    }
}

    </code>
</pre>

![imagen](https://res.cloudinary.com/dvhl6xkqf/image/upload/v1626710515/Academia-Java.-CDMX/persistencia/Captura_de_pantalla_181_ln8fk0.png)