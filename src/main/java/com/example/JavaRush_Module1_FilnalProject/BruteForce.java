package com.example.JavaRush_Module1_FilnalProject;

import java.util.HashMap;
import java.util.Map;

public class BruteForce implements DecryptAble{
    private static final char[] ALPHABET = Alphabet.getAlphabet();
    private static int textLength;
    private static StringBuilder outputText = new StringBuilder();
    private static int alternativeResult = Integer.MIN_VALUE;
    private static int successCounter;

    public static int keyFinder(StringBuilder text) {
        textLength = text.length();
        boolean isFind = false;
        int key;
        int result = 0;
        for (key = 0; key < ALPHABET.length; key++) {
            outputText = Coder.decrypt(text, key);
            successCounter = 0;
            if (spaceChecker() && sentenceChecker() && propositionChecker()) {  // Ключ прошел все проверки
                result = key;
                isFind = true;
            }
            if (successCounter >= 2) {
                alternativeResult = key;
            }

        }
        if (isFind) {
            return result;
        } else {
            return Integer.MIN_VALUE;    // не нашли ключ
        }
    }

    // Проверка на количество предложений, оканчивающихся точкой
    private static boolean sentenceChecker() {
        int minSentenceCount = textLength / 400;    // Минимальное количество предложений в тексте
        int currentCount = 0;
        for (int i = 0; i < textLength - 2; i++) {
            char ch = outputText.charAt(i);
            if (Character.isLetter(ch)) {
                if (outputText.charAt(i + 1) == '.' && outputText.charAt(i + 2) == ' ') {   // Нашли предложение, которое заканчивается точкой и пробелом
                    currentCount++;
                }
            }
        }
        System.out.println("Количество предложений: " + currentCount + " / " + minSentenceCount);   /* Логирование */
        if (currentCount >= minSentenceCount){
            successCounter++;
        }
        return currentCount >= minSentenceCount;
    }

    // Проверка на количество предлогов и союзов
    private static boolean propositionChecker() {
        int minPropositionCount = textLength / 100;  // Минимальное количество предлогов и союзов в тексте
        int currentCount = 0;
        for (int i = 0; i < textLength - 7; i++) {
            String str = Character.toString(outputText.charAt(i)) + Character.toString(outputText.charAt(i + 1)) + Character.toString(outputText.charAt(i + 2)) + Character.toString(outputText.charAt(i + 3)) + Character.toString(outputText.charAt(i + 4)) + Character.toString(outputText.charAt(i + 5));
            if (outputText.charAt(i) == ' ') {
                // Нашли предлог
                if (Character.toLowerCase(outputText.charAt(i + 1)) == 'в' && outputText.charAt(i + 2) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(outputText.charAt(i + 1)) == 'н' && outputText.charAt(i + 2) == 'а' && outputText.charAt(i + 3) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(outputText.charAt(i + 1)) == 'c' && outputText.charAt(i + 2) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(outputText.charAt(i + 1)) == 'о' && outputText.charAt(i + 2) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(outputText.charAt(i + 1)) == 'п' && outputText.charAt(i + 2) == 'о' && outputText.charAt(i + 3) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(outputText.charAt(i + 1)) == 'к' && outputText.charAt(i + 2) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(outputText.charAt(i + 1)) == 'и' && outputText.charAt(i + 2) == 'з' && outputText.charAt(i + 3) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(outputText.charAt(i + 1)) == 'п' && outputText.charAt(i + 2) == 'е' && outputText.charAt(i + 3) == 'р' && outputText.charAt(i + 4) == 'е' && outputText.charAt(i + 5) == 'д' && outputText.charAt(i + 6) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(outputText.charAt(i + 1)) == 'з' && outputText.charAt(i + 2) == 'а' && outputText.charAt(i + 3) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(outputText.charAt(i + 1)) == 'п' && outputText.charAt(i + 2) == 'о' && outputText.charAt(i + 3) == 'д' && outputText.charAt(i + 4) == ' ') {
                    currentCount++;
                }
            }

            if (outputText.charAt(i) == ' ') {
                // Нашли союз
                if (Character.toLowerCase(outputText.charAt(i + 1)) == 'и' && outputText.charAt(i + 2) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(outputText.charAt(i + 1)) == 'а' && outputText.charAt(i + 2) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(outputText.charAt(i + 1)) == 'н' && outputText.charAt(i + 2) == 'о' && outputText.charAt(i + 3) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(outputText.charAt(i + 1)) == 'ч' && outputText.charAt(i + 2) == 'т' && outputText.charAt(i + 3) == 'о' && outputText.charAt(i + 4) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(outputText.charAt(i + 1)) == 'к' && outputText.charAt(i + 2) == 'а' && outputText.charAt(i + 3) == 'к' && outputText.charAt(i + 4) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(outputText.charAt(i + 1)) == 'е' && outputText.charAt(i + 2) == 'с' && outputText.charAt(i + 3) == 'л' && outputText.charAt(i + 4) == 'и' && outputText.charAt(i + 5) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(outputText.charAt(i + 1)) == 'т' && outputText.charAt(i + 2) == 'о' && outputText.charAt(i + 3) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(outputText.charAt(i + 1)) == 'ч' && outputText.charAt(i + 2) == 'т' && outputText.charAt(i + 3) == 'о' && outputText.charAt(i + 4) == 'б' && outputText.charAt(i + 5) == 'ы' && outputText.charAt(i + 6) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(outputText.charAt(i + 1)) == 'т' && outputText.charAt(i + 2) == 'а' && outputText.charAt(i + 3) == 'к' && outputText.charAt(i + 4) == 'ж' && outputText.charAt(i + 5) == 'е' && outputText.charAt(i + 6) == ' ') {
                    currentCount++;
                }
            }
        }
        System.out.println("Количество предлогов: " + currentCount + " / " + minPropositionCount);   /* Логирование */
        if (currentCount >= minPropositionCount){
            successCounter++;
        }
        return currentCount >= minPropositionCount;
    }

    private static boolean spaceChecker() {
        int minSpaceCount = textLength / 15;    // Минимальное количество пробелов в тексте
        int currentCount = 0;
        for (int i = 0; i < textLength; i++) {
            if (outputText.charAt(i) == ' ') {
                currentCount++;
            }
        }
        System.out.println("Количество пробелов: " + currentCount + " / " + minSpaceCount);   /* Логирование */
        if (currentCount >= minSpaceCount){
            successCounter++;
        }
        return currentCount >= minSpaceCount;
    }

    public static int getAlternativeResult() {
        return alternativeResult;
    }
}
