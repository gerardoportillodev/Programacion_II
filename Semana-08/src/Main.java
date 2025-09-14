package biblioteca;

import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Biblioteca bib = new Biblioteca();
        var pLibros = Paths.get("libros.txt");
        var pUsuarios = Paths.get("usuarios.txt");
        // Cargar si existen
        bib.cargarLibros(pLibros);
        bib.cargarUsuarios(pUsuarios);

        Scanner sc = new Scanner(System.in);
        int opc;
        do {
            System.out.println("""
            --- Biblioteca ---
            1) Registrar libro
            2) Registrar usuario
            3) Prestar
            4) Devolver
            5) Listar por género
            6) Listar por autor
            7) Listar por disponibilidad
            8) Guardar
            0) Salir
            """);
            System.out.print("Opción: ");
            opc = Integer.parseInt(sc.nextLine().trim());

            switch (opc) {
                case 1 -> {
                    System.out.print("Titulo: "); String t = sc.nextLine();
                    System.out.print("Autor: "); String a = sc.nextLine();
                    System.out.print("Año: "); int an = Integer.parseInt(sc.nextLine());
                    System.out.print("Género: "); String g = sc.nextLine();
                    bib.registrarLibro(new Libro(t, a, an, g));
                }
                case 2 -> {
                    System.out.print("ID: "); String id = sc.nextLine();
                    System.out.print("Nombre: "); String nom = sc.nextLine();
                    bib.registrarUsuario(new Usuario(nom, id));
                }
                case 3 -> {
                    System.out.print("ID usuario: "); String id = sc.nextLine();
                    System.out.print("Título: "); String t = sc.nextLine();
                    System.out.println(bib.prestar(id, t) ? "Préstamo OK" : "No se pudo prestar");
                }
                case 4 -> {
                    System.out.print("ID usuario: "); String id = sc.nextLine();
                    System.out.print("Título: "); String t = sc.nextLine();
                    System.out.println(bib.devolver(id, t) ? "Devolución OK" : "No se pudo devolver");
                }
                case 5 -> {
                    System.out.print("Género: "); String g = sc.nextLine();
                    bib.imprimir(bib.listarPorGenero(g));
                }
                case 6 -> {
                    System.out.print("Autor: "); String a = sc.nextLine();
                    bib.imprimir(bib.listarPorAutor(a));
                }
                case 7 -> {
                    System.out.print("¿Listar disponibles? (s/n): ");
                    boolean disp = sc.nextLine().trim().equalsIgnoreCase("s");
                    bib.imprimir(bib.listarPorDisponibilidad(disp));
                }
                case 8 -> {
                    bib.guardarLibros(pLibros);
                    bib.guardarUsuarios(pUsuarios);
                    System.out.println("Datos guardados.");
                }
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida.");
            }
        } while (opc != 0);
    }
}
