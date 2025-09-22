/**
 * Representa un libro en la biblioteca.
 */
public class Libro extends RecursoBiblioteca implements Prestable {
    private boolean prestado;

    public Libro(String titulo, String autor, int anio) {
        super(titulo, autor, anio);
        this.prestado = false;
    }

    @Override
    public void prestar() {
        if (!prestado) {
            prestado = true;
            System.out.println("El libro \"" + titulo + "\" ha sido prestado.");
        } else {
            System.out.println("El libro \"" + titulo + "\" ya estaba prestado.");
        }
    }

    @Override
    public void devolver() {
        if (prestado) {
            prestado = false;
            System.out.println("El libro \"" + titulo + "\" ha sido devuelto.");
        } else {
            System.out.println("El libro \"" + titulo + "\" no estaba prestado.");
        }
    }

    @Override
    public boolean estaPrestado() {
        return prestado;
    }
}
