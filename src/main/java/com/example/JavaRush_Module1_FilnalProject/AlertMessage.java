package com.example.JavaRush_Module1_FilnalProject;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class AlertMessage {

    public static void successMessage(String text) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(text);
        alert.setHeaderText("Файл сохранен в следующей директории: " + FileUtils.getOutputPath());
        alert.setContentText("Вы хотите открыть файл?");

        ButtonType buttonTypeYes = new ButtonType("Ок");
        ButtonType buttonTypeNo = new ButtonType("Отмена");

        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeYes){
            FileUtils.openFile();
        } else {

        }
    }

    public static void wrongPathMessage(String text) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
//        alert.setTitle("Некорректный путь");
        alert.setHeaderText(text);
//        alert.setContentText("Выберите файл для шифрования / расшифровки");
        alert.showAndWait();
    }

    public static void wrongKeyMessage(String text) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
//        alert.setTitle("Неправильный ключ");
        alert.setHeaderText(text);
        alert.showAndWait();
    }
}
