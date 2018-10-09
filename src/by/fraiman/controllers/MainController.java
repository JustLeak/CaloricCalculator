package by.fraiman.controllers;

import by.fraiman.models.BMRCalculator;
import by.fraiman.models.CalcDetails;
import by.fraiman.models.LossCalculator;
import by.fraiman.models.enums.ActivityLevel;
import by.fraiman.models.enums.Gender;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {

    @FXML
    private TextField weightField;

    @FXML
    private TextField heightField;

    @FXML
    private TextField ageField;

    @FXML
    private RadioButton maleRB;

    @FXML
    private ToggleGroup genderGroup;

    @FXML
    private RadioButton femaleRB;

    @FXML
    private ChoiceBox<String> activityChoiceBox;

    @FXML
    private TextField desiredWeightField;

    @FXML
    private TextField lossField;

    @FXML
    private Button calculateBtn;

    @FXML
    private TextField not;

    @FXML
    private TextField loss;


    @FXML
    public void initialize() {
        for (ActivityLevel activityLevel : ActivityLevel.values()) {
            activityChoiceBox.getItems().add(activityLevel.getDescription());
        }

        activityChoiceBox.setValue(activityChoiceBox.getItems().get(0));

        calculateBtn.setOnAction(event -> {
            if (check()) {
                CalcDetails calcDetails = null;
                try {
                    calcDetails = read();

                    if (calcDetails.getWeight() == calcDetails.getdWeight())
                        System.exit(0);

                } catch (Exception e) {
                    System.exit(0);
                }
                double BMR = BMRCalculator.getBMR(calcDetails);
                not.setText(String.valueOf(BMR));
                loss.setText(String.valueOf(LossCalculator.calculate(calcDetails, BMR)));
            }
        });

        lossField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[\\d.]*")) {
                lossField.setText(newValue.replaceAll("[^\\d.]", ""));
            }
        });

        heightField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[\\d.-]*")) {
                heightField.setText(newValue.replaceAll("[^\\d.-]", ""));
            }
        });

        ageField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[\\d.]*")) {
                ageField.setText(newValue.replaceAll("[^\\d.]", ""));
            }
        });

        desiredWeightField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[\\d.]*")) {
                desiredWeightField.setText(newValue.replaceAll("[^\\d.]", ""));
            }
        });
    }

    private CalcDetails read() throws Exception {
        CalcDetails calcDetails = new CalcDetails();

        calcDetails.setActive(ActivityLevel.getActivity(activityChoiceBox.getValue()));
        calcDetails.setAge(Double.parseDouble(ageField.getCharacters().toString()));
        calcDetails.setGender(getSelectedGender());
        calcDetails.setHeight(Double.parseDouble(heightField.getCharacters().toString()));
        calcDetails.setWeight(Double.parseDouble(weightField.getCharacters().toString()));

        calcDetails.setdWeight(Double.parseDouble(desiredWeightField.getCharacters().toString()));
        calcDetails.setLossPerWeek(Double.parseDouble(lossField.getCharacters().toString()));

        if (calcDetails.getdWeight() == 0 ||
                calcDetails.getAge() == 0 ||
                calcDetails.getWeight() == 0 ||
                calcDetails.getHeight() == 0 ||
                calcDetails.getLossPerWeek() == 0)
            throw new Exception(new RuntimeException());
        return calcDetails;
    }

    private Gender getSelectedGender() {
        if (maleRB.isSelected())
            return Gender.MALE;
        else return Gender.FEMALE;
    }

    private boolean check() {
        try {
            Double.parseDouble(heightField.getCharacters().toString());
            Double.parseDouble(ageField.getCharacters().toString());
            Double.parseDouble(weightField.getCharacters().toString());
            Double.parseDouble(desiredWeightField.getCharacters().toString());
            Double.parseDouble(lossField.getCharacters().toString());
        } catch (Exception ex) {
            wrongInputAlert("Please check out your inputs.");
            return false;
        }
        return true;
    }

    private void wrongInputAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("WARNING");
        alert.setHeaderText("Wrong input!");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
