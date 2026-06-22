package com.fidelitas.java.practicaprogramada2_grupo5;

public class StockInsuficienteException extends RuntimeException {

    public StockInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
