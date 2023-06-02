package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {
    private Calculator calculator = new Calculator();

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
        if(calculator.isFlagClearForNext())
            display.setText("");
        display.setText(display.getText() + numButton.getText());
    }

    @FXML
    protected void onACButtonClick(){
        display.setText("");
        calculator.clear();
    }

    @FXML
    protected void onOperationButtonClick(ActionEvent event){
        Button opButton = ((Button)event.getSource());
        if(display.getText().length() == 0)
            return;
        display.setText(calculator.handleOperation(display.getText(), opButton.getText()));
    }

    @FXML
    protected void onCalculateButtonClick(){
        display.setText(calculator.equalHandler(display.getText()));
    }
}