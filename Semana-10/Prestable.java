/**
 * Define el contrato para recursos que pueden ser prestados.
 */
public interface Prestable {
    void prestar();
    void devolver();
    boolean estaPrestado();
}
