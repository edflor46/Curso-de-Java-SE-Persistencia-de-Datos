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
import javax.swing.JOptionPane;

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
        elJson = elJson.substring(0, elJson.length() - 1);

        //Crear objeto  de la clsae Gson
        Gson gson = new Gson();
        Gatos gatos = gson.fromJson(elJson, Gatos.class);

        //Redimensionar
        Image image = null;
        try {
            URL url = new URL(gatos.getUrl());
            image = ImageIO.read(url);

            ImageIcon fondoGato = new ImageIcon(image);

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

    public static void favoritoGato(Gatos gatos) {

    }
}
