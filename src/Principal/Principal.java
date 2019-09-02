package Principal;

import Modelo.*;
import Vista.*;
import Controlador.*;

public class Principal {

    public static void main(String[] args) {
        Usuario modeloUsuario = new Usuario();
        Consultas_Usuario modeloConsultas = new Consultas_Usuario();
        Login vistaLogin = new Login();
        Vista.Principal vp = new Vista.Principal();
        
        Controlador_Usuario controladorUsu = new Controlador_Usuario(modeloUsuario, modeloConsultas, vistaLogin);
        controladorUsu.iniciar();
        hilo h1 = new hilo();
        h1.run();
        vistaLogin.setVisible(true);
    }
}
