package com.example.temperature;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public Label welcomeLabel;

    @FXML
    public ChoiceBox<String> choiceBox;

    @FXML
    public TextField userInputField;

    @FXML
    public Button convertButton;

    public static final String C_TO_F_TEXT = "Celsius to Fahrenheit";
    public static final String F_TO_C_TEXT = "Fahrenheit to Celsius";

    public boolean isC_TO_F = true ;

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        choiceBox.getItems().add(C_TO_F_TEXT);
        choiceBox.getItems().add(F_TO_C_TEXT);
        choiceBox.setValue(C_TO_F_TEXT);

        choiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if(newValue.equals(C_TO_F_TEXT)){
                isC_TO_F = true;
            }else {
                isC_TO_F = false;
            }
        });

        convertButton.setOnAction(actionEvent -> {
            convert();
        });

    }

    private void convert() {
        String input = userInputField.getText();
        float enteredTemperature;
        try{
            enteredTemperature = Float.parseFloat(input);
        }catch (Exception e){
            warnUser();
            return;
        }
        float newTemperature = 0.0f;

        if(isC_TO_F){
            newTemperature = (enteredTemperature*9/5)+32;
        }else {
            newTemperature =(enteredTemperature -32)*5/9;
        }
        display(newTemperature);
    }

    private void warnUser() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Invalid Temperature Entered");
        alert.setContentText("Please enter valid input ");
        alert.show();
    }

    private void display(float newTemperature) {
        String unit = isC_TO_F? "F" : "C";
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("The Temperature is: "+newTemperature+unit);
        alert.show();
    }
}