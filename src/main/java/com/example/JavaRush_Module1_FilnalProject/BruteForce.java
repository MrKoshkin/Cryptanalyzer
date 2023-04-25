package com.example.JavaRush_Module1_FilnalProject;

public class BruteForce {
    private static final char[] ALPHABET = Alphabet.getAlphabet();

    public static int keyFinder(StringBuilder text) {
        int key;
        for (key = 0; key < ALPHABET.length; key++) {
            Coder.decrypt(text, key);
        }
        return 0;
    }
}
