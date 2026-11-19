public class Venta {

private int idVenta;
private Date fechaVenta;
private Double cantidadKilos;
private Double valorKilo;
private Double valorTotalVenta;

public Double calcularTotalVenta() {
        this.valorTotalVenta = this.cantiDadKilos * this.valorKilo;
        return this.valorTotalVenta;
    }

    public boolean registrarVenta() {
        return true;
    }
}