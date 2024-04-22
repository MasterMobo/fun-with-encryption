package org.example.crypto.rsa.math.lcm;

import org.example.crypto.rsa.math.gdc.EuclideanGCDCalculator;

public class EuclideanLCMCalculator implements LCMCalculator{
    @Override
    public long lcm(long n1, long n2) {
        long gdc = (new EuclideanGCDCalculator()).gcd(n1, n2);
        return (n1 * n2) / gdc;
    }
}
