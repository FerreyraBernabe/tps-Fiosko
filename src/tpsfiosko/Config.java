
package tpsfiosko;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class Config {

    public static String LeerRutaVentas() {
        try {
            // El txt está en la carpeta raíz del proyecto
            Path path = Paths.get("rutaventas.txt");
            // Lee todas las líneas y toma la primera
            String ruta = Files.readAllLines(path).get(0).trim();
            return ruta;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String LeerRutaPagos() {
        try {
            // El txt está en la carpeta raíz del proyecto
            Path path = Paths.get("rutapagosdig.txt");
            // Lee todas las líneas y toma la primera
            String ruta = Files.readAllLines(path).get(0).trim();
            return ruta;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
