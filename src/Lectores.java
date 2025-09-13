class RegistrarLectores{
    private String nombre;
    private String id;
    private int librosPrestados;

    RegistrarLectores(String nombre, String id, int librosPrestados){
        this.librosPrestados=librosPrestados;
        this.id=id;
        this.nombre=nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public String getId(){
        return id;
    }

    public int getLibrosPrestados(){
        return librosPrestados;
    }

    public void setNombre(){
        this.nombre=nombre;
    }

    public void setId(){
        this.id=id;
    }

    public void prestarLibros(int prestar){
       if(prestar==0){
           System.out.println("No hay libros prestados");
       }else if(prestar<0){
           System.out.println(" ");
       }
       else{
           librosPrestados=librosPrestados+prestar;
           System.out.println("Cantidad de libros prestados: " + librosPrestados);
       }
    }

    public void devolverLibros(int devolver){
        if(devolver==0){
            System.out.println("No hay libros devueltos");
        }else if(librosPrestados<devolver){
            System.out.println(" ");
        }
        else{
            librosPrestados=librosPrestados-devolver;
            System.out.println("Cantidad de libros devueltos: " + librosPrestados);
        }

    }

    public void mostrarInfo(){
        System.out.println("--- Mostrando información ---");
        System.out.println("Nombre de usuario: " + nombre);
        System.out.println("ID: " + id);
        System.out.println("Cantidad actual de libros: " + librosPrestados);
        System.out.println("-----------------------------");
    }

}

class Lectores{
    public static void main(String[] args){
        RegistrarLectores lector= new RegistrarLectores("Dee","223D",0);
        lector.getNombre();
        lector.getId();
        lector.getLibrosPrestados();
        lector.prestarLibros(3);
        lector.devolverLibros(1);
        lector.mostrarInfo();


    }

}