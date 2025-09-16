package ejercicio1;

public class Moto extends Vehiculo {
    public Moto(String marca, String modelo, int anio) {
        super(marca, modelo, anio);
    }

    @Override
    public void acelerar() {
        System.out.println("La moto acelera con rapidez.");
    }

    @Override
    public void frenar() {
        System.out.println("La moto frena usando ambos frenos.");
    }

    @Override
    public String obtenerTipo() {
        return "Moto";
    }
}
