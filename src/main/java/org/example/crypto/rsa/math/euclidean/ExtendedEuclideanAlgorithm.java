package org.example.crypto.rsa.math.euclidean;

public class ExtendedEuclideanAlgorithm {
    public EuclideanSequence[] calculate(long a, long b) {
        /*
             Using Extended Euclidean algorithm to calculate gcd(a, b), s and t.
             Where a*s + b*t = gcd(a, b)

             Returns: A EuclideanSequence[] res[i] of length 3 where:
             - res[0].getPrev() is gcd(a, b)
             - res[1].getCurrent() is s.
             - res[2].getCurrent() is t. res[2].getPrev() mod b is the Multiplicative Inverse of a mod b (only when a and b are coprimes)

             Source: https://en.wikipedia.org/wiki/Extended_Euclidean_algorithm
         */

        long q;
        EuclideanSequence r = new EuclideanSequence(a, b);
        EuclideanSequence s = new EuclideanSequence(1, 0);
        EuclideanSequence t = new EuclideanSequence(0, 1);

        while (r.getCurrent() > 0) {
            q = r.getPrev() / r.getCurrent();
            r.getNext(q);
            s.getNext(q);
            t.getNext(q);
        }

        return new EuclideanSequence[] {r, s, t};
    }
}
