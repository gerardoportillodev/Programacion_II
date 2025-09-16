package ejercicio1;

public class Coche extends Vehiculo {
    public Coche(String marca, String modelo, int anio) {
        super(marca, modelo, anio);
    }

    @Override
    public void acelerar() {
        System.out.println("El coche acelera tranquilo en carretera.");
    }

    @Override
    public void frenar() {
        System.out.println("El coche frena con ABS.");
    }

    @Override
    public String obtenerTipo() {
        return "Coche";
    }
}

