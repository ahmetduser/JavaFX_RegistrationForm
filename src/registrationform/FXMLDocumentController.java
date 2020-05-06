/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationform;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author ahmetduser
 */
public class FXMLDocumentController implements Initializable {

    // the name of the nodes are coming from fxml fx:id -> it is identity associated to component in fxml to build a controller
    @FXML
    private TextField txtFullName;
    @FXML
    private Label lblNameError;

    @FXML
    private TextField txtMail;
    @FXML
    private Label lblMailError;

    @FXML
    private TextField txtPass;
    @FXML
    private Label lblPassError;

    @FXML
    private ComboBox boxCountry;
    @FXML
    private Label lblCountryError;

    @FXML
    private TextField txtCity;
    @FXML
    private Label lblCityError;

    @FXML
    private Label lblError;     // General Error Label

    @FXML
    private void handleRegisterButtonAction(ActionEvent event) {
        String fullName;
        String mail;
        String pass;
        String country;
        String city;

        // Check if any of the text field is empty
        ArrayList<TextField> txtList = new ArrayList<>();
        txtList.add(txtFullName);
        txtList.add(txtMail);
        txtList.add(txtPass);
        txtList.add(txtCity);
        // iterate the textField nodes
        for (TextField nodes : txtList) {
            if (nodes.getText().isEmpty()) {
                lblError.setText("Please complete the all form");
            }

        }
        if (boxCountry.getSelectionModel().isEmpty()) {     // check if a country is selected
            lblCountryError.setText("Select a country from the list");
        } else if (isValidEmailAddress(txtMail.getText()) == false) {     // check if the mail address is a valid address
            lblMailError.setText("Enter a valid mail");
            lblError.setText("");
        } else {
            lblCountryError.setText("");
            lblMailError.setText("");

            // store the user's inputs
            fullName = txtFullName.getText();
            mail = txtMail.getText();
            pass = txtPass.getText();
            country = boxCountry.getSelectionModel().getSelectedItem().toString();
            city = txtCity.getText();

            // create an object of the Record class
            Record record = new Record(fullName, mail, pass, country, city);

            // send the information to the users_table
            record.usersTable();

            // send the login informations to the login_info table
            record.loginInfoTable();
            

            lblError.setText("Registaration is succesful");
        }

    }

    
    //JavaMail(TM) API 1.6.2 --email validation
    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        // display the list of countries 
        boxCountry.setItems(Countries.obsList());

    }

}
