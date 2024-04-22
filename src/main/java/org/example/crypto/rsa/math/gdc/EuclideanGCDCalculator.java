package org.example.crypto.rsa.math.gdc;

import org.example.crypto.rsa.math.euclidean.EuclideanAlgorithm;

public class EuclideanGCDCalculator implements GCDCalculator{
    public EuclideanGCDCalculator() {
    }

    @Override
    public long gcd(long n1, long n2) {
        return (new EuclideanAlgorithm()).calculate(n1, n2);
    }
}
