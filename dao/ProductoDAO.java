package dao;

import model.Producto;
import java.util.List;

public interface ProductoDAO {
    boolean registrar(Producto producto);
    List<Producto> listar();
    boolean actualizar(Producto producto);
    boolean eliminar(int idProducto);
}
