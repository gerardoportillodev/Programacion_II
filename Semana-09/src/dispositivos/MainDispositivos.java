package dispositivos;

public class MainDispositivos {
    public static void main(String[] args) {
        // Dispositivos individuales
        Imprimible impresora = new Impresora();
        impresora.imprimir("Contrato laboral");

        Escaneable escaner = new Escaner();
        escaner.escanear("Documento identidad");

        // Dispositivo multifuncional
        Multifuncional multi = new Multifuncional();
        multi.imprimir("Informe mensual");
        multi.escanear("Recibo de servicios");
        multi.copiar("Manual de usuario");

        // Polimorfismo con interfaces
        Imprimible i = multi;
        Escaneable e = multi;
        Copiable c = multi;

        i.imprimir("Carta de recomendación");
        e.escanear("Pasaporte");
        c.copiar("Factura electrónica");
    }
}
