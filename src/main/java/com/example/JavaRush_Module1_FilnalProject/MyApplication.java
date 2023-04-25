package com.example.JavaRush_Module1_FilnalProject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MyApplication extends Application {
    private Stage stage;
    Scene scene1, scene2;
    private TextField pathTextField, keyTextField;
    private Text textForKey, textMessage1;
    private Button selectFileButton, encryptButton, decryptButton1, decryptButton2, decryptButton3, exitButton;

    @Override
    public void start(Stage stage) {
        this.stage = stage;

        // Сцена 1 конфигурация
        {
            //Выбор файла
            selectFileButton = new Button("Выбрать файл");
            selectFileButton.setOnAction(event -> {
                FileChooser fileChooser = new FileChooser();
                File selectedFile = fileChooser.showOpenDialog(stage);
                if (selectedFile != null) {
                    pathTextField.setText(selectedFile.getAbsolutePath());
//                    System.out.println("Выбран файл: " + selectedFile.getAbsolutePath());
                }
            });

            // Текстовое поле с Path
            pathTextField = new TextField();
            pathTextField.setPrefWidth(500);
            pathTextField.setPrefHeight(20);

            // Текст
            textMessage1 = new Text("Приложение поддерживает только документы формата .docx и .txt");
            textMessage1.setFont(Font.font("Arial", FontPosture.ITALIC, 12));

            // Текст
            textForKey = new Text("Введите ключ (сдвиг): ");
            textForKey.setFont(Font.font("Arial", 14));

            // Текстовое поле для ввода ключа
            keyTextField = new TextField();
            keyTextField.setPrefWidth(50);
            keyTextField.setPrefHeight(20);
//            Coder.setKey(Integer.parseInt(keyTextField.getText()));   // Определение ключа

            // Кнопка зашифровать
            {
                encryptButton = new Button("Зашифровать по ключу");
                encryptButton.setPrefWidth(300); // ширина кнопки
                encryptButton.setPrefHeight(40); // высота кнопки
                encryptButton.setOnAction(actionEvent -> {
                    if (pathTextField.getText().isEmpty()) {    // Проверка на пустой путь
                        AlertMessage.wrongPathMessage("Выберите файл для шифрования");
                    } else if (keyTextField.getText().isEmpty()) {    // Проверка на пустой ключ
                        AlertMessage.wrongKeyMessage("Введите целочисленный ключ (сдвиг)");
                    } else {
                        try {
                            int key = Integer.parseInt(keyTextField.getText());   // Определение ключа
                            StringBuilder text = FileUtils.read(pathTextField.getText());   // Преобразование входящего файла в стрингбилдер
                            System.out.println("Выбран файл: " + FileUtils.getInputPath());
                            StringBuilder encryptedText = Coder.encrypt(text, key);  // Шифруем
                            FileUtils.write(encryptedText); // Записываем в новый файл
                            pathTextField.setText(FileUtils.getOutputPath().toString());    // Подставляем путь нового файла в текстовое поле
                            System.out.println("Файл зашифрован по адресу: " + FileUtils.getOutputPath());
                            AlertMessage.successMessage("Файл успешно зашифрован");
                        } catch (UnsupportedFileException e) {
                            throw new RuntimeException(e);
                        } catch (NumberFormatException e) {
                            AlertMessage.wrongKeyMessage("Введите целочисленный ключ (сдвиг)");
                        }
                    }
                });
            }

            // Кнопка расшифровать по ключу
            {
                decryptButton1 = new Button("Расшифровать с помощью ключа");
                decryptButton1.setPrefWidth(300); // ширина кнопки
                decryptButton1.setPrefHeight(40); // высота кнопки
                decryptButton1.setOnAction(actionEvent -> {
                    if (pathTextField.getText().isEmpty()) {    // Проверка на пустой путь
                        AlertMessage.wrongPathMessage("Выберите файл для расшифровки");
                    } else if (keyTextField.getText().isEmpty()) {    // Проверка на пустой ключ
                        AlertMessage.wrongKeyMessage("Введите целочисленный ключ (сдвиг)");
                    } else {
                        try {
                            int key = Integer.parseInt(keyTextField.getText());   // Определение ключа
                            StringBuilder text = FileUtils.read(pathTextField.getText());     // Преобразование входящего файла в стрингбилдер
                            System.out.println("Выбран файл: " + FileUtils.getInputPath());
                            StringBuilder decryptedText = Coder.decrypt(text, key);  // Шифруем
                            FileUtils.write(decryptedText); // Записываем в новый файл
                            System.out.println("Файл расшифрован по адресу: " + FileUtils.getOutputPath());
                            AlertMessage.successMessage("Файл успешно расшифрован");
                        } catch (UnsupportedFileException e) {
                            throw new RuntimeException(e);
                        } catch (NumberFormatException e) {
                            AlertMessage.wrongKeyMessage("Введите целочисленный ключ (сдвиг)");
                        }
                    }
                });
            }

            // Кнопка расшифровать BruteForce
            decryptButton2 = new Button("Расшифровать с помощью brute force");
            decryptButton2.setPrefWidth(300); // ширина кнопки
            decryptButton2.setPrefHeight(40); // высота кнопки
            decryptButton2.setOnAction(actionEvent -> {

            });

            // Кнопка расшифровать методом стат анализа
            decryptButton3 = new Button("Расшифровать с помощью стат. анализа");
            decryptButton3.setPrefWidth(300); // ширина кнопки
            decryptButton3.setPrefHeight(40); // высота кнопки
            decryptButton3.setOnAction(actionEvent -> {

            });

            // Кнопка выхода из программы
            exitButton = new Button("Выход");
            exitButton.setPrefWidth(300); // ширина кнопки
            exitButton.setPrefHeight(40); // высота кнопки
            exitButton.setOnAction(actionEvent -> {
                System.exit(0);
            });
        }




        // Создаем контейнер на сцене 1 для выбора файла
        HBox pathContainerHBox = new HBox(20); // отступ
        pathContainerHBox.getChildren().addAll(selectFileButton, pathTextField);
        pathContainerHBox.setAlignment(Pos.TOP_LEFT);

        VBox pathContainerVbox = new VBox(20);
        pathContainerVbox.getChildren().addAll(pathContainerHBox,textMessage1);
        pathContainerVbox.setAlignment(Pos.TOP_LEFT);
        pathContainerVbox.setPadding(new Insets(20));

        // Создаем контейнер на сцене 1 для введения ключа
        HBox keyContainer = new HBox(20); // 10 - отступ между компонентами
        keyContainer.getChildren().addAll(textForKey, keyTextField);
//        keyContainer.setAlignment(Pos.TOP_LEFT);
        keyContainer.setPadding(new Insets(20)); // Отступы

        VBox buttonsBox = new VBox(30);
        buttonsBox.getChildren().addAll(encryptButton, decryptButton1, decryptButton2, decryptButton3, exitButton);
        buttonsBox.setAlignment(Pos.CENTER);
        buttonsBox.setPadding(new Insets(20)); // Отступы

        // Создаем контейнер root на Сцене 1
        VBox root = new VBox(30); // Отступ между компонентами
        root.setPadding(new Insets(10)); // Отступы
        root.getChildren().addAll(pathContainerVbox, keyContainer, buttonsBox);
        root.setAlignment(Pos.CENTER);

        scene1 = new Scene(root, 840, 600);
        stage.setTitle("Итоговый проект по Модулю 1");
        stage.setScene(scene1);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);

    }

    // Обработчик события для кнопки ""
    private int getKey(ActionEvent event) {
        String key = pathTextField.getText(); // Получаем ключ из текстового поля
        System.out.println("Ключ: " + key); // Выводим ключ в консоль
        return Integer.parseInt(key);
    }


}