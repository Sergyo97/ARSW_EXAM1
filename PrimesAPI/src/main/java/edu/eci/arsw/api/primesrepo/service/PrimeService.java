package edu.eci.arsw.api.primesrepo.service;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;

import java.util.List;
import java.util.Set;

/**
 * @author Santiago Carrillo 2/22/18.
 */
public interface PrimeService {

    void addFoundPrime(FoundPrime foundPrime) throws Exception;

    Set<FoundPrime> getFoundPrimes();

    FoundPrime getPrime(String prime);

}
