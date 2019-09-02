package Modelo;

public class Usuario {

    private int id;
    private String Nom_usuario;
    private String nombres;
    private String apellidos;
    private String contraseña;
    private String telefono;
    private String direccion;
    private String tipoUsuario;

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_usuario() {
        return Nom_usuario;
    }

    public void setNom_usuario(String Nom_usuario) {
        this.Nom_usuario = Nom_usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void imprimir() {
        System.out.println("datos usuario activo!!!");
    //    System.out.println("ID: " + id);
        System.out.println("USUARIO: " + Nom_usuario);
        System.out.println("NOMBRES: " + nombres);
        System.out.println("APELLIDOS: " + apellidos);
        System.out.println("CONTRASEÑA: " + contraseña);
        System.out.println("TELEFONO: " + telefono);
        System.out.println("DIRECCION: " + direccion);
        System.out.println("TIPO DE USUARIO: " + tipoUsuario);
    }
}
