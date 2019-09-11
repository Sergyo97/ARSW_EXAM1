package edu.eci.arsw.primefinder;

import java.math.BigInteger;

import edu.eci.arsw.threads.MainThread;

public class PrimesFinderTool {

    private static final int NUMTHREADS = 4;

    public static void main(String[] args) {

        int maxPrim = 1000;

        PrimesResultSet prs = new PrimesResultSet("john");
        MainThread mt = new MainThread();
        mt.run();
        PrimeFinder.findPrimes(new BigInteger("1"), new BigInteger("10"), prs, NUMTHREADS);

        System.out.println("Prime numbers found:");

        // System.out.println(prs.getPrimes());

        System.out.println(prs.getPrimes());
    }

}
