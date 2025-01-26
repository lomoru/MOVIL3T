package com.example.movil3t;

public class Pokemon {

    private final String nombre;
    private final int indice;
    private final String tipo;
    private final int peso;
    private final int altura;
    private final String imagen;

    public Pokemon(String nombre, int indice, String tipo, int peso, int altura, String imagen) {
        this.nombre = nombre;
        this.indice = indice;
        this.tipo = tipo;
        this.peso = peso;
        this.altura = altura;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getPeso() {
        return peso;
    }

    public int getAltura() {
        return altura;
    }

    public String getImagen() {
        return imagen;
    }
}
