public class Usuario {

private int idUsuario;
private String nombreUsuario;
private String apellidoUsuario;
private String correoUsuario;
private String contrasenaUsuario;
private String rol;

public String obtenerDatosUsuario() {
        return nombreUsuario + " " + apellidoUsuario + " - rol: " + rol;
    }

    public boolean iniciarSesion() {
        return true;
    }
}
