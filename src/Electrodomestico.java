/*
* @Author Guillermo Cifre Gonzalez
* @Version 1.0.0*/

import java.util.Locale;

public class Electrodomestico {
    // Atributos por defecto
    protected final double PRECIO_BASE = 100;
    protected final String COLOR = "blanco";
    protected final char CONSUMO_ELECTRICO = 'F';
    protected final double PESO = 5;

    // Atributos
    protected double precio_base;
    protected String color;
    protected char consumo_electrico;
    protected double peso;
    protected String[] colores = {"blanco", "negro", "rojo", "azul", "gris"};
    protected char [] consumos_electricos = {'A', 'B', 'C', 'D', 'E', 'F'};


    // Constructores:
    public Electrodomestico() {
    }

    public Electrodomestico(double precio_base, double peso) {
        this.precio_base = precio_base;
        this.peso = peso;
    }

    public Electrodomestico(double precio_base, String color, char consumo_electrico, double peso) {
        this.color = comprobarColor(color);
        this.consumo_electrico = comprobarConsumoEnergetico(consumo_electrico);
        this.precio_base = precio_base;
        this.peso = peso;
    }

    // Métodos get
    public double getPrecio_base() {
        return precio_base;
    }

    public String getColor() {
        return color;
    }

    public char getConsumo_electrico() {
        return consumo_electrico;
    }

    public double getPeso() {
        return peso;
    }

    // Método Comprobar consumo energetico
    private char comprobarConsumoEnergetico(char letra) {
        char letraMayuscula = Character.toUpperCase(letra);
        for (int i = 0; i < consumos_electricos.length; i++){
            if (letraMayuscula == consumos_electricos[i]) {
                return letraMayuscula;
            }
        }
        return CONSUMO_ELECTRICO;
    };

    // Método comprobar color
    private String comprobarColor(String color) {
        String colorMinuscula = color.toLowerCase();
        for (int i = 0; i < colores.length; i++){
            if (colorMinuscula.equals(colores[i])) {
                return colorMinuscula;
            }
        }
        return COLOR;
    };

    // Método precio final
    public double precioFinal() {
        double precio = this.precio_base;
        double peso = this.peso;
        char consumo = this.consumo_electrico;
        double precioSegunConsumo = precioSegunConsumo(consumo);
        double precioSegunPeso = precioSegunPeso(peso);
        double precioFinal = precioSegunConsumo + precioSegunPeso + precio;
        return precioFinal;
    };

    public double precioSegunConsumo(char consumo_electrico) {
        double precio = 0;
        char consumo_electrico_Mayuscula = Character.toUpperCase(consumo_electrico);
            switch (consumo_electrico_Mayuscula) {
                case 'A': precio = 100; break;
                case 'B': precio = 80; break;
                case 'C': precio = 60; break;
                case 'D': precio = 50; break;
                case 'E': precio = 30; break;
                case 'F': precio = 10; break;
            }
        return precio;
    }

    public double precioSegunPeso(double pesoElectrodomestico) {
        double precio = 0;
        if (0 <= pesoElectrodomestico || pesoElectrodomestico <= 19.0) {
            precio = 10;
        }

        if (20 <= pesoElectrodomestico || pesoElectrodomestico <= 49.0) {
            precio = 50;
        }

        if (50 <= pesoElectrodomestico || pesoElectrodomestico <= 79.0) {
            precio = 80;
        }

        if (pesoElectrodomestico <= 80 ) {
            precio = 100;
        }
        return precio;
    }

    @Override
    public String toString() {
        return "Electrodomestico{" +
                "precio_base=" + precio_base +
                ", color='" + color + '\'' +
                ", consumo_electrico=" + consumo_electrico +
                ", peso=" + peso +
                '}';
    }
}
