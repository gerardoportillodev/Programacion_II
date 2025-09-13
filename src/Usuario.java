
public abstract class Usuario {
    protected String id;
    protected String nombre;
    protected String email;

    public Usuario(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public abstract void mostrarInformacion();
}

interface Autenticable {
    void login();
    void logout();
}

class Estudiante extends Usuario implements Autenticable {
    private String carrera;
    private int ciclo;

    public Estudiante(String id, String nombre, String email, String carrera, int ciclo) {
        super(id, nombre, email);
        this.carrera = carrera;
        this.ciclo = ciclo;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Estudiante:");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Email: " + email);
        System.out.println("Carrera: " + carrera);
        System.out.println("Ciclo: " + ciclo);
    }

    @Override
    public void login() {
        System.out.println("El estudiante " + nombre + " ha iniciado sesión.");
    }

    @Override
    public void logout() {
        System.out.println("El estudiante " + nombre + " ha cerrado sesión.");
    }
}

// Clase Profesor
class Profesor extends Usuario implements Autenticable {
    private String departamento;
    private String especialidad;

    public Profesor(String id, String nombre, String email, String departamento, String especialidad) {
        super(id, nombre, email);
        this.departamento = departamento;
        this.especialidad = especialidad;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Profesor:");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Email: " + email);
        System.out.println("Departamento: " + departamento);
        System.out.println("Especialidad: " + especialidad);
    }

    @Override
    public void login() {
        System.out.println("El profesor " + nombre + " ha iniciado sesión.");
    }

    @Override
    public void logout() {
        System.out.println("El profesor " + nombre + " ha cerrado sesión.");
    }
}

