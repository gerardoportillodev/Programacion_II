package biblioteca;

public class Libro {
    private String titulo;
    private String autor;
    private int anio;
    private String genero;
    private boolean prestado;

    public Libro(String titulo, String autor, int anio, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.genero = genero;
        this.prestado = false;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnio() { return anio; }
    public String getGenero() { return genero; }
    public boolean isPrestado() { return prestado; }

    public boolean prestar() {
        if (prestado) return false;
        prestado = true; return true;
    }
    public boolean devolver() {
        if (!prestado) return false;
        prestado = false; return true;
    }

    @Override public String toString() {
        return titulo + " - " + autor + " (" + anio + ") [" + genero + "] "
                + (prestado ? "Prestado" : "Disponible");
    }
}
