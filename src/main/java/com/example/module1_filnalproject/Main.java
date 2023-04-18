package com.example.module1_filnalproject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;

import static javafx.application.Application.launch;

public class Main {

    static ArrayList<Character> mergedAlphabet = new ArrayList<>();
    static ArrayList<Character> upperCaseAlphabet = new ArrayList<>();
    static ArrayList<Character> lowerCaseAlphabet = new ArrayList<>();
    static ArrayList<Character> numbers = new ArrayList<>();
    static ArrayList<Character> symbols = new ArrayList<>();
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        setAlphabet();  //Создаем алфавитные справочники
//        System.out.println(upperCaseAlphabet);
        System.out.println(symbols);
        stringBuilder = readFile(Path.of("C:\\Users\\s.koshkin\\Desktop\\СЗ на лицензию Smartsheet.txt"));  //Записываем в стрингбилдер наш файл
        int key = -3;
        stringBuilder = Coder.encrypt(stringBuilder, key);      //Шифруем файл со сдвигом key
        stringBuilder = Coder.decrypt(stringBuilder, key);    //Дешифруем файл со сдвигом key
        writeFile(Path.of("log.txt"));
    }

    private static void setAlphabet() {
        for (int i = 1040; i < 1072; i++) {     // Генерация прописных букв русского алфавита
            upperCaseAlphabet.add((char) i);
        }
        for (int i = 1072; i < 1104; i++) {     // Генерация строчных букв русского алфавита
            lowerCaseAlphabet.add((char) i);
        }
        for (int i = 48; i < 58; i++) {         // Генерация цифр
            numbers.add((char) i);
        }
        for (int i = 32; i < 48; i++) {         // Генерация символов_1
            symbols.add((char) i);
        }
        for (int i = 58; i < 65; i++) {         // Генерация символов_2
            symbols.add((char) i);
        }
        mergedAlphabet.addAll(upperCaseAlphabet);
        mergedAlphabet.addAll(lowerCaseAlphabet);
        mergedAlphabet.addAll(numbers);
        mergedAlphabet.addAll(symbols);
    }

    private static StringBuilder readFile(Path path) {
        try (Reader reader = new InputStreamReader(new FileInputStream(path.toFile()), StandardCharsets.UTF_8)) {
            int i = -1;
            while ((i = reader.read()) != -1) {
                stringBuilder.append((char) i);      //Записываем весь текст в Стрингбилдер
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder;
    }

    private static void writeFile(Path path) {
        try (FileWriter writer = new FileWriter(path.toFile())) {
            writer.write(stringBuilder.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
