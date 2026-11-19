package model;

public class Producto {

    private int idProducto;
    private String tipoProducto;
    private String descripcionProducto;

    public Producto() {}

    public Producto(int idProducto, String tipoProducto, String descripcionProducto) {
        this.idProducto = idProducto;
        this.tipoProducto = tipoProducto;
        this.descripcionProducto = descripcionProducto;
    }

    public Producto(String tipoProducto, String descripcionProducto) {
        this.tipoProducto = tipoProducto;
        this.descripcionProducto = descripcionProducto;
    }

    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }

    public String getTipoProducto() { return tipoProducto; }
    public void setTipoProducto(String tipoProducto) { this.tipoProducto = tipoProducto; }

    public String getDescripcionProducto() { return descripcionProducto; }
    public void setDescripcionProducto(String descripcionProducto) { this.descripcionProducto = descripcionProducto; }
}
