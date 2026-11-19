public class Producto {

    private int idProducto;
    private String nombreProducto;
    private String tipoProducto;
    private double precioUnitario;

    public void consultarProducto() {
        System.out.println("Producto: " + nombreProducto);
    }

    public void actualizarPrecio() {
        System.out.println("Precio actualizado");
    }
}