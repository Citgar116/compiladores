// Tener un archivo txt donde contenga un texto, tener un metodo donde sea posible leer caracter por caracter en orden de la palbra
// Si es Hola, llamamos el metodo y nos devuelve H, pero cuando volvamos a llamar el metodo, mandamos o, no es 
// posible que pueda regresar la H nuevamente
// Tambien tendremos un metodo donde mande a llamar a toda la palabra completa, 
// Es mejor usar un arreglo porque lo puede mandar todo de una sola vez
// Y debe ser en clases

import java.io.FileReader;

public class leerexpresion {

    char[] arreglo;
    int posicion;

    public leerexpresion(String archivo){
        String texto = "";
        posicion = 0;

        try {
            
            FileReader leer = new FileReader(archivo);
            int c;

            while((c = leer.read()) != -1){
                texto += (char)c;
            }

            leer.close();

            arreglo = texto.toCharArray();
            
        }
        catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public char leerCaracter(){
        
        if(posicion < arreglo.length){
            char c = arreglo[posicion];
            posicion++;
            return c;
        }
        else{
            return '\0'; 
        }

    }

    public String[] obtenerTextoCompleto(){
        return new String[]{new String(arreglo)};   
    }

    public class Main{
        
        public static void main(String[] args) {
            leerexpresion archivo = new leerexpresion("expresion.txt");

           System.out.println(archivo.leerCaracter());
           System.out.println(archivo.leerCaracter());
           System.out.println(java.util.Arrays.toString(archivo.obtenerTextoCompleto()));
           
    }
 }
}





// Para el ejercicio 5, tenemos que registrar 3 expresiones segun la reglas del archivo docs, 
// lo que se debe hacer es leer caracter por caracter y clasificarlas segun la categoria de las 
// reglas del documento de word, por ejemplo Hola mundo, va pasando caracter por caracter, es un numero, no.
// Se pasa al siguiente caracter, basicamente debe pasar por todas las reglas para ver si se pasan y se llegue a 
// clasificar segun donde corresponda

//Se entrega el jueves viejos chichones buscar google