package Intersection;

import java.util.Random;

public class Car extends Thread{
    private int id;
    public Intersection intersection = Intersection.getIntersection();
    private static Object CarClassLevelLock = new Object();

    public Car(){
        Random random = new Random();
        id = random.nextInt(10000);
    }

    public int getID() {
        return id;
    }

    @Override
    public void run() {
        System.out.println(id+" is approaching the intersection");
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(id+" is arrived to intersection");

        synchronized (CarClassLevelLock) {
            synchronized (intersection.lampMonitor) {
                while (!intersection.isLampGreen()) {
                    try {
                        intersection.lampMonitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(id + " is exited the intersection");
            }
        }

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(id+" left...");
        //super.run();
    }
}
