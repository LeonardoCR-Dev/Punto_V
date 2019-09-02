package Controlador;

import Modelo.Consultas_Usuario;
import Modelo.Usuario;

import Vista.Login;
import Vista.Principal;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controlador_Usuario implements ActionListener {

    private Usuario modeloUsuario;
    private Consultas_Usuario modeloConsultas;
    private Login vistaLogin;
    Principal vistaPrincipal = new Principal();
    //private Principal vistaPrincipal;

    public Controlador_Usuario(Usuario modeloUsuario, Consultas_Usuario modeloConsultas, Login vistaLogin) {
        this.modeloUsuario = modeloUsuario;
        this.modeloConsultas = modeloConsultas;
        this.vistaLogin = vistaLogin;
        // this.vistaPrincipal = vistaPrincipal;

        this.vistaLogin.jButton_Entrar.addActionListener(this);
        this.vistaLogin.jPasswordField_Contraseña.addActionListener(this);
        this.vistaLogin.jTextField_Usuario.addActionListener(this);
        //  this.vistaPrincipal.jButton_CerrarSesion.addActionListener(this);
    }

    public void iniciar() {
        vistaLogin.setTitle("Login Top Bussines");
        vistaLogin.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaLogin.jButton_Entrar) {
            validacionLogin();
        }
        if (e.getSource() == vistaLogin.jTextField_Usuario) {
            validacionLogin();
        }
        if (e.getSource() == vistaLogin.jPasswordField_Contraseña) {
            validacionLogin();
        }
    }

    private void validacionLogin() {
        if (vistaLogin.jTextField_Usuario.getText().equals("") || vistaLogin.jPasswordField_Contraseña.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos por favor!!!");
        } else {
            modeloUsuario.setNom_usuario(vistaLogin.jTextField_Usuario.getText().toString().toUpperCase());
            modeloUsuario.setContraseña(vistaLogin.jPasswordField_Contraseña.getText().toString().toUpperCase());
            if (modeloConsultas.login(modeloUsuario, vistaLogin.jTextField_Usuario.getText().toUpperCase(), vistaLogin.jPasswordField_Contraseña.getText().toUpperCase())) {

                JOptionPane.showMessageDialog(null, "Bienvenido " + vistaLogin.jTextField_Usuario.getText().toUpperCase());
                vistaLogin.dispose();
                Controlador_VistaPrincipal controladorVP = new Controlador_VistaPrincipal(vistaPrincipal, modeloUsuario, vistaLogin);
                modeloUsuario.imprimir();
                if (modeloUsuario.getTipoUsuario().equals("ADMINISTRADOR")) {
                    vistaPrincipal.setVisible(true);
                    vistaPrincipal.jLabel_UsuarioActivo.setText(modeloUsuario.getNom_usuario());
                    tipoVistaAdministrador();
                    //vistaPrincipal.setLocationRelativeTo(null);
                    vistaLogin.jTextField_Usuario.setText(null);
                    vistaLogin.jPasswordField_Contraseña.setText(null);
                    vistaPrincipal.setExtendedState(MAXIMIZED_BOTH);
                } else {
                    vistaPrincipal.jLabel_UsuarioActivo.setText(modeloUsuario.getNom_usuario());
                    vistaPrincipal.setVisible(true);
                    vistaPrincipal.setLocationRelativeTo(null);
                    tipoVistaUsuario();
                    vistaLogin.jTextField_Usuario.setText(null);
                    vistaLogin.jPasswordField_Contraseña.setText(null);
                    vistaPrincipal.setExtendedState(MAXIMIZED_BOTH);
                }
            } else {
                limpiarUsuario();
                vistaLogin.jTextField_Usuario.setText(null);
                vistaLogin.jPasswordField_Contraseña.setText(null);
                JOptionPane.showMessageDialog(null, "Verifique los datos");
            }
            limpiarUsuario();
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

    private void tipoVistaUsuario() {
        
        vistaPrincipal.jButton_Usuarios_ADMIN.setVisible(false);
    }

    private void tipoVistaAdministrador() {
        vistaPrincipal.jButton_Usuarios_ADMIN.setVisible(true);
        
    }
}
