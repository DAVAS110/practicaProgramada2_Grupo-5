package com.fidelitas.java.practicaprogramada2_grupo5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventario {

    private List<Producto> lista;
    private Map<String, Producto> mapa;

    public Inventario() {
        this.lista = new ArrayList<>();
        this.mapa = new HashMap<>();
    }

    public void agregar(Producto p) {
        if (mapa.containsKey(p.getCodigo())) {
            System.out.println("Ya existe un producto con el codigo: " + p.getCodigo());
            return;
        }
        lista.add(p);
        mapa.put(p.getCodigo(), p);
        System.out.println("Producto agregado: " + p.getNombre());
    }

    public Producto buscarPorCodigo(String codigo) {
        Producto p = mapa.get(codigo);
        if (p == null) {
            throw new ProductoNoEncontradoException(
                    "No existe un producto con el codigo: " + codigo);
        }
        return p;
    }

    public void eliminar(String codigo) {
        Producto p = buscarPorCodigo(codigo);
        lista.remove(p);
        mapa.remove(codigo);
        System.out.println("Producto eliminado: " + p.getNombre());
    }

    public void modificar(String codigo, String nuevoNombre, double nuevoPrecio, int nuevaCantidad) {
        Producto p = buscarPorCodigo(codigo);
        if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
            p.setNombre(nuevoNombre);
        }
        if (nuevoPrecio > 0) {
            p.setPrecio(nuevoPrecio);
        }
        if (nuevaCantidad >= 0) {
            p.setCantidad(nuevaCantidad);
        }
    }

    public void listarTodos() {
        if (lista.isEmpty()) {
            System.out.println("El inventario esta vacio.");
            return;
        }
        System.out.println("========== INVENTARIO ==========");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
        System.out.println("================================");
    }

    public List<Producto> getLista() {
        return lista;
    }

    public boolean estaVacio() {
        return lista.isEmpty();
    }
}
