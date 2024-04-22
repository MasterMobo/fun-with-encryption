package org.example.crypto.rsa.math.totient;

import org.example.crypto.rsa.math.lcm.EuclideanLCMCalculator;
import org.example.crypto.rsa.math.lcm.LCMCalculator;

public class CarmichaelTotientCalculator implements TotientCalculator{

    @Override
    public long calculate(long p, long q) {
        // Source: https://en.wikipedia.org/wiki/RSA_(cryptosystem)#Padding_schemes:~:text=Hence%20%CE%BB(n)%20%3D%20lcm(p%20%E2%88%92%201%2C%20q%20%E2%88%92%201).

        LCMCalculator calculator = new EuclideanLCMCalculator();
        return calculator.lcm(p - 1, q - 1);
    }
}
