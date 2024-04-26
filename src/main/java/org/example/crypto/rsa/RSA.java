package org.example.crypto.rsa;

/* Sources:
* https://en.wikipedia.org/wiki/RSA_(cryptosystem)*/

import org.example.crypto.Cryptosystem;
import org.example.crypto.rsa.math.EuclideanMultInverseCalculator;
import org.example.crypto.rsa.math.MultInverseCalculator;
import org.example.crypto.rsa.math.gdc.EuclideanGCDCalculator;
import org.example.crypto.rsa.math.gdc.GCDCalculator;
import org.example.crypto.rsa.math.totient.CarmichaelTotientCalculator;
import org.example.crypto.rsa.math.totient.EulerTotientCalculator;
import org.example.crypto.rsa.math.totient.TotientCalculator;

public class RSA implements Cryptosystem {

    /*
        p and q are two large prime numbers (chosen at random) with a large difference.
        The standard method is to choose random integers and use a primality test until two primes are found.
    */
    private long p;
    private long q;
    private long d;
    private long e;
    private long n;
    private long eSeed; // e value to start generating coprime. See getSmallCoprime().
    private TotientCalculator totientCalculator;
    private GCDCalculator gcdCalculator;
    private MultInverseCalculator multInverseCalculator;

    public RSA() {
    }

    public RSA(long p, long q) {
        this.p = p;
        this.q = q;
        eSeed = 3;
        totientCalculator = new CarmichaelTotientCalculator();
        gcdCalculator = new EuclideanGCDCalculator();
        multInverseCalculator = new EuclideanMultInverseCalculator();
    }

    public RSA(long p, long q, long eSeed) {
        this.p = p;
        this.q = q;
        this.eSeed = eSeed;
        totientCalculator = new CarmichaelTotientCalculator();
        gcdCalculator = new EuclideanGCDCalculator();
        multInverseCalculator = new EuclideanMultInverseCalculator();
    }

    private long getSmallCoprime(long n) {
        // Returns a number e (seeded) that is coprime with input n
        long e = eSeed;

        while (!isCoprime(e, n)) {
            e++;
        }

        return e;
    }

    private boolean isCoprime(long n1, long n2) {
        return gcdCalculator.gcd(n1, n2) == 1;
    }

    public long modPow(long base, long exponent, long modulus) {
        // Computes base^exponent mod modulus using a modular exponent algorithm
        // Exponentiation by squaring algorithm
        // Source: https://stackoverflow.com/a/3191350

        // We start by reading the LSB of the exponent (right-to-left)

        // Every time the exponent doubles (shifted right a bit), the base has to square.
        // If we see a 0 after doubling, we do not need to do anything.
        // If we see a 1, we know we need to add one more exponent,
        // Which is the same as multiplying by the base.

        long res = 1;

        while (exponent > 0) {

            // Read the LSB to see if it's 1
            if ((exponent & 1) == 1) {
                res = (res * base) % modulus;    // If 1 then multiply by the base
            }

            // Shift right to next bit
            exponent >>= 1;
            base = (base * base) % modulus;   // Square the base
        }

        return res;
    }

    @Override
    public long encrypt(long message) {
        /*
            n is used as the modulus for both the public and private keys.
            n is released as part of the public key.
        */
        n = p * q;

        long lambdaN = totientCalculator.calculate(p, q);

        e = getSmallCoprime(lambdaN);

        d = multInverseCalculator.calculate(e, lambdaN);

        return modPow(message, e, n);
    }

    @Override
    public long decrypt(long cipher) {
        return modPow(cipher, d, n);
    }
}
