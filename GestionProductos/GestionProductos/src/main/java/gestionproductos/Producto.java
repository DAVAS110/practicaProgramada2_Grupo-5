package gestionproductos;


 //Producto concreto. Extiende ProductoBase y valida sus datos en el constructor mediante this
 
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

        this.setNombre(nombre);
        this.setPrecio(precio);
        this.setCantidad(cantidad);
    }

    /**
     * Precio final sin descuento, según lo solicitado.
     */
    @Override
    public double getPrecioFinal() {
        return this.getPrecio();
    }

    /**
     * Reduce el stock validando cantidad y disponibilidad.
     *
     * @throws CantidadInvalidaException  si la cantidad es <= 0
     * @throws StockInsuficienteException si no hay stock suficiente
     */
    public void vender(int cantidadVendida) throws CantidadInvalidaException, StockInsuficienteException {
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
