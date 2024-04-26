package org.example;

import org.example.crypto.Cryptosystem;
import org.example.crypto.rsa.RSA;

public class Main {

    public static void main(String[] args) {
        RSA rsa = new RSA(61, 53, 17);

        long message = 2000;
        long cipher = rsa.encrypt(message);

        System.out.println(rsa.decrypt(cipher));
    }
}