package biblioteca;

import java.util.ArrayList;

public class RegistrarLectores {
    private String nombre;
    private String id;
    private ArrayList<RegistrarLibros> librosPrestados;

    public RegistrarLectores(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.librosPrestados = new ArrayList<>();
    }

    public void prestarLibro(RegistrarLibros libro) {
        if (!libro.isPrestado()) {
            libro.prestar();
            librosPrestados.add(libro);
            System.out.println(nombre + " ha prestado el libro: " + libro.getTitulo());
        } else {
            System.out.println("El libro " + libro.getTitulo() + " ya está prestado.");
        }
    }

    public void devolverLibro(RegistrarLibros libro) {
        if (librosPrestados.contains(libro)) {
            libro.devolver();
            librosPrestados.remove(libro);
            System.out.println(nombre + " ha devuelto el libro: " + libro.getTitulo());
        } else {
            System.out.println(nombre + " no tiene prestado el libro: " + libro.getTitulo());
        }
    }

    public void mostrarInfo() {
        System.out.println("--- Información del lector ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + id);
        System.out.println("Libros prestados:");
        if (librosPrestados.isEmpty()) {
            System.out.println("   Ninguno");
        } else {
            for (RegistrarLibros libro : librosPrestados) {
                System.out.println("   - " + libro.getTitulo());
            }
        }
        System.out.println("-------------------------------");
    }
}
