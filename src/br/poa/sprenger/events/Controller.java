package br.poa.sprenger.events;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class Controller {

    @FXML private TextField nameField;
    @FXML private Button helloButton;
    @FXML private Button byeButton;
    @FXML private CheckBox clearNameField;

    @FXML public void onButtonClicked(ActionEvent e) {
        if (e.getSource().equals(helloButton)){
            System.out.println("Hello, " + nameField.getText());
        } else if (e.getSource().equals(byeButton)) {
            System.out.println("Bye, " + nameField.getText());
        }

        if (clearNameField.isSelected()) {
            nameField.clear();

            helloButton.setDisable(true);
            byeButton.setDisable(true);
        }
    }

    @FXML public void handleKeyReleased() {
        String text = nameField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();
        helloButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }

    @FXML public void handleCheck() {
        System.out.println("The checkbox is " + (clearNameField.isSelected() ? "checked" : "not checked"));
    }
}
