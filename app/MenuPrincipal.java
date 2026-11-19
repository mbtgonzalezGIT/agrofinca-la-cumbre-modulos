package app;

import dao.*;
import model.*;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

    private static final Scanner sc = new Scanner(System.in);
    private static final ProductoDAO productoDAO = new ProductoDAOImpl();
    private static final VentaDAO ventaDAO = new VentaDAOImpl();

    public static void main(String[] args) {
        String opcion = "";
        do {
            System.out.println("\n==============================================");
            System.out.println("  SISTEMA CONTABLE AGROFINCA LA CUMBRE - CRUD ");
            System.out.println("==============================================");
            System.out.println("1. Gestión de Módulo PRODUCTOS");
            System.out.println("2. Gestión de Módulo VENTAS");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextLine().trim();

            switch (opcion) {
                case "1" -> menuProductos();
                case "2" -> menuVentas();
                case "3" -> System.out.println("¡Gracias por utilizar el sistema!");
                default -> System.out.println("Opción no válida.");
            }
        } while (!opcion.equals("3"));
    }

    private static void menuProductos() {
        String op = "";
        do {
            System.out.println("\n----------------------------------------------");
            System.out.println("           --- MÓDULO PRODUCTOS ---           ");
            System.out.println("----------------------------------------------");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Consultar / Listar Productos");
            System.out.println("3. Actualizar Producto");
            System.out.println("4. Eliminar Producto");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            op = sc.nextLine().trim();

            switch (op) {
                case "1" -> {
                    System.out.print("Tipo de Producto: ");
                    String tipo = sc.nextLine().trim();
                    System.out.print("Descripción del Producto: ");
                    String desc = sc.nextLine().trim();
                    
                    if (productoDAO.registrar(new Producto(tipo, desc))) {
                        System.out.println("-> ¡ÉXITO: Producto guardado correctamente en MySQL!");
                    } else {
                        System.out.println("-> No se pudo guardar el registro en MySQL.");
                    }
                }
                case "2" -> mostrarTablaProductos();
                case "3" -> {
                    mostrarTablaProductos();
                    System.out.print("Ingrese el ID del producto a actualizar: ");
                    try {
                        int id = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Nuevo Tipo de Producto: ");
                        String tipo = sc.nextLine().trim();
                        System.out.print("Nueva Descripción: ");
                        String desc = sc.nextLine().trim();
                        if (productoDAO.actualizar(new Producto(id, tipo, desc))) {
                            System.out.println("-> ¡ÉXITO: Producto actualizado correctamente!");
                        } else {
                            System.out.println("-> No se encontró el registro con el ID ingresado.");
                        }
                    } catch (Exception e) {
                        System.out.println("-> Debe ingresar un ID numérico válido.");
                    }
                }
                case "4" -> {
                    mostrarTablaProductos();
                    System.out.print("Ingrese el ID del producto a eliminar: ");
                    try {
                        int id = Integer.parseInt(sc.nextLine().trim());
                        if (productoDAO.eliminar(id)) {
                            System.out.println("-> ¡ÉXITO: Producto eliminado de la base de datos!");
                        } else {
                            System.out.println("-> No se encontró el registro con el ID ingresado.");
                        }
                    } catch (Exception e) {
                        System.out.println("-> Debe ingresar un ID numérico válido.");
                    }
                }
                case "5" -> {}
                default -> System.out.println("Opción no válida.");
            }
        } while (!op.equals("5"));
    }

    private static void menuVentas() {
        String op = "";
        do {
            System.out.println("\n----------------------------------------------");
            System.out.println("            --- MÓDULO VENTAS ---             ");
            System.out.println("----------------------------------------------");
            System.out.println("1. Registrar Venta");
            System.out.println("2. Consultar / Listar Ventas");
            System.out.println("3. Actualizar Venta");
            System.out.println("4. Eliminar Venta");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            op = sc.nextLine().trim();

            switch (op) {
                case "1" -> {
                    try {
                        System.out.print("Valor Total de la Venta ($): ");
                        double valor = Double.parseDouble(sc.nextLine().trim());
                        Date fechaActual = new Date(System.currentTimeMillis());
                        
                        // Registra la venta directamente sin pedir ID de usuario
                        if (ventaDAO.registrar(new Venta(fechaActual, valor, 0))) {
                            System.out.println("-> ¡ÉXITO: Venta registrada correctamente en MySQL!");
                        } else {
                            System.out.println("-> No se pudo guardar la venta en MySQL.");
                        }
                    } catch (Exception e) {
                        System.out.println("-> En el valor debe ingresar números (ejemplo: 150000).");
                    }
                }
                case "2" -> mostrarTablaVentas();
                case "3" -> {
                    mostrarTablaVentas();
                    System.out.print("Ingrese el ID de la venta a actualizar: ");
                    try {
                        int id = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Nuevo Valor Total ($): ");
                        double valor = Double.parseDouble(sc.nextLine().trim());
                        Date fechaActual = new Date(System.currentTimeMillis());

                        if (ventaDAO.actualizar(new Venta(id, fechaActual, valor, 0))) {
                            System.out.println("-> ¡ÉXITO: Venta actualizada correctamente!");
                        } else {
                            System.out.println("-> No se encontró el registro con el ID ingresado.");
                        }
                    } catch (Exception e) {
                        System.out.println("-> Debe ingresar datos numéricos válidos.");
                    }
                }
                case "4" -> {
                    mostrarTablaVentas();
                    System.out.print("Ingrese el ID de la venta a eliminar: ");
                    try {
                        int id = Integer.parseInt(sc.nextLine().trim());
                        if (ventaDAO.eliminar(id)) {
                            System.out.println("-> ¡ÉXITO: Venta eliminada con éxito!");
                        } else {
                            System.out.println("-> No se encontró la venta.");
                        }
                    } catch (Exception e) {
                        System.out.println("-> Debe ingresar un ID numérico válido.");
                    }
                }
                case "5" -> {}
                default -> System.out.println("Opción no válida.");
            }
        } while (!op.equals("5"));
    }

    private static void mostrarTablaProductos() {
        List<Producto> lista = productoDAO.listar();
        System.out.println("\n--- LISTADO DE PRODUCTOS EN BASE DE DATOS ---");
        if (lista.isEmpty()) {
            System.out.println("(No hay productos registrados actualmente)");
        } else {
            System.out.println("ID | TIPO DE PRODUCTO | DESCRIPCIÓN");
            System.out.println("----------------------------------------------");
            for (Producto p : lista) {
                System.out.printf("%d | %s | %s\n", p.getIdProducto(), p.getTipoProducto(), p.getDescripcionProducto());
            }
        }
    }

    private static void mostrarTablaVentas() {
        List<Venta> lista = ventaDAO.listar();
        System.out.println("\n--- LISTADO DE VENTAS EN BASE DE DATOS ---");
        if (lista.isEmpty()) {
            System.out.println("(No hay ventas registradas actualmente)");
        } else {
            System.out.println("ID VENTA | FECHA | VALOR TOTAL");
            System.out.println("----------------------------------------------");
            for (Venta v : lista) {
                System.out.printf("%d | %s | $%.2f\n", v.getIdVenta(), v.getFechaVenta(), v.getValorVenta());
            }
        }
    }
}