package com.fidelitas.java.practicaprogramada2_grupo5;

public class Producto extends ProductoBase {

    public Producto(String codigo, String nombre, double precio, int cantidad) {
        super(codigo, nombre, precio, cantidad);

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio.");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0.");
        }
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        }
    }

    @Override
    public double getPrecioFinal() {
        return this.getPrecio();
    }

    public void vender(int cantidadVendida) {
        if (cantidadVendida <= 0) {
            throw new CantidadInvalidaException(
                    "La cantidad a vender debe ser mayor a 0. Recibido: " + cantidadVendida);
        }
        if (cantidadVendida > this.getCantidad()) {
            throw new StockInsuficienteException(
                    "Stock insuficiente para '" + this.getNombre()
                    + "'. Disponible: " + this.getCantidad()
                    + ", solicitado: " + cantidadVendida);
        }
        this.setCantidad(this.getCantidad() - cantidadVendida);
    }
}
