package edu.eci.arsw.threads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.eci.arsw.mouseutils.MouseMovementMonitor;
import edu.eci.arsw.primefinder.PrimesFinderTool;

public class MainThread extends Thread {
    
    public static AtomicBoolean wait = new AtomicBoolean(false);

    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
                synchronized (wait) {
                    if (MouseMovementMonitor.getInstance().getTimeSinceLastMouseMovement() > 10000) {
                        wait.set(true);
                        System.out.println("Idle CPU");

                    } else {
                        wait.set(false);
                        wait.notifyAll();
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(PrimesFinderTool.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}