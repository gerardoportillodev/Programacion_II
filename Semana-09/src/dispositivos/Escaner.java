package dispositivos;

public class Escaner implements Escaneable {
    @Override
    public void escanear(String documento) {
        System.out.println("Escáner: Escaneando -> " + documento);
    }
}
