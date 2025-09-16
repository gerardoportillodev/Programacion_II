package ejercicio2;

public class Empleado {
    protected String nombre;
    protected int id;
    protected double salarioBase;

    public Empleado(String nombre, int id, double salarioBase) {
        this.nombre = nombre;
        this.id = id;
        this.salarioBase = salarioBase;
    }

    // Método que será redefinido en las subclases
    public double calcularSalario() {
        return salarioBase;
    }

    public String obtenerInfo() {
        return "Empleado: " + nombre + " | ID: " + id + " | Salario base: " + salarioBase;
    }
}
