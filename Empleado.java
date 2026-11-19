public class Empleado {

private int idEmpleado;
private String nombreEmpleado;
private String telefonoEmpleado;
private String cargo;
private Double kilosRecolectados;

public String obtenerDatosEmpleado() {
        return nombreEmpleado + " " + apellidoEmpleado + " - Cargo: " + cargo;
    }
}