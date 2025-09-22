/**
 * Representa un DVD en la biblioteca.
 */
public class DVD extends RecursoBiblioteca implements Prestable {
    private boolean prestado;

    public DVD(String titulo, String autor, int anio) {
        super(titulo, autor, anio);
        this.prestado = false;
    }

    @Override
    public void prestar() {
        if (!prestado) {
            prestado = true;
            System.out.println("El DVD \"" + titulo + "\" ha sido prestado.");
        } else {
            System.out.println("El DVD \"" + titulo + "\" ya estaba prestado.");
        }
    }

    @Override
    public void devolver() {
        if (prestado) {
            prestado = false;
            System.out.println("El DVD \"" + titulo + "\" ha sido devuelto.");
        } else {
            System.out.println("El DVD \"" + titulo + "\" no estaba prestado.");
        }
    }

    @Override
    public boolean estaPrestado() {
        return prestado;
    }
}
