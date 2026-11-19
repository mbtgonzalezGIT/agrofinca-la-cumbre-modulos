public class Proveedor {

    private int idProveedor;
    private String nombreProveedor;
    private String telefonoProveedor;
    private String direccionproveedor;

    public String obtenerDatosProveedor() {
        return nombreProveedor + " - Tel: " + telefonoProveedor;
    }
}