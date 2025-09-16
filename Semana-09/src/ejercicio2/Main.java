package ejercicio2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Empleado> empleados = new ArrayList<>();

        empleados.add(new Gerente("Noé Gerardo Portillo", 1, 35000));
        empleados.add(new Desarrollador("Tito Kino", 2, 2000, 3));
        empleados.add(new Disenador("Wang Lonyi", 3, 1800));

        procesarEmpleados(empleados);
    }

    // Método que procesa lista polimórficamente
    public static void procesarEmpleados(ArrayList<Empleado> empleados) {
        for (Empleado e : empleados) {
            System.out.println(e.obtenerInfo());
            System.out.println("Salario calculado: " + e.calcularSalario());
            System.out.println();
        }
    }
}
