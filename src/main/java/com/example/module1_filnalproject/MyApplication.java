package com.example.module1_filnalproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MyApplication extends Application {
    private TextField textField1;
    private Button okButton;
    private Button cancelButton;

    @Override
    public void start(Stage stage) {
        textField1 = new TextField();
        textField1.setPrefWidth(400);
        textField1.setPrefHeight(40);

        okButton = new Button("Ок");
        okButton.setPrefWidth(100); // ширина кнопки
        okButton.setPrefHeight(30); // высота кнопки

        cancelButton = new Button("Отмена");
        cancelButton.setPrefWidth(100); // ширина кнопки
        cancelButton.setPrefHeight(30); // высота кнопки

        FileChooser fileChooser = new FileChooser();

        // Создаем контейнер и добавляем в него кнопки
        HBox hbox = new HBox(100); // 10 - отступ между кнопками
        hbox.getChildren().addAll(okButton, cancelButton);
        hbox.setAlignment(Pos.CENTER);

        // Создаем контейнер VBox и добавляем в него текстовые поля и кнопки
        VBox root = new VBox(50);
        root.setPadding(new Insets(40));
        root.getChildren().addAll(textField1, hbox);

        Scene scene = new Scene(root, 480, 200);
        stage.setTitle("Итоговый проект по Модулю 1");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);

    }

    // Обработчик события для кнопки "Сохранить"
    private void getPath (ActionEvent event) {
        String PathStr = textField1.getText(); // Получаем текст из текстового поля
//        System.out.println("Сохранено: " + text); // Выводим текст в консоль (можно заменить на свою логику сохранения)
    }
}