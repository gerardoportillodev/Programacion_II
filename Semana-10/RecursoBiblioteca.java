/**
 * Clase base para los recursos de la biblioteca.
 * Contiene atributos y métodos comunes.
 */
public abstract class RecursoBiblioteca {
    protected String titulo;
    protected String autor;
    protected int anio;

    public RecursoBiblioteca(String titulo, String autor, int anio) {
        if (titulo == null || titulo.isBlank())
            throw new IllegalArgumentException("El título no puede estar vacío.");
        if (autor == null || autor.isBlank())
            throw new IllegalArgumentException("El autor no puede estar vacío.");
        if (anio <= 0)
            throw new IllegalArgumentException("El año debe ser mayor a 0.");

        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnio() { return anio; }

    @Override
    public String toString() {
        return String.format("%s (%d) - %s", titulo, anio, autor);
    }
}
