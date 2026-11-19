public class Reporte {

private int idReporte;
private String tipoReporte;
private Date fechaReporte;
private Double totalIngresos;
private Double totalGastos;

public double consultarReporte() {
        return totalIngresos - totalGastos;
    }

    public String generarReporte() {
        return "Reporte " + tipoReporte + " generado exitosamente.";
    }
}