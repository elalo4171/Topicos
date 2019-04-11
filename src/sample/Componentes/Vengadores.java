package sample.Componentes;


import javafx.scene.control.ProgressBar;

public class Vengadores extends Thread {

    private ProgressBar pgbCarril;

    public Vengadores(String nombre, ProgressBar pgbCarril){
        super(nombre);
        this.pgbCarril = pgbCarril;
    }

    @Override
    public void run() {
        super.run();

        /*try {
            System.out.println("Sale el vengador "+getName());
            for (int i = 1; i <= 10; i++) {
                sleep((long) (Math.random() * 1000));
                System.out.println("Km "+i+": "+getName());
            }
            System.out.println("Llegó a la meta "+getName());
        }
        catch(InterruptedException ie){}*/

        try {
            double avance = 0;
            while (avance < 1) {

                avance += Math.random() / 10;
                pgbCarril.setProgress(avance);
                sleep((long) (Math.random() * 1000));
            }
        }
        catch (InterruptedException ie){}

    }
}