/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fidelitas.java.practicaprogramada2_grupo5;

/**
 *
 * @author lajch
 */
public class DetalleCarrito {
    
    private Producto producto;
    private int cantidad;

    public DetalleCarrito(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public double calcularSubtotal() {
        return producto.obtenerPrecioFinal() * cantidad;
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