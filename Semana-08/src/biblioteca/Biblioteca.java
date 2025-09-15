package biblioteca;

import java.util.*;

public class Biblioteca {
    private final List<Libro> libros = new ArrayList<>();
    private final Map<String, Usuario> usuarios = new HashMap<>();

    // Gestión de Libros
    public void registrarLibro(Libro l) { libros.add(l); }
    public List<Libro> listarTodos() { return libros; }
    public List<Libro> listarDisponibles() {
        List<Libro> disp = new ArrayList<>();
        for (Libro l : libros) if (!l.isPrestado()) disp.add(l);
        return disp;
    }

    //  Gestión de Usuarios
    public void registrarUsuario(Usuario u) {
        usuarios.put(u.getId(), u);
    }

    public Usuario obtenerUsuario(String id, String nombreSiNuevo) {
        return usuarios.computeIfAbsent(id.toLowerCase(), k -> new Usuario(id, nombreSiNuevo));
    }

    public Collection<Usuario> getUsuarios() {
        return usuarios.values();
    }
}
