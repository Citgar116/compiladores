// Tener un archivo txt donde contenga un texto, tener un metodo donde sea posible leer caracter por caracter en orden de la palbra
// Si es Hola, llamamos el metodo y nos devuelve H, pero cuando volvamos a llamar el metodo, mandamos o, no es 
// posible que pueda regresar la H nuevamente
// Tambien tendremos un metodo donde mande a llamar a toda la palabra completa, 
// Es mejor usar un arreglo porque lo puede mandar todo de una sola vez
// Y debe ser en clases

class leerTexto{

    private String texto;
    private char[] arreglo;
    private int indice;

    public leerTexto(String texto) {
        this.texto = texto;
        this.arreglo = texto.toCharArray();
        this.indice = 0;
    }

    public char leerCaracter() {
        if (indice < arreglo.length) {
            return arreglo[indice++];
        }
        return '\0'; 
        
    }

    public String leerPalabraCompleta() {
        return texto;
    } 

}


// Para el ejercicio 5, tenemos que registrar 3 expresiones segun la reglas del archivo docs, 
// lo que se debe hacer es leer caracter por caracter y clasificarlas segun la categoria de las 
// reglas del documento de word, por ejemplo Hola mundo, va pasando caracter por caracter, es un numero, no.
// Se pasa al siguiente caracter, basicamente debe pasar por todas las reglas para ver si se pasan y se llegue a 
// clasificar segun donde corresponda

//Se entrega el jueves viejos chichones buscar google