import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido. Espere 5 segundos los resultados son generados.\n");
        //Creamos las colecciones (por ejemplo, ArrayLists) donde almacenaremos los resultados
        //por separado de nuestros dados.
        List<Integer> resDado1 = new ArrayList<>();
        List<Integer> resDado2 = new ArrayList<>();
        List<Integer> resDado3 = new ArrayList<>();

        //Creamos nuestros hilos (objetos de la clase Runnable), usando tirarDado() que lo devuelve
        //a cada objeto se le pasa como parámetro su correspondiente colección.
        Runnable dado1 = tirarDado(resDado1);
        Runnable dado2 = tirarDado(resDado2);
        Runnable dado3 = tirarDado(resDado3);

        //Creamos el ScheduledExecutorService, que organizará la ejecución de nuestros hilos.
        ScheduledExecutorService ejecutor = Executors.  newScheduledThreadPool(3);

        //Programamos usando el SchedulerExecutorService a cada hilo de forma que pase un segundo,
        //y después de que pase ese segundo se almacene un resultado en la colección que corresponda.
        ejecutor.scheduleAtFixedRate(dado1, 1, 1, TimeUnit.SECONDS);
        ejecutor.scheduleAtFixedRate(dado2, 1, 1, TimeUnit.SECONDS);
        ejecutor.scheduleAtFixedRate(dado3, 1, 1, TimeUnit.SECONDS);

        //Volvemos a programar el SchedulerExecutorService, pero esta vez de forma que, después de
        //5 resultados (5 segundos) se impriman los mismos y se detenga la ejecución de los hilos.
        ejecutor.schedule(
                //Creamos una expresión lambda que nos devuelva un objeto Runnable con su run() especificado.
                () -> {
                    //Detenemos la ejecución de los hilos
                    ejecutor.shutdown();
                    //Este run() nos imprimirá las colecciones en las que hemos almacenado los resultados.
                    System.out.println("RESULTADOS:\n" +
                            "-Dado 1: " + resDado1 + "\n" +
                            "-Dado 2: " + resDado2 + "\n" +
                            "-Dado 3: " + resDado3);
                },
        5, TimeUnit.SECONDS);


    }

    public static Runnable tirarDado(Collection<Integer> resultados){
        //Con esta expresión lambda, definimos run(), devolviéndonos un objeto Runnable.
        return () -> {
            //Añadirá a la colección adjuntada como parámetro un número entero aleatorio entre 1 y 6.
            resultados.add((int) (Math.random() * 6) + 1);
        };
    }
}