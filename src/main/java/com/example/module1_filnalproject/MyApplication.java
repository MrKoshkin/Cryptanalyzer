package com.example.module1_filnalproject;

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
    private TextField pathTextField;
    private Text text1;
    private Button mode1, mode2, getKeyButton, selectFileButton;

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
            mode1 = new Button("Шифрование / расшифровка");
            mode1.setPrefWidth(300); // ширина кнопки
            mode1.setPrefHeight(40); // высота кнопки
            mode1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    stage.setScene(scene2);

                }
            });

            //Криптоанализ Brute Force
            mode2 = new Button("Криптоанализ методом brute force");
            mode2.setPrefWidth(300); // ширина кнопки
            mode2.setPrefHeight(40); // высота кнопки
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

            pathTextField = new TextField();
            pathTextField.setPrefWidth(500);
            pathTextField.setPrefHeight(20);

        }




        // Создаем контейнер на сцене 2 для выбора файла
        HBox hbox1 = new HBox(30); // 10 - отступ между кнопками
        hbox1.getChildren().addAll(selectFileButton, pathTextField);
        hbox1.setAlignment(Pos.CENTER_LEFT);
        hbox1.setPadding(new Insets(50)); // Отступы

        // Создаем контейнер VBox и добавляем в него текстовые поля и кнопки
        VBox root = new VBox(30); // Отступ между компонентами
        root.setPadding(new Insets(50)); // Отступы
        root.getChildren().addAll(text1, mode1, mode2);
        root.setAlignment(Pos.CENTER);

        scene1 = new Scene(root, 840, 400);
        scene2 = new Scene(hbox1, 840, 400);
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