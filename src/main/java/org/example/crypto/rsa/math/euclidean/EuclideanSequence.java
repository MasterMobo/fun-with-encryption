package org.example.crypto.rsa.math.euclidean;

public class EuclideanSequence {
    private long prev;
    private long current;

    public EuclideanSequence() {
    }

    public EuclideanSequence(long prev, long current) {
        this.prev = prev;
        this.current = current;
    }

    public long getNext(long quotient) {
        long next = prev - quotient * current;
        prev = current;
        current = next;
        return next;
    }

    public long getPrev() {
        return prev;
    }

    public long getCurrent() {
        return current;
    }
}
