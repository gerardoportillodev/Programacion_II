package dispositivos;

public class Impresora implements Imprimible {
    @Override
    public void imprimir(String documento) {
        System.out.println("Impresora: Imprimiendo -> " + documento);
    }
}
