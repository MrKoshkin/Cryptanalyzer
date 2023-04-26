package com.example.JavaRush_Module1_FilnalProject;

public class BruteForce {
    private static final char[] ALPHABET = Alphabet.getAlphabet();
    private static int textLength;
    private static StringBuilder text;

    public static int keyFinder(StringBuilder text) {
        textLength = text.length();
        int key;
        for (key = 1; key < ALPHABET.length; key++) {
            BruteForce.text = Coder.decrypt(text, key);
            if (sentenceChecker() && propositionChecker() && spaceChecker()) {
                return key;
            }
        }
        return -1;  // не нашли ключ
    }

    // Проверка на количество предложений, оканчивающихся точкой
    private static boolean sentenceChecker() {
        int minSentenceCount = textLength / 250;    // Минимальное количество предложений в тексте
        int currentCount = 0;
        for (int i = 0; i < textLength - 2; i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                if (text.charAt(i + 1) == '.' && text.charAt(i + 2) == ' ') {   // Нашли предложение, которое заканчивается точкой и пробелом
                    currentCount++;
                }
            }
        }
        return currentCount >= minSentenceCount;
    }

    // Проверка на количество предлогов и союзов
    private static boolean propositionChecker() {
        int minPropositionCount = textLength / 13;  // Минимальное количество предлогов и союзов в тексте
        int currentCount = 0;
        for (int i = 0; i < textLength - 7; i++) {
            if (text.charAt(i) == ' ') {
                // Нашли предлог или союз
                if (Character.toLowerCase(text.charAt(i + 1)) == 'в' && text.charAt(i + 2) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(text.charAt(i + 1)) == 'н' && text.charAt(i + 2) == 'а' && text.charAt(i + 3) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(text.charAt(i + 1)) == 'c' && text.charAt(i + 2) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(text.charAt(i + 1)) == 'о' && text.charAt(i + 2) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(text.charAt(i + 1)) == 'п' && text.charAt(i + 2) == 'о' && text.charAt(i + 3) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(text.charAt(i + 1)) == 'к' && text.charAt(i + 2) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(text.charAt(i + 1)) == 'и' && text.charAt(i + 2) == 'з' && text.charAt(i + 3) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(text.charAt(i + 1)) == 'п' && text.charAt(i + 2) == 'е' && text.charAt(i + 3) == 'р' && text.charAt(i + 4) == 'е' && text.charAt(i + 5) == 'д' && text.charAt(i + 6) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(text.charAt(i + 1)) == 'з' && text.charAt(i + 2) == 'а' && text.charAt(i + 3) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(text.charAt(i + 1)) == 'п' && text.charAt(i + 2) == 'о' && text.charAt(i + 3) == 'д' && text.charAt(i + 4) == ' ') {
                    currentCount++;
                }

                if (Character.toLowerCase(text.charAt(i + 1)) == 'и' && text.charAt(i + 2) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(text.charAt(i + 1)) == 'а' && text.charAt(i + 2) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(text.charAt(i + 1)) == 'н' && text.charAt(i + 2) == 'о' && text.charAt(i + 3) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(text.charAt(i + 1)) == 'ч' && text.charAt(i + 2) == 'т' && text.charAt(i + 3) == 'о' && text.charAt(i + 4) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(text.charAt(i + 1)) == 'к' && text.charAt(i + 2) == 'а' && text.charAt(i + 3) == 'к' && text.charAt(i + 4) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(text.charAt(i + 1)) == 'е' && text.charAt(i + 2) == 'с' && text.charAt(i + 3) == 'л' && text.charAt(i + 4) == 'и' && text.charAt(i + 5) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(text.charAt(i + 1)) == 'т' && text.charAt(i + 2) == 'о' && text.charAt(i + 3) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(text.charAt(i + 1)) == 'ч' && text.charAt(i + 2) == 'т' && text.charAt(i + 3) == 'о' && text.charAt(i + 4) == 'б' && text.charAt(i + 5) == 'ы' && text.charAt(i + 6) == ' ') {
                    currentCount++;
                } else if (Character.toLowerCase(text.charAt(i + 1)) == 'т' && text.charAt(i + 2) == 'а' && text.charAt(i + 3) == 'к' && text.charAt(i + 4) == 'ж' && text.charAt(i + 5) == 'е' && text.charAt(i + 6) == ' ') {
                    currentCount++;
                }
            }
        }
        return currentCount >= minPropositionCount;
    }

    private static boolean spaceChecker() {
        int minSpaceCount = textLength / 14;    // Минимальное количество пробелов в тексте
        int currentCount = 0;
        for (int i = 0; i < textLength; i++) {
            if (text.charAt(i) == ' ') {
                currentCount++;
            }
        }
        return currentCount >= minSpaceCount;
    }
}
