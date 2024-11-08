import pkgHilos.*;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        //En primer lugar, creamos una colección (en este caso ArrayList) en la que guardaremos
        //nuestros hilos para crearlos y ejecutarlos de forma ordenada como hilos
        List<Thread> hilos = new ArrayList<>();
        //Añadimos hilos de nuestras tres clases creadas en el paquete pkgHilos
        hilos.add(new HiloAlfa("Hilo\tAlfa"));
        hilos.add(new HiloBeta("Hilo\tBeta"));
        hilos.add(new HiloOmega("Hilo\tOmega"));

        //Una vez estén nuestros hilos en la colección, los lanzamos usando un bucle
        for(Thread hilo: hilos){
            hilo.start();
        }
    }
}