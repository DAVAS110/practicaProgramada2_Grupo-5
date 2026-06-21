package com.fidelitas.java.practicaprogramada2_grupo5;


 // Clase abstracta que define los atributos comunes de un producto
 
public abstract class ProductoBase {

    private final String codigo; // atributo final
    private String nombre;
    private double precio;
    private int cantidad;

    public ProductoBase(String codigo, String nombre, double precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Método abstracto: cada subclase decide cómo calcular el precio final
    public abstract double getPrecioFinal();

    @Override
    public String toString() {
        return "Codigo: " + this.codigo
                + " | Nombre: " + this.nombre
                + " | Precio: " + this.precio
                + " | Cantidad: " + this.cantidad
                + " | Precio Final: " + getPrecioFinal();
    }
}
