public class usuarioMain {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("E001", "Ana López", "ana@universidad.edu", "Ingeniería Informática", 4);
        Profesor profesor = new Profesor("P001", "Carlos Ruiz", "carlos@universidad.edu", "Informática", "Base de Datos");


           estudiante.mostrarInformacion();
           System.out.println();
           profesor.mostrarInformacion();
           System.out.println();

            estudiante.login();
            estudiante.logout();
            System.out.println();
            profesor.login();
            profesor.logout();

    }


}
