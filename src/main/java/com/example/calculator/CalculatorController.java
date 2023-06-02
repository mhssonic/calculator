package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private Button calculate;

    @FXML
    private TextField display;

    @FXML
    private Button dive;

    @FXML
    private Button dot;

    @FXML
    private Button minus;

    @FXML
    private Button multe;

    @FXML
    protected void onNumberButtonClick(ActionEvent event) {
        Button numButton = ((Button)event.getSource());
        int number = Integer.parseInt(numButton.getText());
        display.setText(display.getText() + numButton.getText());
    }

    @FXML
    protected void onACButtonClick(){
        display.setText("");
    }

    @FXML
    protected void onOperationButtonClick(ActionEvent event){
        Button numButton = ((Button)event.getSource());
        display.setText(display.getText() + numButton.getText());
    }

    @FXML
    protected void onCalculateButtonClick(){

    }
}