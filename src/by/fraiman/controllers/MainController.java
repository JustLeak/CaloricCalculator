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
            CalcDetails calcDetails = read();
            double BMR = BMRCalculator.getBMR(calcDetails);
            not.setText(String.valueOf(BMR));
            loss.setText(String.valueOf(LossCalculator.calculate(calcDetails.getWeight(), Double.parseDouble(desiredWeightField.getCharacters().toString()), Double.parseDouble(lossField.getCharacters().toString()), BMR)));
        });
    }

    private CalcDetails read() {
        CalcDetails calcDetails = new CalcDetails();

        calcDetails.setActive(ActivityLevel.getActivity(activityChoiceBox.getValue()));
        calcDetails.setAge(Double.parseDouble(ageField.getCharacters().toString()));
        calcDetails.setGender(getSelectedGender());
        calcDetails.setHeight(Double.parseDouble(heightField.getCharacters().toString()));
        calcDetails.setWeight(Double.parseDouble(weightField.getCharacters().toString()));

        return calcDetails;
    }

    private Gender getSelectedGender() {
        if (maleRB.isSelected())
            return Gender.MALE;
        else return Gender.FEMALE;
    }
}
