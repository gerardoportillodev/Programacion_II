package ejercicio2;

public class Gerente extends Empleado {
    public Gerente(String nombre, int id, double salarioBase) {
        super(nombre, id, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (salarioBase * 0.20); // +20% bono
    }
}
