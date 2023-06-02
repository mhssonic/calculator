package com.example.calculator;

public class Calculator {
    public boolean isFlagClearForNext() {
        if (flagClearForNext){
            flagClearForNext = false;
            return true;
        }
        return false;
    }

    private boolean flagClearForNext = false;
    private Float number1 = null;
    private Float number2 = null;
    private String operation = "";
    private float calculateBinaryNumber(){
        switch (operation) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                if(number2 == 0)
                    return 0;
                return number1 / number2;
            default:
                break;
        }
        return 0;
    }

    public String handleOperation(String text, String newOperation){
        if(text.equals(""))
            return "";
        if(number1 == null)
            number1 = Float.parseFloat(text);
        else
            number2 = Float.parseFloat(text);
        if(operation.equals("")){
            operation = newOperation;
            return "";
        }
        if(number2 != null) {
            Float answer = calculateBinaryNumber();
            operation = newOperation;
            number1 = answer;
            number2 = null;
            flagClearForNext = true;
            return answer.toString();
        }
        return "";
    }

    public String equalHandler(String text){
        if(operation.equals("") || number1 == null || text.equals(""))
            return text;
        number2 = Float.parseFloat(text);
        Float answer = calculateBinaryNumber();
        number1 = answer;
        number2 = null;
        operation = "";
        flagClearForNext = true;
        return answer.toString();
    }

    public void clear(){
        flagClearForNext = false;
        number1 = null;
        number2 = null;
        operation = "";
    }
}
