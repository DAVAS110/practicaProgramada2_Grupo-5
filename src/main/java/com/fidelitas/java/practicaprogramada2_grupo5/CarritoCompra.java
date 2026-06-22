package com.fidelitas.java.practicaprogramada2_grupo5;

import java.util.ArrayList;

public class CarritoCompra {

    private ArrayList<DetalleCarrito> productosCarrito;

    public CarritoCompra() {
        this.productosCarrito = new ArrayList<>();
    }

    public ArrayList<DetalleCarrito> getProductosCarrito() {
        return productosCarrito;
    }

    public void setProductosCarrito(ArrayList<DetalleCarrito> productosCarrito) {
        this.productosCarrito = productosCarrito;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo.");
        }
        if (cantidad <= 0) {
            throw new CantidadInvalidaException(
                "La cantidad debe ser mayor que cero. Recibido: " + cantidad);
        }
        if (cantidad > producto.getCantidad()) {
            throw new StockInsuficienteException(
                "Stock insuficiente para '" + producto.getNombre()
                + "'. Disponible: " + producto.getCantidad()
                + ", solicitado: " + cantidad);
        }
        DetalleCarrito detalle = new DetalleCarrito(producto, cantidad);
        productosCarrito.add(detalle);
        producto.setCantidad(producto.getCantidad() - cantidad);
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < productosCarrito.size(); i++) {
            total = total + productosCarrito.get(i).calcularSubtotal();
        }
        return total;
    }

    public String generarDetalleCarrito() {
        String texto = "";
        if (productosCarrito.isEmpty()) {
            texto = "El carrito esta vacio.";
        } else {
            texto = texto + "=========== CARRITO DE COMPRA ===========\n";
            for (int i = 0; i < productosCarrito.size(); i++) {
                DetalleCarrito detalle = productosCarrito.get(i);
                Producto producto = detalle.getProducto();
                texto = texto + "Producto: " + producto.getNombre() + "\n";
                texto = texto + "Codigo: " + producto.getCodigo() + "\n";
                texto = texto + "Precio unitario: " + producto.getPrecioFinal() + "\n";
                texto = texto + "Cantidad: " + detalle.getCantidad() + "\n";
                texto = texto + "Subtotal: " + detalle.calcularSubtotal() + "\n";
                texto = texto + "----------------------------------------\n";
            }
            texto = texto + "TOTAL: " + calcularTotal() + "\n";
            texto = texto + "=========================================\n";
        }
        return texto;
    }

    public void vaciarCarrito() {
        productosCarrito.clear();
    }
}
