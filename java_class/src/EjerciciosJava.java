public class EjerciciosJava {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIOS JAVA ===\n");

        //-------------------------------------------------------

        // 1. Verificar si un número es positivo o negativo
        System.out.println("1. Verificar si un número es positivo o negativo:");
        int numero = -5; // Cambia este valor para probar
        if (numero > 0) {
            System.out.println("El número " + numero + " es positivo");
        } else if (numero < 0) {
            System.out.println("El número " + numero + " es negativo");
        } else {
            System.out.println("El número es cero");
        }
        System.out.println();

        //-------------------------------------------------------

        // 2. Determinar si un número es par o impar
        System.out.println("2. Determinar si un número es par o impar:");
        int num = 7; // Cambia este valor para probar
        if (num % 2 == 0) {
            System.out.println("El número " + num + " es par");
        } else {
            System.out.println("El número " + num + " es impar");
        }
        System.out.println();

        //-------------------------------------------------------

        // 3. Mostrar los primeros 10 números naturales (usando for)
        System.out.println("3. Primeros 10 números naturales:");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        //-------------------------------------------------------

        // 4. Sumar los números del 1 al 10 (usando while)
        System.out.println("4. Suma de números del 1 al 10:");
        int suma = 0;
        int contador = 1;
        while (contador <= 10) {
            suma += contador;
            contador++;
        }
        System.out.println("La suma es: " + suma);
        System.out.println();

        //-------------------------------------------------------

        // 5. Tabla del 5 (usando for)
        System.out.println("5. Tabla del 5:");
        for (int i = 1; i <= 10; i++) {
            System.out.println("5 x " + i + " = " + (5 * i));
        }
        System.out.println();

        //-------------------------------------------------------

        // 6. Números en reversa del 20 al 1 (usando for)
        System.out.println("6. Números en reversa del 20 al 1:");
        for (int i = 20; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        //-------------------------------------------------------

        // 7. Números impares entre 1 y 50 (usando for con if)
        System.out.println("7. Números impares entre 1 y 50:");
        for (int i = 1; i <= 50; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\n");

        //-------------------------------------------------------

        // 8. Verificar si el 13 es un número primo (usando if-else)
        System.out.println("8. Verificar si el 13 es un número primo:");
        int numeroAPrueba = 13;
        boolean esPrimo = true;

        if (numeroAPrueba <= 1) {
            esPrimo = false;
        } else if (numeroAPrueba == 2) {
            esPrimo = true;
        } else if (numeroAPrueba % 2 == 0) {
            esPrimo = false;
        } else {
            for (int i = 3; i * i <= numeroAPrueba; i += 2) {
                if (numeroAPrueba % i == 0) {
                    esPrimo = false;
                    break;
                }
            }
        }

        if (esPrimo) {
            System.out.println("El número " + numeroAPrueba + " es primo");
        } else {
            System.out.println("El número " + numeroAPrueba + " no es primo");
        }
        System.out.println();

        //-------------------------------------------------------

        // 9. Múltiplos de 3 hasta 30 (usando do-while)
        System.out.println("9. Múltiplos de 3 hasta 30:");
        int multiplo = 3;
        do {
            System.out.print(multiplo + " ");
            multiplo += 3;
        } while (multiplo <= 30);
        System.out.println("\n");

        //-------------------------------------------------------

        // 10. Hola mundo
        System.out.println("10. Hola mundo!!!!");
    }
}

