package com.fidelitas.java.practicaprogramada2_grupo5;

import java.util.Scanner;

public class practicaProgramada2_Grupo5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();
        CarritoCompra carrito = new CarritoCompra();
        int opcion = 0;

        do {
            System.out.println("\n===== FARMACIA SALUD INTEGRAL =====");
            System.out.println("1. Agregar producto farmaceutico");
            System.out.println("2. Modificar producto");
            System.out.println("3. Listar productos");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Agregar producto al carrito");
            System.out.println("6. Generar recibo");
            System.out.println("7. Salir");
            System.out.print("Elija una opcion: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
                switch (opcion) {
                    case 1:
                        agregarProducto(scanner, inventario);
                        break;
                    case 2:
                        modificarProducto(scanner, inventario);
                        break;
                    case 3:
                        inventario.listarTodos();
                        break;
                    case 4:
                        eliminarProducto(scanner, inventario);
                        break;
                    case 5:
                        agregarAlCarrito(scanner, inventario, carrito);
                        break;
                    case 6:
                        Factura factura = new Factura(carrito);
                        System.out.println(factura.generarRecibo());
                        break;
                    case 7:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opcion invalida, intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un numero valido.");
            } finally {
                System.out.println("----------------------------------");
            }

        } while (opcion != 7);

        scanner.close();
    }

    private static void agregarProducto(Scanner scanner, Inventario inventario) {
        try {
            System.out.print("Codigo: ");
            String codigo = scanner.nextLine().trim();
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine().trim();
            System.out.print("Precio: ");
            double precio = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Cantidad en inventario: ");
            int cantidad = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Tiene descuento? (s/n): ");
            String resp = scanner.nextLine().trim();

            if (resp.equalsIgnoreCase("s")) {
                System.out.print("Porcentaje de descuento (ej: 10 para 10%): ");
                double descuento = Double.parseDouble(scanner.nextLine().trim());
                inventario.agregar(new ProductoDescuento(codigo, nombre, precio, cantidad, descuento));
            } else {
                inventario.agregar(new Producto(codigo, nombre, precio, cantidad));
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: ingrese valores numericos validos.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Operacion de agregar producto finalizada.");
        }
    }

    private static void modificarProducto(Scanner scanner, Inventario inventario) {
        try {
            System.out.print("Codigo del producto a modificar: ");
            String codigo = scanner.nextLine().trim();
            System.out.print("Nuevo nombre (Enter para no cambiar): ");
            String nombre = scanner.nextLine().trim();
            System.out.print("Nuevo precio (0 para no cambiar): ");
            double precio = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Nueva cantidad (-1 para no cambiar): ");
            int cantidad = Integer.parseInt(scanner.nextLine().trim());
            inventario.modificar(codigo, nombre, precio, cantidad);
            System.out.println("Producto modificado correctamente.");
        } catch (NumberFormatException e) {
            System.out.println("Error: ingrese valores numericos validos.");
        } catch (ProductoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Operacion de modificar producto finalizada.");
        }
    }

    private static void eliminarProducto(Scanner scanner, Inventario inventario) {
        try {
            System.out.print("Codigo del producto a eliminar: ");
            String codigo = scanner.nextLine().trim();
            inventario.eliminar(codigo);
        } catch (ProductoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Operacion de eliminar producto finalizada.");
        }
    }

    private static void agregarAlCarrito(Scanner scanner, Inventario inventario, CarritoCompra carrito) {
        try {
            System.out.print("Codigo del producto: ");
            String codigo = scanner.nextLine().trim();
            Producto producto = inventario.buscarPorCodigo(codigo);
            System.out.print("Cantidad: ");
            int cantidad = Integer.parseInt(scanner.nextLine().trim());
            carrito.agregarProducto(producto, cantidad);
            System.out.println("Producto agregado al carrito.");
            System.out.println(carrito.generarDetalleCarrito());
            
        } catch (NumberFormatException e) {
            System.out.println("Error: ingrese una cantidad numerica valida.");
            
        } catch (ProductoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
            
        } catch (CantidadInvalidaException e) {
            System.out.println("Error: " + e.getMessage());
            
        } catch (StockInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
            
        } finally {
            System.out.println("Operacion de agregar al carrito finalizada.");
        }
    }
}
