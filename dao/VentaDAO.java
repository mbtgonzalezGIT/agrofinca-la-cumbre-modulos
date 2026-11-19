package dao;

import model.Venta;
import java.util.List;

public interface VentaDAO {
    boolean registrar(Venta venta);
    List<Venta> listar();
    boolean actualizar(Venta venta);
    boolean eliminar(int idVenta);
}
