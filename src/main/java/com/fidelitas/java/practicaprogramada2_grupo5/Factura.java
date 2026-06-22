/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fidelitas.java.practicaprogramada2_grupo5;

/**
 *
 * @author lajch
 */
public class Factura {
    
    private CarritoCompra carrito;

    public Factura(CarritoCompra carrito) {
        this.carrito = carrito;
    }

    public CarritoCompra getCarrito() {
        return carrito;
    }

    public void setCarrito(CarritoCompra carrito) {
        this.carrito = carrito;
    }
    
    public String generarRecibo() {
        
        String recibo = "";
        
        recibo = recibo + "========================================\n";
        recibo = recibo + "        FARMACIA SALUD INTEGRAL\n";
        recibo = recibo + "     Productos de Bienestar Animal\n";
        recibo = recibo + "========================================\n";
        
        if (carrito.getProductosCarrito().size() == 0) {
            recibo = recibo + "No hay productos en el carrito.\n";
        } else {
            
            for (int i = 0; i < carrito.getProductosCarrito().size(); i++) {
                
                DetalleCarrito detalle = carrito.getProductosCarrito().get(i);
                Producto producto = detalle.getProducto();
                
                recibo = recibo + "Producto: " + producto.getNombre() + "\n";
                recibo = recibo + "Codigo: " + producto.getCodigo() + "\n";
                recibo = recibo + "Precio final unitario: " + producto.obtenerPrecioFinal() + "\n";
                recibo = recibo + "Cantidad: " + detalle.getCantidad() + "\n";
                recibo = recibo + "Subtotal: " + detalle.calcularSubtotal() + "\n";
                recibo = recibo + "----------------------------------------\n";
            }
            
            recibo = recibo + "TOTAL A PAGAR: " + carrito.calcularTotal() + "\n";
        }
        
        recibo = recibo + "========================================\n";
        recibo = recibo + "Gracias por su compra.\n";
        
        return recibo;
    }
}