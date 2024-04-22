package org.example.crypto.rsa.math.totient;

public class EulerTotientCalculator implements TotientCalculator{
    @Override
    public long calculate(long p, long q) {
        // Calculate Euler's totient function (p and q are coprimes)
        // Source: https://en.wikipedia.org/wiki/RSA_(cryptosystem)#Padding_schemes:~:text=%CF%86(n)%20%3D%20(p%20%E2%88%92%201)(q%20%E2%88%92%201)

        return (p - 1) * (q - 1);
    }
}
