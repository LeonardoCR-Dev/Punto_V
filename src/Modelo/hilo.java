package Modelo;

import Vista.Inicio;

public class hilo extends Thread {
    //tiempo 1200
    private int t = 1;
    public void run() {
        try {
            Inicio l = new Inicio();
            l.setLocationRelativeTo(null);
            l.setVisible(true);
            l.Etiqueta.setText("Cargando");
            Thread.sleep(t);
            l.Etiqueta.setText("Cargando.");
            Thread.sleep(t);
            l.Etiqueta.setText("Cargando..");
            Thread.sleep(t);
            l.Etiqueta.setText("Cargando...");
            Thread.sleep(t);
            l.Etiqueta.setText("Cargando");
            Thread.sleep(t);
            l.Etiqueta.setText("Cargando.");
            Thread.sleep(t);
            l.Etiqueta.setText("Cargando..");
            Thread.sleep(t);
            l.Etiqueta.setText("Cargando...");
            Thread.sleep(t);
            l.Etiqueta.setText("Listo");
            Thread.sleep(t);
            l.setVisible(false);
        } catch (Exception e) {
        }
        
    }
}
