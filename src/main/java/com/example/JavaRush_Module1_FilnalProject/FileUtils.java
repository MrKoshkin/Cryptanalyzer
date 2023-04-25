package com.example.JavaRush_Module1_FilnalProject;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.awt.Desktop;

public class FileUtils {
    private static Path inputPath;
    private static Path outputPath;
    private static String fileExtension;
    private static StringBuilder text;

    public static Path getInputPath() {
        return inputPath;
    }

    public static Path getOutputPath() {
        return outputPath;
    }

    public static String getFileExtension() {
        return fileExtension;
    }

    public static StringBuilder getText() {
        return text;
    }

    public static StringBuilder read(String pathString) throws UnsupportedFileException {
        inputPath = Path.of(pathString);
        text = new StringBuilder();
        // Определение расширения файла
        if (inputPath.toFile().getName().endsWith(".docx")) {
            readDocx();
        } else if (inputPath.toFile().getName().endsWith(".txt")) {
            readTxt();
        } else {
            throw new UnsupportedFileException("Unsupported file type: " + inputPath.toFile().getName());
        }
        return text;
    }

    // Чтение docx и запись в StringBuilder
    private static void readDocx() {
        try (XWPFDocument doc = new XWPFDocument(new FileInputStream(inputPath.toFile()))) {
            // Чтение текста из параграфов документа и запись в StringBuilder
            for (XWPFParagraph p : doc.getParagraphs()) {
                text.append(p.getText()).append("\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Чтение txt и запись в StringBuilder
    private static void readTxt() {
        try (Reader reader = new InputStreamReader(new FileInputStream(inputPath.toFile()), StandardCharsets.UTF_8)) {
            int i = -1;
            while ((i = reader.read()) != -1) {
                text.append((char) i);      //Запись всего текст в Стрингбилдер
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void write(StringBuilder sb) {
        FileUtils.text = sb;
        File inputFile = new File(inputPath.toUri());
        if (inputPath.toFile().getName().endsWith(".docx")) {
            outputPath = (new File(inputFile.getParent(), "output.docx")).toPath(); // Указываем путь к новому файлу формата docx
            writeDocx();
        } else if (inputPath.toFile().getName().endsWith(".txt")) {
            outputPath = (new File(inputFile.getParent(), "output.txt")).toPath(); // Указываем путь к новому файлу формата txt
            writeTxt();
        }
    }

    // Запись StringBuilder в docx
    private static void writeDocx() {
        try (XWPFDocument newDoc = new XWPFDocument();
             FileOutputStream out = new FileOutputStream(outputPath.toFile())) {
            XWPFParagraph p = newDoc.createParagraph();
            p.createRun().setText(text.toString());
            newDoc.write(out);
        } catch (IOException e) {
            System.out.println("Ошибка при обработке файлов: " + e.getMessage());
        }
    }

    // Запись StringBuilder в txt
    private static void writeTxt() {
        try (FileWriter writer = new FileWriter(outputPath.toFile())) {
            writer.write(text.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void openFile() {
        File file = outputPath.toFile();
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) {
                try {
                    desktop.open(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
