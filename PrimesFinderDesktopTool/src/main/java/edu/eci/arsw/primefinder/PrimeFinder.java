package edu.eci.arsw.primefinder;

import java.math.BigInteger;

import edu.eci.arsw.threads.PrimeFinderThread;

public class PrimeFinder {

    public static void findPrimes(BigInteger _a, BigInteger _b, PrimesResultSet prs, int numthreads)
            throws InterruptedException {

        PrimeFinderThread[] threadList = new PrimeFinderThread[numthreads];

        for (int i = 0; i < numthreads; i++) {
            threadList[i] = new PrimeFinderThread(
                    _a.add((_b.divide(BigInteger.valueOf(numthreads))).multiply(BigInteger.valueOf(i))),
                    _a.add((_b.divide(BigInteger.valueOf(numthreads))).multiply(BigInteger.valueOf(i + 1))), prs);
        }

        for (PrimeFinderThread pft : threadList) {
            pft.start();
        }

        for (PrimeFinderThread pft : threadList) {
            pft.join();
        }

    }

}
