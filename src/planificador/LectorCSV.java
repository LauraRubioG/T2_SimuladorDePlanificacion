package planificador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LectorCSV {

    public static List<Proceso> leer(String ruta){
        // Inicializamos una lista de procesos
        List<Proceso> procesos = new ArrayList<>();

        try {
            // Primero leemos linea a linea el contenido del fichero
            List<String> lineas = Files.readAllLines(Path.of(ruta));

            //con el for recorremos las lineas que hemos leido para quitar los espacios e ignorar lo siguiente
            for (String linea : lineas){
                //quitamos los espacio con strip()
                linea = linea.strip();

                //pasamos e ignoramos si empieza por # o está vacía
                if (!linea.isEmpty() && !linea.startsWith("#")) {

                    //la dividimos por ";"
                    String[] partes = linea.split(";");

                    //comprobamos que no falte ningun dato (nombre, llegada, rafaga)
                    if (partes.length < 3) {
                        System.out.println("Error: Faltan datos " + linea);
                        //para la ejecucion del programa
                        System.exit(1);
                    }

                    //convertimos los valores
                    String nombre = partes[0].strip();
                    int llegada = Integer.parseInt(partes[1].strip());
                    int rafaga = Integer.parseInt(partes[2].strip());

                    //tenemos que comprobar que la llegada sea menos o igual a 0 y la ráfaga menos a 0
                    if (llegada < 0 || rafaga <= 0) {
                        System.out.println("Los valores son Incorrectos (debe ser: llegada >=0 y rafaga >0)" + nombre);
                        System.exit(1);
                    }

                    //creamos el objeto de la clase proceso y lo guardamos en la lista
                    Proceso nuevoProceso = new Proceso(nombre, llegada, rafaga);
                    procesos.add(nuevoProceso);
                }
            }
        } catch (IOException e){
            System.out.println("Error a la hora de abrir el archivo" + ruta);
            //printStackTrace() sirva para que imprima el rasto de los pasos
            e.printStackTrace();
        }

        //devolvemos la lista que ya hemos rellenado
        return procesos;
    }

}
