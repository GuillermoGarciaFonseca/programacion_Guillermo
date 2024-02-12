package com.example.calculadora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.lang.Math;

public class CalculatorController {

    @FXML
    private TextField inputField;

    private String operator = "";
    private double firstNumber = 0;

    @FXML
    private void handleButtonClick(ActionEvent event) {
        String buttonText = ((Button) event.getSource()).getText();

        if (isNumeric(buttonText)) {
            inputField.appendText(buttonText);
        } else if (isOperator(buttonText)) {
            if (!inputField.getText().isEmpty()) {
                firstNumber = Double.parseDouble(inputField.getText());
                operator = buttonText;
                inputField.clear();
            }
        } else if (buttonText.equals("=")) {
            if (!operator.isEmpty() && !inputField.getText().isEmpty()) {
                double secondNumber = Double.parseDouble(inputField.getText());
                double result = calculate(firstNumber, secondNumber, operator);
                inputField.setText(String.valueOf(result));
                operator = "";
            }
        } else if (buttonText.equals("C")) {
            inputField.clear();
            firstNumber = 0;
            operator = "";
        } else if (buttonText.equals("sqrt")) {
            if (!inputField.getText().isEmpty()) {
                double number = Double.parseDouble(inputField.getText());
                double result = Math.sqrt(number);
                inputField.setText(String.valueOf(result));
            }
        } else if (buttonText.equals("x^2")) {
            if (!inputField.getText().isEmpty()) {
                double number = Double.parseDouble(inputField.getText());
                double result = Math.pow(number, 2);
                inputField.setText(String.valueOf(result));
            }
        } else if (buttonText.equals("sin")) {
            if (!inputField.getText().isEmpty()) {
                double number = Double.parseDouble(inputField.getText());
                double result = Math.sin(Math.toRadians(number));
                inputField.setText(String.valueOf(result));
            }
        } else if (buttonText.equals("cos")) { // Coseno
            if (!inputField.getText().isEmpty()) {
                double number = Double.parseDouble(inputField.getText());
                double result = Math.cos(Math.toRadians(number));
                inputField.setText(String.valueOf(result));
            }
        } else if (buttonText.equals("tan")) { // Tangente
            if (!inputField.getText().isEmpty()) {
                double number = Double.parseDouble(inputField.getText());
                double result = Math.tan(Math.toRadians(number));
                inputField.setText(String.valueOf(result));
            }
        }
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(String str) {
        return "+-*/".contains(str);
    }

    private double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    return 0; 
                }
            default:
                return 0;
        }
    }
}
