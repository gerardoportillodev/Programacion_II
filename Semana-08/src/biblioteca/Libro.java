package biblioteca;

public class Libro {
    private final String titulo;
    private final String autor;
    private final int anio;
    private final String genero;
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

    public void marcarPrestado() { prestado = true; }
    public void marcarDisponible() { prestado = false; }

    @Override
    public String toString() {
        return String.format("%s - %s (%d) [%s] -> %s",
                titulo, autor, anio, genero,
                prestado ? "prestado" : "disponible");
    }
}
