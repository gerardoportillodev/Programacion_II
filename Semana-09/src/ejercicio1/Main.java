package ejercicio1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();

        listaVehiculos.add(new Coche("Toyota", "Agya", 2023));
        listaVehiculos.add(new Moto("Yamaha", "R6", 2021));
        listaVehiculos.add(new Camion("Mitsubishi", "L200 Triton Sportero", 2025));

        for (Vehiculo v : listaVehiculos) {
            System.out.println(v.obtenerTipo() + " - " + v.obtenerInfo());
            v.acelerar();
            v.frenar();
            System.out.println();
        }
    }
}
