package biblioteca;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class Biblioteca {
    private final List<Libro> libros = new ArrayList<>();
    private final Map<String, Usuario> usuarios = new HashMap<>();

    // --- Registro ---
    public void registrarLibro(Libro l) { libros.add(l); }
    public void registrarUsuario(Usuario u) { usuarios.put(u.getId(), u); }

    // --- Búsqueda auxiliar ---
    public Optional<Libro> buscarLibroPorTitulo(String titulo) {
        return libros.stream().filter(l -> l.getTitulo().equalsIgnoreCase(titulo)).findFirst();
    }
    public Optional<Usuario> buscarUsuarioPorId(String id) {
        return Optional.ofNullable(usuarios.get(id));
    }

    // --- Préstamo / devolución ---
    public boolean prestar(String idUsuario, String tituloLibro) {
        var u = buscarUsuarioPorId(idUsuario);
        var l = buscarLibroPorTitulo(tituloLibro);
        if (u.isEmpty() || l.isEmpty()) return false;
        return u.get().tomarPrestado(l.get());
    }
    public boolean devolver(String idUsuario, String tituloLibro) {
        var u = buscarUsuarioPorId(idUsuario);
        var l = buscarLibroPorTitulo(tituloLibro);
        if (u.isEmpty() || l.isEmpty()) return false;
        return u.get().devolver(l.get());
    }

    // --- Listados ---
    public List<Libro> listarPorGenero(String genero) {
        return libros.stream()
                .filter(l -> l.getGenero().equalsIgnoreCase(genero))
                .collect(Collectors.toList());
    }
    public List<Libro> listarPorAutor(String autor) {
        return libros.stream()
                .filter(l -> l.getAutor().equalsIgnoreCase(autor))
                .collect(Collectors.toList());
    }
    public List<Libro> listarPorDisponibilidad(boolean disponible) {
        return libros.stream()
                .filter(l -> l.isPrestado() != disponible) // disponible = !prestado
                .collect(Collectors.toList());
    }

    // --- Persistencia simple (CSV con ;) ---
    public void guardarLibros(Path p) throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(p)) {
            for (Libro l : libros) {
                bw.write(String.join(";",
                        l.getTitulo(), l.getAutor(),
                        String.valueOf(l.getAnio()),
                        l.getGenero(),
                        String.valueOf(l.isPrestado())));
                bw.newLine();
            }
        }
    }
    public void cargarLibros(Path p) throws IOException {
        libros.clear();
        if (!Files.exists(p)) return;
        try (BufferedReader br = Files.newBufferedReader(p)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] x = line.split(";");
                if (x.length < 5) continue;
                Libro l = new Libro(x[0], x[1], Integer.parseInt(x[2]), x[3]);
                if (Boolean.parseBoolean(x[4])) l.prestar();
                libros.add(l);
            }
        }
    }

    public void guardarUsuarios(Path p) throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(p)) {
            for (Usuario u : usuarios.values()) {
                String titulos = u.getLibrosPrestados().stream()
                        .map(Libro::getTitulo).collect(Collectors.joining("|"));
                bw.write(u.getId() + ";" + u.getNombre() + ";" + titulos);
                bw.newLine();
            }
        }
    }
    public void cargarUsuarios(Path p) throws IOException {
        usuarios.clear();
        if (!Files.exists(p)) return;
        try (BufferedReader br = Files.newBufferedReader(p)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] x = line.split(";");
                if (x.length < 2) continue;
                Usuario u = new Usuario(x[1], x[0]); // nombre, id
                // reconstruir préstamos (opcional: si quieres “re-unir” con libros ya cargados)
                if (x.length >= 3 && !x[2].isBlank()) {
                    for (String titulo : x[2].split("\\|")) {
                        buscarLibroPorTitulo(titulo).ifPresent(l -> u.tomarPrestado(l));
                    }
                }
                usuarios.put(u.getId(), u);
            }
        }
    }

    // utilidades para mostrar
    public void imprimir(List<Libro> lista) { lista.forEach(l -> System.out.println(" - " + l)); }
    public void imprimirCatalogo() { imprimir(libros); }
}
