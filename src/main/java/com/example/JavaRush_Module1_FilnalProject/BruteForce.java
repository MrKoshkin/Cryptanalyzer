package com.example.JavaRush_Module1_FilnalProject;

import java.util.HashMap;
import java.util.Map;

public class BruteForce {
    private static final char[] ALPHABET = Alphabet.getAlphabet();
    private static int textLength;
    private static StringBuilder outputText = new StringBuilder();

    public static int keyFinder(StringBuilder text) {
        textLength = text.length();
        int key;
        Map<Integer,Integer> resultMap = new HashMap<>();
        int index = 0;
        for (key = 1; key < ALPHABET.length; key++) {
            outputText = Coder.decrypt(text, key);
            if (spaceChecker() && sentenceChecker() && propositionChecker()) {
                resultMap.put(index, key);
                index++;
            }
        }
        if (resultMap.size()>0) {
            return resultMap.get(0);
        } else {
            return 0;  // не нашли ключ
        }
    }

    // Проверка на количество предложений, оканчивающихся точкой
    private static boolean sentenceChecker() {
        int minSentenceCount = textLength / 350;    // Минимальное количество предложений в тексте
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
        return currentCount >= minSentenceCount;
    }

    // Проверка на количество предлогов и союзов
    private static boolean propositionChecker() {
        int minPropositionCount = textLength / 90;  // Минимальное количество предлогов и союзов в тексте
        int currentCount = 0;
        for (int i = 0; i < textLength - 7; i++) {
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
        return currentCount >= minPropositionCount;
    }

    private static boolean spaceChecker() {
        int minSpaceCount = textLength / 14;    // Минимальное количество пробелов в тексте
        int currentCount = 0;
        for (int i = 0; i < textLength; i++) {
            if (outputText.charAt(i) == ' ') {
                currentCount++;
            }
        }
        System.out.println("Количество пробелов: " + currentCount + " / " + minSpaceCount);   /* Логирование */
        return currentCount >= minSpaceCount;
    }
}
