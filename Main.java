import java.io.FileReader;
import java.util.Arrays;

//Clase para lectura
class Lector {
    char[] arreglo;
    int posicion;

    public Lector(String archivo) {
        String texto = "";
        posicion = 0;

        try {
            FileReader leer = new FileReader(archivo);
            int c;

            while ((c = leer.read()) != -1) {
                texto += (char) c;
            }

            leer.close();
            arreglo = texto.toCharArray();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            arreglo = new char[0];
        }
    }

    public char leerCaracter() {
        if (posicion < arreglo.length) {
            char c = arreglo[posicion];
            posicion++;
            return c;
        } else {
            return '\0'; //Fin del archivo
        }
    }

    public String[] obtenerTextoCompleto() {
        return new String[] { new String(arreglo) };
    }
}

//cslase para clasificacion
class Clasificador {

    public boolean esMinuscula(char c) {
        return (c >= 97 && c <= 122); // a hasta z
    }

    public boolean esMayuscula(char c) {
        return (c >= 65 && c <= 90); //A hasta Z
    }

    public boolean esNumero(char c) {
        return (c >= 48 && c <= 57); //0-9
    }

    public boolean esEspacio(char c) {
        return (c == 32 || c == '\n' || c == '\t'); //Espacio, salto de linea, tab
    }

    public boolean esPunto(char c) {
        return (c == '.');
    }

    //ER: ( [a-z] ) . ( [a-z] | [A-Z] | [0-9] )*
    public boolean esIdentificador(String palabra) {
        if (palabra.length() == 0) return false;

        //primer caracter minuscula
        if (!esMinuscula(palabra.charAt(0))) {
            return false;
        }

        //el resto no importa
        for (int i = 1; i < palabra.length(); i++) {
            char c = palabra.charAt(i);
            if (!esMinuscula(c) && !esMayuscula(c) && !esNumero(c)) {
                return false;
            }
        }
        return true;
    }

    //ER:( [0-9]+ ) . (\.[0-9]+ )?
    public boolean esDigito(String palabra) {
        if (palabra.length() == 0) return false;

        boolean tienePunto = false;

        //primer char es numero
        if (!esNumero(palabra.charAt(0))) {
            return false;
        }

        for (int i = 1; i < palabra.length(); i++) {
            char c = palabra.charAt(i);

            if (esPunto(c)) {
                //Si ya había un punto o el punto está al final, es inválido
                if (tienePunto || i == palabra.length() - 1) {
                    return false;
                }
                tienePunto = true;
            } else if (!esNumero(c)) {
                return false;
            }
        }
        return true;
    }

    //ER:([A-Z] . [a-z]+ )
    public boolean esPalabraReservada(String palabra) {
        //Al menos 2 caracteres, una mayuscula y una o mas minusculas
        if (palabra.length() < 2) return false;

       if (!esMayuscula(palabra.charAt(0))) {
            return false;
        }

        for (int i = 1; i < palabra.length(); i++) {
            if (!esMinuscula(palabra.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // Clasifica una palabra
    public String clasificar(String palabra) {
        if (esPalabraReservada(palabra)) {
            return "Palabra reservada";
        } else if (esDigito(palabra)) {
            return "Digito / Número";
        } else if (esIdentificador(palabra)) {
            return "Identificador";
        } else {
            return "No entra en ninguna";
        }
    }
}


//Clase MAIN
public class Main {
    public static void main(String[] args) {
        Lector archivo = new Lector("expresion.txt");
        Clasificador clasificador = new Clasificador();

        char c1 = archivo.leerCaracter();
        char c2 = archivo.leerCaracter();

        System.out.println("Primer caracter: " + c1);
        System.out.println("Segundo caracter: " + c2);

        System.out.println("Texto completo:" + Arrays.toString(archivo.obtenerTextoCompleto()));

        //Clasificacion ejemplo
        String palabra = "Variable1";
        System.out.println("Clasificación de '" + palabra + "': " + clasificador.clasificar(palabra));

    }
}
