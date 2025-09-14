package dispositivos;

public class Multifuncional implements Imprimible, Escaneable, Copiable {
    @Override
    public void imprimir(String documento) {
        System.out.println("Multifuncional: Imprimiendo -> " + documento);
    }

    @Override
    public void escanear(String documento) {
        System.out.println("Multifuncional: Escaneando -> " + documento);
    }

    @Override
    public void copiar(String documento) {
        System.out.println("Multifuncional: Copiando -> " + documento);
    }
}
