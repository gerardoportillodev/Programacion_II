package ejercicio1;

public class Camion extends Vehiculo {
    public Camion(String marca, String modelo, int anio) {
        super(marca, modelo, anio);
    }

    @Override
    public void acelerar() {
        System.out.println("El camión acelera lentamente por su peso.");
    }

    @Override
    public void frenar() {
        System.out.println("El camión usa frenos de aire para detenerse.");
    }

    @Override
    public String obtenerTipo() {
        return "Camión";
    }
}
