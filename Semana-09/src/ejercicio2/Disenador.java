package ejercicio2;

public class Disenador extends Empleado {
    public Disenador(String nombre, int id, double salarioBase) {
        super(nombre, id, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (salarioBase * 0.15); // +15% bono creatividad
    }
}
