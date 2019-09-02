package Controlador;

import Modelo.Usuario;
import Modelo.funciones;
import Vista.Login;
import Vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador_VistaPrincipal implements ActionListener {
    
    private Principal vistaPrincipal;
    //   private funciones modeloFunciones;
    private Usuario modeloUsuario;
    private Login vistaLogin;
    
    public void iniciar() {
        vistaPrincipal.setLocationRelativeTo(null);
    }

    public Controlador_VistaPrincipal(Principal vistaPrincipal, Usuario modeloUsuario, Login vistaLogin) {
        this.vistaPrincipal = vistaPrincipal;
        //   this.modeloFunciones = modeloFunciones;
        this.modeloUsuario = modeloUsuario;
        this.vistaLogin = vistaLogin;
        
        this.vistaPrincipal.jButton_CerrarSesion.addActionListener(this);
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(modeloUsuario.getNom_usuario() + "--------");
        if (e.getSource() == vistaPrincipal.jButton_CerrarSesion) {
            System.out.println("aquiiiiiiiiii");
            vistaPrincipal.dispose();
            //modeloUsuario.imprimir();
            System.out.println("antes de limpiar");
            limpiarUsuario();
            System.out.println("despiues de limpiar");
            //  modeloUsuario.imprimir();
            vistaPrincipal.jLabel_UsuarioActivo.setText(null);
            vistaPrincipal.dispose();
            vistaLogin.setVisible(true);
            
        }       
    }
    
    private void limpiarUsuario() {
        modeloUsuario.setId(0);
        modeloUsuario.setNom_usuario(null);
        modeloUsuario.setNombres(null);
        modeloUsuario.setApellidos(null);
        modeloUsuario.setContraseña(null);
        modeloUsuario.setDireccion(null);
        modeloUsuario.setTelefono(null);
    }
    
    private void tipoVista() {
        
        vistaPrincipal.jButton_Usuarios_ADMIN.setVisible(false);
    }
    
}
