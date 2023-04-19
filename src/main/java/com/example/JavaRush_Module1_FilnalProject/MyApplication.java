package com.example.JavaRush_Module1_FilnalProject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MyApplication extends Application {
    private Stage stage;
    Scene scene1, scene2;
    private TextField pathTextField, keyTextField;
    private Text text1, text2;
    private Button mode1Button, mode2Button, selectFileButton, encryptButton, decryptButton, backButton;

    @Override
    public void start(Stage stage) {
        this.stage = stage;

        // Сцена 1 конфигурация
        {
            //Выбор режима
            text1 = new Text("Выберите режим");
            Font headerBoldFont = Font.font("Arial", FontWeight.BOLD, 20);
            text1.setFont(headerBoldFont);

            //Шифр цезаря по ключу
            mode1Button = new Button("Шифрование / расшифровка");
            mode1Button.setPrefWidth(300); // ширина кнопки
            mode1Button.setPrefHeight(40); // высота кнопки
            mode1Button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    stage.setScene(scene2);

                }
            });

            //Криптоанализ Brute Force
            mode2Button = new Button("Криптоанализ методом brute force");
            mode2Button.setPrefWidth(300); // ширина кнопки
            mode2Button.setPrefHeight(40); // высота кнопки
        }

        // Сцена 2 конфигурация
        {
            //Выбор файла
            selectFileButton = new Button("Выбрать файл");
            selectFileButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    FileChooser fileChooser = new FileChooser();
                    File selectedFile = fileChooser.showOpenDialog(stage);
                    if (selectedFile != null) {
                        pathTextField.setText(selectedFile.getAbsolutePath());
                        System.out.println("Выбран файл: " + selectedFile.getAbsolutePath());
                    }
                }
            });

            // Текстовое поле с Path
            pathTextField = new TextField();
            pathTextField.setPrefWidth(500);
            pathTextField.setPrefHeight(20);

            // Текст
            text2 = new Text("Введите ключ (сдвиг): ");
            text2.setFont(Font.font("Arial", 14));

            // Текстовое поле для ввода ключа
            keyTextField = new TextField();
            keyTextField.setPrefWidth(50);
            keyTextField.setPrefHeight(20);
        }




        // Создаем контейнер на сцене 2 для выбора файла
        HBox pathContainer = new HBox(30); // 10 - отступ между кнопками
        pathContainer.getChildren().addAll(selectFileButton, pathTextField);
        pathContainer.setAlignment(Pos.TOP_LEFT);
        pathContainer.setPadding(new Insets(50)); // Отступы

        // Создаем контейнер на сцене 2 для введения ключа
        HBox keyContainer = new HBox(30); // 10 - отступ между компонентами
        keyContainer.getChildren().addAll(text2, keyTextField);
//        keyContainer.setAlignment(Pos.TOP_LEFT);
        keyContainer.setPadding(new Insets(50)); // Отступы

        VBox scene2VBOX = new VBox(30);
        scene2VBOX.getChildren().addAll(pathContainer, keyContainer);
        scene2VBOX.setAlignment(Pos.CENTER);
        scene2VBOX.setPadding(new Insets(50)); // Отступы

        // Создаем контейнер root на Сцене 1
        VBox root = new VBox(30); // Отступ между компонентами
        root.setPadding(new Insets(50)); // Отступы
        root.getChildren().addAll(text1, mode1Button, mode2Button);
        root.setAlignment(Pos.CENTER);

        scene1 = new Scene(root, 840, 300);
        scene2 = new Scene(scene2VBOX, 840, 300);
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