package com.example.JavaRush_Module1_FilnalProject;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class FileUtils {
    private static Path path;
    private static String fileExtension;
    private static StringBuilder sb;

    public static Path getPath() {
        return path;
    }

    public static String getFileExtension() {
        return fileExtension;
    }

    public static StringBuilder getSb() {
        return sb;
    }

    public static StringBuilder read(String pathString) throws UnsupportedFileException {
        path = Path.of(pathString);
        // Определение расширения файла
        if (path.toFile().getName().endsWith(".docx")) {
            readDocx();
        } else if (path.toFile().getName().endsWith(".txt")) {
            readTxt();
        } else {
            throw new UnsupportedFileException("Unsupported file type: " + path.toFile().getName());
        }
        return sb;
    }

    // Чтение docx и запись в StringBuilder
    private static void readDocx() {
        try (XWPFDocument doc = new XWPFDocument(new FileInputStream(path.toFile()))) {
            // Чтение текста из параграфов документа и запись в StringBuilder
            for (XWPFParagraph p : doc.getParagraphs()) {
                sb.append(p.getText()).append("\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Чтение txt и запись в StringBuilder
    private static void readTxt() {
        try (Reader reader = new InputStreamReader(new FileInputStream(path.toFile()), StandardCharsets.UTF_8)) {
            int i = -1;
            while ((i = reader.read()) != -1) {
                sb.append((char) i);      //Запись всего текст в Стрингбилдер
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void write(StringBuilder sb) {
        FileUtils.sb = sb;
        if (path.toFile().getName().endsWith(".docx")) {
            writeDocx();
        } else if (path.toFile().getName().endsWith(".txt")) {
            writeTxt();
        }
    }

    // Запись StringBuilder в docx
    private static void writeDocx() {

    }

    // Запись StringBuilder в txt
    private static void writeTxt() {

    }
}
