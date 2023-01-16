public class Secadora extends Electrodomestico{
    // Atributo por defecto
    protected final double CARGADEF = 5;

    // Atributos
    protected double carga;

    // Constructores
    public Secadora() {
    }

    public Secadora(double precio_base, double peso) {
        super(precio_base, peso);
        this.carga = CARGADEF;
    }

    public Secadora(double precio_base, String color, char consumo_electrico, double peso, double carga) {
        super(precio_base, color, consumo_electrico, peso);
        this.carga = carga;
    }

    // Getters
    public double getCarga() {
        return carga;
    }

    // Método aumento precio
    private double aumentoPrecio(double carga) {
        double sumPrecio = 0;
        if (carga > 30) {
            return sumPrecio = 50;
        }
        return sumPrecio;
    }

    // Método precio final
    @Override
    public double precioFinal() {
        double carga = getCarga();
        double precio = super.precioFinal();
        double precio_final = carga + precio;
        return precio_final;
    }
}
