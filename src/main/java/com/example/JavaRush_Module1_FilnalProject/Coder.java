package com.example.JavaRush_Module1_FilnalProject;

import java.util.ArrayList;

import static com.example.JavaRush_Module1_FilnalProject.BruteForce.*;
import static com.example.JavaRush_Module1_FilnalProject.Main.*;

class Coder {
    protected static StringBuilder encrypt(StringBuilder stringBuilder, int key) {
        if (stringBuilder == null) {
            System.out.println("File is empty!");
            return null;
        }
        char[] chars = stringBuilder.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            boolean isFind = false;
            for (int j = 0; j < upperCaseAlphabet.size(); j++) {
                if (isFind) {
                    break;
                }
                if (chars[i] == upperCaseAlphabet.get(j)) {
                    int index = getShift(upperCaseAlphabet, j, key);
                    chars[i] = upperCaseAlphabet.get(index);
                    isFind = true;
                }
            }
            for (int j = 0; j < lowerCaseAlphabet.size(); j++) {
                if (isFind) {
                    break;
                }
                if (chars[i] == lowerCaseAlphabet.get(j)) {
                    int index = getShift(lowerCaseAlphabet, j, key);
                    chars[i] = lowerCaseAlphabet.get(index);
                    isFind = true;
                }
            }
            for (int j = 0; j < numbers.size(); j++) {
                if (isFind) {
                    break;
                }
                if (chars[i] == numbers.get(j)) {
                    int index = getShift(numbers, j, key);
                    chars[i] = numbers.get(index);
                    isFind = true;
                }
            }
            for (int j = 0; j < symbols.size(); j++) {
                if (isFind) {
                    break;
                }
                if (chars[i] == symbols.get(j)) {
                    int index = getShift(symbols, j, key);
                    chars[i] = symbols.get(index);
                    isFind = true;
                }
            }
        }
        stringBuilder.delete(0, stringBuilder.length() - 1);
        for (int i = 0; i < chars.length; i++) {
            stringBuilder.append(chars[i]);
        }
        return stringBuilder;
    }

    protected static int getShift(ArrayList<Character> list, int j, int key) {
        if (key >= 0) {
            if (key > list.size() - 1 && (j + key % list.size() > list.size() - 1)) {
                return (j + key % list.size()) - list.size();
            } else if (key > list.size() - 1) {
                return j + key % list.size();
            } else if (j + key > list.size() - 1) {
                return (j + key) - list.size();
            } else {
                return j + key;
            }
        } else {
            key *= -1;
            if (key > list.size() - 1 && (j - key % list.size()) < 0) {
                return list.size() - (key % list.size() - j);
            } else if (key > list.size() - 1) {
                return j - key % list.size();
            } else if (j - key < 0) {
                return list.size() - (key - j);
            } else {
                return j - key;
            }
        }
    }

    protected static StringBuilder decrypt(StringBuilder stringBuilder, int key) {
        if (stringBuilder == null) {
            System.out.println("File is empty!");
            return null;
        }
        char[] chars = stringBuilder.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            boolean isFind = false;
            for (int j = 0; j < upperCaseAlphabet.size(); j++) {
                if (isFind) {
                    break;
                }
                if (chars[i] == upperCaseAlphabet.get(j)) {
                    int index = getReverseShift(upperCaseAlphabet, j, key);
                    chars[i] = upperCaseAlphabet.get(index);
                    isFind = true;
                }
            }
            for (int j = 0; j < lowerCaseAlphabet.size(); j++) {
                if (isFind) {
                    break;
                }
                if (chars[i] == lowerCaseAlphabet.get(j)) {
                    int index = getReverseShift(lowerCaseAlphabet, j, key);
                    chars[i] = lowerCaseAlphabet.get(index);
                    isFind = true;
                }
            }
            for (int j = 0; j < numbers.size(); j++) {
                if (isFind) {
                    break;
                }
                if (chars[i] == numbers.get(j)) {
                    int index = getReverseShift(numbers, j, key);
                    chars[i] = numbers.get(index);
                    isFind = true;
                }
            }
            for (int j = 0; j < symbols.size(); j++) {
                if (isFind) {
                    break;
                }
                if (chars[i] == symbols.get(j)) {
                    int index = getReverseShift(symbols, j, key);
                    chars[i] = symbols.get(index);
                    isFind = true;
                }
            }
        }
        stringBuilder.delete(0, stringBuilder.length() - 1);
        for (int i = 0; i < chars.length; i++) {
            stringBuilder.append(chars[i]);
        }
        return stringBuilder;
    }

    protected static int getReverseShift(ArrayList<Character> list, int j, int key) {
        if (key >= 0) {
            if (key > list.size() - 1 && (j - key % list.size()) < 0) {
                return list.size() - (key % list.size() - j);
            } else if (key > list.size() - 1) {
                return j - key % list.size();
            } else if (j - key < 0) {
                return list.size() - (key - j);
            } else {
                return j - key;
            }
        } else {
            key *= -1;
            if (key > list.size() - 1 && (j + key % list.size() > list.size() - 1)) {
                return (j + key % list.size()) - list.size();
            } else if (key > list.size() - 1) {
                return j + key % list.size();
            } else if (j + key > list.size() - 1) {
                return (j + key) - list.size();
            } else {
                return j + key;
            }
        }
    }

    protected static void decrypt(StringBuilder stringBuilder) {
        if (stringBuilder == null) {
            System.out.println("File is empty!");
            return;
        }

        int key = bruteForceKeyFinder(stringBuilder);
        decrypt(stringBuilder, key);
    }
}
