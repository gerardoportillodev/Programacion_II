package ejercicio3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Forma> formas = new ArrayList<>();

        formas.add(new Circulo(5));
        formas.add(new Rectangulo(4, 6));
        formas.add(new Triangulo(4, 3, 3, 4, 5));

        double totalAreas = 0;
        double totalPerimetros = 0;

        for (Forma f : formas) {
            System.out.println("Forma: " + f.obtenerInfo());
            System.out.println("Área: " + f.calcularArea());
            System.out.println("Perímetro: " + f.calcularPerimetro());
            System.out.println();

            totalAreas += f.calcularArea();
            totalPerimetros += f.calcularPerimetro();
        }

        System.out.println("Total Áreas = " + totalAreas);
        System.out.println("Total Perímetros = " + totalPerimetros);
    }
}

