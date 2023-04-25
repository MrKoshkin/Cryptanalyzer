package com.example.JavaRush_Module1_FilnalProject;

import javafx.scene.control.Alert;

public class AlertMessage {

    public static void wrongPathMessage() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Некорректный путь");
        alert.setHeaderText("Выберите файл для шифрования / расшифровки");
//        alert.setContentText("Выберите файл для шифрования / расшифровки");
        alert.showAndWait();
    }

    public static void wrongKeyMessage() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Неправильный ключ");
        alert.setHeaderText("Введите целочисленный ключ (сдвиг)");
        alert.showAndWait();
    }
}
