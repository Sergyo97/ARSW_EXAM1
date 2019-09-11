package edu.eci.arsw.api.primesrepo;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import edu.eci.arsw.api.primesrepo.service.PrimeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Santiago Carrillo 2/22/18.
 */
@RestController
public class PrimesController {

    @Autowired
    PrimeService primeService;

    @GetMapping("/primes")
    public ResponseEntity<?> getAllPrimes() {
        return new ResponseEntity<>(primeService.getFoundPrimes(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/primes")
    public ResponseEntity<?> createPrimes(@RequestBody FoundPrime fp) {
        try {
            primeService.addFoundPrime(fp);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/primes/{primenumber}")
    public ResponseEntity<?> getPrimeByNumber(@PathVariable String primeNumber){
        return new ResponseEntity<>(primeService.getPrime(primeNumber), HttpStatus.ACCEPTED);
    }

}
