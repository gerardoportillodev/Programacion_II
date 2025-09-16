package ejercicio2;

public class Desarrollador extends Empleado {
    private int proyectos; // cantidad de proyectos realizados

    public Desarrollador(String nombre, int id, double salarioBase, int proyectos) {
        super(nombre, id, salarioBase);
        this.proyectos = proyectos;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (salarioBase * 0.10 * proyectos); // +10% por proyecto
    }
}
