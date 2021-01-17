package Intersection;

public class Intersection extends Thread{
    private static Intersection TheIntersection = new Intersection();
    boolean lampIsGreen = false;
    public Object lampMonitor = new Object();

    private Intersection(){}

    public static Intersection getIntersection() {
        return TheIntersection;
    }

    public boolean isLampGreen() {
        return lampIsGreen;
    }

    private void switchLamp(){
        synchronized (lampMonitor) {
            lampIsGreen = !lampIsGreen;
            if (lampIsGreen)
                System.out.println("The lamp is GREEN");
            else
                System.out.println("The lamp is RED");
            this.lampMonitor.notifyAll();
        }
    }

    @Override
    public void run(){
        System.out.println("The lamp is initially RED");
        while(true) {
            try {
                sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.switchLamp();

        }

    }
}
