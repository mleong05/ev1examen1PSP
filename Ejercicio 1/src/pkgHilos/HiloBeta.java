package pkgHilos;

public class HiloBeta extends Thread{
    //Propiedades
    private final String nombre;

    //Métodos
    public HiloBeta(String nombre){
        //Se le asigna un nombre personalizado como propiedad usando el constructor
        this.nombre = nombre;
    }

    @Override
    public void run(){
        //Imprimimos el nombre personalizado del hilo 5 veces
        for (int i = 1; i <= 5; i++){
            System.out.println(nombre);
        }
    }
}
