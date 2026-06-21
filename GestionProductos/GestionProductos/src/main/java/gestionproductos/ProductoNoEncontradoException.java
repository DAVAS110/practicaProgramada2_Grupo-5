package gestionproductos;

  //aparece cuando se busca un producto por código y no existe.
public class ProductoNoEncontradoException extends Exception {

    public ProductoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
