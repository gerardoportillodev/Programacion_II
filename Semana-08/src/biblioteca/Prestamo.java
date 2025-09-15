package biblioteca;

import java.time.LocalDate;

public class Prestamo {
    private final Libro libro;
    private final LocalDate fechaPrestamo;
    private final int diasPrestamo;

    public Prestamo(Libro libro, int diasPrestamo) {
        this.libro = libro;
        this.fechaPrestamo = LocalDate.now();
        this.diasPrestamo = Math.min(diasPrestamo, 15); // máximo 15 días
        libro.marcarPrestado();
    }

    public Libro getLibro() { return libro; }
    public LocalDate getFechaPrestamo() { return fechaPrestamo; }
    public int getDiasPrestamo() { return diasPrestamo; }

    public LocalDate getFechaDevolucion() {
        return fechaPrestamo.plusDays(diasPrestamo);
    }

    public void devolver() {
        libro.marcarDisponible();
    }

    @Override
    public String toString() {
        return libro.getTitulo() +
                " (prestado el " + fechaPrestamo +
                ", devolver antes de " + getFechaDevolucion() + ")";
    }
}
