package com.example.JavaRush_Module1_FilnalProject;

import java.util.Arrays;

public class Coder {
    private static final char[] ALPHABET = Alphabet.getAlphabet();
    private static int key;

    public static int getKey() {
        return key;
    }

    public static void setKey(int key) {
        Coder.key = key;
    }

    public static StringBuilder encrypt(StringBuilder text) {
        char[] result = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isUpperCase(ch)) {    // Заглавные буквы
                result[i] = Character.toUpperCase(encryptChar(Character.toLowerCase(ch)));
            } else {    // Строчные буквы
                result[i] = encryptChar(ch);
            }
        }
        text.delete(0, text.length() - 1);  // Очищаем стрингбилдер
        for (int i = 0; i < result.length; i++) {
            text.append(result[i]); // Записываем результат в стрингбилдер
        }
        return text;
    }

    private static char encryptChar(char ch) {
        int index = Arrays.binarySearch(ALPHABET, ch);  // Определение индекса символа в алфавите
        if (index < 0) {    // Нет такого символа в алфавите
            return ch;
        }
        index = (index - key + ALPHABET.length) % ALPHABET.length;  // Получаем новый индекс с учетом сдвига
        return ALPHABET[index];
    }

    public static StringBuilder decrypt(StringBuilder text) {
        char[] result = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isUpperCase(ch)) {
                result[i] = Character.toUpperCase(decryptChar(Character.toLowerCase(ch)));
            } else {
                result[i] = decryptChar(ch);
            }
        }
        text.delete(0, text.length() - 1);  // Очищаем стрингбилдер
        for (int i = 0; i < result.length; i++) {
            text.append(result[i]); // Записываем результат в стрингбилдер
        }
        return text;
    }

    private static char decryptChar(char ch) {
        int index = Arrays.binarySearch(ALPHABET, ch);
        if (index < 0) {
            return ch;
        }
        index = (index - key + ALPHABET.length) % ALPHABET.length;
        return ALPHABET[index];
    }
}
