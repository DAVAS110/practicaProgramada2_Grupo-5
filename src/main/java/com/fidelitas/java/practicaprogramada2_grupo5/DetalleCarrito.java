package com.fidelitas.java.practicaprogramada2_grupo5;

public class DetalleCarrito {

    private Producto producto;
    private int cantidad;

    public DetalleCarrito(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double calcularSubtotal() {
        return this.producto.getPrecioFinal() * this.cantidad;
    }

    @Override
    public String toString() {
        return "DetalleCarrito{"
                + "producto=" + producto.getNombre()
                + ", cantidad=" + cantidad
                + ", subtotal=" + calcularSubtotal()
                + '}';
    }
}
