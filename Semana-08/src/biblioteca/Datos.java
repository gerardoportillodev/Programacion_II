import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Libro {
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private String genero;
    private boolean disponible;

    public Libro(String titulo, String autor, int anioPublicacion, String genero, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.genero = genero;
        this.disponible = disponible;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnioPublicacion() { return anioPublicacion; }
    public String getGenero() { return genero; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    @Override
    public String toString() {
        return "Título: " + titulo + 
               ", Autor: " + autor + 
               ", Año: " + anioPublicacion + 
               ", Género: " + genero + 
               ", Disponible: " + (disponible ? "Sí" : "No");
    }
}

class Usuario {
    private String nombre;
    private String identificacion;
    private List<Libro> librosPrestados;

    public Usuario(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.librosPrestados = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public String getIdentificacion() { return identificacion; }
    public List<Libro> getLibrosPrestados() { return librosPrestados; }

    public void agregarLibroPrestado(Libro libro) {
        librosPrestados.add(libro);
    }

    public void removerLibroPrestado(Libro libro) {
        librosPrestados.remove(libro);
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + 
               ", ID: " + identificacion + 
               ", Libros prestados: " + librosPrestados.size();
    }
}

class Biblioteca {
    private List<Libro> libros;
    private List<Usuario> usuarios;
    private static final String ARCHIVO_LIBROS = "libros.txt";
    private static final String ARCHIVO_USUARIOS = "usuarios.txt";

    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        cargarDatos();
    }

    // Métodos de persistencia (TU PARTE)
    public void guardarDatos() {
        guardarLibros();
        guardarUsuarios();
        System.out.println("Datos guardados exitosamente.");
    }

    private void guardarLibros() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_LIBROS))) {
            for (Libro libro : libros) {
                writer.write(libroToString(libro));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar libros: " + e.getMessage());
        }
    }

    private void guardarUsuarios() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_USUARIOS))) {
            for (Usuario usuario : usuarios) {
                writer.write(usuarioToString(usuario));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar usuarios: " + e.getMessage());
        }
    }

    public void cargarDatos() {
        cargarLibros();
        cargarUsuarios();
        System.out.println("Datos cargados exitosamente.");
    }

    private void cargarLibros() {
        libros.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_LIBROS))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Libro libro = stringToLibro(linea);
                if (libro != null) {
                    libros.add(libro);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de libros no encontrado. Se creará uno nuevo.");
        } catch (IOException e) {
            System.out.println("Error al cargar libros: " + e.getMessage());
        }
    }

    private void cargarUsuarios() {
        usuarios.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_USUARIOS))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Usuario usuario = stringToUsuario(linea);
                if (usuario != null) {
                    usuarios.add(usuario);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de usuarios no encontrado. Se creará uno nuevo.");
        } catch (IOException e) {
            System.out.println("Error al cargar usuarios: " + e.getMessage());
        }
    }

    private String libroToString(Libro libro) {
        return libro.getTitulo() + "|" + 
               libro.getAutor() + "|" + 
               libro.getAnioPublicacion() + "|" + 
               libro.getGenero() + "|" + 
               libro.isDisponible();
    }

    private Libro stringToLibro(String linea) {
        try {
            String[] partes = linea.split("\\|");
            if (partes.length == 5) {
                String titulo = partes[0];
                String autor = partes[1];
                int anio = Integer.parseInt(partes[2]);
                String genero = partes[3];
                boolean disponible = Boolean.parseBoolean(partes[4]);
                
                return new Libro(titulo, autor, anio, genero, disponible);
            }
        } catch (Exception e) {
            System.out.println("Error al convertir línea a libro: " + linea);
        }
        return null;
    }

    private String usuarioToString(Usuario usuario) {
        StringBuilder sb = new StringBuilder();
        sb.append(usuario.getNombre()).append("|")
          .append(usuario.getIdentificacion()).append("|");
        
        for (Libro libro : usuario.getLibrosPrestados()) {
            sb.append(libro.getTitulo()).append(",");
        }
        if (!usuario.getLibrosPrestados().isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        
        return sb.toString();
    }

    private Usuario stringToUsuario(String linea) {
        try {
            String[] partes = linea.split("\\|");
            if (partes.length >= 2) {
                String nombre = partes[0];
                String identificacion = partes[1];
                
                Usuario usuario = new Usuario(nombre, identificacion);
                
                if (partes.length == 3 && !partes[2].isEmpty()) {
                    String[] librosPrestados = partes[2].split(",");
                    for (String tituloLibro : librosPrestados) {
                        Libro libro = buscarLibroPorTitulo(tituloLibro.trim());
                        if (libro != null) {
                            usuario.agregarLibroPrestado(libro);
                            libro.setDisponible(false);
                        }
                    }
                }
                
                return usuario;
            }
        } catch (Exception e) {
            System.out.println("Error al convertir línea a usuario: " + linea);
        }
        return null;
    }

    private Libro buscarLibroPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        guardarLibros();
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        guardarUsuarios();
    }

    public void realizarPrestamo(String idUsuario, String tituloLibro) {
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        Libro libro = buscarLibroPorTitulo(tituloLibro);
        
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }
        if (libro == null) {
            System.out.println("Libro no encontrado.");
            return;
        }
        if (!libro.isDisponible()) {
            System.out.println("El libro no está disponible.");
            return;
        }
        
        usuario.agregarLibroPrestado(libro);
        libro.setDisponible(false);
        guardarDatos();
        System.out.println("Préstamo realizado exitosamente.");
    }

    public void realizarDevolucion(String idUsuario, String tituloLibro) {
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        Libro libro = buscarLibroPorTitulo(tituloLibro);
        
        if (usuario == null || libro == null) {
            System.out.println("Usuario o libro no encontrado.");
            return;
        }
        
        if (usuario.getLibrosPrestados().contains(libro)) {
            usuario.removerLibroPrestado(libro);
            libro.setDisponible(true);
            guardarDatos();
            System.out.println("Devolución realizada exitosamente.");
        } else {
            System.out.println("Este usuario no tiene prestado ese libro.");
        }
    }

    public void listarLibros() {
        System.out.println("\n=== LISTA DE LIBROS ===");
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    public void listarLibrosPorGenero(String genero) {
        System.out.println("\n=== LIBROS DEL GÉNERO: " + genero + " ===");
        for (Libro libro : libros) {
            if (libro.getGenero().equalsIgnoreCase(genero)) {
                System.out.println(libro);
            }
        }
    }

    public void listarLibrosPorAutor(String autor) {
        System.out.println("\n=== LIBROS DEL AUTOR: " + autor + " ===");
        for (Libro libro : libros) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                System.out.println(libro);
            }
        }
    }

    public void listarLibrosDisponibles() {
        System.out.println("\n=== LIBROS DISPONIBLES ===");
        for (Libro libro : libros) {
            if (libro.isDisponible()) {
                System.out.println(libro);
            }
        }
    }

    public void listarUsuarios() {
        System.out.println("\n=== LISTA DE USUARIOS ===");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    private Usuario buscarUsuarioPorId(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdentificacion().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    public List<Libro> getLibros() { return libros; }
    public List<Usuario> getUsuarios() { return usuarios; }
}

public class SistemaBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== SISTEMA DE GESTIÓN DE BIBLIOTECA ===");
            System.out.println("1. Registrar libro");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Realizar préstamo");
            System.out.println("4. Realizar devolución");
            System.out.println("5. Listar libros");
            System.out.println("6. Listar libros por género");
            System.out.println("7. Listar libros por autor");
            System.out.println("8. Listar libros disponibles");
            System.out.println("9. Listar usuarios");
            System.out.println("10. Guardar datos manualmente");
            System.out.println("11. Cargar datos manualmente");
            System.out.println("12. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    registrarLibro(biblioteca, scanner);
                    break;
                case 2:
                    registrarUsuario(biblioteca, scanner);
                    break;
                case 3:
                    realizarPrestamo(biblioteca, scanner);
                    break;
                case 4:
                    realizarDevolucion(biblioteca, scanner);
                    break;
                case 5:
                    biblioteca.listarLibros();
                    break;
                case 6:
                    System.out.print("Ingrese el género: ");
                    String genero = scanner.nextLine();
                    biblioteca.listarLibrosPorGenero(genero);
                    break;
                case 7:
                    System.out.print("Ingrese el autor: ");
                    String autor = scanner.nextLine();
                    biblioteca.listarLibrosPorAutor(autor);
                    break;
                case 8:
                    biblioteca.listarLibrosDisponibles();
                    break;
                case 9:
                    biblioteca.listarUsuarios();
                    break;
                case 10:
                    biblioteca.guardarDatos();
                    break;
                case 11:
                    biblioteca.cargarDatos();
                    break;
                case 12:
                    biblioteca.guardarDatos();
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 12);

        scanner.close();
    }

    private static void registrarLibro(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Año de publicación: ");
        int anio = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Género: ");
        String genero = scanner.nextLine();
        
        Libro libro = new Libro(titulo, autor, anio, genero, true);
        biblioteca.agregarLibro(libro);
        System.out.println("Libro registrado exitosamente.");
    }

    private static void registrarUsuario(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Número de identificación: ");
        String id = scanner.nextLine();
        
        Usuario usuario = new Usuario(nombre, id);
        biblioteca.agregarUsuario(usuario);
        System.out.println("Usuario registrado exitosamente.");
    }

    private static void realizarPrestamo(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("ID del usuario: ");
        String idUsuario = scanner.nextLine();
        System.out.print("Título del libro: ");
        String tituloLibro = scanner.nextLine();
        
        biblioteca.realizarPrestamo(idUsuario, tituloLibro);
    }

    private static void realizarDevolucion(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("ID del usuario: ");
        String idUsuario = scanner.nextLine();
        System.out.print("Título del libro: ");
        String tituloLibro = scanner.nextLine();
        
        biblioteca.realizarDevolucion(idUsuario, tituloLibro);
    }
}