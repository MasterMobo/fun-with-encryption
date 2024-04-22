package org.example;

import org.example.crypto.Cryptosystem;
import org.example.crypto.rsa.RSA;

public class Main {
    public static void main(String[] args) {
        Cryptosystem rsa = new RSA(3, 11, 3);

        long message = 5;
        long cipher = rsa.encrypt(message);

        System.out.println(rsa.decrypt(cipher));

    }
}