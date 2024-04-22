package org.example.crypto.rsa.math;

import org.example.crypto.rsa.math.euclidean.ExtendedEuclideanAlgorithm;

public class EuclideanMultInverseCalculator implements MultInverseCalculator{
    @Override
    public long calculate(long n, long modBase) {
        // Calculates the Multiplicative Inverse of n (mod modBase) using Extended Euclidean Algorithm.
        // Source: https://www.extendedeuclideanalgorithm.com/multiplicative_inverse.php
        ExtendedEuclideanAlgorithm euclidean = new ExtendedEuclideanAlgorithm();

        return Math.floorMod(euclidean.calculate(modBase, n)[2].getPrev(), modBase);
    }
}
