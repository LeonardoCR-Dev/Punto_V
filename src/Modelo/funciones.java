package Modelo;

import Vista.Principal;

public class funciones {

    private Usuario modeloUsuario;
    private Principal vistaPrincipal;

    public void limpiarUsuario() {
        
//        modeloUsuario.setId(0);
        modeloUsuario.setNom_usuario(null);
        modeloUsuario.setNombres(null);
        modeloUsuario.setApellidos(null);
        modeloUsuario.setContraseña(null);
        modeloUsuario.setDireccion(null);
        modeloUsuario.setTelefono(null);
    }

    public void tipoVista() {        
        vistaPrincipal.jButton_Usuarios_ADMIN.setVisible(false);
    }
}
