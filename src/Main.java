
class Vehiculo{
    String marca;
    int año;

    Vehiculo(String marca, int año){
        this.marca = marca;
        this.año = año;
    }
    void mostrarInfo(){
        System.out.println("Vehiculo Marca: " + marca + ", Año: " + año);
    }
}

class Automovil extends Vehiculo{
    String modelo;
    int puertas;

    Automovil(String marca, int año, String modelo, int puertas){
        super(marca, año);
        this.modelo = modelo;
        this.puertas = puertas;

    }
    @Override
    void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Modelo: " + modelo + ", Puertas: " + puertas);
    }

}

public class Main {
    public static void main(String[] args){
        Automovil miAuto = new Automovil("Toyota", 2025, "Hilux", 4);
        Automovil miAuto2 = new Automovil("Mazda", 2025, "CX9", 4);

        System.out.println("********************************************************");
        miAuto.mostrarInfo();
        System.out.println("********************************************************");
        miAuto2.mostrarInfo();
        System.out.println("********************************************************");
    }
}