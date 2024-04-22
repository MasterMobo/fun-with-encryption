package org.example.crypto.rsa.math;

public interface MultInverseCalculator {

    // Calculates the Multiplicative Inverse of n (mod modBase)
    long calculate(long n, long modBase);
}
