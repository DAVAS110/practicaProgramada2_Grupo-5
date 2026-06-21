package gestionproductos;

 // Se lanza cuando se intenta vender/retirar más cantidad de la disponible en stock
 
public class StockInsuficienteException extends Exception {

    public StockInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
