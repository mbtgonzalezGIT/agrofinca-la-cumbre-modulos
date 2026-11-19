public class Pago {

private int idPago;
private Date fechaPago;
private String tipoPago;
private Double kilosRecolectados;
private int diasTrabajados;
private Double valorPago;

public double calcularTotalPago() {
        this.valorPago = (kilosRecolectados * 1000) + (diasTrabajados * 50000);
        return this.valorPago;
    }

    public boolean registrarPago() {
        return true;
    }
}