public class mainLibro {
    public static void main(String[] args){

        Libro miLibro= new Libro("Arthur Conan Doyle","El perro de los Baskerville");
        System.out.println("Estás leyendo: "+" "+miLibro.getTitulo()+" "+"de: "+" "+miLibro.getAutor());

        System.out.println("--- Cantidad de páginas leidas---");

        miLibro.leerPaginas(30);
        System.out.println("Has aumentado: "+" "+ miLibro.getPaginasLeidas()+" "+"paginas");

        miLibro.mostrarProgreso();

    }

}
