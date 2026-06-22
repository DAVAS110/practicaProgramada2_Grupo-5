package com.fidelitas.java.practicaprogramada2_grupo5;

  //aparece cuando se busca un producto por código y no existe.
public class ProductoNoEncontradoException extends Exception {

    public ProductoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
