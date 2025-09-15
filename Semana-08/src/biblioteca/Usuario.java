package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private final String id;
    private final String nombre;
    private final List<Prestamo> prestamos = new ArrayList<>();

    public Usuario(String id, String nombre) {
        this.id = id.toLowerCase();
        this.nombre = nombre.toLowerCase();
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public List<Prestamo> getPrestamos() { return prestamos; }

    public boolean tomarPrestado(Libro l, int dias) {
        if (l.isPrestado()) return false;
        prestamos.add(new Prestamo(l, dias));
        return true;
    }

    public boolean devolver(Libro l) {
        for (Prestamo p : prestamos) {
            if (p.getLibro().equals(l)) {
                p.devolver();
                prestamos.remove(p);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre).append(" (").append(id).append(")\nPrestamos:");
        if (prestamos.isEmpty()) sb.append(" ninguno");
        else for (Prestamo p : prestamos) sb.append("\n - ").append(p);
        return sb.toString();
    }
}
