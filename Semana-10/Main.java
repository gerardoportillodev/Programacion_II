import java.util.Scanner;

/**
 * Programación 2
 * Menú interactivo en consola.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Prestable[] recursos = new Prestable[]{
                new Libro("El Quijote", "Miguel de Cervantes", 1605),
                new Revista("National Geographic", "Varios autores", 2024),
                new DVD("Interstellar", "Christopher Nolan", 2014)
        };

        int opcion;
        do {
            System.out.println("\n===== Biblioteca =====");
            for (int i = 0; i < recursos.length; i++) {
                System.out.printf("%d) %s | Prestado: %s%n",
                        i + 1,
                        recursos[i].toString(),
                        recursos[i].estaPrestado() ? "Sí" : "No");
            }
            System.out.println("0) Salir");
            System.out.print("Seleccione un recurso (0 para salir): ");

            opcion = leerEntero(scanner);

            if (opcion > 0 && opcion <= recursos.length) {
                Prestable recurso = recursos[opcion - 1];
                menuAcciones(scanner, recurso);
            } else if (opcion != 0) {
                System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 0);

        System.out.println("¡Gracias por usar la biblioteca!");
        scanner.close();
    }

    private static void menuAcciones(Scanner scanner, Prestable recurso) {
        int accion;
        do {
            System.out.println("\nSeleccione una acción:");
            System.out.println("1) Prestar");
            System.out.println("2) Devolver");
            System.out.println("3) Ver estado");
            System.out.println("0) Volver al menú principal");
            System.out.print("Opción: ");
            accion = leerEntero(scanner);

            switch (accion) {
                case 1 -> {
                    recurso.prestar();
                    return; // regresa al menú principal automáticamente
                }
                case 2 -> {
                    recurso.devolver();
                    return; // regresa al menú principal automáticamente
                }
                case 3 -> System.out.println("¿Está prestado? " + recurso.estaPrestado());
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida.");
            }
        } while (accion != 0);
    }

    private static int leerEntero(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Ingrese un número válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
