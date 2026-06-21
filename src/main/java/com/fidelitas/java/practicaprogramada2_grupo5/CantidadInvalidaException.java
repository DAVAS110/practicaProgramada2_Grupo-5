package com.fidelitas.java.practicaprogramada2_grupo5;


 // Se lanza cuando se intenta asignar una cantidad inválida (negativa) a un producto.
 
public class CantidadInvalidaException extends Exception {

    public CantidadInvalidaException(String mensaje) {
        super(mensaje);
    }
}
