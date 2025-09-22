/**
 * Representa una revista en la biblioteca.
 */
public class Revista extends RecursoBiblioteca implements Prestable {
    private boolean prestado;

    public Revista(String titulo, String autor, int anio) {
        super(titulo, autor, anio);
        this.prestado = false;
    }

    @Override
    public void prestar() {
        if (!prestado) {
            prestado = true;
            System.out.println("La revista \"" + titulo + "\" ha sido prestada.");
        } else {
            System.out.println("La revista \"" + titulo + "\" ya estaba prestada.");
        }
    }

    @Override
    public void devolver() {
        if (prestado) {
            prestado = false;
            System.out.println("La revista \"" + titulo + "\" ha sido devuelta.");
        } else {
            System.out.println("La revista \"" + titulo + "\" no estaba prestada.");
        }
    }

    @Override
    public boolean estaPrestado() {
        return prestado;
    }
}
