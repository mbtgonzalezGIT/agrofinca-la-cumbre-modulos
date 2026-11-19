package model;

import java.sql.Date;

public class Venta {

    private int idVenta;
    private Date fechaVenta;
    private double valorVenta;
    private int idUsuario;

    public Venta() {}

    public Venta(int idVenta, Date fechaVenta, double valorVenta, int idUsuario) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.valorVenta = valorVenta;
        this.idUsuario = idUsuario;
    }

    public Venta(Date fechaVenta, double valorVenta, int idUsuario) {
        this.fechaVenta = fechaVenta;
        this.valorVenta = valorVenta;
        this.idUsuario = idUsuario;
    }

    public int getIdVenta() { return idVenta; }
    public void setIdVenta(int idVenta) { this.idVenta = idVenta; }

    public Date getFechaVenta() { return fechaVenta; }
    public void setFechaVenta(Date fechaVenta) { this.fechaVenta = fechaVenta; }

    public double getValorVenta() { return valorVenta; }
    public void setValorVenta(double valorVenta) { this.valorVenta = valorVenta; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
}