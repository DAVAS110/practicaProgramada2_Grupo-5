package com.fidelitas.java.practicaprogramada2_grupo5;

public class ProductoDescuento extends Producto {

    private double porcentajeDescuento;

    public ProductoDescuento(String codigo, String nombre, double precio,
            int cantidad, double porcentajeDescuento) {
        super(codigo, nombre, precio, cantidad);

        if (porcentajeDescuento < 0 || porcentajeDescuento > 100) {
            throw new IllegalArgumentException("El descuento debe estar entre 0 y 100.");
        }
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public double getPorcentajeDescuento() {
        return this.porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        if (porcentajeDescuento < 0 || porcentajeDescuento > 100) {
            throw new IllegalArgumentException("El descuento debe estar entre 0 y 100.");
        }
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public double getPrecioFinal() {
        return this.getPrecio() * (1 - this.porcentajeDescuento / 100);
    }

    @Override
    public String toString() {
        return super.toString() + " | Descuento: " + this.porcentajeDescuento + "%";
    }
}
