package biblioteca;

import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Biblioteca bib = new Biblioteca();
        inicializarDatos(bib);

        int opc;
        do {
            mostrarMenu();
            opc = leerEntero("Opción: ");

            switch (opc) {
                case 1 -> registrarLibro(bib);
                case 2 -> registrarUsuario(bib);
                case 3 -> prestarLibro(bib);
                case 4 -> devolverLibro(bib);
                case 5 -> listarTodos(bib);
                case 6 -> listarDisponibles(bib);
                case 7 -> listarUsuarios(bib);
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.\n");
            }
        } while (opc != 0);
    }

    // Datos ficticios
    private static void inicializarDatos(Biblioteca bib) {
        // Libros salvadoreños
        bib.registrarLibro(new Libro("cuzcatlan donde bate la mar del sur", "alfonso quinonez molina", 1930, "novela"));
        bib.registrarLibro(new Libro("caceria de brujos", "manlio argueta", 1970, "cuento"));
        bib.registrarLibro(new Libro("en la montana", "roque dalton", 1969, "poesia"));
        bib.registrarLibro(new Libro("el valle de las hamacas", "pedro geofroy rivas", 1956, "ensayo"));
        bib.registrarLibro(new Libro("un dia en la vida", "manlio argueta", 1980, "novela"));
        bib.registrarLibro(new Libro("canto a nuestra independencia", "alfonso quijada urias", 1971, "poesia"));
        bib.registrarLibro(new Libro("los perros magicos de los volcanes", "manlio argueta", 1979, "cuento infantil"));
        bib.registrarLibro(new Libro("el cipitio", "claudia lars", 1950, "cuento"));
        bib.registrarLibro(new Libro("pobrecito poeta que era yo", "roque dalton", 1969, "poesia"));
        bib.registrarLibro(new Libro("ciudad sin sueno", "alvaro menen desleal", 1963, "teatro"));

        // Usuarios
        Usuario u1 = new Usuario("u001", "morales ramos karla andrea");
        Usuario u2 = new Usuario("u002", "nunez castaneda dulce victoria");
        Usuario u3 = new Usuario("u003", "orellana cordova sara noemy");
        Usuario u4 = new Usuario("u004", "portillo santamaria noe gerardo");
        Usuario u5 = new Usuario("u005", "romero vasquez jecson adonis");

        bib.registrarUsuario(u1);
        bib.registrarUsuario(u2);
        bib.registrarUsuario(u3);
        bib.registrarUsuario(u4);
        bib.registrarUsuario(u5);

        // préstamos iniciales
        u1.tomarPrestado(bib.listarDisponibles().get(0), 10); // 10 días
        u2.tomarPrestado(bib.listarDisponibles().get(2), 7);  // 7 días
        u3.tomarPrestado(bib.listarDisponibles().get(4), 15); // 15 días
    }

    // Menú
    private static void mostrarMenu() {
        System.out.println("""
        ***--- Biblioteca ---***
        1) Registrar libro
        2) Registrar usuario
        3) Prestar libro
        4) Devolver libro
        5) Ver catálogo completo
        6) Ver solo disponibles
        7) Ver usuarios
        0) Salir
        """);
    }

    // Métodos de acciones
    private static void registrarLibro(Biblioteca bib) {
        System.out.print("Título: "); String t = sc.nextLine();
        System.out.print("Autor: "); String a = sc.nextLine();
        int an = leerEntero("Año: ");
        System.out.print("Género: "); String g = sc.nextLine();
        bib.registrarLibro(new Libro(t, a, an, g));
        System.out.println("Libro registrado.\n");
    }

    private static void registrarUsuario(Biblioteca bib) {
        System.out.print("ID usuario: "); String id = sc.nextLine();
        System.out.print("Nombre completo: "); String n = sc.nextLine();
        bib.registrarUsuario(new Usuario(id, n));
        System.out.println("Usuario registrado.\n");
    }

    private static void prestarLibro(Biblioteca bib) {
        Usuario u = elegirUsuario(bib);
        if (u == null) return;

        List<Libro> disp = bib.listarDisponibles();
        if (disp.isEmpty()) {
            System.out.println("No hay libros disponibles.\n");
            return;
        }

        mostrarLista(disp);
        int idx = leerEntero("Elige número de libro: ") - 1;
        if (idx < 0 || idx >= disp.size()) {
            System.out.println("Selección inválida.\n");
            return;
        }

        int dias = leerEntero("¿Cuántos días lo necesitas? (máx 15): ");
        if (dias < 1 || dias > 15) dias = 15; // control

        if (u.tomarPrestado(disp.get(idx), dias)) {
            Prestamo p = u.getPrestamos().get(u.getPrestamos().size()-1);
            System.out.println("Préstamo realizado. Devuelve antes de " + p.getFechaDevolucion() + "\n");
        } else {
            System.out.println("No se pudo prestar.\n");
        }
    }

    private static void devolverLibro(Biblioteca bib) {
        Usuario u = elegirUsuario(bib);
        if (u == null) return;

        List<Prestamo> prestados = u.getPrestamos();
        if (prestados.isEmpty()) {
            System.out.println("No tienes libros prestados.\n");
            return;
        }

        for (int i = 0; i < prestados.size(); i++) {
            System.out.println((i+1) + ") " + prestados.get(i));
        }

        int idx = leerEntero("Elige número de préstamo a devolver: ") - 1;
        if (idx >= 0 && idx < prestados.size() &&
                u.devolver(prestados.get(idx).getLibro())) {
            System.out.println("Devolución realizada.\n");
        } else {
            System.out.println("No se pudo devolver.\n");
        }
    }

    private static void listarTodos(Biblioteca bib) {
        System.out.println("Catálogo completo");
        mostrarLista(bib.listarTodos());
    }

    private static void listarDisponibles(Biblioteca bib) {
        System.out.println("Libros disponibles");
        mostrarLista(bib.listarDisponibles());
    }

    private static void listarUsuarios(Biblioteca bib) {
        System.out.println("Usuarios registrados");
        for (Usuario u : bib.getUsuarios()) {
            System.out.println(u);
            System.out.println();
        }
    }

    // Utilidades
    private static Usuario elegirUsuario(Biblioteca bib) {
        List<Usuario> usuarios = new ArrayList<>(bib.getUsuarios());
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.\n");
            return null;
        }
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println((i+1) + ") " + usuarios.get(i).getNombre() + " (id: " + usuarios.get(i).getId() + ")");
        }
        int idx = leerEntero("Elige número de usuario: ") - 1;
        if (idx >= 0 && idx < usuarios.size()) return usuarios.get(idx);
        System.out.println("Selección inválida.\n");
        return null;
    }

    private static void mostrarLista(List<Libro> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay resultados.\n");
        } else {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println((i+1) + ") " + lista.get(i));
            }
            System.out.println();
        }
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intenta de nuevo.");
            }
        }
    }
}
