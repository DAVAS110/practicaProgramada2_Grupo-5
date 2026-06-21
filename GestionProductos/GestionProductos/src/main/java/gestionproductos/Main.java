package gestionproductos;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        Producto[] productos = {
            new Producto("P001", "Teclado mecanico", 25000.0, 10),
            new Producto("P002", "Mouse inalambrico", 8000.0, 5),
            new Producto("P003", "Monitor 24 pulgadas", 95000.0, 3)
        };

        String opcion;
        do {
            opcion = JOptionPane.showInputDialog(null,
                    "===== MENU =====\n"
                    + "1. Ver inventario\n"
                    + "2. Vender producto\n"
                    + "3. Buscar producto por codigo\n"
                    + "4. Salir\n\n"
                    + "Elegi una opcion:",
                    "Gestion de Productos",
                    JOptionPane.QUESTION_MESSAGE);

            if (opcion == null) {
                break; // el usuario cerro la ventana
            }

            switch (opcion.trim()) {
                case "1":
                    mostrarInventario(productos);
                    break;
                case "2":
                    venderProducto(productos);
                    break;
                case "3":
                    buscarProducto(productos);
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida, intenta de nuevo.");
            }

        } while (!opcion.trim().equals("4"));
    }

    private static void mostrarInventario(Producto[] productos) {
        StringBuilder sb = new StringBuilder("--- Inventario ---\n");
        for (Producto p : productos) {
            sb.append(p).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void venderProducto(Producto[] productos) {
        String codigo = JOptionPane.showInputDialog(null, "Ingresa el codigo del producto:");
        if (codigo == null) {
            return;
        }
        String cantidadTexto = JOptionPane.showInputDialog(null, "Ingresa la cantidad a vender:");
        if (cantidadTexto == null) {
            return;
        }

        try {
            int cantidad = Integer.parseInt(cantidadTexto.trim());
            Producto producto = buscarPorCodigo(productos, codigo);
            producto.vender(cantidad);

            JOptionPane.showMessageDialog(null,
                    "Venta realizada con exito:\n" + producto);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Ingresa una cantidad numerica valida.",
                    "Error", JOptionPane.ERROR_MESSAGE);

        } catch (ProductoNoEncontradoException e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage(), "Producto no encontrado", JOptionPane.ERROR_MESSAGE);

        } catch (CantidadInvalidaException e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage(), "Cantidad invalida", JOptionPane.ERROR_MESSAGE);

        } catch (StockInsuficienteException e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage(), "Stock insuficiente", JOptionPane.ERROR_MESSAGE);

        } finally {
            System.out.println("Operacion de venta finalizada para el codigo: " + codigo);
        }
    }

    private static void buscarProducto(Producto[] productos) {
        String codigo = JOptionPane.showInputDialog(null, "Ingresa el codigo del producto a buscar:");
        if (codigo == null) {
            return;
        }

        try {
            Producto producto = buscarPorCodigo(productos, codigo);
            JOptionPane.showMessageDialog(null,
                    "Producto encontrado:\n" + producto);

        } catch (ProductoNoEncontradoException e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage(), "Producto no encontrado", JOptionPane.ERROR_MESSAGE);

        } finally {
            System.out.println("Busqueda finalizada para el codigo: " + codigo);
        }
    }

    private static Producto buscarPorCodigo(Producto[] productos, String codigo)
            throws ProductoNoEncontradoException {
        for (Producto p : productos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        throw new ProductoNoEncontradoException("No existe un producto con el codigo: " + codigo);
    }
}
