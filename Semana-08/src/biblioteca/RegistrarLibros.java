package biblioteca;

public class RegistrarLibros {
    private String titulo;
    private String autor;
    private int anio;
    private String genero;
    private boolean prestado;

    public RegistrarLibros(String titulo, String autor, int anio, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.genero = genero;
        this.prestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void prestar() {
        if (!prestado) {
            prestado = true;
        } else {
            System.out.println("El libro " + titulo + " ya está prestado.");
        }
    }

    public void devolver() {
        if (prestado) {
            prestado = false;
        } else {
            System.out.println("El libro " + titulo + " no estaba prestado.");
        }
    }

    public void mostrarInfo() {
        System.out.println(titulo + " - " + autor + " (" + anio + ") [" + genero + "] " +
                (prestado ? "Prestado" : "Disponible"));
    }
}
