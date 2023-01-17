public class Television extends Electrodomestico{
    // Atributos por defecto
    private final double PULGADASDEF = 20;
    private final double MINPULGADAS = 40;
    private final Boolean SINTONIZADORTDTDEF = false;

    // Atributos
    private double pulgadas;
    private boolean sintonizadorTDT;

    // Contructores

    public Television() {
    }

    public Television(double precio_base, double peso) {
        super(precio_base, peso);
        this.pulgadas = PULGADASDEF;
        this.sintonizadorTDT = SINTONIZADORTDTDEF;
    }
    public Television(double precio_base, String color, char consumo_electrico, double peso, double pulgadas, boolean sintonizadorTDT) {
        super(precio_base, color, consumo_electrico, peso);
        this.pulgadas = pulgadas;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    // Getters
    public double getPulgadas() {
        return pulgadas;
    }

    public boolean isSintonizadorTDT() {
        return sintonizadorTDT;
    }

    // Método precio final
    @Override
    public double precioFinal() {
        double precio = super.precioFinal();
        // System.out.println("Precio: " + precio);
        double precioSegunPulgadas = precioSegunPulgadas();
        // System.out.println("Aumento precio por pulgadas: " + precioSegunPulgadas);
        double precioSiSintonizador = precioSiSintonizador();
        // System.out.println("Aumento precio por sintonizador: " + precioSiSintonizador);
        double precio_final = precio + precioSegunPulgadas + precioSiSintonizador;
        return precio_final;
    }

    // Método precio segun pulgadas
    private double precioSegunPulgadas() {
        double precio = 0;
        double precio_base = getPrecio_base();
        double resolucion = getPulgadas();
        if (resolucion > MINPULGADAS) {
            return precio = (precio_base * (0.3));
        }
        return precio;
    }

    // Método precio si sintonizador
    private double precioSiSintonizador() {
        double precio = 0;
        boolean sintonidador = isSintonizadorTDT();
        if (sintonidador) {
            return precio = 50;
        }
        return precio;
    }

    @Override
    public String toString() {
        return "Television{" +
                "pulgadas=" + pulgadas +
                ", sintonizadorTDT=" + sintonizadorTDT +
                ", precio_base=" + precio_base +
                ", color='" + color + '\'' +
                ", consumo_electrico=" + consumo_electrico +
                ", peso=" + peso +
                '}';
    }
}
