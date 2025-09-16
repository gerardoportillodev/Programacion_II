package ejercicio3;

public abstract class Forma {
    public abstract double calcularArea();
    public abstract double calcularPerimetro();

    public String obtenerInfo() {
        return this.getClass().getSimpleName();
    }
}
