import java.util.ArrayList;

public class Arreglos{

    public static void main(String[] args){

        // --------------------------------- ARREGLOS ESTATICOS

        int[] myArray; //Declaración
        myArray = new int[5]; // Inicialización
        myArray[0] = 4; // agregar valor
        myArray[1] = 8; // agregar valor
        myArray[2] = 8; // agregar valor
        myArray[3] = 5; // agregar valor
        myArray[4] = 9; // agregar valor
        // myArray[5] = 123;
        
        String[] frutas = {"manzana", "mango", "sandia"};

    // arreglo de objetos - version larga
        Object[] arregloObjetos;
        arregloObjetos = new Object[5];
        arregloObjetos[0] =  frutas;

    // arreglo de objetos version corta
        Object[] arregloObjetosDos = {frutas, myArray};
  

    // conversion explicita
        String[] unaFruta = (String[]) arregloObjetos[0];

        System.out.println( myArray[0] + " My primer arreglo");
        System.out.println( frutas[0] + " arreglo frutas");
        System.out.println( arregloObjetos[0] + " Arreglo Objetos indice 0");
        System.out.println( unaFruta + " unafruta");
        System.out.println(unaFruta[0] + " hola hola");


    //  -    ---------------- ARREGLOS DINAMICOS
        ArrayList<Integer> nuevoArreglo = new ArrayList<Integer>();
        nuevoArreglo.add(5); 
        nuevoArreglo.add(15);  
        // ArrayList<int> arregloPeque = new ArrayList<int>(); !! ESTO NO SE PUEDE HACER

        System.out.println(nuevoArreglo.get(0) + " Valor del indice 0 del arreglo dinamico");
    }
}