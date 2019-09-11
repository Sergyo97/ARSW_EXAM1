package edu.eci.arsw.threads;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicBoolean;

import edu.eci.arsw.math.MathUtilities;
import edu.eci.arsw.primefinder.PrimesResultSet;

/**
 * PrimeFinderThread
 */
public class PrimeFinderThread extends Thread {

    private BigInteger a, b;
    private PrimesResultSet prs;
    public static AtomicBoolean wait = new AtomicBoolean(false);

    public PrimeFinderThread(BigInteger a, BigInteger b, PrimesResultSet prs) {
        super();
        this.a = a;
        this.b = b;
        this.prs = prs;
    }

    public void run() {

        BigInteger ai = a;
        BigInteger bi = b;
        BigInteger ii = ai;

        MathUtilities mu = new MathUtilities();

        int count = 0;
        while (ii.compareTo(bi) <= 0) {
            synchronized (wait) {
                while (wait.get()) {
                    try {
                        wait.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            count++;
            if (mu.isPrime(ii)) {
                prs.addPrime(BigInteger.ONE);
            }
        }
    }

}