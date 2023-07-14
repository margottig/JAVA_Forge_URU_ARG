import java.util.ArrayList;
import java.util.Random;

public class Rompe{

/* Crear un arreglo con los siguientes valores: 3,5,1,2,7,9,8,13,25,32. Imprimir la suma de todos los números en el arreglo. El método también debe retornar un arreglo que incluya solo los números que son mayores a 10 (Por ejemplo cuando envía el arreglo anterior, debe retornar un arreglo con los valores de 13,25,32).*/ 
public ArrayList<Integer> sumaTodos(ArrayList<Integer> arreglo){

    int suma = 0;
    ArrayList<Integer> numerosMayores = new ArrayList<Integer>();

    //EQUIVALENTE A FOR DE ABAJO
    //  for(int iterador=0; i<arreglo.size(), iterador++){
    //     suma += arreglo[iterador];
    //     } 

        for(int elemento : arreglo){
        // System.out.println("QUE ES Elementoo " + elemento);
        suma += elemento;
        if(elemento > 10 ){
            numerosMayores.add(elemento);
    }
    }
    System.out.println("La suma total es: " + suma);

    return numerosMayores;

}


/* Crear un arreglo con los siguientes valores: 
Nancy, Jinichi, Fujibayashi, Momochi, Ishikawa. 
Mezcle el arreglo e imprima el nombre de cada persona. 
Haga que el método también devuelva un arreglo con los nombres que tienes más de 5 caracteres. */

public  ArrayList<String> mezclaNombres(ArrayList<String> arreglo){
    Random aleatorio = new Random();
    ArrayList<String> nombreMayorCincoCaracteres = new ArrayList<String>();

    for(String nombre : arreglo){
        String nombreAleatorio = arreglo.get(aleatorio.nextInt(arreglo.size()));
        System.out.println("Mi nombre es: " + nombreAleatorio);
        
        if(nombre.length() > 5 ){
            nombreMayorCincoCaracteres.add(nombre);
        }
        
    }
    return nombreMayorCincoCaracteres;


}


}