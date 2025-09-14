package biblioteca;

public class Lectores {
    public static void main(String[] args) {
        // Crear libros
        RegistrarLibros libro1 = new RegistrarLibros("Wonder", "R.J. Palacio", 2012, "Ficción juvenil");
        RegistrarLibros libro2 = new RegistrarLibros("Bajo la misma estrella", "John Green", 2012, "Romance juvenil");
        RegistrarLibros libro3 = new RegistrarLibros("El niño con el pijama de rayas", "John Boyne", 2006, "Histórica");

        // Crear un lector
        RegistrarLectores lector = new RegistrarLectores("Ana López", "A123");

        // Probar prestamos y devoluciones
        lector.prestarLibro(libro1);
        lector.prestarLibro(libro2);
        lector.prestarLibro(libro1); // este ya está prestado
        lector.devolverLibro(libro1);

        // Mostrar info del lector
        lector.mostrarInfo();

        // Mostrar info de todos los libros
        System.out.println();
        libro1.mostrarInfo();
        libro2.mostrarInfo();
        libro3.mostrarInfo();
    }
}
