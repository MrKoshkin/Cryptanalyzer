package com.example.JavaRush_Module1_FilnalProject;

public class Coder {
    private static final char[] ALPHABET = Alphabet.getAlphabet();
    private static int key;

    public static int getKey() {
        return key;
    }

    public static void setKey(int key) {
        Coder.key = key;
    }
}
