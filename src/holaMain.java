import java.util.Arrays;
import java.util.List;

public class holaMain {
    public static void main(String[] args){

        //array
        int[] numeros= {5,10,33,100,81};
        String[] nombres={"Carlos","Josue","Pedro","Mauricio","Eddie"};
        //lengh: saber la longitud del array
        System.out.println("La longitud del array es de: "+ numeros.length);
        System.out.println("La longitud del array es de: "+ nombres.length);

        //sort: para ordenar

        Arrays.sort(numeros);
        System.out.println("Array ordenado: "+Arrays.toString(numeros));

        //binarysearch: buscar posición

        int posicion= Arrays.binarySearch(numeros,100);
        System.out.println("La posicion del 100 es: "+posicion);

        //equals
        int[] otrosNumeros = {200, 201, 300, 500, 1004};
        boolean sonIguales= Arrays.equals(numeros,otrosNumeros);
        System.out.println("¿Son iguales? " + sonIguales);
        if(sonIguales== true){
            System.out.println("los arrays son iguales");
        }else{
            System.out.println("Los arrays son distintos");
        }

        //array fill: rellenar

        Arrays.fill(numeros,100);
        System.out.println("Rellenando el array con números 100: "+Arrays.toString(numeros));

        //copy

        int[] copArray= Arrays.copyOf(otrosNumeros,otrosNumeros.length);
        System.out.println("Copia de array: "+Arrays.toString(copArray));

        //toString
        System.out.println("Array como String: "+Arrays.toString(nombres));

        //list

        System.out.println("Como lista: "+Arrays.asList(nombres));

        //stream

        System.out.println("Suma: "+Arrays.stream(otrosNumeros).sum());

        //multi

        int[][] Seelie= {{1,2},{4,5}};
        System.out.println("Seelie :3 "+Arrays.deepToString(Seelie));


    }
}
