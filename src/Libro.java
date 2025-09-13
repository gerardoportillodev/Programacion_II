public class Libro {
    String Autor;
    String Titulo;
    int paginasLeidas;

public Libro(String Autor, String Titulo){
    this.Autor= Autor;
    this.Titulo= Titulo;
    this.paginasLeidas= 10;
}

public String getAutor(){
    return Autor;
}

public String getTitulo(){
    return Titulo;
}

public int getPaginasLeidas(){
    return paginasLeidas;
}

public void leerPaginas(int numeroLeidas){
    paginasLeidas+=numeroLeidas;
}

public void mostrarProgreso(){
    System.out.println("Has leido esta cantidad de páginas "+" "+paginasLeidas+" "+"del libro: "+" "+Titulo+" "+"de"+" "+Autor);
}








}
