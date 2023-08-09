import java.util.ArrayList;
import java.util.Random;

public class TestRompe{

    public static void main(String[] hola){

        ArrayList<Integer> numeros = new ArrayList<Integer>();
        numeros.add(5);
        numeros.add(4);
        numeros.add(10);
        numeros.add(2);
        numeros.add(15);

        ArrayList<String> nombres = new ArrayList<String>();
        nombres.add("Nancy");
        nombres.add("Jinichi");
        nombres.add("Vampire");
        nombres.add("Fujibayashi");
        nombres.add("Sonic");
        nombres.add("Momochi");

        Rompe ejercicioUno = new Rompe();

        System.out.println("Arreglo de numeros mayores a 10: " + ejercicioUno.sumaTodos(numeros));
        System.out.println( "Arreglo de nombres con total de caracteres mayor a 5: " + ejercicioUno.mezclaNombres(nombres));
        

    }
}



// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Random;
// public class CodeExample {
//     public static void main() {
        
        
//         Collections.shuffle(numeros);
//         System.out.println(numeros); // [5, 4, 3, 2, 1]
//         Collections.sort(numeros);
//         System.out.println(numeros); // [1, 2, 3, 4, 5]
                
//         Random r = new Random();
//         System.out.println(r.nextInt()); // Sin límites
//         System.out.println(r.nextInt(5)); // Con límites entre 0 y 5
//     }
// }
