package ejercicio1;

public class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int anio;

    public Vehiculo(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    public void acelerar() {
        System.out.println("El vehículo acelera...");
    }

    public void frenar() {
        System.out.println("El vehículo va frenando...");
    }

    public String obtenerInfo() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Año: " + anio;
    }

        public String obtenerTipo() {
        return "Vehículo Normal";
    }
}
