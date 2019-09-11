package edu.eci.arsw.api.primesrepo.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;

/**
 * @author Santiago Carrillo 2/22/18.
 */
@Component
public class PrimeServiceStub implements PrimeService {

    private final Map<String, FoundPrime> fps = new HashMap<>();
    private FoundPrime fp;

    @Override
    public void addFoundPrime(FoundPrime foundPrime) throws Exception {
        if (fps.containsKey(fp.getPrime())) {
            throw new Exception("The prime number is given already");
        } else {
            fps.put(fp.getUser(), fp);
        }
    }

    @Override
    public Set<FoundPrime> getFoundPrimes() {
        Set<FoundPrime> fpSet = new HashSet<>();
        for (FoundPrime fp : fps.values()) {
            fpSet.add(fp);
        }
        return fpSet;
    }

    @Override
    public FoundPrime getPrime(String prime) {
        /*for (type var : iterable) {

        }*/
        return null;
    }
}
