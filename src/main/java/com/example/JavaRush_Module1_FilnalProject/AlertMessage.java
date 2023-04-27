package com.example.JavaRush_Module1_FilnalProject;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.controlsfx.control.action.Action;

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

    public static void failBruteForceMessage(String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
//        alert.setTitle(text);
        alert.setHeaderText(text);
        ButtonType buttonTypeYes;
        if (BruteForce.getAlternativeResult() != -666) {
            alert.setContentText("Наиболее подходящий ключ: " + BruteForce.getAlternativeResult());
            buttonTypeYes = new ButtonType("Хорошо");
        } else {
            buttonTypeYes = new ButtonType("Очень жаль");
        }

        alert.getButtonTypes().setAll(buttonTypeYes);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeYes){

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

//    public static void emptyKeyMessage() {
//
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("Отсутствует ключ");
//        alert.setHeaderText("Вы хотите расшифровать методом BruteForce?");
//
//        ButtonType buttonTypeYes = new ButtonType("Да");
//        ButtonType buttonTypeNo = new ButtonType("Нет");
//
//        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
//
//        alert.showAndWait().ifPresent(buttonType -> {
//            if (buttonType == buttonTypeYes) {
//                if (actionOnOK != null) {
//                    actionOnOK.run();
//                }
//            } else if (buttonType == cancelButton) {
//                if (actionOnCancel != null) {
//                    actionOnCancel.run();
//                }
//            }
//        });
//    }
}
