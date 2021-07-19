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
                    GatosService.verGatos();

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
