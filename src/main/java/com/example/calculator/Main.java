package com.example.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 280, 360);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
        CalculatorController calculatorController = fxmlLoader.getController();
        scene.setOnKeyPressed(calculatorController::keyBoardHandler);
    }

    public static void main(String[] args) {
        launch();
    }
}