package org.example.crypto.rsa.math.euclidean;

public class EuclideanAlgorithm {
    public EuclideanAlgorithm() {
    }

    public long calculate(long n1, long n2) {
        // Euclidean Algorithm
        long a = n1;
        long b = n2;
        long remainder = a % b;

        while (remainder > 0L) {
            a = b;
            b = remainder;
            remainder = a % b;
        }

        return b;
    }
}
