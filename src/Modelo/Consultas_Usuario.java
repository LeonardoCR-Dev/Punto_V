package Modelo;

import java.sql.*;

public class Consultas_Usuario extends Conexion {

    public boolean registrar(Usuario user) {

        PreparedStatement ps = null;
        Connection con = getConnection();

        String consulta_SQL = "INSERT INTO ususario (Nom_usuario, nombres, apellidos, contraseña, telefono, direccion,tipoUsuario) CALUES(?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(consulta_SQL);
            ps.setString(1, user.getNom_usuario());
            ps.setString(2, user.getNombres());
            ps.setString(3, user.getApellidos());
            ps.setString(4, user.getContraseña());
            ps.setString(5, user.getTelefono());
            ps.setString(6, user.getDireccion());
            ps.setString(7, user.getTipoUsuario());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean modificar(Usuario user) {
        PreparedStatement ps = null;
        Connection con = getConnection();

        String consulta_SQL = "UPDATE ususario SET (nombres, apellidos, contraseña, telefono, direccion, tipoUsuario) WHERE Nom_usuario=?";
        try {
            ps = con.prepareStatement(consulta_SQL);
            ps.setString(2, user.getNombres());
            ps.setString(3, user.getApellidos());
            ps.setString(4, user.getContraseña());
            ps.setString(5, user.getTelefono());
            ps.setString(6, user.getDireccion());
            ps.setString(7, user.getTipoUsuario());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean eliminar(Usuario user) {
        PreparedStatement ps = null;
        Connection con = getConnection();

        String consulta_SQL = "DELETE FROM usuario WHERE Nom_usuario=?";
        try {
            ps = con.prepareStatement(consulta_SQL);
            ps.setString(2, user.getNom_usuario());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean buscar(Usuario user) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();

        String consulta_SQL = "SELECT * FROM usuario WHERE Nom_usuario=?";
        try {
            ps = con.prepareStatement(consulta_SQL);
            ps.setString(1, user.getNom_usuario());
            rs = ps.executeQuery();
            while (rs.next()) {
                user.setId(Integer.parseInt(rs.getString("id")));
                user.setNom_usuario(rs.getString("Nom_usuario"));
                user.setNombres(rs.getString("nombres"));
                user.setApellidos(rs.getString("apellidos"));
                user.setContraseña(rs.getString("contraseña"));
                user.setTelefono(rs.getString("telefono"));
                user.setDireccion(rs.getString("direccion"));
                user.setTipoUsuario(rs.getString("tipoUsuario"));
            }
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean login(Usuario user, String busqueda_User, String busqueda_Contraseña) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();

        String consulta_SQL = "SELECT * FROM usuario WHERE Nom_usuario=? && contraseña=?";
        try {
            String[] arreglo = new String[8];
            ps = con.prepareStatement(consulta_SQL);
            ps.setString(1, user.getNom_usuario());
            ps.setString(2, user.getContraseña());
            rs = ps.executeQuery();
            while (rs.next()) {
                arreglo[0] = rs.getString("id");
                arreglo[1] = rs.getString("Nom_usuario");
                arreglo[2] = rs.getString("nombres");
                arreglo[3] = rs.getString("apellidos");
                arreglo[4] = rs.getString("contraseña");
                arreglo[5] = rs.getString("telefono");
                arreglo[6] = rs.getString("direccion");
                arreglo[7] = rs.getString("tipoUsuario");
            }
//            user.setId(Integer.parseInt(arreglo[0]));
            user.setNom_usuario(arreglo[1]);
            user.setNombres(arreglo[2]);
            user.setApellidos(arreglo[3]);
            user.setContraseña(arreglo[4]);
            user.setTelefono(arreglo[5]);
            user.setDireccion(arreglo[6]);
            user.setTipoUsuario(arreglo[7]);
            if (busqueda_User.equals(arreglo[1]) && busqueda_Contraseña.equals(arreglo[4])) {                
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
