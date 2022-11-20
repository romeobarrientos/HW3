package com.cse.hw3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class customerController {
    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField address;

    @FXML
    private TextField customerID;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField savings;

    @FXML
    private TextField checking;

    @FXML
    private Label error_label;

    @FXML
    private Label confirmation;


    @FXML
    private String firstStr, lastStr, addressString, customerIDString, checkingString, savingsString, phoneNumberString;

    @FXML
    public void onCancelButtonClick(ActionEvent event) throws IOException {
        firstName.clear();
        lastName.clear();
        address.clear();
        customerID.clear();
        phoneNumber.clear();
        savings.clear();
        checking.clear();
    }

    public void onSaveButtonClick(ActionEvent event) throws IOException {
        firstStr = firstName.getText();
        lastStr = lastName.getText();
        addressString = address.getText();
        customerIDString = customerID.getText();
        savingsString = savings.getText();
        checkingString = checking.getText();
        phoneNumberString = phoneNumber.getText();

        if(customerIDString.length() == 4){
            error_label.setText("");
            try{
                File file = new File("src/main/java/customerData/" + lastName.getText() + ".txt");
                FileWriter write = new FileWriter(file);

                write.write("First Name: " + firstStr + "\n");
                write.write("Last Name: " + lastStr + "\n");
                write.write("Address: " + addressString + "\n");
                write.write("Phone Number: " + phoneNumberString + "\n");
                write.write("Customer ID: " + customerIDString + "\n");
                write.write("Savings Account Number: " + savingsString + "\n");
                write.write("Checkings Account Number: " + checkingString + "\n");
                write.close();
                confirmation.setText("Congrats! You have been successfully added.");
            }
            catch(NumberFormatException e){
                error_label.setText("Incorrect Customer ID! Please input a 4-digit integer and try again.");
            }

        }
        else{
            error_label.setText("Incorrect Customer ID! Please input a 4-digit integer and try again.");
        }
    }
}