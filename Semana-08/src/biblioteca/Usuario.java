package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String id;
    private List<Libro> librosPrestados = new ArrayList<>();

    public Usuario(String nombre, String id) {
        this.nombre = nombre; this.id = id;
    }

    public String getNombre() { return nombre; }
    public String getId() { return id; }
    public List<Libro> getLibrosPrestados() { return librosPrestados; }

    public boolean tomarPrestado(Libro l) {
        if (l.isPrestado()) return false;
        if (l.prestar()) { librosPrestados.add(l); return true; }
        return false;
    }

    public boolean devolver(Libro l) {
        if (!librosPrestados.contains(l)) return false;
        if (l.devolver()) { librosPrestados.remove(l); return true; }
        return false;
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario: ").append(nombre).append(" (").append(id).append(")\n")
                .append("Prestados:\n");
        if (librosPrestados.isEmpty()) sb.append("  Ninguno\n");
        else for (Libro l: librosPrestados) sb.append("  - ").append(l.getTitulo()).append("\n");
        return sb.toString();
    }
}
