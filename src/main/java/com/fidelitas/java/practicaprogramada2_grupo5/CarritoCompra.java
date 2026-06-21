/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fidelitas.java.practicaprogramada2_grupo5;

/**
 *
 * @author lajch
 */
public class CarritoCompra {
    
    private ArrayList<DetalleCarrito> productosCarrito;

    public CarritoCompra() {
        this.productosCarrito = new ArrayList<DetalleCarrito>();
    }

    public ArrayList<DetalleCarrito> getProductosCarrito() {
        return productosCarrito;
    }

    public void setProductosCarrito(ArrayList<DetalleCarrito> productosCarrito) {
        this.productosCarrito = productosCarrito;
    }
    
    public void agregarProducto(Producto producto, int cantidad) throws Exception {
        
        if (producto == null) {
            throw new Exception("El producto no existe.");
        }
        
        if (cantidad <= 0) {
            throw new Exception("La cantidad debe ser mayor que cero.");
        }
        
        if (cantidad > producto.getCantidadInventario()) {
            throw new Exception("No hay stock suficiente para agregar el producto al carrito.");
        }
        
        DetalleCarrito detalle = new DetalleCarrito(producto, cantidad);
        productosCarrito.add(detalle);
        
        int nuevaCantidad = producto.getCantidadInventario() - cantidad;
        producto.setCantidadInventario(nuevaCantidad);
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
        
        if (productosCarrito.size() == 0) {
            texto = "El carrito esta vacio.";
        } else {
            texto = texto + "=========== CARRITO DE COMPRA ===========\n";
            
            for (int i = 0; i < productosCarrito.size(); i++) {
                
                DetalleCarrito detalle = productosCarrito.get(i);
                Producto producto = detalle.getProducto();
                
                texto = texto + "Producto: " + producto.getNombre() + "\n";
                texto = texto + "Codigo: " + producto.getCodigo() + "\n";
                texto = texto + "Precio unitario: " + producto.obtenerPrecioFinal() + "\n";
                texto = texto + "Cantidad: " + detalle.getCantidad() + "\n";
                texto = texto + "Subtotal: " + detalle.calcularSubtotal() + "\n";
                texto = texto + "----------------------------------------\n";
            }
            
            texto = texto + "TOTAL: " + calcularTotal() + "\n";
            texto = texto + "========================================\n";
        }
        
        return texto;
    }
    
    public void vaciarCarrito() {
        productosCarrito.clear();
    }
}