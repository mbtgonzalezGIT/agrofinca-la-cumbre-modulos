public class Compra {

private int idCompra;
private Date fechaCompra;
private Double cantidadProducto;
private Double valorTotalCompra;

public Double calcularTotalCompra() {
        return this.valorTotalCompra;
    }

    public boolean registrarCompra() {
        return true;
    }
}