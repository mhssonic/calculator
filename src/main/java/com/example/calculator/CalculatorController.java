package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

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
        numberInput(numButton.getText());
    }

    private void numberInput(String number){
        if(calculator.isFlagClearForNext())
            display.setText("");
        display.setText(display.getText() + number);
    }


    @FXML
    protected void onACButtonClick(){
        display.setText("");
        calculator.clear();
    }

    @FXML
    protected void onOperationButtonClick(ActionEvent event){
        Button opButton = ((Button)event.getSource());
        operationInput(opButton.getText());
    }

    private void operationInput(String operation){
        if(display.getText().length() == 0)
            return;
        display.setText(calculator.handleOperation(display.getText(), operation));
    }

    @FXML
    protected void onCalculateButtonClick(){
        display.setText(calculator.equalHandler(display.getText()));
    }

    public void keyBoardHandler(KeyEvent event){
        if(event.getText().length() == 1){
            char key = event.getText().charAt(0);
            if(key >= '0' && key <= '9' || key == '.')
                numberInput(event.getText());
            else if(key == '/' || key == '*' || key == '-' || key == '+')
                operationInput(event.getText());
            else if(key == '=')
                onCalculateButtonClick();
        }
        if(event.getCode() == KeyCode.BACK_SPACE)
            onACButtonClick();
        else if (event.getCode() == KeyCode.ENTER)
            onCalculateButtonClick();
    }
}