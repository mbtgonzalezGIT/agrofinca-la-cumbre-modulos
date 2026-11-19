package dao;

import config.ConexionBD;
import model.Venta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentaDAOImpl implements VentaDAO {

    @Override
    public boolean registrar(Venta venta) {
        String sql = "INSERT INTO venta (fecha_venta, valor_venta, id_usuario) VALUES (?, ?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, venta.getFechaVenta());
            stmt.setDouble(2, venta.getValorVenta());
            stmt.setInt(3, venta.getIdUsuario());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("-> Error MySQL al registrar venta: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Venta> listar() {
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT * FROM venta";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Venta(
                    rs.getInt("id_venta"),
                    rs.getDate("fecha_venta"),
                    rs.getDouble("valor_venta"),
                    rs.getInt("id_usuario")
                ));
            }
        } catch (SQLException e) {
            System.err.println("-> Error MySQL al listar ventas: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public boolean actualizar(Venta venta) {
        String sql = "UPDATE venta SET valor_venta = ?, id_usuario = ? WHERE id_venta = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, venta.getValorVenta());
            stmt.setInt(2, venta.getIdUsuario());
            stmt.setInt(3, venta.getIdVenta());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("-> Error MySQL al actualizar venta: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int idVenta) {
        String sql = "DELETE FROM venta WHERE id_venta = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idVenta);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("-> Error MySQL al eliminar venta: " + e.getMessage());
            return false;
        }
    }
}
