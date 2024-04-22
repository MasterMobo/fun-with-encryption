package org.example.crypto;

public interface Cryptosystem {
    long encrypt(long message);
    long decrypt(long cipher);
}
